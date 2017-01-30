package by.catalog.bean;

/**
 * Created by Volha_Hitskaya on 1/30/2017.
 */
public class NewsItem {
    private String category;
    private String title;
    private String dateOfRelease;
    private String additionalInfo;

    public NewsItem(String category, String title, String dateOfRelease, String additionalInfo) {
        this.category = category;
        this.title = title;
        this.dateOfRelease = dateOfRelease;
        this.additionalInfo = additionalInfo;
    }


}
