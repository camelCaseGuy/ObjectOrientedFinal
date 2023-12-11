package priceCalculationStrategies;

public interface CalculatePriceStrategy {

	public double CalculateSellingPrice(double itemAmount, int quantity);

	public double CalculateRentalPrice(double itemAmount, int daysRented);
}
