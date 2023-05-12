import java.util.Date;

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

    public void rentItem(Customer customer) {
        this.setAvailable(false);
        Rental rental = new Rental(customer, this, Integer.parseInt(this.getID() + String.valueOf(customer.getID())));
        customer.getRentals().add(rental);
        System.out.println("Movie named " + this.getTitle() + " rented");
    }

    public void returnItem(Rental rental) {
        this.setAvailable(true);
        rental.getCustomer().getRentals().remove(rental);
        System.out.println("Movie named " + this.getTitle() + " returned");
        System.out.println("Your lateFee: " + rental.calculateLateFee() + 'T');
    }
}
