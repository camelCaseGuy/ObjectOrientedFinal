package movieRentalPriceCalculationStrategies;

public class RegularRentalPriceStrategy implements CalculateRentalPriceStrategy {
	double regularAmount = 2;
	int regularDays = 2;
	double regularMultiplier = 1.5;

	@Override
	public double calculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += regularAmount;
		if (daysRented > regularDays) {
			movieAmount += (daysRented - regularDays) * regularMultiplier;
		}
		return movieAmount;
	}
}