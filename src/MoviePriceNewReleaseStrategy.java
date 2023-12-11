/**
 * Price strategy for calculating rental charges for new release movies.
 */
public class MoviePriceNewReleaseStrategy implements PriceStrategy {
    @Override
    public Double calculatePrice(int daysRented) {
        // Calculate the rental amount
        return daysRented * 3.0; // Using 3.0 to ensure the result is a Double.
    }
}
