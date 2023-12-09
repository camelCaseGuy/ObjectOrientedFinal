package movieRentalPackage;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private double totalCharge = 0;
	private int frequentRenterPoints = 0;
	List<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental newRental) {
		_rentals.add(newRental);
	}

	public void removeRental(Rental newRental) {
		_rentals.remove(newRental);
	}

	public String getName() {
		return _name;
	}

	public String customerStatement() {
		String movieInfo = "";

		for (Rental rental : _rentals) {
			double thisMovieCharge = 0;

			if (rental.isFreeMovie(frequentRenterPoints) && frequentRenterPoints >= 10) {
				frequentRenterPoints = frequentRenterPoints - 10;
			} else {
				thisMovieCharge = rental.calculateRentalAmount(thisMovieCharge);
				frequentRenterPoints = rental.calculateFrequentRentalPoints(frequentRenterPoints);
			}

			movieInfo += "\t<Movie>\n\t\t<Title>" + rental.getMovie().getTitle() + "</Title>\n\t\t<Price>"
					+ thisMovieCharge + "</Price>\n\t\t<Duration>" + rental.getDaysRented()
					+ "</Duration>\n\t</Movie>\n";
			totalCharge += thisMovieCharge;
		}

		return printXML(movieInfo, totalCharge);
	}

	public String printXML(String movieData, double amountDue) {
		String xmlString = "<Record>\n\t<Name>" + getName() + "</Name>\n" + movieData + "\t<AmountDue>" + amountDue
				+ "</AmountDue>\n" + "\t<RentalPoints>" + frequentRenterPoints + "</RentalPoints>\n</Record>"
				+ "\n\nThank you for choosing us, " + this._name + "!!!";

		return xmlString;
	}
}