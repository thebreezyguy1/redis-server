package org.redis;

import org.redis.server.RedisServer;

public class Main {
    public static void main(String[] args) {
        int port = 6379; // Default Redis port
        int maxConnections = 50; // Default max connections

        // Parse command line arguments if provided
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number. Using default: " + port);
            }
        }

        if (args.length > 1) {
            try {
                maxConnections = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid max connections. Using default: " + maxConnections);
            }
        }

        try {
            RedisServer server = new RedisServer(port, maxConnections);
            server.start();
        } catch (Exception e) {
            System.err.println("Error starting server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}