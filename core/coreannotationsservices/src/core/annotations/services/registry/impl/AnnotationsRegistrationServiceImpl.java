package core.annotations.services.registry.impl;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.services.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
import core.annotations.services.registry.impl.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.services.registry.impl.tasks.RegisterAnnotationTask;
import core.annotations.services.registry.impl.tasks.RegisterLibrariesAnnotationsTask;
import core.annotations.services.registry.impl.tasks.RegisterLibraryAnnotationsTask;
import core.annotations.services.registry.impl.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl extends AnnotationServiceObject implements AnnotationsRegistrationService
{
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        Stream<LibraryConfiguration> notNullLibrariesConfigurationStream = new FilterNotNullLibrariesConfigurationTask().run(librariesConfiguration);
        notNullLibrariesConfigurationStream = new FilterAnnotationsNotBeenRegisteredForLibraryTask().run(notNullLibrariesConfigurationStream);
        new RegisterLibrariesAnnotationsTask().run(notNullLibrariesConfigurationStream);
    }
    
    
    @Override
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        new RegisterAnnotationTask().run(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return new HaveAnnotationsBeenRegisteredForLibraryTask().run(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        new SetAnnotationsAsRegisteredForLibraryTask().run(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        new RegisterLibraryAnnotationsTask().run(libraryConfiguration);
    }
}