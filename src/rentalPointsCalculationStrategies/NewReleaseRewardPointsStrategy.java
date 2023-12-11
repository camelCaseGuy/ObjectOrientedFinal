package rentalPointsCalculationStrategies;

public class NewReleaseRewardPointsStrategy implements CalculateRewardPointsStrategy {

	@Override
	public int calculateRewardPoints(int rewardPoints, int daysRented) {
		rewardPoints++;
		if (daysRented > 1) {
			rewardPoints++;
		}
		return rewardPoints;
	}

}
