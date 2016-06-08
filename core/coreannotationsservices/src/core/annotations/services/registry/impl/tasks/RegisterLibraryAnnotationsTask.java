package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;

public class RegisterLibraryAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private OrionProperties annotationsDeclarations;
    private String currentAnnotationClass;
    private String currentAnnotationServiceClass;
    private String currentAnnotationServiceMethodToCall;
    
    
    public void run(LibraryConfiguration libraryConfiguration)
    {
        LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
        annotationsDeclarations = loadLibraryAnnotationsDefinitionsTask.run(libraryConfiguration);
        
        if(annotationsDeclarations.isNotEmpty())
        {
            int annotationCounter = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(libraryConfiguration.getLibraryName());
            sb.append(".annotation.");
            sb.append(annotationCounter);
            String annotationDeclaration = sb.toString();
            
            while(currentAnnotationIsDeclared(annotationDeclaration))
            {
                resolveCurrentAnnotationClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceMethodToCall(libraryConfiguration.getLibraryName(), annotationCounter);
                registerLibraryAnnotation();
                ++annotationCounter;
                sb = new StringBuilder();
                sb.append(libraryConfiguration.getLibraryName());
                sb.append(".annotation.");
                sb.append(annotationCounter);
                annotationDeclaration = sb.toString();
            }
        }
        
        new SetAnnotationsAsRegisteredForLibraryTask().run(libraryConfiguration.getLibraryName());
    }
    
    
    private boolean currentAnnotationIsDeclared(String annotationDeclaration)
    {
        return annotationsDeclarations.doesPropExist(annotationDeclaration);
    }
    
    
    private void resolveCurrentAnnotationClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(libraryName);
        sb1.append(".annotation.");
        sb1.append(annotationCounter);
        currentAnnotationClass = annotationsDeclarations.getProp(sb1.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(libraryName);
        sb2.append(".annotation.facade.");
        sb2.append(annotationCounter);
        currentAnnotationServiceClass = annotationsDeclarations.getProp(sb2.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceMethodToCall(String libraryName, int annotationCounter)
    {
        StringBuilder sb3 = new StringBuilder();
        sb3.append(libraryName);
        sb3.append(".annotation.facade.processing.method.");
        sb3.append(annotationCounter);
        currentAnnotationServiceMethodToCall = annotationsDeclarations.getProp(sb3.toString());
    }
    
    
    private void registerLibraryAnnotation()
    {
        OrionAnnotation OrionAnnotationToRegister = new OrionAnnotation(currentAnnotationClass, currentAnnotationServiceClass, currentAnnotationServiceMethodToCall);
        new RegisterAnnotationTask().run(OrionAnnotationToRegister);
    }
}