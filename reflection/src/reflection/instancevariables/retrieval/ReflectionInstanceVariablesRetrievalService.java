package reflection.instancevariables.retrieval;

import java.lang.reflect.Field;
import java.util.List;
import reflection.ReflectionService;

public interface ReflectionInstanceVariablesRetrievalService extends ReflectionService
{
    public Field[] getDeclaredInstanceVariablesArray(Object object);


    public Field[] getDeclaredInstanceVariablesArray(Class<?> aClass);


    public List<Field> getDeclaredInstanceVariables(Object object);


    public List<Field> getDeclaredInstanceVariables(Class<?> aClass);


    public Field[] getPrivateInstanceVariablesArray(Object object);


    public Field[] getPrivateInstanceVariablesArray(Class<?> aClass);


    public List<Field> getPrivateInstanceVariables(Object object);


    public List<Field> getPrivateInstanceVariables(Class<?> aClass);


    public Field[] getDeclaredProtectedInstanceVariablesArray(Object object);


    public Field[] getDeclaredProtectedInstanceVariablesArray(Class<?> aClass);


    public List<Field> getDeclaredProtectedInstanceVariables(Object object);


    public List<Field> getDeclaredProtectedInstanceVariables(Class<?> aClass);


    public Field[] getDeclaredPublicInstanceVariablesArray(Object object);


    public Field[] getDeclaredPublicInstanceVariablesArray(Class<?> aClass);


    public List<Field> getDeclaredPublicInstanceVariables(Object object);


    public List<Field> getDeclaredPublicInstanceVariables(Class<?> aClass);


    public Field[] getInherittedInstanceVariablesArray(Object object);


    public Field[] getInherittedInstanceVariablesArray(Class<?> aClass);


    public List<Field> getInherittedInstanceVariables(Object object);


    public List<Field> getInherittedInstanceVariables(Class<?> aClass);


    public Field[] getAllInstanceVariablesArray(Object object);


    public Field[] getAllInstanceVariablesArray(Class<?> aClass);


    public List<Field> getAllInstanceVariables(Object object);


    public List<Field> getAllInstanceVariables(Class<?> aClass);
}