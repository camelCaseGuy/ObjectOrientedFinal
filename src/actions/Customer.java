package actions;

import java.util.ArrayList;
import java.util.List;

import items.Item;

public class Customer {
	private String _name;
	private double totalCharge = 0;
	private int rewardPoints = 0;
	public boolean halfOffCoupon = false;
	List<Rent> _rentals = new ArrayList<Rent>();
	List<Sell> _sellingItem = new ArrayList<Sell>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rent newRental) {
		_rentals.add(newRental);
	}

	public void addSellingItem(Sell arg) {
		_sellingItem.add(arg);
	}

	public void removeRental(Rent arg) {
		_rentals.remove(arg);
	}

	public String getName() {
		return _name;
	}

	public String customerSoldItemsReceipt() {
		String soldData = "";
		double totalAmount = 0;

		for (Sell selling : _sellingItem) {
			double itemAmount = 0;
			itemAmount = selling.detemineSoldAmount(itemAmount);

			Item item = selling.item;
			if (item != null) {
				totalAmount += itemAmount;
				soldData += "\n\t<Sold>\n\t\t<Title>" + String.valueOf(item.getItemName()) + "</Title>\n\t\t<Price>"
						+ itemAmount + "</Price>\n\t\t<Quantity>" + selling.quantity + "</Quantity>\n\t</Sold>";
			}
		}

		return printSoldXML(soldData, totalAmount);
	}

	public String customerRentalReceipt() {
		String movieInfo = "";

		for (Rent rental : _rentals) {
			double thisMovieCharge = 0;

			if (rental.isFreeCoupon(rewardPoints) && rewardPoints >= 10) {
				rewardPoints = rewardPoints - 10;
			} else {
				thisMovieCharge = rental.calculateRentalAmount(thisMovieCharge);
				rewardPoints = rental.calculateFrequentRentalPoints(rewardPoints);
			}
			
			if(this.halfOffCoupon) {
				thisMovieCharge = rental.HalfOffDiscountCoupon(thisMovieCharge);
			}

			movieInfo += "\t<Movie>\n\t\t<Title>" + rental.item.getItemName() + "</Title>\n\t\t<Price>"
					+ thisMovieCharge + "</Price>\n\t\t<Duration>" + rental.getDaysRented()
					+ "</Duration>\n\t</Movie>\n";
			totalCharge += thisMovieCharge;
		}

		return printRentalXML(movieInfo, totalCharge);
	}

	public String printRentalXML(String data, double amount) {
		String xmlString = "*****************RENTAL RECEIPT**********************\n";
		
		if(this.halfOffCoupon) {
			xmlString += "\t***WITH 50% OFF COUPON PRESENTED***\n";
		}
		
		xmlString += "<Record>\n\t<Name>" + getName()
				+ "</Name>\n" + data + "\t<AmountDue>" + amount + "</AmountDue>\n" + "\t<RentalPoints>"
				+ rewardPoints + "</RentalPoints>\n</Record>" + "\n\nThank you for renting our item!, "
				+ this._name + "!!!\n****************************************************\n";

		return xmlString;
	}

	public String printSoldXML(String data, double amount) {
		String xmlString = "*******************SELL RECEIPT*********************\n" + "<Record>\n\t<Name>" + getName()
				+ "</Name>" + data + "\n\t<Total>" + amount + "</Total>\n</Record>\n\nThank you for selling us your Item!, " + this._name
				+ "!!!\n****************************************************\n";

		return xmlString;
	}
}