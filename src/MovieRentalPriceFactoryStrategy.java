// public class MovieRentalPriceFactoryStrategy {
// 	public CalculateRentalPriceStrategy getRentalPrice(Movie movie) {
// 		if (movie.getPriceCode() == Movie.REGULAR) {
// 			return new RegularRentalPriceStrategy();
// 		} else if (movie.getPriceCode() == Movie.CHILDRENS) {
// 			return new ChildrenRentalPriceStrategy();
// 		} else if (movie.getPriceCode() == Movie.NEW_RELEASE) {
// 			return new NewReleaseRentalPriceStrategy();
// 		} else {
// 			System.out.println("Unknown movie type/category");
// 		}
// 		return null;
// 	}

// }