package movieRentalPointsCalculationFactory;

import movieRentalPackage.Movie;
import movieRentalPointsCalculationStrategies.CalculateRentalPointsStrategy;
import movieRentalPointsCalculationStrategies.ChildrenRentalPointsStrategy;
import movieRentalPointsCalculationStrategies.NewReleaseRentalPointsStrategy;
import movieRentalPointsCalculationStrategies.RegularRentalPointsStrategy;

public class MovieRentalPointsFactoryStrategy {
	public CalculateRentalPointsStrategy getRentalPoints(Movie movie) {
		if (movie.getPriceCode() == movie.REGULAR) {
			return new RegularRentalPointsStrategy();
		} else if (movie.getPriceCode() == movie.CHILDRENS) {
			return new ChildrenRentalPointsStrategy();
		} else if (movie.getPriceCode() == movie.NEW_RELEASE) {
			return new NewReleaseRentalPointsStrategy();
		} else {
			System.out.println("Unknown Type or Category");
		}
		return null;
	}
}
