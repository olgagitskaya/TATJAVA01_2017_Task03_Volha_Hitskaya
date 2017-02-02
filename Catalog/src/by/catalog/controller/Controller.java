package by.catalog.controller;

import by.catalog.bean.NewsItem;
import by.catalog.controller.command.Command;

import java.util.Date;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public final class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimeter = ' ';
    private final char category = ' ';
    private final char title = ' ';
    private final char date = ' ';
    private final char text = ' ';

    public String executeCommand(String request) {
        String commandName = request.substring(0, request.indexOf(paramDelimeter));
        String inputString = request.split(" ", )
        String categoryFromRequest = request.substring(1, request.indexOf(category));
        String titleFromRequest = request.substring(2, request.indexOf(title));
        String dateFromRequest = request.substring(3, request.indexOf(date));
        String textFromRequest = request.substring(4, request.indexOf(text));
        Command executionCommand = provider.getCommand(commandName);
        NewsItem newsItem = new NewsItem(categoryFromRequest, titleFromRequest,dateFromRequest,textFromRequest);
        String response = executionCommand.execute(newsItem);
        return response;
    }
}
