package designpatterns;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternObject extends OrionObject
{
    public DesignPatternObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatterns");
        libraryConfiguration.setConfigurationFilePath("/configuration/Pipeline.prop");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}