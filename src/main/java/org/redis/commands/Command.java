package org.redis.commands;

/*
 * This interface defines the contract for all Redis commands.
 */

public interface Command {
    /**
     * Executes the commands with the given arguments
     * @param args The command arguments
     * @return The result of the command execution
     */
    Object execute(String[] args);

    /**
     * @return The name of the command
     */
    String getName();

    /**
     * @return The minimum number of arguments required
     */
    int getArgsCount();
}
