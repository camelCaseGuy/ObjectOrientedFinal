package actions;

import items.Item;
import priceCalculationStrategies.CalculatePriceStrategy;
import priceFactoryStrategies.CalculatePriceFactoryStrategy;
import transaction.Transaction;

public class Sell {

	public Item item;
	public int quantity;
	private Transaction transaction;

	public Sell(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
		this.transaction = new Transaction();
	}

	public double detemineSoldAmount(double itemAmount) {
		CalculatePriceStrategy computeSellingPriceStrategy;
		computeSellingPriceStrategy = new CalculatePriceFactoryStrategy().getCalculateSellingPrice(item);
		itemAmount = computeSellingPriceStrategy.CalculateSellingPrice(itemAmount, quantity);

		return itemAmount;
	}

}
