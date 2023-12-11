package priceCalculationStrategies;

public class ExtraPointsPriceStrategy implements CalculatePriceStrategy {

	double itemPrice = .1;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

	public double CalculateRentalPrice(double itemAmount, int daysRented) {
		// itemAmount += itemPrice * daysRented;
		return itemAmount;
	}

}