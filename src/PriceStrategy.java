/**
 * Defines an interface for price strategies.
 */
public interface PriceStrategy {

    /**
     * Get the rental amount based on the number of rental days.
     *
     * @param days The number of days the item is rented for.
     * @return The rental amount as a Double.
     */
    Double calculatePrice(int days);
}
