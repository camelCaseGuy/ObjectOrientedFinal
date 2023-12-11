package transaction;

import rentalCoupons.Coupon;
import rentalCoupons.CouponDecorator;

public class TransactionDecorator extends CouponDecorator {

	public TransactionDecorator(Coupon decoratedCoupon) {
		super(decoratedCoupon);
	}

	public double applyCoupon(double movieAmount) {
		return decoratedCoupon.applyCoupon(movieAmount);
	}

	public double applyCoupon(double movieAmount, int rewardPoints) {
		return 0;
	}

}
