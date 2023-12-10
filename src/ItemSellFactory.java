

public class ItemSellFactory {

	public CalculateSellingPriceStrategy getCalculateSellingPrice(Item itemType) {
		if (itemType instanceof CD) {
			return new CDPriceStrategy();

		} else if (itemType instanceof ConsoleGame) {
			return new ConsoleGamesPriceStrategy();

		} else {
			System.out.println("We do not accept this item");
		}

		return null;

	}

}
