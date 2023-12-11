import java.util.List;
import java.util.ArrayList;

/**
 * Represents a customer in the rental store.
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private List<Charge> charges = new ArrayList<>();
    private double frequentRenterPoints;

    /**
     * Constructs a Customer with a given name.
     *
     * @param inputName The full name of the customer.
     */
    public Customer(String inputName) {
        name = inputName;
    }

    /**
     * Adds a rental to the customer's list of rentals, applies any applicable coupon,
     * and updates the charges and frequent renter points accordingly.
     *
     * @param newRental The rental to be added.
     * @param coupon    The coupon to apply to the rental, if any.
     */
    public void addRental(Rental newRental, CouponList coupon) {
        addFrequentRenterPoints(newRental.getNewFrequentRenterPointsToAdd());
        applyCouponToRental(newRental, coupon);
        addRentalToCustomer(newRental);
        addChargeToCustomer(newRental); 
    }

    /**
     * Applies a coupon to a rental and updates points.
     */
    private void applyCouponToRental(Rental rental, CouponList coupon) {
        // Coupon logic is encapsulated in Rental's applyCoupon
        rental.applyCoupon(coupon, frequentRenterPoints);
        
        // Adjust customer's frequent rental points, if applicable 
        if ((coupon == CouponList.TEN_POINTS_FOR_FREE_MOVIE) && (frequentRenterPoints >= 10)) {
            frequentRenterPoints -= 10;
            frequentRenterPoints -= rental.getNewFrequentRenterPointsToAdd();
        } 
    }


    /**
     * Adds a rental to the customer's list.
     */
    private void addRentalToCustomer(Rental rental) {
        rentals.add(rental);
    }


    /**
     * Adds a charge to the customer's list based on the rental.
     */
    private void addChargeToCustomer(Rental rental) {
        charges.add(rental.getCharge());
    }

    /**
     * Removes a rental from the customer's list of rentals.
     *
     * @param rentalToRemove The rental to be removed.
     */
    public void removeRental(Rental rentalToRemove) {
        rentals.remove(rentalToRemove);
    }

    /**
     * Returns the customer's list of rentals.
     *
     * @return A list of the customer's rentals.
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * Returns the customer's list of charges.
     *
     * @return A list of the customer's charges.
     */
    public List<Charge> getCharges() {
        return charges;
    }

    /**
     * Returns the customer's name.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the total frequent renter points accumulated by the customer.
     *
     * @return The customer's frequent renter points.
     */
    public double getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    /**
     * Adds frequent renter points to the customer's balance.
     *
     * @param pointsToAdd The number of points to add to the balance.
     */
    public void addFrequentRenterPoints(double pointsToAdd) {
        frequentRenterPoints += pointsToAdd;
    }
}
