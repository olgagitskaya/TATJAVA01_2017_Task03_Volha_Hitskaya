package by.catalog.service.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.factory.DAOFactory;
import by.catalog.service.CatalogService;
import by.catalog.service.exception.ServiceException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class CatalogServiceImpl implements CatalogService {
    @Override
    public NewsItem addNewsItem(String category, String title, String additionalInfo)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        NewsItem newsItem = new NewsItem(category.toLowerCase(),title,dateFormat.format(currentDate),additionalInfo);
        newsItemDAO.addNewsItem(category.toLowerCase(),newsItem);
        return newsItem;
    }

    @Override
    public ArrayList<NewsItem>  searchNewsItemByTitle(String title)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        ArrayList<NewsItem> result = newsItemDAO.getNewsItemsByTitle(title);
        return result;
    }

    @Override
    public ArrayList<NewsItem> searchNewsItemByDate(String date)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        ArrayList<NewsItem> result = newsItemDAO.getNewsItemByDate(date);
        return result;
    }
}
