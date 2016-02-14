package core.annotations.services.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask implements AnnotationTask
{
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    
    
    public void run(AnnotationsRegistrationService annotationsRegistrationService, AnnotationsLoaderService annotationsLoaderService, Stream<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.forEach((libraryConfiguration) -> registerLibraryAnnotationsTask.run(annotationsRegistrationService, annotationsLoaderService, libraryConfiguration));
    }
}