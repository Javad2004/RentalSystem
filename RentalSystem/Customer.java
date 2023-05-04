import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String email;
    private final String phone_number;
    private final String address;
    private final int ID;
    private final List<Rental> rentals;

    public Customer(String name, String email, String phone_number, String address, int ID) {
        this.name= name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.ID = ID;
        this.rentals = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
