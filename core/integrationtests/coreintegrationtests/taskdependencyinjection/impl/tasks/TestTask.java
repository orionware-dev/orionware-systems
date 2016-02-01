package coreintegrationtests.taskdependencyinjection.impl.tasks;

import core.OrionObject;
import coreintegrationtests.servicedependencyinjection.TestService;

public class TestTask extends OrionObject implements TestService
{
    @Override
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.taskdependencyinjection.impl.tasks.TestTask...";
    }
}