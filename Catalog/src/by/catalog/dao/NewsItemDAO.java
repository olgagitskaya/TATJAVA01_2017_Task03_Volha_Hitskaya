package by.catalog.dao;

import by.catalog.bean.NewsItem;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public interface NewsItemDAO {
    void addNewsItem(String category, NewsItem newsItem);
    String getNewsItemByTitle(String title);
    ArrayList<NewsItem> getNewsItemByNewsText(String text);
    ArrayList<NewsItem> getAllNews();
//    void getFilmNews();
//    void getBookNews();
//    void getDiskNews();
}
