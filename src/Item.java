/**
 * This is an abstract class for representing items.
 * It declares constant fields and methods that are abstract by default.
 * This serves as a generic abstract class for items.
 */
public abstract class Item {

    private String type; // Item type, e.g., "movie" - to use when saving to a database.
    private String title; // Item's "name," e.g., "movie name," "audio file name".

    // Item price strategy code - special custom field:
    private PriceStrategies priceStrategyCode;

    /**
     * Constructs an Item object with the specified attributes.
     *
     * @param type           The type of the item, e.g., "movie."
     * @param title          The name of the item, e.g., "movie name."
     * @param priceCode      The price strategy code for the item.
     */
    public Item(String type, String title, PriceStrategies priceCode) {
        this.type = type;
        this.title = title;
        this.priceStrategyCode = priceCode;
    }

    /**
     * Gets the type of the item.
     *
     * @return The item type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the price strategy code for the item.
     *
     * @param priceCode The new price strategy code to set.
     */
    public void setPriceStrategyCode(PriceStrategies priceCode) {
        this.priceStrategyCode = priceCode;
    }

    /**
     * Gets the title of the item.
     *
     * @return The item title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the price strategy code for the item.
     *
     * @return The price strategy code for the item.
     */
    public PriceStrategies getPriceStrategyCode() {
        return priceStrategyCode;
    }
}
