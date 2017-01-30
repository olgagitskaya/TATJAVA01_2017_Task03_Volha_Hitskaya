package by.catalog.dao.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class XmlFileNewsItemDAO implements NewsItemDAO{

    private ArrayList<NewsItem> filmNews = new ArrayList<NewsItem>();
    private ArrayList<NewsItem> bookNews = new ArrayList<NewsItem>();
    private ArrayList<NewsItem> diskNews = new ArrayList<NewsItem>();

    private XmlFileNewsItemDAO()
    {
        try
        {
            loadInitFile();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private void loadInitFile() throws Exception
    {
        String filePath = new File("src/DataSource.xml").getAbsolutePath();
        File file = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        NodeList filmNewsList = document.getElementsByTagName("FilmNews").item(0).getChildNodes();
        for (Node node: )
        {
            String category = "FilmNews";
            String title = filmNewsList.item(i).getAttributes().getNamedItem("category").getNodeValue();
            String dateOfRelease = "";
            String additionalInfo = "";
            NewsItem newsItem = new NewsItem(category, title, dateOfRelease, additionalInfo);
            this.filmNews.add(newsItem);
        }
        NodeList bookNewsList = document.getElementsByTagName("BookNews").item(0).getChildNodes();
        for (int i = 0; i < bookNewsList.getLength(); i++)
        {
            String category = "BookNews";
            String title = "";
            String dateOfRelease = "";
            String additionalInfo = "";
            NewsItem newsItem = new NewsItem(category, title, dateOfRelease, additionalInfo);
            this.bookNews.add(newsItem);
        }
        NodeList diskNewsList = document.getElementsByTagName("DiskNews").item(0).getChildNodes();
        for (int i = 0; i < diskNewsList.getLength(); i++)
        {
            String category = "DiskNews";
            String title = "";
            String dateOfRelease = "";
            String additionalInfo = "";
            NewsItem newsItem = new NewsItem(category, title, dateOfRelease, additionalInfo);
            this.diskNews.add(newsItem);
        }
    }

    @Override
    public void addNewsItem()
    {

    }

    @Override
    public void searchNewsItem()
    {

    }

    @Override
    public void getAllNews()
    {

    }



}
