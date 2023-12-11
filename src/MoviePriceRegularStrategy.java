/**
 * Price strategy for calculating rental charges for regular movies.
 */
public class MoviePriceRegularStrategy implements PriceStrategy {
    @Override
    public Double calculatePrice(int daysRented) {
        double chargeAmount = 2.0;

        // Calculate additional charges if rented for more than 2 days.
        if (daysRented > 2) {
            chargeAmount += (daysRented - 2) * 1.5;
        }

        return chargeAmount;
    }
}
