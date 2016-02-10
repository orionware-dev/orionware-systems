package core.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OrionProperties extends Properties
{
    private static final long serialVersionUID = 2244989344408978785L;
    
    
    public void loadProperties(InputStream propertiesFileInput)
    {
        try
        {
            load(propertiesFileInput);
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    public void registerProp(String key, String value)
    {
        put(key, value);
    }
    
    
    public void updateProp(String key, String value)
    {
        put(key, value);
    }
    
    
    public void deleteProp(String key)
    {
        remove(key);
    }
    
    
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }
    
    
    public String getProp(String prop)
    {
        return getProperty(prop);
    }
    
    
    public boolean doesPropExist(String prop)
    {
        return getProp(prop) != null;
    }
}