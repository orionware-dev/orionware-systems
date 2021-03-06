package designpatterns.configuration;

import designpatterns.DesignPatternsConfiguration;

public class DesignPatternsLibraryConfiguration implements DesignPatternsConfiguration
{
    private PipelineConfiguration pipelineConfiguration;


    public PipelineConfiguration getPipelineConfiguration()
    {
        return this.pipelineConfiguration;
    }


    public void setPipelineConfiguration(PipelineConfiguration pipelineConfiguration)
    {
        this.pipelineConfiguration = pipelineConfiguration;
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getPipelineConfiguration().hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object == null || object.getClass() != getClass())
        {
            return false;
        }
        else
        {
            DesignPatternsLibraryConfiguration otherDesignPatternsLibraryConfiguration = (DesignPatternsLibraryConfiguration)object;

            if(this.getPipelineConfiguration().equals(otherDesignPatternsLibraryConfiguration.getPipelineConfiguration()))
            {
                return true;
            }
        }

        return false;
    }
}