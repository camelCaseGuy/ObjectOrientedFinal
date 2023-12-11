package rentalCoupons;

public class FreeMovie implements Coupon {

	public double applyCoupon(double movieAmount) {
		return movieAmount;
	}

	public double applyCoupon(double movieAmount, int rewardPoints) {
		if (rewardPoints >= 10) {
			System.out.println("APPLIED FREE MOVIE COUPON" + rewardPoints);
			movieAmount = 0;
		}
		return movieAmount;
	}
}
