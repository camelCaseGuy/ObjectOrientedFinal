package priceFactoryStrategies;

import items.*;
import rentalPointsCalculationStrategies.*;

public class CalculateRewardPointsFactoryStrategy {
	public CalculateRewardPointsStrategy getRentalPoints(Item item) {
		if (item instanceof Movie) {
			Movie movie = (Movie) item;
			if (movie.getPriceCode() == movie.REGULAR) {
				return new RegularRewardPointsStrategy();
			} else if (movie.getPriceCode() == movie.CHILDRENS) {
				return new ChildrenRewardPointsStrategy();
			} else if (movie.getPriceCode() == movie.NEW_RELEASE) {
				return new NewReleaseRewardPointsStrategy();
			} else {
				return new CalculateItemRewardPointsStrategy();
			}

		} else {
			return new CalculateItemRewardPointsStrategy();
		}

	}
}
