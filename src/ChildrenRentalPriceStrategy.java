

public class ChildrenRentalPriceStrategy implements CalculateRentalPriceStrategy {
	double childrenAmount = 1.5;
	int childrenDays = 3;
	double childrenMultiplier = 1.5;

	@Override
	public double calculateRentalPrice(double movieAmount, int daysRented) {
		movieAmount += childrenAmount;
		if (daysRented > childrenDays) {
			movieAmount += (daysRented - childrenDays) * childrenMultiplier;
		}
		return movieAmount;
	}

}