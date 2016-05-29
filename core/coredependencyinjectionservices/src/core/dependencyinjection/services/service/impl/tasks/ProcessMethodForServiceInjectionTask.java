package core.dependencyinjection.services.service.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.service.ServiceInjector;
import core.reflection.facades.loader.ReflectionFacade;

public class ProcessMethodForServiceInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionFacade reflectionFacade;
    
    
    public void run(Object object, Method method, ReflectionFacade reflectionFacade, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        this.reflectionFacade = reflectionFacade;
        this.object = object;
        reflectionFacade.makeMethodAccessible(method);
        ServiceInjector serviceInjection = (ServiceInjector)annotationsGatheringFacade.extractAnnotationFromMethod(method, ServiceInjector.class);
        
        if(serviceInjection != null)
        {
            processInjection(method, serviceInjection);
        }
    }
    
    
    private void processInjection(Method method, ServiceInjector serviceInjection)
    {
        //the format is package1.package2.services.servicename.ServiceInterface
        String classToInject = serviceInjection.ID();
        //we transform it to package1.package2.services.servicename.impl.ServiceInterfaceImpl
        String classNameToInject = classToInject.substring(classToInject.lastIndexOf(".") + 1);
        classToInject = classToInject.substring(0, classToInject.lastIndexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(classToInject);
        sb.append(".impl.");
        sb.append(classNameToInject);
        sb.append("Impl");
        classToInject = sb.toString();
        
        try
        {
            reflectionFacade.callMethod(method, object, Class.forName(classToInject).newInstance());
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
}