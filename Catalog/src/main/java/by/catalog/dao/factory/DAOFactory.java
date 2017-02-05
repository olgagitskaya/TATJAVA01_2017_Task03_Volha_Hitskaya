package by.catalog.dao.factory;

import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.exception.DAOException;
import by.catalog.dao.impl.XmlFileNewsItemDAO;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public final class DAOFactory
{

    private static final DAOFactory instance = new DAOFactory();

    private final NewsItemDAO xmlFileNewsItemImpl;

    private DAOFactory()
    {
        NewsItemDAO xlmFileDAO = null;
        try
        {
            xlmFileDAO = new XmlFileNewsItemDAO();
        }
        catch (DAOException e)
        {
            xlmFileDAO = null;
        }
        finally
        {
            this.xmlFileNewsItemImpl = xlmFileDAO;
        }

    }

    public static DAOFactory getInstance()
    {

        return instance;
    }

    public NewsItemDAO getNewsItemDAO() throws DAOException
    {
        if (xmlFileNewsItemImpl == null)
        {
            throw new DAOException("DAO was not initialized");
        }
        return xmlFileNewsItemImpl;
    }
}
