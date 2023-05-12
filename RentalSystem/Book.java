import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Item{
    private String author;
    private String publisher;

    public Book(String title, String genre,String author ,String publisher, Date releaseDate, int ID) {
        super(title, genre, releaseDate, ID);
        this.author = author;
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
