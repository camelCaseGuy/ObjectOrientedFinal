

public class TenDollarsOff implements Coupon {

	public double applyCoupon(double totalAmount) {
		if (totalAmount >= 50) {
			return totalAmount -= 10;
		} else {
			return totalAmount;
		}
	}

	public double applyCoupon(double movieAmount, int frequentRenterPoints) {
		return 0;
	}

}
