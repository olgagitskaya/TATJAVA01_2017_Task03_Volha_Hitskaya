package by.catalog.dao.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
import by.catalog.dao.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class XmlFileNewsItemDAO implements NewsItemDAO{

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
        try{
            String filePath = new File("src/DataSource.xml").getAbsolutePath();
            File file = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            this.filmNews = loadNewsCategory(document,"FilmNews");
            this.bookNews = loadNewsCategory(document,"BookNews");
            this.diskNews = loadNewsCategory(document,"DiskNews");
        }catch(Exception e)
        {
            throw new DAOException("Error loading Xml File");
        }

    }

    public ArrayList<NewsItem> loadNewsCategory(Document document, String category)
    {
        ArrayList<NewsItem> news = new ArrayList<NewsItem>();
        NodeList newsList = document.getElementsByTagName(category).item(0).getChildNodes();
        for (int i=0; i < newsList.getLength(); i++)
        {
            String title = newsList.item(i).getAttributes().getNamedItem("title").getNodeValue();
            String dateOfRelease = newsList.item(i).getAttributes().getNamedItem("dateofrelease").getNodeValue();
            String additionalInfo = newsList.item(i).getAttributes().getNamedItem("additionalinfo").getNodeValue();
            String newsText = newsList.item(i).getTextContent();
            NewsItem newsItem = new NewsItem(category, title, dateOfRelease, additionalInfo, newsText);
            news.add(newsItem);
        }
        return news;
    }

    @Override
    public void addNewsItem(String category, NewsItem newsItem)
    {
        if(category.equals("FilmNews"))
        {
            this.filmNews.add(newsItem);
        }
        else if(category.equals("BookNews"))
        {
            this.bookNews.add(newsItem);
        }
        else if(category.equals("DiskNews"))
        {
            this.diskNews.add(newsItem);
        }
    }

    @Override
    public NewsItem getNewsItemByTitle(String title)
    {
        ArrayList<NewsItem> allNews = getAllNews();
        for(NewsItem newsItem: allNews)
            {
                if(newsItem.getTitle().equals(title))
                {
                    return newsItem;
                }
            }
        return null;
    }

    @Override
    public ArrayList<NewsItem> getNewsItemByNewsText(String text)
    {
        ArrayList<NewsItem> allNews = getAllNews();
        ArrayList<NewsItem> newsResults = new ArrayList<NewsItem>();
        for(NewsItem newsItem: allNews)
        {
            if(newsItem.getNewsText().contains(text))
            {
                newsResults.add(newsItem);
            }
        }
        return newsResults;
    }

    @Override
    public ArrayList<NewsItem> getAllNews()
    {
        ArrayList<NewsItem> allNews = new ArrayList();
        allNews.addAll(this.filmNews);
        allNews.addAll(this.bookNews);
        allNews.addAll(this.diskNews);
        return allNews;
    }



}
