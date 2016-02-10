package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.tasks.GetCoreClasspathRootPathTask;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.ConfigurationRegistry;
import core.configuration.registry.PropertiesRegistrationService;

public class RegisterPropertyTask implements OrionConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }
}