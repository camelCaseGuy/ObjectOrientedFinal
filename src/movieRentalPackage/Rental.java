package movieRentalPackage;

import movieRentalPointsCalculationFactory.MovieRentalPointsFactoryStrategy;
import movieRentalPointsCalculationStrategies.CalculateRentalPointsStrategy;
import movieRentalPriceCalculationFactory.MovieRentalPriceFactoryStrategy;
import movieRentalPriceCalculationStrategies.CalculateRentalPriceStrategy;
import movieRentalTransaction.Transaction;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	// rental price before applying any coupons. We need to add a sales price
	private double moviePrice;
	// used to apply coupons
	private Transaction transaction;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
		this.transaction = new Transaction();
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double calculateRentalAmount(double movieAmount) {
		CalculateRentalPriceStrategy calculateRentalPriceStrategy;
		calculateRentalPriceStrategy = new MovieRentalPriceFactoryStrategy().getRentalPrice(_movie);
		movieAmount = calculateRentalPriceStrategy.calculateRentalPrice(movieAmount, _daysRented);
		movieAmount = transaction.applyCoupon(movieAmount);
		moviePrice = movieAmount;
		return movieAmount;

	}

	public int calculateFrequentRentalPoints(int frequentRenterPoints) {
		CalculateRentalPointsStrategy calculateRentalPointsStrategy;
		calculateRentalPointsStrategy = new MovieRentalPointsFactoryStrategy().getRentalPoints(_movie);
		frequentRenterPoints = calculateRentalPointsStrategy.calculateRentalPoints(frequentRenterPoints, _daysRented);
		return frequentRenterPoints;
	}

	public boolean isFreeMovie(int frequentRenterPoints) {
		double movieAmount = transaction.applyFreeMovieCoupon(moviePrice, frequentRenterPoints);

		if (movieAmount == 0) {
			return true;
		} else {
			return false;
		}
	}

}