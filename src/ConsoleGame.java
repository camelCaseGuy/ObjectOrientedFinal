public class ConsoleGame extends Item {

    /**
     * Constructs a Movie object with the given title and price code.
     *
     * @param title     The title of the movie.
     * @param priceStrategyCode The price strategy code for the movie.
     */
    public ConsoleGame(String title, PriceStrategies priceStrategyCode) {
        // Calls the constructor of the parent class (Item) to set type, title, and price code.
        super("movie", title, priceStrategyCode);
    }
}
