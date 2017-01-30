package by.catalog.controller;

import by.catalog.controller.command.Command;
import by.catalog.controller.command.CommandName;
import by.catalog.controller.command.impl.AddNewsItem;
import by.catalog.controller.command.impl.SearchNewsItem;
import by.catalog.controller.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_NEWS_ITEM, new AddNewsItem());
        repository.put(CommandName.SEARCH_NEWS_ITEM, new SearchNewsItem());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try
        {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e)
        {    //write log
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
