package movieRentalCouponCalculation;

public class FreeMovie implements Coupon {

	public double applyCoupon(double movieAmount) {
		return movieAmount;
	}

	public double applyCoupon(double movieAmount, int frequentRenterPoints) {
		if (frequentRenterPoints >= 10) {
			movieAmount = 0;
		}
		return movieAmount;
	}
}
