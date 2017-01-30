package by.catalog.service;

import by.catalog.bean.NewsItem;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public interface CatalogService {
        void addNewsItem(NewsItem newsItem);
        void searchNewsItem(NewsItem newsItem);
}
