package movieRentalPointsCalculationStrategies;

public class ChildrenRentalPointsStrategy implements CalculateRentalPointsStrategy {
	@Override
	public int calculateRentalPoints(int frequentRenterPoints, int daysRented) {
		frequentRenterPoints++;
		return frequentRenterPoints;
	}
}