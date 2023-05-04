import java.util.Date;

public class Game extends Item{
    private final String publisher;
    private final String platform;

    public Game(String title, String genre, String publisher, String platform, Date releaseDate, int ID, int rentalFee){
        super(title, genre, releaseDate, ID, rentalFee);
        this.publisher = publisher;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void rentItem(Customer customer) {
        this.setAvailable(false);
        Rental rental = new Rental(customer, this, Integer.parseInt(this.getID() + String.valueOf(customer.getID())));
        customer.getRentals().add(rental);
        System.out.println("Game named " + this.getTitle() + " rented");
    }

    public void returnItem(Rental rental) {
        this.setAvailable(true);
        rental.getCustomer().getRentals().remove(rental);
        System.out.println("Game named " + this.getTitle() + " returned");
        System.out.println("Your lateFee: " + rental.calculateLateFee() + 'T');
    }
}
