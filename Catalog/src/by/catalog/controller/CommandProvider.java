package by.catalog.controller;

import by.catalog.controller.command.Command;
import by.catalog.controller.command.CommandName;
import by.catalog.controller.command.impl.AddNewsItem;
import by.catalog.controller.command.impl.SearchNewsItemByNewsText;
import by.catalog.controller.command.impl.SearchNewsItemByTitle;
import by.catalog.controller.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
final class CommandProvider
{
    private final Map<String, Command> commandList = new HashMap<>();

    CommandProvider()
    {
        commandList.put(CommandName.ADD_NEWS_ITEM, new AddNewsItem());
        commandList.put(CommandName.SEARCH_NEWS_ITEM_TITLE, new SearchNewsItemByTitle());
        commandList.put(CommandName.SEARCH_NEWS_ITEM_TEXT, new SearchNewsItemByNewsText());
        commandList.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name)
    {
        String commandName = name.toUpperCase();
        //Command command = null;
        if (commandList.containsKey(commandName))
        {
            return commandList.get(commandName);
        }
        return commandList.get(CommandName.WRONG_REQUEST);
    }
}
