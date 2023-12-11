package actions;

import items.*;

public class Cart {

	public static void main(String[] args) {
		// CUSTOMER MR SMITH WENT TO OUR STORE
		Customer smith = new Customer("Mr.Smith");

		// HE BOUGHT A FEW ITEMS SUCH AS:
		
		// Different types of movies
		Item<Movie> childrensmovie = new Movie("CINDERALLA", 2);
		Item<Movie> regularmovie = new Movie("BIG HERO 6", 0);
		Item<Movie> newmovie = new Movie("MISSION IMPOSSIBLE", 1);
		
		// Video games
		Item<ConsoleGames> ps5Game = new ConsoleGames("SPIDERMAN");
		Item<ConsoleGames> godOfWar = new ConsoleGames("GOD OF WAR");
		
		// Music
		Item<CDs> powerRangers = new CDs("Power Rangers Theme Song");
		
		// Snacks
		Item<Snacks> Pringles = new Snacks("Salty Pringles");
		Item<Snacks> Chocolate = new Snacks("Chocolate");

		
		// Books
		Item<Books> HarryPotter = new Books("Harry Potter");
		Item<Books> Captain = new Books("Captain");
		Item<Books> ABC = new Books("ABC");

		// Extra points
		Item<ExtraPoints> extraPoints = new ExtraPoints("Extra Points");

		// HE RENTED THOSE ITEMS after presenting a half off discount
		smith.halfOffCoupon = true;
		smith.addRental(new Rent(childrensmovie, 5));
		smith.addRental(new Rent(regularmovie, 3));
		smith.addRental(new Rent(newmovie, 7));
		smith.addRental(new Rent(ps5Game, 2));
		smith.addRental(new Rent(godOfWar, 2));
		smith.addRental(new Rent(powerRangers, 5));
		smith.addRental(new Rent(Pringles, 1));
		smith.addRental(new Rent(Chocolate, 1));
		smith.addRental(new Rent(HarryPotter, 2));
		smith.addRental(new Rent(Captain, 2));
		smith.addRental(new Rent(ABC, 2)); // free book after 10 rental points

		
		// AND THEN SOLD THEM 
		smith.addSellingItem(new Sell(childrensmovie, 1));
		smith.addSellingItem(new Sell(regularmovie, 1));
		smith.addSellingItem(new Sell(newmovie, 1));
		smith.addSellingItem(new Sell(ps5Game, 1));
		smith.addSellingItem(new Sell(godOfWar, 1));
		smith.addSellingItem(new Sell(powerRangers, 1));
		smith.addSellingItem(new Sell(Pringles, 1));
		smith.addSellingItem(new Sell(Chocolate, 1));
		smith.addSellingItem(new Sell(HarryPotter, 1));
		smith.addSellingItem(new Sell(Captain, 1));
		smith.addSellingItem(new Sell(ABC, 2));
		smith.addSellingItem(new Sell(extraPoints, 1000));

		// RENTAL THEN SELLER RECEIPTS PRINTED
		System.out.println(smith.customerRentalReceipt());
		System.out.println(smith.customerSoldItemsReceipt());
	}

}