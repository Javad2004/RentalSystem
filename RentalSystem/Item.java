import java.util.Date;

public abstract class Item {
    private final String title;
    private final String genre;
    private final Date releaseDate;
    private final int ID;
    private final int rentalFee;
    private boolean available = true;

    public Item(String title, String genre, Date releaseDate, int ID, int rentalFee) {
        this.ID = ID;
        this.genre = genre;
        this.rentalFee = rentalFee;
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

    public int getRentalFee() {
        return rentalFee;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract void rentItem(Customer customer);
    public abstract void returnItem(Rental rental);
}
