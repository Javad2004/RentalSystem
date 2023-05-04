import java.util.Date;

public class Book extends Item{
    private final String author;
    private final String publisher;

    public Book(String title, String genre,String author ,String publisher, Date releaseDate, int ID, int rentalFee) {
        super(title, genre, releaseDate, ID, rentalFee);
        this.author = author;
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void rentItem(Customer customer) {
        this.setAvailable(false);
        Rental rental = new Rental(customer, this, Integer.parseInt(this.getID() + String.valueOf(customer.getID())));
        customer.getRentals().add(rental);
        System.out.println("Book named " + this.getTitle() + " rented");
    }

    public void returnItem(Rental rental) {
        this.setAvailable(true);
        rental.getCustomer().getRentals().remove(rental);
        System.out.println("Book named " + this.getTitle() + " returned");
        System.out.println("Your lateFee: " + rental.calculateLateFee() + 'T');
    }
}
