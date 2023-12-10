

public class ConsoleGamesPriceStrategy implements CalculateSellingPriceStrategy {

	double itemPrice = 5;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}
}