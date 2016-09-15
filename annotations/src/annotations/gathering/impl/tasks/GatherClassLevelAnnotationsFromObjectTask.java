package annotations.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.filtering.AnnotationsFilteringService;
import annotations.filtering.impl.AnnotationsFilteringServiceImpl;

public class GatherClassLevelAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private static AnnotationsFilteringService annotationsFilteringService = new AnnotationsFilteringServiceImpl();
    
    
    public static List<OrionAnnotation> run(Object object)
    {
        if(object != null)
        {
            List<Annotation> allClassLevelAnnotations = Arrays.asList(object.getClass().getAnnotations());
            List<OrionAnnotation> annotationsList = new ArrayList<OrionAnnotation>();
            
            for(Annotation annotation : allClassLevelAnnotations)
            {
                OrionAnnotation orionAnnotation = new OrionAnnotation(annotation.annotationType().getName(), null, null, null);
                annotationsList.add(orionAnnotation);
            }
            
            //we filter the annotations, because if it finds a registered
            //annotation that matches
            //one in the list of object annotations then we can process it
            //otherwise it means that Orion
            //will have to try to process non-Orion-based annotations like
            //Java/Spring/etc. annotations
            //in which case it is processed by the respective framework
            List<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(annotationsList);
            registeredAnnotations.forEach(orionAnnotation -> annotationsFilteringService.addAnnotationTypeForObject(orionAnnotation, AnnotationType.CLASS));
            return registeredAnnotations;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}