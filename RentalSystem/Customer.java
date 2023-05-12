import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phone_number;
    private String address;
    private int ID;
    private List<Rental> rentals;

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
