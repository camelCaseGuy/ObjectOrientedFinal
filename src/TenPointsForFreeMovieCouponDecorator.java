public class TenPointsForFreeMovieCouponDecorator extends CouponDecorator {
    private double frequentRenterPoints;

    public TenPointsForFreeMovieCouponDecorator(PriceStrategy wrappedPriceStrategy, double frequentRenterPoints) {
        super(wrappedPriceStrategy);
        this.frequentRenterPoints = frequentRenterPoints;
    }

    @Override
    public Double calculatePrice(int daysRented) {
        if (frequentRenterPoints >= 10) {
            return 0.0; // Free movie if they have at least 10 points.
        } else {
            return wrappedPriceStrategy.calculatePrice(daysRented);
        }
    }
}