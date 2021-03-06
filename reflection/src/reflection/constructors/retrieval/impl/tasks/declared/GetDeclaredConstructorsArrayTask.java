package reflection.constructors.retrieval.impl.tasks.declared;

import java.lang.reflect.Constructor;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Constructor<?>[] run(Class<?> aClass)
    {
        return aClass.getDeclaredConstructors();
    }
    
    
    public static Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}