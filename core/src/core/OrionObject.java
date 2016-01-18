package core;

import java.util.HashSet;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.CoreConfiguration;
import core.configuration.LibraryConfiguration;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    protected Set<LibraryConfiguration> librariesConfigurationSet = new HashSet<LibraryConfiguration>();
    
    
    public OrionObject()
    {
        loadCoreConfiguration();
        
        if(new LibraryServiceImpl().isCoreLibrary(getClass()))
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    private void loadCoreConfiguration()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName(CoreConfiguration.LIBRARY_NAME);
        libraryConfiguration.setConfigurationFilePath(CoreConfiguration.PROPERTIES_FILE_PATH);
        libraryConfiguration.setAnnotationsFilePath(CoreConfiguration.ANNOTATIONS_DEFINITION_FILE_PATH);
        librariesConfigurationSet.add(libraryConfiguration);
    }
    
    
    //this method is called by this constructor if only the core is running.
    //If another library is running like datastructures, then that constructor
    //will call this method so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        new ConfigurationServiceImpl().loadLibrariesProperties(librariesConfigurationSet);
        new AnnotationsConfigurationServiceImpl().loadLibrariesAnnotations(librariesConfigurationSet);
        new AnnotationsProcessorServiceImpl().processAllAnnotations(this);
    }
}