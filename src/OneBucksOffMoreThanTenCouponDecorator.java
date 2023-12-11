public class OneBucksOffMoreThanTenCouponDecorator extends CouponDecorator {

    public OneBucksOffMoreThanTenCouponDecorator(PriceStrategy wrappedPriceStrategy) {
        super(wrappedPriceStrategy);
    }

    @Override
    public Double calculatePrice(int daysRented) {
        double originalPrice = wrappedPriceStrategy.calculatePrice(daysRented);
        return originalPrice > 10 ? originalPrice - 1 : originalPrice;
    }
}