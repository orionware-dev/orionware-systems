package annotations.services.processor.impl.tasks;

import java.util.List;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;

public class ApplyAnnotationsToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(List<OrionAnnotation> annotations, Object object)
    {
        annotations.forEach(annotation -> new ApplyAnnotationToObjectTask().run(object, annotation));
    }
}