package priceCalculationStrategies;

public class SnacksPriceStrategy implements CalculatePriceStrategy {

	double itemPrice = 2;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

	public double CalculateRentalPrice(double itemAmount, int daysRented) {
		itemAmount += itemPrice * daysRented;
		return itemAmount;
	}

}