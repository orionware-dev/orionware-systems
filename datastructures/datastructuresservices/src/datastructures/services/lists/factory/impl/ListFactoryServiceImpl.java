package datastructures.services.lists.factory.impl;

import core.OrionSimpleObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.tasks.CreateEmptyArrayListTask;

public class ListFactoryServiceImpl<T> extends OrionSimpleObject implements ListFactoryService<T>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionList<T> createEmptyArrayList(Class<T> listType)
    {
        return new CreateEmptyArrayListTask().run(listType);
    }
}