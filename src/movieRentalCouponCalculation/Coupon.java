package movieRentalCouponCalculation;

public interface Coupon {
	public double applyCoupon(double movieAmount);

	public double applyCoupon(double movieAmount, int frequentRenterPoints);
}