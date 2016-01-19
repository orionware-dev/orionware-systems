package datastructuresfacades.configuration;

import core.general.OrionConfiguration;

public class DataStructuresFacadesConfiguration extends OrionConfiguration
{
    public String BIN_DIR;
    public String DEFAULT_CONFIGURATION_DIR;
    public String LIBRARY_NAME;
    //public String PROPERTIES_FILE_PATH;
    //public String ANNOTATIONS_DEFINITION_FILE_PATH;
    
    //classpath dirs
    public String CLASSPATH_ROOT = LIBRARY_NAME;
    public String INTEGRATION_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "integrationtests";
    public String UNIT_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "unittests";
    
    
    public DataStructuresFacadesConfiguration()
    {
        BIN_DIR = "bin";
        DEFAULT_CONFIGURATION_DIR = "configuration";
        LIBRARY_NAME = "datastructuresfacades";
        //PROPERTIES_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/DataStructures.prop";
        //ANNOTATIONS_DEFINITION_FILE_PATH = "/" + DEFAULT_CONFIGURATION_DIR + "/DataStructuresAnnotations.prop";
        CLASSPATH_ROOT = LIBRARY_NAME;
        INTEGRATION_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "integrationtests";
        UNIT_TESTS_CLASSPATH_ROOT = LIBRARY_NAME + "unittests";
    }
}