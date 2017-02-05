package by.catalog.dao.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class XmlFileNewsItemDAO implements NewsItemDAO
{

    private ArrayList<NewsItem> filmNews = new ArrayList<NewsItem>();
    private ArrayList<NewsItem> bookNews = new ArrayList<NewsItem>();
    private ArrayList<NewsItem> diskNews = new ArrayList<NewsItem>();


    public XmlFileNewsItemDAO() throws DAOException
    {
        try
        {
            loadDataSourceFile();
        }
        catch (DAOException e)
        {
            throw new DAOException(e);
        }
    }

    private void loadDataSourceFile() throws DAOException
    {
        try
        {
            String filePath = new File("src/DataSource.xml").getAbsolutePath();
            File file = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            this.filmNews = loadNewsCategory(document, "film");
            this.bookNews = loadNewsCategory(document, "book");
            this.diskNews = loadNewsCategory(document, "disk");
        }
        catch (Exception e)
        {
            throw new DAOException("Error loading Xml File");
        }

    }

    private ArrayList<NewsItem> loadNewsCategory(Document document, String category) throws DAOException
    {
        try
        {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr1 = xpath.compile("/catalog/" + category + "/newsItem");
            NodeList newsList = (NodeList) expr1.evaluate(document, XPathConstants.NODESET);
            ArrayList<NewsItem> news = new ArrayList<NewsItem>();
            for (int i = 0; i < newsList.getLength(); i++)
            {
                String title = newsList.item(i).getAttributes().getNamedItem("title").getNodeValue();
                String date = newsList.item(i).getAttributes().getNamedItem("date").getNodeValue();
                String additionalinfo = newsList.item(i).getAttributes().getNamedItem("additionalinfo").getNodeValue();
                NewsItem newsItem = new NewsItem(category, title, date, additionalinfo);
                news.add(newsItem);
            }
            return news;
        }
        catch (Exception e)
        {
            throw new DAOException("Error loading news category");
        }

    }

    @Override
    public void addNewsItem(String category, NewsItem newsItem)
    {
        if (category.equals("film"))
        {
            this.filmNews.add(newsItem);
        } else if (category.equals("book"))
        {
            this.bookNews.add(newsItem);
        } else if (category.equals("disk"))
        {
            this.diskNews.add(newsItem);
        }
    }

    @Override
    public ArrayList<NewsItem> getNewsItemsByTitleAndDate(String title, String date)
    {
        ArrayList<NewsItem> allNews = getAllNews();
        ArrayList<NewsItem> newsResults = new ArrayList<NewsItem>();
        if(title.isEmpty() && date.isEmpty())
        {
            return newsResults;
        }
        for (NewsItem newsItem : allNews)
        {
            boolean titleFound = true;
            if (!title.isEmpty() && !newsItem.getTitle().contains(title))
            {
                titleFound = false;
            }

            boolean dateFound = true;
            if (!date.isEmpty() && !newsItem.getDate().contains(date))
            {
                dateFound = false;
            }

            if (titleFound && dateFound)
            {
                newsResults.add(newsItem);
            }
        }
        return newsResults;
    }

    private ArrayList<NewsItem> getAllNews()
    {
        ArrayList<NewsItem> allNews = new ArrayList();
        allNews.addAll(this.filmNews);
        allNews.addAll(this.bookNews);
        allNews.addAll(this.diskNews);
        return allNews;
    }


}
