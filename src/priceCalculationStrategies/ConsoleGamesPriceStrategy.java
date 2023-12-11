package priceCalculationStrategies;

public class ConsoleGamesPriceStrategy implements CalculatePriceStrategy {

	double itemPrice = 5;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

	public double CalculateRentalPrice(double itemAmount, int daysRented) {
		itemAmount += itemPrice * daysRented;
		return itemAmount;
	}
}