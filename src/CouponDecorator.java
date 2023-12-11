/**
 * Decorator for applying coupon-based price (and points) modifications.
 */
public abstract class CouponDecorator implements PriceStrategy {
    protected PriceStrategy wrappedPriceStrategy; // The original price strategy being decorated.

    /**
     * Wraps a price strategy with a coupon.
     *
     * @param wrappedPriceStrategy The price strategy to be decorated.
     */
    public CouponDecorator(PriceStrategy wrappedPriceStrategy) {
        this.wrappedPriceStrategy = wrappedPriceStrategy;
    }
}
