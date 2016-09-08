package core.annotations.services.processor.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationToMethodTask;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationsToMethodTask;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.AnnotationsRegistrationServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private AnnotationsFilteringService annotationsFilteringService;
    private AnnotationsGatheringService annotationsGatheringService;
    private AnnotationsRegistrationService annotationsRegistrationService;


    public AnnotationsProcessorServiceImpl()
    {
        this.annotationsFilteringService = new AnnotationsFilteringServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        this.annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    }


    @Override
    public void processAllAnnotations(Object orionObject)
    {
        List<Annotation> allObjectAnnotations = annotationsGatheringService.gatherAllAnnotationsFromObject(orionObject);
        //we filter the annotations, because if it finds a registered
        //annotation that matches
        //one in the list of object annotations then we can process it
        //otherwise it means that Orion
        //will have to try to process non-Orion-based annotations like
        //Java/Spring/etc. annotations
        //in which case it is processed by the respective framework
        Stream<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allObjectAnnotations);
        new ApplyAnnotationsToMethodTask().run(registeredAnnotations, orionObject);
    }


    //returns true if annotation has been applied to method and false if it is
    //not registered
    @Override
    public boolean applyMethodAnnotation(Object OrionObject, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;

        if(annotationsRegistrationService.isAnnotationRegistered(annotationToProcess))
        {
            new ApplyAnnotationToMethodTask().run(OrionObject, annotationToProcess);
            isAnnotationApplicable = true;
        }

        return isAnnotationApplicable;
    }
}