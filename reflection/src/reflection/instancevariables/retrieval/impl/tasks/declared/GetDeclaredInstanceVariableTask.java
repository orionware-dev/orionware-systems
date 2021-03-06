package reflection.instancevariables.retrieval.impl.tasks.declared;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public static Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }
    
    
    public static Field run(String instanceVariableName, Class<?> aClass)
    {
        try
        {
            return aClass.getDeclaredField(instanceVariableName);
        }
        catch(NoSuchFieldException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return null;
    }
}