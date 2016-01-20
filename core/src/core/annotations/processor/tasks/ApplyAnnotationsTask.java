package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.RegisteredAnnotation;
import core.annotations.processor.AnnotationsProcessorService;
import core.reflection.ReflectionService;
import core.registry.RegisteredAnnotations;
import core.services.OrionTask;

public class ApplyAnnotationsTask implements OrionTask
{
    private AnnotationsProcessorService annotationsProcessorService;
    private OrionObject object;
    private List<Annotation> allObjectAnnotationsList;
    

    public void run(AnnotationsProcessorService annotationsProcessorService, OrionObject object, List<Annotation> allObjectAnnotationsList)
    {
        this.annotationsProcessorService = annotationsProcessorService;
        this.object = object;
        this.allObjectAnnotationsList = allObjectAnnotationsList;
        RegisteredAnnotations.forEach((annotation) -> applyAnnotation((RegisteredAnnotation)annotation));
    }
    
    
    private void applyAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        //if it finds a registered annotation that matches the one it is processing now then process it
        //otherwise it means that we are processing an annotation that has not been registered
        //in which case we ignore it. It could be a Java/Spring/etc. annotation in which
        //case it is processed by the respective framework
        if(allObjectAnnotationsList.stream()
            .filter((annotation) -> annotation.annotationType().getName().equals(registeredAnnotation.getAnnotationClass()))
            .count() == 1)
        {
            applyAnnotationToMethod(registeredAnnotation);
        }
    }
    
    
    private void applyAnnotationToMethod(RegisteredAnnotation registeredAnnotation)
    {
        try
        {
            ReflectionService reflectionService = annotationsProcessorService.getReflectionService();
            Object someAnnotationService = reflectionService.loadAndInstantiateClass(registeredAnnotation.getAnnotationService());
            Method someMethod = someAnnotationService.getClass().getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), OrionObject.class);
            reflectionService.callMethod(someMethod, someAnnotationService, object);
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
    }
}