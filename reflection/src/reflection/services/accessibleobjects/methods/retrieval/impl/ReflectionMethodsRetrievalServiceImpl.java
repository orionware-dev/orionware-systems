package reflection.services.accessibleobjects.methods.retrieval.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.methods.retrieval.ReflectionMethodsRetrievalService;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredDefaultMethodsArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredMethodsArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredPrivateMethodsArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredProtectedMethodsArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredPublicMethodsArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetInherittedMethodsArrayTask;

public class ReflectionMethodsRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionMethodsRetrievalService
{
    @Override
    public Method[] getDeclaredMethodsArray(Object object)
    {
        return new GetDeclaredMethodsArrayTask().run(object);
    }

    
    @Override
    public Method[] getDeclaredMethodsArray(Class<?> aClass)
    {
        return new GetDeclaredMethodsArrayTask().run(aClass);
    }

    
    @Override
    public List<Method> getDeclaredMethods(Object object)
    {
        return Arrays.asList(getDeclaredMethodsArray(object));
    }
    

    @Override
    public List<Method> getDeclaredMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredMethodsArray(aClass));
    }


    @Override
    public Method[] getDeclaredDefaultMethodsArray(Object object)
    {
        return new GetDeclaredDefaultMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getDeclaredDefaultMethodsArray(Class<?> aClass)
    {
        return new GetDeclaredDefaultMethodsArrayTask().run(aClass);
    }


    @Override
    public List<Method> getDeclaredDefaultMethods(Object object)
    {
        return Arrays.asList(getDeclaredDefaultMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredDefaultMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredDefaultMethodsArray(aClass));
    }


    @Override
    public Method[] getDeclaredPrivateMethodsArray(Object object)
    {
        return new GetDeclaredPrivateMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getDeclaredPrivateMethodsArray(Class<?> aClass)
    {
        return new GetDeclaredPrivateMethodsArrayTask().run(aClass);
    }


    @Override
    public List<Method> getDeclaredPrivateMethods(Object object)
    {
        return Arrays.asList(getDeclaredPrivateMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredPrivateMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredPrivateMethodsArray(aClass));
    }
    
    
    @Override
    public Method[] getDeclaredProtectedMethodsArray(Object object)
    {
        return new GetDeclaredProtectedMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getDeclaredProtectedMethodsArray(Class<?> aClass)
    {
        return new GetDeclaredProtectedMethodsArrayTask().run(aClass);
    }


    @Override
    public List<Method> getDeclaredProtectedMethods(Object object)
    {
        return Arrays.asList(getDeclaredProtectedMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredProtectedMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredProtectedMethodsArray(aClass));
    }
    
    
    @Override
    public Method[] getDeclaredPublicMethodsArray(Object object)
    {
        return new GetDeclaredPublicMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getDeclaredPublicMethodsArray(Class<?> aClass)
    {
        return new GetDeclaredPublicMethodsArrayTask().run(aClass);
    }


    @Override
    public List<Method> getDeclaredPublicMethods(Object object)
    {
        return Arrays.asList(getDeclaredPublicMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredPublicMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredPublicMethodsArray(aClass));
    }
    
    
    @Override
    public Method[] getInherittedMethodsArray(Object object)
    {
        return new GetInherittedMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getInherittedMethodsArray(Class<?> aClass)
    {
        return new GetInherittedMethodsArrayTask().run(aClass);
    }
    
    
    @Override
    public List<Method> getInherittedMethods(Object object)
    {
        return Arrays.asList(getInherittedMethodsArray(object));
    }


    @Override
    public List<Method> getInherittedMethods(Class<?> aClass)
    {
        return Arrays.asList(getInherittedMethodsArray(aClass));
    }
}