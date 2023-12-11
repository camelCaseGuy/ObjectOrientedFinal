package priceCalculationStrategies;

public class BooksPriceStrategy implements CalculatePriceStrategy {

	double itemPrice = 4;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

	public double CalculateRentalPrice(double itemAmount, int daysRented) {
		itemAmount += itemPrice * daysRented;
		return itemAmount;
	}

}