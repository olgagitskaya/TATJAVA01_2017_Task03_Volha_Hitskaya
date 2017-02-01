package by.catalog.controller.command.impl;

import by.catalog.controller.command.Command;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.factory.DAOFactory;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class SearchNewsItemByTitle implements Command {
    String response = null;

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        if (catalogService.searchNewsItemByTitle(request) != null) {
            response = "NewsItem is found by title";
            return response;
        }

        return "NewsItem is not found by title";
    }
}
