package core.configuration.classpath.tasks;

import java.io.File;
import core.configuration.OrionConfigurationTask;
import core.configuration.CoreConfigurationEnum;
import core.configuration.DefaultConfigurationEnum;

public class GetClasspathRootPathTask implements OrionConfigurationTask
{
    public String run(String libraryClasspathRootPath)
    {
        //use this class to get the path of this class
        File classpathRoot = new File(this.getClass().getResource("").getPath());
        StringBuilder sb = null;
        
        //get parent dir until we reach the classpath root which is the "core" dir
        do
        {
            classpathRoot = new File(classpathRoot.getParent());
            sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
            
            if(libraryClasspathRootPathDoesNotEqualClasspathRoot(libraryClasspathRootPath)
                && classpathRootEndsWithClasspathRoot(classpathRoot, sb))
            {
                classpathRoot = new File(classpathRoot.getParent());
                sb = new StringBuilder();
                sb.append(CoreConfigurationEnum.CLASSPATH_ROOT.get());
                sb.append(File.separator);
                sb.append(DefaultConfigurationEnum.BIN_DIR.get());
                
                if(classpathRootEndsWithClasspathBinDir(classpathRoot, sb))
                {
                    classpathRoot = new File(classpathRoot.getParent());
                    classpathRoot = new File(classpathRoot.getParent());
                    sb = new StringBuilder();
                    sb.append(classpathRoot.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    sb.append(File.separator);
                    sb.append(DefaultConfigurationEnum.BIN_DIR.get());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    classpathRoot = new File(sb.toString());
                }
                else
                {
                    sb = new StringBuilder();
                    sb.append(classpathRoot.getAbsolutePath());
                    sb.append(File.separator);
                    sb.append(libraryClasspathRootPath);
                    classpathRoot = new File(sb.toString());
                }
                
                break;
            }
        }
        while(!classpathRoot.getName().endsWith(libraryClasspathRootPath));
        
        if(classpathRoot.getAbsolutePath().endsWith("coreconfiguration"))
        {
            sb = new StringBuilder();
            sb.append(classpathRoot.getAbsolutePath());
            sb.append(File.separator);
            sb.append(DefaultConfigurationEnum.BIN_DIR.get());
            sb.append(File.separator);
            sb.append("core");
            classpathRoot = new File(sb.toString());
        }
        else if(!classpathRoot.getAbsolutePath().endsWith("core" + File.separator + "configuration"))
        {
            classpathRoot = new File(classpathRoot.getParent());
            classpathRoot = new File(classpathRoot.getParent());
            sb = new StringBuilder();
            sb.append(classpathRoot.getAbsolutePath());
            sb.append(File.separator);
            sb.append(libraryClasspathRootPath);
            sb.append(File.separator);
            sb.append(DefaultConfigurationEnum.BIN_DIR.get());
            sb.append(File.separator);
            sb.append(libraryClasspathRootPath);
            classpathRoot = new File(sb.toString());
        }
        
        return classpathRoot.getAbsolutePath();
    }
    
    
    private boolean libraryClasspathRootPathDoesNotEqualClasspathRoot(String libraryClasspathRootPath)
    {
        return !CoreConfigurationEnum.CLASSPATH_ROOT.get().equals(libraryClasspathRootPath);
    }
    
    
    private boolean classpathRootEndsWithClasspathRoot(File classpathRoot, StringBuilder sb)
    {
        return classpathRoot.getAbsolutePath().endsWith(sb.toString());
    }
    
    
    private boolean classpathRootEndsWithClasspathBinDir(File classpathRoot, StringBuilder sb)
    {
        return classpathRoot.getAbsolutePath().endsWith(sb.toString());
    }
}