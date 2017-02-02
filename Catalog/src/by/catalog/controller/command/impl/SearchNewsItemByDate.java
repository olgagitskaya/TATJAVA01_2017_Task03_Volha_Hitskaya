package by.catalog.controller.command.impl;

import by.catalog.bean.NewsItem;
import by.catalog.controller.command.Command;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

import java.util.ArrayList;

/**
 * Created by Volha_Hitskaya on 2/1/2017.
 */

public class SearchNewsItemByDate implements Command
{
    String response = null;

    @Override
    public String execute(String request)
    {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        String date = request.split(" ")[1];
        ArrayList<NewsItem> result = catalogService.searchNewsItemByDate(date);
        if (result != null && result.size() > 0)
        {
            response = "Result: \n";
            for (NewsItem item : result)
            {
                response += item.toString() + "\n";
            }
            return response.trim();
        }

        return "Not Found";
    }
}
