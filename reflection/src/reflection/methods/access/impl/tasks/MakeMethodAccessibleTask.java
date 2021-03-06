package reflection.methods.access.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class MakeMethodAccessibleTask extends ReflectionObject implements ReflectionTask
{
    private Method method;


    public void run(Method method)
    {
        this.method = method;

        if(methodIsNotAccessible())
        {
            makeMethodAccessible();
        }
    }


    private boolean methodIsNotAccessible()
    {
        return !method.isAccessible();
    }


    private void makeMethodAccessible()
    {
        try
        {
            method.setAccessible(true);
        }
        catch(SecurityException e)
        {
            e.printStackTrace();
        }
    }
}