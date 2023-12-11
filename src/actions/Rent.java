package actions;

import items.Item;
import priceCalculationStrategies.CalculatePriceStrategy;
import priceFactoryStrategies.CalculatePriceFactoryStrategy;
import priceFactoryStrategies.CalculateRewardPointsFactoryStrategy;
import rentalPointsCalculationStrategies.CalculateRewardPointsStrategy;
import transaction.Transaction;

public class Rent {
	public Item item;
	private int _daysRented;
	private double itemPrice;
	private Transaction transaction;

	public Rent(Item item, int daysRented) {
		this.item = item;
		this._daysRented = daysRented;
		this.transaction = new Transaction();
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public double calculateRentalAmount(double itemAmount) {
		CalculatePriceStrategy calculateRentalPrice;
		calculateRentalPrice = new CalculatePriceFactoryStrategy().getCalculateRentalPrice(item);
		itemAmount = calculateRentalPrice.CalculateRentalPrice(itemAmount, _daysRented);

		return itemAmount;
	}

	public int calculateFrequentRentalPoints(int rewardPoints) {
		CalculateRewardPointsStrategy calculateRentalPointsStrategy;
		calculateRentalPointsStrategy = new CalculateRewardPointsFactoryStrategy().getRentalPoints(item);
		rewardPoints = calculateRentalPointsStrategy.calculateRewardPoints(rewardPoints, _daysRented);

		// System.out.println("RENTALPOINTS" + rewardPoints);
		return rewardPoints;
	}

	public boolean isFreeCoupon(int rewardPoints) {
		double itemAmount = transaction.applyFreeCoupon(itemPrice, rewardPoints);
		if ((int) itemAmount == 0) {
			// System.out.println("TRUE! "+movieAmount);
			return true;
		} else {
			return false;
		}
	}
	
	public double HalfOffDiscountCoupon(double itemAmount) {
		itemAmount = transaction.applyDiscountCoupon(itemAmount);
		return itemAmount;
	}

}