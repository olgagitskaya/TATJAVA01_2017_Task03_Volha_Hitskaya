package by.catalog.service;

import by.catalog.bean.NewsItem;
import by.catalog.service.exception.ServiceException;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public interface CatalogService {
        NewsItem addNewsItem(String request) throws ServiceException;
        String searchNewsItemByTitle(String request) throws ServiceException;
        String searchNewsItemByNewsText(String request) throws ServiceException;
}
