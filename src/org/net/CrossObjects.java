package org.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drwozd on 26.06.16.
 */
public class CrossObjects
{
    private static CrossObjects crossObjects = null;

    private Map<String, Object> objectMap = new HashMap<>();

    public Object getObject(String id)
    {
        return objectMap.get(id);
    }

    public void addObject(String id, Object object)
    {
        objectMap.put(id, object);
    }

    public Object removeObject(String id)
    {
        return objectMap.remove(id);
    }

    public static synchronized CrossObjects getPool()
    {
        if (crossObjects == null)
            crossObjects = new CrossObjects();
        return crossObjects;
    }
}