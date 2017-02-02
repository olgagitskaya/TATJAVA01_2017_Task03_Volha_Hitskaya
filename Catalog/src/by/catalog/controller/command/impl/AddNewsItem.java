package by.catalog.controller.command.impl;

import by.catalog.bean.NewsItem;
import by.catalog.controller.command.Command;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class AddNewsItem implements Command
{
    String response = null;

    @Override
    public String execute(String request)
    {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        String[] inputString = request.split(" ", 4);
        String category = inputString[1];
        String title = inputString[2];
        String additionalinfo = inputString[3];
        NewsItem result = catalogService.addNewsItem(category, title, additionalinfo);
        if (result != null)
        {
            response = "NewsItem added\n" + result.toString();
            return response;
        }
        return "Not Added";
    }
}
