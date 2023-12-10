

public class ItemSellFactory {

	public CalculateSellingPriceStrategy getCalculateSellingPrice(Item itemType) {
		if (itemType instanceof CDs) {
			return new CDsPriceStrategy();

		} else if (itemType instanceof ConsoleGame) {
			return new ConsoleGamesPriceStrategy();

		} else {
			System.out.println("We do not accept this item");
		}

		return null;

	}

}
