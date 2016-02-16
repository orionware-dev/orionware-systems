package core.configuration.classpath.tasks;

import java.io.File;
import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.OrionConfigurationTask;

public class IsCoreLibraryTask extends ConfigurationObject implements OrionConfigurationTask
{
    public boolean run(Class<?> classBeingRun)
    {
        File classpathRoot = new File(classBeingRun.getResource("").getPath());
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("core");
        sb.append(File.separator);
        sb.append("core");
        
        if(classpathRoot.getAbsolutePath().indexOf(sb.toString()) != -1)
        {
            return true;
        }
        
        return false;
    }
}