import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Item {
    private String title;
    private String genre;
    private Date releaseDate;
    private int ID;
    private boolean isAvailable;

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
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public void rentItem(Customer customer) {
        this.setAvailable(false);
        Rental rental = new Rental(this, Integer.parseInt(this.getID() + String.valueOf(customer.getID())));

        try {
            customer.getRentals().add(rental);
        } catch (NullPointerException e) {
            List<Rental> rentals = new ArrayList<>();
            rentals.add(rental);
            customer.setRentals(rentals);
        }

        System.out.println("Item named " + this.getTitle() + " rented");
    }

    public void returnItem(Rental rental) {
        this.setAvailable(true);

        try {
            rental.getCustomer().getRentals().remove(rental);
            System.out.println("Item named " + this.getTitle() + " returned");
            System.out.println("Your lateFee: " + rental.calculateLateFee() + 'T');
        } catch (NullPointerException e) {
            System.out.println("No rentals");
        }

    }
}