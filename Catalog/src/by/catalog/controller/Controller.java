package by.catalog.controller;

import by.catalog.controller.command.Command;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public final class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimeter = ' ';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
