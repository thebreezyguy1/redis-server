package org.redis.commands;

/*
 * This class processes Redis commands by interpreting client requests and executing them against the DataStore.
 */

import org.redis.storage.DataStore;

public class CommandProcessor {
    private final DataStore dataStore;

    public CommandProcessor(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Object processCommand(String[] commandParts) {
        if (commandParts.length == 0) {
            return null;
        }

        String command = commandParts[0].toUpperCase();

        switch (command) {
            case "SET":
                if (commandParts.length < 3) return "ERROR: Invalid SET command";
                dataStore.set(commandParts[1], commandParts[2]);
                return "OK";
            case "GET":
                if (commandParts.length < 2) return "ERROR: Invalid GET command";
                Object value = dataStore.get(commandParts[1]);
                return value != null ? value : "(nil)";
            case "DEL":
                if (commandParts.length < 2) return "ERROR: Invalid DEL command";
                return dataStore.delete(commandParts[1]) ? 1 : 0;
            case "EXISTS":
                if (commandParts.length < 2) return "ERROR: Invalid EXISTS command";
                return dataStore.exits(commandParts[1]) ? 1 : 0;
            default:
                return "ERROR: Unknown command: '" + command + "'";
        }
    }
}
