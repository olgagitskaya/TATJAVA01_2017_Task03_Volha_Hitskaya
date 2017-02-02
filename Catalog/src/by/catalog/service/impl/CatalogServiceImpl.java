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
    public NewsItem addNewsItem(String request)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",3);
        String category = "";
        String title = "";
        String newsText = "";
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        NewsItem newsItem = new NewsItem(category,title,dateFormat.format(currentDate),newsText);
        newsItemDAO.addNewsItem(category,newsItem);
        return newsItem;
    }

    @Override
    public NewsItem searchNewsItemByTitle(String request)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",4);
        NewsItem result = newsItemDAO.getNewsItemByTitle(inputString[2]);
        return result;
    }

    @Override
    public ArrayList<NewsItem> searchNewsItemByNewsText(String request)
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",3);
        ArrayList<NewsItem> result = newsItemDAO.getNewsItemByNewsText(inputString[2]);
        return result;
    }
}
