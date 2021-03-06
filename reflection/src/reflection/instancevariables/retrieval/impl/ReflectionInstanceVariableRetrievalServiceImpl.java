package reflection.instancevariables.retrieval.impl;

import java.lang.reflect.Field;
import reflection.ReflectionServiceObject;
import reflection.instancevariables.retrieval.ReflectionInstanceVariableRetrievalService;
import reflection.instancevariables.retrieval.impl.tasks.checks.IsPrivateInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.checks.IsProtectedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.checks.IsPublicInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredProtectedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredPublicInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.inheritted.GetInherittedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.privates.GetPrivateInstanceVariableTask;

public class ReflectionInstanceVariableRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariableRetrievalService
{
    @Override
    public Field getDeclaredInstanceVariable(String instanceVariableName, Object object)
    {
        return GetDeclaredInstanceVariableTask.run(instanceVariableName, object);
    }


    @Override
    public Field getDeclaredInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);
    }


    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Object object)
    {
        return GetPrivateInstanceVariableTask.run(instanceVariableName, object);
    }


    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return GetPrivateInstanceVariableTask.run(instanceVariableName, aClass);
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object)
    {
        return GetDeclaredPublicInstanceVariableTask.run(instanceVariableName, object);
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return GetDeclaredPublicInstanceVariableTask.run(instanceVariableName, aClass);
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object)
    {
        return GetDeclaredProtectedInstanceVariableTask.run(instanceVariableName, object);
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return GetDeclaredProtectedInstanceVariableTask.run(instanceVariableName, aClass);
    }


    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Object object)
    {
        return GetInherittedInstanceVariableTask.run(instanceVariableName, object);
    }


    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return GetInherittedInstanceVariableTask.run(instanceVariableName, aClass);
    }


    @Override
    public boolean isPrivateInstanceVariable(Field instanceVariable)
    {
        return IsPrivateInstanceVariableTask.run(instanceVariable);
    }


    @Override
    public boolean isProtectedInstanceVariable(Field instanceVariable)
    {
        return IsProtectedInstanceVariableTask.run(instanceVariable);
    }


    @Override
    public boolean isPublicInstanceVariable(Field instanceVariable)
    {
        return IsPublicInstanceVariableTask.run(instanceVariable);
    }
}