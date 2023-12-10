

public class CDsPriceStrategy implements CalculateSellingPriceStrategy {

	double itemPrice = 2;

	public double CalculateSellingPrice(double itemAmount, int quantity) {
		itemAmount += itemPrice * quantity;
		return itemAmount;
	}

}