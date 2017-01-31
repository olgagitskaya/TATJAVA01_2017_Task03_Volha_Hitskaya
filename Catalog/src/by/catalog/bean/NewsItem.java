package by.catalog.bean;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class NewsItem {
    private String category;
    private String title;
    private String dateOfRelease;
    private String additionalInfo;
    private String newsText;

    public NewsItem(String category, String title, String dateOfRelease, String additionalInfo, String newsText) {
        this.category = category;
        this.title = title;
        this.dateOfRelease = dateOfRelease;
        this.additionalInfo = additionalInfo;
        this.newsText = newsText;
    }


}