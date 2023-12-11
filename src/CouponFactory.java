/**
 * Factory class for creating price strategy decorators based on coupons.
 * It enhances the original pricing strategy with additional behaviors defined by the coupons.
 */
public class CouponFactory {

    /**
     * Creates a decorated PriceStrategy based on the given coupon type.
     *
     * @param originalStrategy The original pricing strategy to be decorated.
     * @param couponType       The type of coupon to apply to the pricing strategy.
     * @param points           The number of points the customer has, which is relevant for certain coupons.
     * @return A PriceStrategy decorated with the appropriate coupon, or the original strategy if no coupon is applicable.
     */
    public PriceStrategy getCouponDecorator(PriceStrategy originalStrategy, CouponList couponType, double points) {
        switch (couponType) {
            case FIFTY_PERCENT_OF_TOTAL:
                // Decorates the strategy with a 50% discount.
                return new FiftyPercentOffCouponDecorator(originalStrategy);
            case ONE_BUCKS_OFF_MORE_THAN_10:
                // Decorates the strategy with a $1 discount for totals over $10.
                return new OneBucksOffMoreThanTenCouponDecorator(originalStrategy);
            case TEN_POINTS_FOR_FREE_MOVIE:
                // Decorates the strategy to offer a free movie if the customer has enough points.
                return new TenPointsForFreeMovieCouponDecorator(originalStrategy, points);
            case NONE:
            default:
                // No decoration is applied; returns the original strategy.
                return originalStrategy;
        }
    }
}
