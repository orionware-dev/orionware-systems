package core.objects.orionobject.impl;

import java.lang.reflect.InvocationTargetException;
import annotations.processing.impl.AnnotationsProcessorServiceImpl;
import annotations.registry.impl.AnnotationsRegistryServiceImpl;
import configuration.CoreConfigurationConfigurationEnumeration;
import configuration.LibrariesConfiguration;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;
import configuration.registry.impl.ConfigurationRegistryServiceImpl;
import core.OrionSimpleObject;
import core.abstraction.ConfigurationEnumeration;
import core.objects.orionobject.OrionObjectProcessorService;
import core.objects.orionobject.impl.tasks.GetEnumerationValueAndSetItToLibraryConfigurationTask;
import core.objects.orionobject.impl.tasks.InitialiseConfigurationTask;
import dependencyinjection.configuration.DependencyInjectionConfigurationEnumeration;

public class OrionObjectProcessorServiceImpl extends OrionSimpleObject implements OrionObjectProcessorService
{
    public OrionObjectProcessorServiceImpl(Object object)
    {
        if(LibrariesConfigurationMapper.coreLibrariesHaveNotBeenRegistered)
        {
            InitialiseConfigurationTask initialiseConfigurationTask = new InitialiseConfigurationTask();
            LibraryConfiguration coreLibraryConfiguration = initialiseConfigurationTask.run(CoreConfigurationConfigurationEnumeration.class.getName(), CoreConfigurationConfigurationEnumeration.values());
            LibrariesConfiguration.registerLibraryConfiguration(coreLibraryConfiguration);
            LibraryConfiguration dependencyInjectionLibraryConfiguration = initialiseConfigurationTask.run(DependencyInjectionConfigurationEnumeration.class.getName(), DependencyInjectionConfigurationEnumeration.values());
            LibrariesConfiguration.registerLibraryConfiguration(dependencyInjectionLibraryConfiguration);
            processAllLibrariesConfiguration(object);
        }
    }
    
    
    @Override
    public void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        if(!LibrariesConfiguration.getLibrariesConfigurationEnumerationClassPaths().contains(libraryConfigurationEnumerationClassPath))
        {
            LibraryConfiguration libraryConfiguration = convertConfigurationEnumerationToLibraryConfiguration(libraryConfigurationEnumerationClassPath);
            LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
            LibrariesConfiguration.registerLibraryConfigurationEnumerationClassPath(libraryConfigurationEnumerationClassPath);
        }
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    private static LibraryConfiguration convertConfigurationEnumerationToLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();

        try
        {
            Class<ConfigurationEnumeration> temp = (Class<ConfigurationEnumeration>)Class.forName(libraryConfigurationEnumerationClassPath);
            Class<Enum> temp1 = (Class<Enum>)Class.forName(libraryConfigurationEnumerationClassPath);
            Enum[] enums = null;

            try
            {
                enums = (Enum[])temp.getMethod("values", new Class<?>[]{}).invoke(temp, new Object[]{});
            }
            catch(IllegalAccessException exception)
            {
                exception.printStackTrace();
            }
            catch(IllegalArgumentException exception)
            {
                exception.printStackTrace();
            }
            catch(InvocationTargetException exception)
            {
                exception.printStackTrace();
            }
            catch(NoSuchMethodException exception)
            {
                exception.printStackTrace();
            }
            catch(SecurityException exception)
            {
                exception.printStackTrace();
            }

            GetEnumerationValueAndSetItToLibraryConfigurationTask getEnumerationValueAndSetItToLibraryConfigurationTask = new GetEnumerationValueAndSetItToLibraryConfigurationTask();
            
            for(Enum enumerationDefinition : enums)
            {
                getEnumerationValueAndSetItToLibraryConfigurationTask.run(temp, temp1, enumerationDefinition, libraryConfiguration);
            }
        }
        catch(ClassNotFoundException exception1)
        {
            exception1.printStackTrace();
        }

        return libraryConfiguration;
    }


    @Override
    public void processAllLibrariesConfiguration(Object object)
    {
        loadLibrariesProperties();
        registerLibrariesAnnotations();
        processAllAnnotations(object);
    }


    private void loadLibrariesProperties()
    {
        new ConfigurationRegistryServiceImpl().loadLibrariesProperties();
    }


    private void registerLibrariesAnnotations()
    {
        new AnnotationsRegistryServiceImpl().registerLibrariesAnnotations();
    }


    private void processAllAnnotations(Object object)
    {
        new AnnotationsProcessorServiceImpl().processAllAnnotations(object);
    }
}