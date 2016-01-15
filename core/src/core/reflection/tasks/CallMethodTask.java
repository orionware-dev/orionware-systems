package core.reflection.tasks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import core.services.OrionTask;

public class CallMethodTask implements OrionTask
{
    public boolean run(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        try
        {
            method.invoke(objectMethodBelongsTo, methodArguments);
            return true;
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
        
        return false;
    }
}