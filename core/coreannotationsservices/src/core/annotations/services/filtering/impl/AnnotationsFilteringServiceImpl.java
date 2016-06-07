package core.annotations.services.filtering.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.tasks.FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask;
import core.annotations.services.filtering.impl.tasks.IsAnnotationRegisteredTask;

public class AnnotationsFilteringServiceImpl extends AnnotationServiceObject implements AnnotationsFilteringService
{
    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList)
    {
        return new FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask().run(allObjectAnnotationsList);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return new IsAnnotationRegisteredTask().run(annotation);
    }
}