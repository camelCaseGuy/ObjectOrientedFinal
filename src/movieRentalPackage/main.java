package movieRentalPackage;

public class Main {

// 1. Your new program must support different types of items including movies, video games, music CDs,
// 		xbox, ps4, and books. You must anticipate other new types of items as well.
// 2. Your new program must support not only renting, but also selling those items.
// 3. You should provide basic functions (e.g., computing rental price, frequent rental points, coupons)
//	  to support renting and selling transactions for those items in the store.

	public static void main(String[] args) {
		Customer smith = new Customer("Mr.Smith");

		Movie childrensmovie = new Movie("Movie 1", 2);
		Movie regularmovie = new Movie("Movie 2", 0);
		Movie newmovie = new Movie("Movie 3", 1);
		Movie secondnewmovie = new Movie("Movie 4", 1);
		Movie thirdnewmovie = new Movie("Movie 5", 1);
		Movie secondregularmovie = new Movie("Movie 6", 1);
		Movie fourthnewmovie = new Movie("Movie 7", 1);
		Movie fifthnewmovie = new Movie("Movie 8", 1);

		Rental one = new Rental(childrensmovie, 12);
		Rental two = new Rental(regularmovie, 7);
		Rental three = new Rental(newmovie, 7);
		Rental four = new Rental(secondnewmovie, 7);
		Rental five = new Rental(thirdnewmovie, 18);
		Rental six = new Rental(secondregularmovie, 18);
		Rental seven = new Rental(fourthnewmovie, 18);
		Rental eight = new Rental(fifthnewmovie, 4);

		// first rental price is 15, but 7.5 after 50% discount
		smith.addRental(one);
		// second rental is 9.5 but 4.75 after 50% discount 
		smith.addRental(two);
		// third rental is 21 but 10.5 after 50% discount 
		smith.addRental(three);
		// fourth rental is 21 but 10.5 after 50% discount 
		smith.addRental(four);
		// fifth rental is 54 but 22.0 after -10$ coupon and 50% discount 
		smith.addRental(five);
		// sixth rental is 54 but 22.0 after -10$ coupon and 50% discount 
		smith.addRental(six);
		// seventh movie is free since rental points added up to 10 here.
		// now they are zero since this movie was free and didn't give any rental points
		smith.addRental(seven);
		// eight movie cost is 12 but 6.0 after 50% off 
		smith.addRental(eight);
		// towards the end we have 2 rental points left after 10 were used earlier.

		System.out.println(smith.customerStatement());
	}

}