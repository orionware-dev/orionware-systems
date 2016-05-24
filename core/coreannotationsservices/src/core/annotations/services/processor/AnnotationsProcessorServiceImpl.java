package core.annotations.services.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.processor.tasks.ApplyAnnotationsTask;
import core.annotations.services.processor.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.processor.tasks.GatherAllObjectAnnotationsTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask;
    private ApplyAnnotationsTask applyAnnotationsTask;
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask;
    private ReflectionService reflectionService;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
        applyAnnotationsTask = new ApplyAnnotationsTask();
        extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
        reflectionService = new ReflectionServiceImpl();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return gatherAllObjectAnnotationsTask.run(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllAnnotationsFromObject(OrionObject);
        applyAnnotationsTask.run(reflectionService, OrionObject, allObjectAnnotationsList);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}