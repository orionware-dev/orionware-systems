package reflection.enumerations.impl.tasks;

import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetEnumerationDefinitionsTask extends ReflectionObject implements ReflectionTask
{
    @SuppressWarnings({"rawtypes"})
    public static Enum[] run(Class<Enum> enumerationClass)
    {
        return enumerationClass.getEnumConstants();
    }
}