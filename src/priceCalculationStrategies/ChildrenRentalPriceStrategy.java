package priceCalculationStrategies;

public class ChildrenRentalPriceStrategy implements CalculatePriceStrategy {
	double childrenAmount = 1.5;
	int childrenDays = 3;
	double childrenMultiplier = 1.5;
	double itemPrice = 2;

	public double CalculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += childrenAmount;
		if (daysRented > childrenDays) {
			movieAmount += (daysRented - childrenDays) * childrenMultiplier;
		}
		return movieAmount;
	}

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

}