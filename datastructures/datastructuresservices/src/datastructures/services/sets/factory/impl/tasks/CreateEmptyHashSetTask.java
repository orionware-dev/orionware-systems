package datastructures.services.sets.factory.impl.tasks;

import datastructures.DataStructuresTask;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructures.services.DataStructuresServicesObject;
import datastructures.sets.OrionHashSet;
import datastructures.sets.OrionSet;

public class CreateEmptyHashSetTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public OrionSet<T> run(Class<T> setType)
    {
        return new OrionHashSet<T>();
    }
}