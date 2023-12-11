public class FiftyPercentOffCouponDecorator extends CouponDecorator {

    public FiftyPercentOffCouponDecorator(PriceStrategy wrappedPriceStrategy) {
        super(wrappedPriceStrategy);
    }

    @Override
    public Double calculatePrice(int daysRented) {
        return wrappedPriceStrategy.calculatePrice(daysRented) * 0.5;
    }
}