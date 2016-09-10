package reflection.services.loader.impl.tasks;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAccessibleObjectsArrayTask extends ReflectionObject implements ReflectionTask
{
    public AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(new GetInstanceVariablesArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetConstructorsArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetMethodsArrayTask().run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }
    
    
    public AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}