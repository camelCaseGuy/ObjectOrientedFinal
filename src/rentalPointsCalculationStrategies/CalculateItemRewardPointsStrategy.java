package rentalPointsCalculationStrategies;

public class CalculateItemRewardPointsStrategy implements CalculateRewardPointsStrategy {

	public int calculateRewardPoints(int rewardPoints, int daysRented) {
		rewardPoints++;
		return rewardPoints;
	}
}
