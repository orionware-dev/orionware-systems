package core.configuration;

public enum CoreConfigurationEnum implements OrionConfigurationEnum
{
    LIBRARY_NAME("coreconfiguration"),
    LIBRARY_CLASS_PATH("/core/" + DefaultConfigurationEnum.DEFAULT_CONFIGURATION_DIR.get()),
    //put an empty string as a prefix, because it complaints that there
    //is no constructor with argument of type CoreConfigurationEnum
    //since LIBRARY_NAME by itself is of type CoreConfigurationEnum
    PROPERTIES_FILE_PATH("" + LIBRARY_CLASS_PATH.get() + "/Core.prop"),
    ANNOTATIONS_DEFINITION_FILE_PATH("" + LIBRARY_CLASS_PATH.get() + "/CoreAnnotations.prop");
    
    
    private final String coreConfigurationValue;
    
    
    private CoreConfigurationEnum(String coreConfigurationValue)
    {
        this.coreConfigurationValue = coreConfigurationValue;
    }
    
    
    @Override
    public String get()
    {
        return coreConfigurationValue;
    }
}