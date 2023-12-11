/**
 * Defines an interface for frequent renter points strategies.
 */
public interface FrequentRenterPointsStrategy {

    /**
     * Calculate frequent renter points based on the number of days rented.
     *
     * @param daysRented The number of days the item is rented for.
     * @return The calculated frequent renter points as a Double.
     */
    Double getPoints(int daysRented);
}
