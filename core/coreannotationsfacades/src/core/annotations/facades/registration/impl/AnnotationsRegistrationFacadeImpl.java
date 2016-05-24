package core.annotations.facades.registration.impl;

import java.util.Set;
import core.annotations.OrionAnnotation;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.registration.AnnotationsRegistrationFacade;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.AnnotationsRegistrationServiceImpl;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationFacadeImpl extends AnnotationFacadeObject implements AnnotationsRegistrationFacade
{
    private AnnotationsRegistrationService annotationsRegistrationService;
    
    
    public AnnotationsRegistrationFacadeImpl()
    {
        annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    }
    
    
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        annotationsRegistrationService.registerLibrariesAnnotations(librariesConfiguration);
    }
    
    
    @Override
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration)
    {
        annotationsRegistrationService.registerLibraryAnnotationsDefinitions(libraryConfiguration);
    }
    
    
    @Override
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        annotationsRegistrationService.registerAnnotation(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return annotationsRegistrationService.haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        annotationsRegistrationService.setAnnotationsAsRegisteredForLibrary(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        annotationsRegistrationService.registerLibraryAnnotations(libraryConfiguration);
    }
}