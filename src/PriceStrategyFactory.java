public class PriceStrategyFactory {

    /**
     * Creates and returns a price strategy based on the provided strategy type.
     *
     * @param strategyType The type of price strategy to create.
     * @return The created price strategy.
     * @throws IllegalArgumentException if an invalid strategy type is provided.
     */
    public PriceStrategy getPriceStrategy(PriceStrategies strategyType) {
        switch (strategyType) {
            case REGULAR:
                return new MoviePriceRegularStrategy();
            case CHILDRENS:
                return new MoviePriceChildrensStrategy();
            case NEW_RELEASE:
                return new MoviePriceNewReleaseStrategy();
            default:
                throw new IllegalArgumentException("Invalid price strategy type");
        }
    }
}
