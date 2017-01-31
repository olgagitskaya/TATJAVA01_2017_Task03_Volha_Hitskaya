package by.catalog.dao.impl;

import by.catalog.bean.NewsItem;
import by.catalog.dao.NewsItemDAO;
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
    ArrayList<NewsItem> allNews = new ArrayList();

    private XmlFileNewsItemDAO() //обработать exception !!!!!!!!!!
    {
        try
        {
            loadDataSourceFile();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private void loadDataSourceFile() throws Exception
    {
        String filePath = new File("src/DataSource.xml").getAbsolutePath();
        File file = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        this.filmNews = loadNewsCategory(document,"FilmNews");
        this.bookNews = loadNewsCategory(document,"BookNews");
        this.diskNews = loadNewsCategory(document,"DiskNews");
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
    public void addNewsItem()
    {

    }

    @Override
    public void searchNewsItemByTitle(String title) //обработать Exception!!!
    {
        try{
            for(NewsItem newsItem: allNews)
            {
                if(newsItem.getClass().getField(title).)

            }
        }catch(Exception e){
            throw new RuntimeException(e);
    }


    }

    @Override //?
    public ArrayList<NewsItem> getAllNews()
    {
        allNews.addAll(this.filmNews);
        allNews.addAll(this.bookNews);
        allNews.addAll(this.diskNews);
        return allNews;
    }



}
