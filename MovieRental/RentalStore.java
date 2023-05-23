import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private List<Customer> customers;
    private List<Movie> movies;
    private List<Movie> availableMovies;

    public RentalStore() {
        this.customers = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.availableMovies = new ArrayList<>();
    }

    public void register(Customer customer) {
        this.customers.add(customer);
        System.out.println("Registered successfully");
    }
    public void addMovie(Movie movie) {
        this.movies.add(movie);
        this.availableMovies.add(movie);
        System.out.println("Added successfully");
    }
    public void removeMovie(Movie movie) {
        boolean check = false;
        for (Movie movie_temp:movies) {
            if (movie_temp == movie) {
                check = true;
                if (!this.availableMovies.contains(movie)) {
                    System.out.println("This movie can't be removed because it's rented");
                }
                else {
                    this.movies.remove(movie);
                    this.availableMovies.remove(movie);
                    System.out.println("Removed successfully");
                }
                break;
            }
        }
        if (!check) {
            System.out.println("Movie Not found!");
        }
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setAvailableMovies(List<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void rentMovie(Movie movie, Customer customer) {
        boolean customerChecker = false;
        for (Customer customer_temp:customers) {
            if (customer_temp == customer) {
                customerChecker = true;
                boolean itemChecker = false;
                for (Movie movie_temp:movies) {
                    if (movie_temp == movie) {
                        itemChecker = true;
                        if(this.availableMovies.contains(movie)) {
                            this.availableMovies.remove(movie);
                            movie.rentMovie(customer);
                        }
                        else {
                            System.out.println("This movie can't be rented because it's rented already");
                        }
                        break;
                    }
                }
                if(!itemChecker) {
                    System.out.println("movie not found!");
                }
                break;
            }
        }
        if(!customerChecker) {
            System.out.println("Customer not found!");
        }
    }

    public void returnMovie(Rental rental) {
        boolean customerChecker = false;
        for (Customer customer:customers) {
            if (rental.getCustomer() == customer) {
                customerChecker = true;
                boolean itemChecker = false;
                for (Movie movie:movies) {
                    if (rental.getMovie() == movie) {
                        itemChecker = true;
                        boolean rentalChecker = false;
                        try {
                            for (Rental rental_temp:customer.getRentals()) {
                                if (rental_temp == rental) {
                                    rentalChecker = true;
                                    availableMovies.add(movie);
                                    movie.returnMovie(rental);
                                    break;
                                }
                            }
                            if (!rentalChecker) {
                                System.out.println("Not borrowed");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("No rentals");
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

    public Movie getMovieByID(int ID) {
        boolean IDChecker = false;
        for (Movie movie:movies) {
            if (movie.getID() == ID) {
                return movie;
            }
        }
        if (!IDChecker){
            System.out.println("Not found!!!");
        }
        return null;
    }
}
