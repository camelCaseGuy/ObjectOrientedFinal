/**
 * Factory for creating frequent renter points strategies based on the price strategy type.
 */
public class FrequentRentalPointsStrategyFactory {

    /**
     * Get the frequent renter points strategy based on the price strategy type.
     *
     * @param strategyType The price strategy type.
     * @return The corresponding frequent renter points strategy.
     */
    public FrequentRenterPointsStrategy getFRPStrategy(PriceStrategies strategyType) {
        switch (strategyType) {
            case REGULAR:
            case CHILDRENS:
                return new FrequentRenterPointsDefault();
            case NEW_RELEASE:
                return new FrequentRenterPointsNewRelease();
            default:
                throw new IllegalArgumentException("Invalid frequent rental points strategy type.");
        }
    }
}
