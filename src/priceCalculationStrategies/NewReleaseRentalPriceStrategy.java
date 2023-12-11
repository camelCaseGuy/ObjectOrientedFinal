package priceCalculationStrategies;

public class NewReleaseRentalPriceStrategy implements CalculatePriceStrategy {
	int newReleaseDays = 3;
	double itemPrice = 6;

	public double CalculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += daysRented * newReleaseDays;
		return movieAmount;
	}

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

}
