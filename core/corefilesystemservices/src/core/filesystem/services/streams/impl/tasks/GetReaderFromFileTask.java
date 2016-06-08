package core.filesystem.services.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class GetReaderFromFileTask extends FileSystemObject implements FileSystemTask
{
    public static Reader run(String filePath)
    {
        try
        {
            return new BufferedReader(new FileReader(filePath));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
}