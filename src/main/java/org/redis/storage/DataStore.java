package org.redis.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class implements the in-memory key-value storage using a thread-safe HashMap.
 */
public class DataStore {
    // The unique field of this class is a Map object
    private final Map<String, Object> store;

    public DataStore() {
        this.store = new ConcurrentHashMap<>();
    }

    public void set(String key, Object value) {
        store.put(key, value);
    }

    public Object get(String key) {
        return store.get(key);
    }

    public boolean exits(String key) {
        return store.containsKey(key);
    }

    public boolean delete(String key) {
        return store.remove(key) != null;
    }

    public void clear() {
        store.clear();
    }

    public int size() {
        return store.size();
    }
}
