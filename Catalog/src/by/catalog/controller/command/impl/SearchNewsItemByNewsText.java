package by.catalog.controller.command.impl;

import by.catalog.bean.NewsItem;
import by.catalog.controller.command.Command;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

/**
 * Created by Volha_Hitskaya on 2/1/2017.
 */

public class SearchNewsItemByNewsText implements Command {
    String response = null;
    @Override
    public String execute(NewsItem newsItem) {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    CatalogService catalogService = serviceFactory.getCatalogService();
        if(catalogService.searchNewsItemByNewsText(newsItem.toString())!=null)

    {
        response = "NewsItem is found by text";
        return response;
    }

        return"NewsItem is not found by text";
}
}
