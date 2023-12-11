public class FrequentRenterPointsDefault implements FrequentRenterPointsStrategy {

    /**
     * Calculate frequent rental points based on the number of days rented.
     *
     * @param daysRented The number of days rented (not used in this default implementation).
     * @return The calculated frequent rental points (1.0 in this default implementation).
     */
    @Override
    public Double getPoints(int daysRented) {
        // Parameter not used, but kept for maintainability and interchangeability
        return 1.0;
    }
}
