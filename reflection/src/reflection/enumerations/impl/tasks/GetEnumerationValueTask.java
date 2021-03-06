package reflection.enumerations.impl.tasks;

import java.lang.reflect.Method;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;

public class GetEnumerationValueTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public static String run(Class<Enum> enumerationClass, String enumerationName)
    {
        String enumerationValue = "";
                        
        try
        {
            Method getterMethod = enumerationClass.getMethod("get", new Class<?>[]{});
            enumerationValue = (String)new ReflectionMethodAccessServiceImpl().callMethod(getterMethod, enumerationClass);

            if(enumerationValue == null)
            {
                enumerationValue = "";
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

        return enumerationValue;
    }
}