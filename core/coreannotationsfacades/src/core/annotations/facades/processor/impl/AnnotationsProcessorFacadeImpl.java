package core.annotations.facades.processor.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.processor.AnnotationsProcessorFacade;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;

public class AnnotationsProcessorFacadeImpl extends AnnotationFacadeObject implements AnnotationsProcessorFacade
{
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public AnnotationsProcessorFacadeImpl()
    {
        this.annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return annotationsProcessorService.gatherAllAnnotationsFromObject(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        annotationsProcessorService.processAllAnnotations(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return annotationsProcessorService.extractAnnotationFromMethod(method, annotationClassToExtract);
    }
}