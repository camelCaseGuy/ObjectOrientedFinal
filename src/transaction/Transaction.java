package transaction;

import rentalCoupons.Coupon;
import rentalCoupons.FreeMovie;
import rentalCoupons.HalfOffCoupon;
import rentalCoupons.TenDollarsOff;

public class Transaction {

	public double applyCoupon(double itemAmount) {
		Coupon tenOff = new TransactionDecorator(new TenDollarsOff());
		itemAmount = tenOff.applyCoupon(itemAmount);

		Coupon halfOff = new TransactionDecorator(new HalfOffCoupon());
		itemAmount = halfOff.applyCoupon(itemAmount);
		return itemAmount;
	}

	public double applyDiscountCoupon(double itemAmount) {
		Coupon halfOffCoupon = new TransactionDecorator(new HalfOffCoupon());
		itemAmount = halfOffCoupon.applyCoupon(itemAmount);
		return itemAmount;
	}

	public double applyFreeCoupon(double moviePrice, int rewardPoints) {
		Coupon freeMovie = new TransactionDecorator(new FreeMovie());
		moviePrice = freeMovie.applyCoupon(moviePrice, rewardPoints);
		return moviePrice;
	}

}
