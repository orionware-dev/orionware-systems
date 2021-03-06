package reflection.methods.retrieval.impl.tasks.inheritted;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredMethodTask;

public class GetInherittedMethodTask extends ReflectionObject implements ReflectionTask
{
    public static Method run(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    public static Method run(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        Method inherittedMethod = null;
        
        try
        {
            if(methodParameterTypes.length == 0)
            {
                methodParameterTypes = new Class<?>[]{Object.class};
            }
            
            Method publicOrInherittedMethod = aClass.getMethod(methodName, methodParameterTypes);
            Method declaredMethod = GetDeclaredMethodTask.run(methodName, aClass, methodParameterTypes);
            
            if(declaredMethod == null || !Modifier.isPublic(declaredMethod.getModifiers()))
            {
                inherittedMethod = publicOrInherittedMethod;
            }
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return inherittedMethod;
    }
}