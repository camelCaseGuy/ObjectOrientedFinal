public class MovieRentalPointsFactoryStrategy {
	public CalculateRentalPointsStrategy getRentalPoints(Movie movie) {
		if (movie.getPriceCode() == Movie.REGULAR) {
			return new RegularRentalPointsStrategy();
		} else if (movie.getPriceCode() == Movie.CHILDRENS) {
			return new ChildrenRentalPointsStrategy();
		} else if (movie.getPriceCode() == Movie.NEW_RELEASE) {
			return new NewReleaseRentalPointsStrategy();
		} else {
			System.out.println("Unknown Type or Category");
		}
		return null;
	}
}
