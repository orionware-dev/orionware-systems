package reflection.instancevariables.retrieval.impl.tasks.privates;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPrivateInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Field[] run(Class<?> aClass)
    {
        List<Field> declaredPrivateInstanceVariables = new ArrayList<Field>();
        
        for(Field instanceVariable : aClass.getDeclaredFields())
        {
            if(Modifier.isPrivate(instanceVariable.getModifiers()))
            {
                declaredPrivateInstanceVariables.add(instanceVariable);
            }
        }
        
        return declaredPrivateInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object)
    {
        return run(object.getClass());
    }
}