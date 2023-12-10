
public class Main {

	public static void main(String[] args) {
		// CUSTOMER RENTING
		Customer smith = new Customer("Mr.Smith");

		Movie childrensmovie = new Movie("Movie 1", 2);
		Movie regularmovie = new Movie("Movie 2", 0);
		Movie newmovie = new Movie("Movie 3", 1);

		Rental one = new Rental(childrensmovie, 12);
		Rental two = new Rental(regularmovie, 7);
		Rental three = new Rental(newmovie, 7);

		smith.addRental(one);
		smith.addRental(two);
		smith.addRental(three);

		
		// CUSTOMER SELLING
		Customer amigo = new Customer("Amigo");

		Item powerRangers = new CDs("Power Rangers");
		Item godOfWar = new ConsoleGame("godOfWar");

		amigo.addSellingItem(new Sell(powerRangers, 10));
		amigo.addSellingItem(new Sell(godOfWar, 10));

		// RENTAL THEN SELLER RECEIPTS PRINTED
		System.out.println(smith.customerRentalReceipt());
		System.out.println(amigo.customerSoldItemsReceipt());
	}

}