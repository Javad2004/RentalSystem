import java.util.Date;

public abstract class Item {
    private String title;
    private String genre;
    private Date releaseDate;
    private int ID;
    private boolean available = true;

    public Item(String title, String genre, Date releaseDate, int ID) {
        this.ID = ID;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void rentItem(Customer customer);
    public abstract void returnItem(Rental rental);
}