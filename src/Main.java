import core.RedisStore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Key-Value Store test...");
        RedisStore store = new RedisStore();

        // Test PUT operations
        store.put("name", "Alice");
        store.put("age", "30");
        store.put("city", "New York");

        // Test GET operations
        System.out.println("Name: " + store.get("name"));
        System.out.println("Age: " + store.get("age"));
        System.out.println("City: " + store.get("city")); // Should be NULL

        // Test DELETE operation
        store.delete("age");
        System.out.println("Age after delete: " + store.get("age")); // Should be NULL

        // Test size
        System.out.println("Current store size: " + store.size());

        // Test clear
        store.clear();
        System.out.println("Current store size after clear: " + store.size());

        System.out.println("Key-Value Store test finished.");
    }
}