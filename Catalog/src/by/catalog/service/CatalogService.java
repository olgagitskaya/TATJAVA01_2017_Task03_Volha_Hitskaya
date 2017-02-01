package by.catalog.service;

import by.catalog.bean.NewsItem;
import by.catalog.dao.exception.DAOException;
import by.catalog.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public interface CatalogService {
        NewsItem addNewsItem(String request);
        NewsItem searchNewsItemByTitle(String request);
        ArrayList<NewsItem> searchNewsItemByNewsText(String request);
}
