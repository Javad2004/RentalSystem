import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie extends Item{
    private String director;
    private String cast;

    public Movie(String title, String genre, String director, String cast, Date releaseDate, int ID) {
        super(title, genre, releaseDate, ID);
        this.director = director;
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
