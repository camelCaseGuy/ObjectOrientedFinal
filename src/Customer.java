

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	// private int _quantity;
	private double totalCharge = 0;
	private int frequentRenterPoints = 0;
	List<Rental> _rentals = new ArrayList<Rental>();
	List<Sell> _sellingItem = new ArrayList<Sell>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental newRental) {
		_rentals.add(newRental);
	}
	
	public void addSellingItem(Sell newSellingItem) {
		_sellingItem.add(newSellingItem);
	}

	public void removeRental(Rental newRental) {
		_rentals.remove(newRental);
	}

	public String getName() {
		return _name;
	}
    
	public String customerSoldItemsReceipt() {
		String soldData = "";
		double soldAmount = 0;

		for (Sell selling : _sellingItem) {
			soldAmount = 0;
			soldAmount = selling.detemineSoldAmount(soldAmount);

			Item item = selling.item;
			if(item != null) {
				soldData += "\n\t<Sold>\n\t\t<Title>" + String.valueOf(item.getItemName())+
                        "</Title>\n\t\t<Price>" + String.valueOf(soldAmount) + "</Price>\n\t</Sold>";
            }
		}

		return printSoldXML(soldData, soldAmount);
	}

	public String customerRentalReceipt() {
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

		return printRentalXML(movieInfo, totalCharge);
	}

	public String printRentalXML(String data, double amount) {
		String xmlString = 
				"*****************RENTAL RECEIPT**********************\n"
				+ "<Record>\n\t<Name>" + getName() + "</Name>\n" + data + "\t<AmountDue>" + amount
				+ "</AmountDue>\n" + "\t<RentalPoints>" + frequentRenterPoints + "</RentalPoints>\n</Record>"
				+ "\n\nThank you for renting our item!, " + this._name 
				+ "!!!\n****************************************************\n";

		return xmlString;
	}
	
	public String printSoldXML(String data, double amount) {
		String xmlString = 	"*******************SELL RECEIPT*********************\n"
				+ "<Record>\n\t<Name>" + getName() + "</Name>" + data + "\n</Record>"
				+ "\n\nThank you for selling us your Item!, " + this._name 
				+ "!!!\n****************************************************\n";

		return xmlString;
	}
}