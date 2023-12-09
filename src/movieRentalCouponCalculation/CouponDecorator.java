package movieRentalCouponCalculation;

public abstract class CouponDecorator implements Coupon {
	protected Coupon decoratedCoupon;

	public CouponDecorator(Coupon decoratedCoupon) {
		this.decoratedCoupon = decoratedCoupon;
	}

	public double applyCoupon(double movieAmount) {
		return decoratedCoupon.applyCoupon(movieAmount);
	}

	public double applyFreeMovieCoupon(int frequentRenterPoints) {
		return 0;
	}
}
