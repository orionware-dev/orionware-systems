package core.configuration.services.classpath.impl;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Set;
import core.configuration.LibraryConfiguration;
import core.configuration.services.ConfigurationServiceObject;
import core.configuration.services.classpath.ConfigurationClasspathService;
import core.configuration.services.classpath.impl.tasks.IsCoreLibraryTask;
import core.configuration.services.classpath.impl.tasks.LoadLibraryPropertiesTask;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.PropertiesRegistrationServiceImpl;
import core.configuration.services.registry.impl.tasks.RegisterLibraryPropertiesTask;
import core.filesystem.facades.streams.FileSystemStreamsFacade;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;

public class ConfigurationClasspathServiceImpl extends ConfigurationServiceObject implements ConfigurationClasspathService
{
    private FileSystemStreamsFacade fileSystemStreamsFacade;
    
    
    public ConfigurationClasspathServiceImpl()
    {
        this.fileSystemStreamsFacade = new FileSystemStreamsFacadeImpl();
    }
    
    
    //this method is accurate when it is called from a base object
    //like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return new IsCoreLibraryTask().run(classBeingRun);
    }


    @Override
    public void loadLibrariesProperties(Set<LibraryConfiguration> librariesConfiguration)
    {
        PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        RegisterLibraryPropertiesTask registerLibraryPropertiesTask = new RegisterLibraryPropertiesTask();
        LoadLibraryPropertiesTask loadLibraryPropertiesTask = new LoadLibraryPropertiesTask();
        librariesConfiguration.stream()
            .filter(libraryConfiguration -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter(libraryConfiguration -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()))
            .forEach(libraryConfiguration -> registerLibraryPropertiesTask.run(this, loadLibraryPropertiesTask, propertiesRegistrationService, libraryConfiguration));
    }
    
    
    @Override
    public InputStream getFileStream(String filePath)
    {
        return fileSystemStreamsFacade.getFileStream(filePath);
    }
    
    
    @Override
    public void closeResource(Closeable stream)
    {
        fileSystemStreamsFacade.closeResource(stream);
    }
}