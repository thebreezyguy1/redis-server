package core;

import java.util.concurrent.ConcurrentHashMap; // Use ConcurrentHashMap for thread safety

public class RedisStore {
    // Use ConcurrentHashMap to allow safe concurrent access from multiple threads
    private final ConcurrentHashMap<String, String> store;

    public RedisStore() {
        this.store = new ConcurrentHashMap<>();
    }

    /**
     * Puts a key-value pair into the store.
     * @param key The key to store.
     * @param value The value to associate with the key.
     */
    public void put(String key, String value) {
        store.put(key, value);
        System.out.println("PUT: " + key + " -> " + value);
    }

    /**
     * Retrieves the value associated with a key.
     * @param key The key to look up.
     * @return The value associated with the key, or null if the key is not found.
     */
    public String get(String key) {
        String value = store.get(key);
        System.out.println("GET: " + key + " -> " + (value != null ? value : "NULL"));
        return value;
    }

    /**
     * Removes a key-value pair from the store
     * @param key The key to remove.
     * @return The value that was removed, or null if the key was not found.
     */
    public String delete(String key) {
        String value = store.get(key);
        System.out.println("DELETE: " + key + " -> " + (value != null ? value : "NULL"));
        return value;
    }

    /**
     * Clears all key-value pairs from the store.
     */
    public void clear() {
        store.clear();
        System.out.println("Store cleared.");
    }

    /**
     * Returns the current size of the store.
     * @return The number of key-value pairs in the store.
     */
    public int size() {
        return store.size();
    }
}
