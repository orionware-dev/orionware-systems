package designpatterns.services.designpatternsobject.impl.tasks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import core.OrionSimpleObject;
import core.configuration.OrionProperties;
import core.configuration.registry.ConfigurationRegistry;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsConfiguration;
import designpatterns.configuration.DesignPatternsLibraryConfiguration;
import designpatterns.configuration.PipelineConfiguration;

public class RegisterPipelineConfigurationTask extends OrionSimpleObject implements DesignPatternsTask
{
    public boolean run(InputStream pipelineConfigurationInput)
    {
        OrionProperties pipelineProperties = new OrionProperties();
        pipelineProperties.loadProperties(pipelineConfigurationInput);
        List<String> allowedClassesNames = new ArrayList<String>();
        int index = 1;

        while(pipelineProperties.get("design.patterns.pipeline.filter.default.allowed.class." + index) != null)
        {
            allowedClassesNames.add((String)pipelineProperties.get("design.patterns.pipeline.filter.default.allowed.class." + index));
            ++index;
        }

        ConfigurationRegistry.loadProperties(pipelineProperties);
        PipelineConfiguration pipelineConfiguration = new PipelineConfiguration();
        pipelineConfiguration.setAllowedClassesNames(allowedClassesNames);
        DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration = new DesignPatternsLibraryConfiguration();
        designPatternsLibraryConfiguration.setPipelineConfiguration(pipelineConfiguration);
        DesignPatternsConfiguration.registerDesignPatternsConfiguration(designPatternsLibraryConfiguration);
        DesignPatternsConfiguration.setPipelineConfiguration(pipelineConfiguration);
        new FileSystemStreamsFacadeImpl().closeResource(pipelineConfigurationInput);
        return true;
    }
}