package designpatterns.services.pipeline.impl.tasks;

import core.dependencyinjection.annotations.Injector;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.DesignPatternsObject;

public class CreateFilterTask extends DesignPatternsObject implements DesignPatternsTask
{
    private IsCustomFunctionTask isCustomFunctionTask;
    
    
    public CreateFilterTask()
    {
        
    }
    
    
    public AbstractFilter run(Object function, String methodToRun, Object... functionParameters)
    {
        AbstractFilter filter = new Filter(function, methodToRun, functionParameters);
        return isCustomFunctionTask.run(filter);
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.IsCustomFunctionTask")
    private void setIsCustomFunctionTask(IsCustomFunctionTask isCustomFunctionTask)
    {
        this.isCustomFunctionTask = isCustomFunctionTask;
    }
}