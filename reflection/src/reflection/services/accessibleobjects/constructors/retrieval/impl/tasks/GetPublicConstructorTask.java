package reflection.services.accessibleobjects.constructors.retrieval.impl.tasks;

import java.lang.reflect.Constructor;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPublicConstructorTask extends ReflectionObject implements ReflectionTask
{
    public Constructor<?> run(Object object, Class<?>... constructorParameterTypes)
    {
        return run(object.getClass(), constructorParameterTypes);
    }
    
    
    public Constructor<?> run(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        try
        {
            if(constructorParameterTypes.length == 0)
            {
                constructorParameterTypes = new Class<?>[]{Object.class};
            }
            
            return aClass.getConstructor(constructorParameterTypes);
        }
        catch(NoSuchMethodException exception)
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