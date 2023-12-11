package rentalPointsCalculationStrategies;

public class RegularRewardPointsStrategy implements CalculateRewardPointsStrategy {
	@Override
	public int calculateRewardPoints(int rewardPoints, int daysRented) {
		rewardPoints++;
		return rewardPoints;
	}
}
