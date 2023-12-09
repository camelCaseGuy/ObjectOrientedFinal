package movieRentalPriceCalculationStrategies;

public class NewReleaseRentalPriceStrategy implements CalculateRentalPriceStrategy {
	int newReleaseDays = 3;

	@Override
	public double calculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += daysRented * newReleaseDays;
		return movieAmount;
	}

}
