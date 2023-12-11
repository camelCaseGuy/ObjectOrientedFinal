/**
 * Price strategy for calculating rental charges for children's movies.
 */
public class MoviePriceChildrensStrategy implements PriceStrategy {
    @Override
    public Double calculatePrice(int daysRented) {
        Double chargeAmount = 1.5;

        // Calculate additional charges if rented for more than 3 days.
        if (daysRented > 3) {
            chargeAmount += (daysRented - 3) * 1.5;
        }

        return chargeAmount;
    }
}
