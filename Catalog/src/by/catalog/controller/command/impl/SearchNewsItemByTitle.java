package by.catalog.controller.command.impl;

import by.catalog.bean.NewsItem;
import by.catalog.controller.command.Command;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.factory.DAOFactory;
import by.catalog.service.CatalogService;
import by.catalog.service.factory.ServiceFactory;

import java.util.ArrayList;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class SearchNewsItemByTitle implements Command {
    String response = null;

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        String title = request.split(" ")[1];
        ArrayList<NewsItem> result = catalogService.searchNewsItemByTitle(title);
        if (result != null && result.size()>0) {
            response = "Result: \n";
            for(NewsItem item : result)
            {
                response+=item.toString()+"\n";
            }
            return response.trim();
        }

        return "Not Found";
    }
}
