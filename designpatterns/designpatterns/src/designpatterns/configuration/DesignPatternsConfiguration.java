package designpatterns.configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import core.abstraction.OrionConfiguration;

public class DesignPatternsConfiguration implements OrionConfiguration
{
    public static boolean haveDesignPatternsConfigurationNotBeenRegistered;
    private static Set<DesignPatternsLibraryConfiguration> designPatternsConfigurationSet;
    private static PipelineConfiguration pipelineConfiguration;

    
    static
    {
        haveDesignPatternsConfigurationNotBeenRegistered = true;
        designPatternsConfigurationSet = Collections.synchronizedSet(new HashSet<DesignPatternsLibraryConfiguration>());
    }


    public static Set<DesignPatternsLibraryConfiguration> getDesignPatternsConfigurationSet()
    {
        return designPatternsConfigurationSet;
    }


    public static synchronized void registerDesignPatternsConfiguration(DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration)
    {
        if(haveDesignPatternsConfigurationNotBeenRegistered)
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);

            if(designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
            {
                haveDesignPatternsConfigurationNotBeenRegistered = false;
            }
        }
        else if(!designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);
        }
    }


    public static PipelineConfiguration getPipelineConfiguration()
    {
        return pipelineConfiguration;
    }


    public static void setPipelineConfiguration(PipelineConfiguration newPipelineConfiguration)
    {
        pipelineConfiguration = newPipelineConfiguration;
    }
}