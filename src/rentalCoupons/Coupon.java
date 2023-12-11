package rentalCoupons;

public interface Coupon {
	public double applyCoupon(double movieAmount);

	public double applyCoupon(double movieAmount, int rewardPoints);
}