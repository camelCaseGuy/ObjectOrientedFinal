

// import movieRentalTransaction.Transaction;

public class Sell {

	public Item item;
	private int quantity;
	// private Transaction transaction = new Transaction();

	public Sell(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public double detemineSoldAmount(double itemAmount) {
		CalculateSellingPriceStrategy computeSellingPriceStrategy;
		computeSellingPriceStrategy = new ItemSellFactory().getCalculateSellingPrice(item);
		itemAmount = computeSellingPriceStrategy.CalculateSellingPrice(itemAmount, quantity);

		return itemAmount;
	}

}
