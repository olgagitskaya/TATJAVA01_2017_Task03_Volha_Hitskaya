package by.catalog.service.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.factory.DAOFactory;
import by.catalog.service.CatalogService;
import by.catalog.service.exception.ServiceException;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class CatalogServiceImpl implements CatalogService {
    @Override
    public NewsItem addNewsItem(String request)  throws ServiceException
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",3);
        NewsItem newsItem = new NewsItem(inputString[2]); //???
        return newsItemDAO.addNewsItem(inputString[1],newsItem);
    }

    @Override
    public String searchNewsItemByTitle(String request)  throws ServiceException
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",4);
        return newsItemDAO.getNewsItemByTitle(inputString[2]);
    }

    @Override
    public String searchNewsItemByNewsText(String request)  throws ServiceException
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsItemDAO newsItemDAO = daoObjectFactory.getNewsItemDAO();
        String [] inputString = request.split(" ",3);
        return newsItemDAO.getNewsItemByNewsText(inputString[2]);
    }
}
