

public class RegularRentalPointsStrategy implements CalculateRentalPointsStrategy {
	@Override
	public int calculateRentalPoints(int frequentRenterPoints, int daysRented) {
		frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
