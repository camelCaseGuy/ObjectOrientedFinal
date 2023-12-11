package priceFactoryStrategies;

import items.*;
import priceCalculationStrategies.*;

public class CalculatePriceFactoryStrategy<T> {

	public CalculatePriceStrategy getCalculateSellingPrice(T itemType) {
		if (itemType instanceof Movie) {
			Movie movie = (Movie) itemType;
			if (movie.getPriceCode() == Movie.REGULAR) {
				return new RegularRentalPriceStrategy();
			} else if (movie.getPriceCode() == Movie.CHILDRENS) {
				return new ChildrenRentalPriceStrategy();
			} else if (movie.getPriceCode() == Movie.NEW_RELEASE) {
				return new NewReleaseRentalPriceStrategy();
			} else {
				System.out.println("We do not accept this item");
			}
		} else if (itemType instanceof CDs) {
			return new CDsPriceStrategy();

		} else if (itemType instanceof ConsoleGames) {
			return new ConsoleGamesPriceStrategy();

		} else if (itemType instanceof Books) {
			return new BooksPriceStrategy();

		} else if (itemType instanceof Snacks) {
			return new SnacksPriceStrategy();

		} else if (itemType instanceof ExtraPoints) {
			return new ExtraPointsPriceStrategy();

		}else {
			System.out.println("We do not accept this item");
		}

		return null;

	}

	public CalculatePriceStrategy getCalculateRentalPrice(T itemType) {
		if (itemType instanceof Movie) {
			Movie movie = (Movie) itemType;
			if (movie.getPriceCode() == Movie.REGULAR) {
				return new RegularRentalPriceStrategy();
			} else if (movie.getPriceCode() == Movie.CHILDRENS) {
				return new ChildrenRentalPriceStrategy();
			} else if (movie.getPriceCode() == Movie.NEW_RELEASE) {
				return new NewReleaseRentalPriceStrategy();
			} else {
				System.out.println("Unknown movie type/category");
			}
		} else if (itemType instanceof CDs) {
			return new CDsPriceStrategy();

		} else if (itemType instanceof ConsoleGames) {
			return new ConsoleGamesPriceStrategy();

		} else if (itemType instanceof Books) {
			return new BooksPriceStrategy();

		} else if (itemType instanceof Snacks) {
			return new SnacksPriceStrategy();

		} else {
			System.out.println("We do not accept this item");
		}

		return null;

	}

}
