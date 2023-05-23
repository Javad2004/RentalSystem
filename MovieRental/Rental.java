import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rental {
    private final Customer customer;
    private final Movie movie;
    private final Date rentalDate;
    private Date returnDate;
    private final int ID;

    public Rental(Customer customer, Movie movie, int ID) {
        this.customer = customer;
        this.movie = movie;
        this.ID = ID;
        this.rentalDate = new Date();
        // Adding 7 days to rentalDate to create return date
        this.returnDate = new Date(rentalDate.getTime() + TimeUnit.DAYS.toMillis(7));
    }

    public int getID() {
        return ID;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double calculateLateFee() {
        int lateFee = 10000;
        Date date = new Date();

        long diffInMillie = date.getTime() - this.returnDate.getTime();
        long diff = TimeUnit.DAYS.convert(diffInMillie, TimeUnit.MILLISECONDS);

        if(diff<=0) {
            return 0;
        }
        return lateFee * diff;
    }
}
