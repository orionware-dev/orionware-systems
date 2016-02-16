package core.reflection.loader.tasks;

import core.OrionSimpleObject;
import core.reflection.ReflectionObject;
import core.reflection.ReflectionTask;

public class LoadClassTask extends ReflectionObject implements ReflectionTask
{
    public Class<?> run(String className)
    {
        try
        {
            return ClassLoader.getSystemClassLoader().loadClass(className);
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}