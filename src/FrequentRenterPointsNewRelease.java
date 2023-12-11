public class FrequentRenterPointsNewRelease implements FrequentRenterPointsStrategy {

    /**
     * Calculate frequent rental points for a new release item based on the number of days rented.
     *
     * @param daysRented The number of days rented.
     * @return The calculated frequent rental points (1.0 if rented for 1 day, 2.0 otherwise).
     */
    @Override
    public Double getPoints(int daysRented) {
        if (daysRented > 1) {
            return 2.0;
        } else {
            return 1.0;
        }
    }
}
