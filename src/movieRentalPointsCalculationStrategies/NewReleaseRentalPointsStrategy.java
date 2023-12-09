package movieRentalPointsCalculationStrategies;

public class NewReleaseRentalPointsStrategy implements CalculateRentalPointsStrategy {

	@Override
	public int calculateRentalPoints(int frequentRenterPoints, int daysRented) {
		frequentRenterPoints++;
		if (daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

}
