package annotations.extraction.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;

public class ExtractAnnotationFromConstructorTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Annotation run(Constructor<?> constructor, Class annotationClassToExtract)
    {
        return constructor.getAnnotation(annotationClassToExtract);
    }
}