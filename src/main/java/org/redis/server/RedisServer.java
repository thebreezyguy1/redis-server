package org.redis.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedisServer {
    private final int port;
    private final ExecutorService threadPool;
    private boolean isRunning;

    public RedisServer(int port, int maxConnections) {
        this.port = port;
        this.threadPool = Executors.newFixedThreadPool(maxConnections);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Redis server started on port " + port);
            isRunning = true;

            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } finally {
            shutdown();
        }
    }

    public void shutdown() {
        isRunning = false;
        if (threadPool != null) {
            threadPool.shutdown();
        }
    }
}
