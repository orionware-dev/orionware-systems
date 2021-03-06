package datastructures.streams;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresService;

public interface StreamService<T> extends DataStructuresService
{
    public void forEach(Stream<T> stream, Consumer<?> action);
    
    
    public void forEach(Collection<T> collection, Consumer<?> action);
}