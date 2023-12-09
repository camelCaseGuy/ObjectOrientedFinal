package movieRentalPriceCalculationFactory;

import movieRentalPackage.Movie;
import movieRentalPriceCalculationStrategies.CalculateRentalPriceStrategy;
import movieRentalPriceCalculationStrategies.ChildrenRentalPriceStrategy;
import movieRentalPriceCalculationStrategies.NewReleaseRentalPriceStrategy;
import movieRentalPriceCalculationStrategies.RegularRentalPriceStrategy;

public class MovieRentalPriceFactoryStrategy {
	public CalculateRentalPriceStrategy getRentalPrice(Movie movie) {
		if (movie.getPriceCode() == movie.REGULAR) {
			return new RegularRentalPriceStrategy();
		} else if (movie.getPriceCode() == movie.CHILDRENS) {
			return new ChildrenRentalPriceStrategy();
		} else if (movie.getPriceCode() == movie.NEW_RELEASE) {
			return new NewReleaseRentalPriceStrategy();
		} else {
			System.out.println("Unknown movie type/category");
		}
		return null;
	}

}