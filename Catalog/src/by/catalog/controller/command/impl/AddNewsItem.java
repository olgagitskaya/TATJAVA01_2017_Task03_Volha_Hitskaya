package by.catalog.controller.command.impl;

import by.catalog.controller.command.Command;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class AddNewsItem implements Command{
    String response = null;
    @Override
    public String execute(String request)
    {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        if(catalogService.addNewsItem(request)!=null)

        {
            response = "NewsItem added";
            return response;
        }

        return"NewsItem not added";

    }
}
