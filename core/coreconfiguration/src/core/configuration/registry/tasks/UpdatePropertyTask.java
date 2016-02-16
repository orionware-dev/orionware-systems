package core.configuration.registry.tasks;

import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.OrionConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class UpdatePropertyTask extends ConfigurationObject implements OrionConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.updateProp(key, value);
    }
}