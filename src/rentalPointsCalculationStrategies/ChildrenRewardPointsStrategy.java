package rentalPointsCalculationStrategies;

public class ChildrenRewardPointsStrategy implements CalculateRewardPointsStrategy {
	@Override
	public int calculateRewardPoints(int rewardPoints, int daysRented) {
		rewardPoints++;
		return rewardPoints;
	}
}