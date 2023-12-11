package priceCalculationStrategies;

public class RegularRentalPriceStrategy implements CalculatePriceStrategy {
	double regularAmount = 2;
	int regularDays = 2;
	double regularMultiplier = 1.5;
	double itemPrice = 4;

	public double CalculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += regularAmount;
		if (daysRented > regularDays) {
			movieAmount += (daysRented - regularDays) * regularMultiplier;
		}
		return movieAmount;
	}

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}
}