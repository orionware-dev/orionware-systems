package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run(Object function, String methodToRun, Object... functionParameters)
    {
        AbstractFilter filter = new Filter(function, methodToRun, functionParameters);
        return new IsCustomFunctionTask().run(filter);
    }
}