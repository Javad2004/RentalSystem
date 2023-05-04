import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private final List<Customer> customers;
    private final List<Item> items;
    private final List<Item> availableItems;

    public RentalStore() {
        this.customers = new ArrayList<>();
        this.items = new ArrayList<>();
        this.availableItems = new ArrayList<>();
    }

    public void register(Customer customer) {
        this.customers.add(customer);
        System.out.println("Registered successfully");
    }
    public void addItem(Item item) {
        this.items.add(item);
        this.availableItems.add(item);
        System.out.println("Added successfully");
    }
    public void removeItem(Item item) {
        boolean check = false;
        for (Item item_temp:items) {
            if (item_temp == item) {
                check = true;
                if (!this.availableItems.contains(item)) {
                    System.out.println("This item can't be removed because it's being borrowed");
                }
                else {
                    this.items.remove(item);
                    this.availableItems.remove(item);
                    System.out.println("Removed successfully");
                }
                break;
            }
        }
        if (!check) {
            System.out.println("Item Not found!");
        }
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void rentItem(Item item, Customer customer) {
        boolean customerChecker = false;
        for (Customer customer_temp:customers) {
            if (customer_temp == customer) {
                customerChecker = true;
                boolean itemChecker = false;
                for (Item item_temp:items) {
                    if (item_temp == item) {
                        itemChecker = true;
                        if(this.availableItems.contains(item)) {
                            this.availableItems.remove(item);
                            item.rentItem(customer);
                        }
                        else {
                            System.out.println("This item can't be borrowed because it's being borrowed by someone else");
                        }
                        break;
                    }
                }
                if(!itemChecker) {
                    System.out.println("Item not found!");
                }
                break;
            }
        }
        if(!customerChecker) {
            System.out.println("Customer not found!");
        }
    }

    public void returnItem(Rental rental) {
        boolean customerChecker = false;
        for (Customer customer:customers) {
            if (rental.getCustomer() == customer) {
                customerChecker = true;
                boolean itemChecker = false;
                for (Item item:items) {
                    if (rental.getItem() == item) {
                        itemChecker = true;
                        boolean rentalChecker = false;
                        for (Rental rental_temp:customer.getRentals()) {
                            if (rental_temp.getItem() == rental.getItem() && rental_temp.getCustomer() == rental.getCustomer() && rental_temp.getID() == rental.getID()) {
                                rentalChecker = true;
                                availableItems.add(item);
                                item.returnItem(rental);
                                break;
                            }
                        }
                        if (!rentalChecker) {
                            System.out.println("Not borrowed");
                        }
                        break;
                    }
                }
                if (!itemChecker) {
                    System.out.println("Item not found!");
                }
                break;
            }
        }
        if (!customerChecker) {
            System.out.println("Customer not found!");
        }

    }

    public Customer getCustomerByID(int ID) {
        boolean IDChecker = false;
        for (Customer customer:customers) {
            if (customer.getID() == ID) {
                return customer;
            }
        }
        if (!IDChecker){
            System.out.println("Not found!!!");
        }
        return null;
    }

    public Item getItemByID(int ID) {
        boolean IDChecker = false;
        for (Item item:items) {
            if (item.getID() == ID) {
                return item;
            }
        }
        if (!IDChecker){
            System.out.println("Not found!!!");
        }
        return null;
    }
}