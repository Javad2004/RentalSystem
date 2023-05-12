import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game extends Item{
    private String publisher;
    private String platform;

    public Game(String title, String genre, String publisher, String platform, Date releaseDate, int ID){
        super(title, genre, releaseDate, ID);
        this.publisher = publisher;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
