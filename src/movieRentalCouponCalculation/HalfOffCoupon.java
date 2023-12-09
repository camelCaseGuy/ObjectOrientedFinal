package movieRentalCouponCalculation;

public class HalfOffCoupon implements Coupon {

	public double applyCoupon(double movieAmount) {
		return movieAmount / 2;
	}

	public double applyCoupon(double movieAmount, int frequentRenterPoints) {
		return 0;
	}

}
