package org.redis.server;

import org.redis.commands.CommandProcessor;
import org.redis.storage.DataStore;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * This class manages individual client connections and communication.
 */

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final CommandProcessor commandProcessor;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.commandProcessor = new CommandProcessor(new DataStore());
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Simple command parsing (will be enhanced later)
                String[] commandParts = inputLine.trim().split("\\s+");
                Object result = commandProcessor.processCommand(commandParts);
                out.println(result);
            }
        } catch (IOException e) {
            System.err.println("Error handling client connection: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
