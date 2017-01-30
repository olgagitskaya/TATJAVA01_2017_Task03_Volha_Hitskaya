package by.catalog.dao.factory;

import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.impl.XmlFileNewsItemDAO;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final NewsItemDAO xmlFileNewsItemImpl = new XmlFileNewsItemDAO();

    private DAOFactory() { }

    public static DAOFactory getInstance() {
        return instance;
    }

    public NewsItemDAO getNewsItemDAO() {
        return xmlFileNewsItemImpl;
    }
}
