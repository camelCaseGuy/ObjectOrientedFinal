/**
 * This is a simplified test program for demonstration purpose.
 */
 public class Test {

    public static void main(String[] args) {
        // Create a customer
        Customer customer1 = new Customer("Blob1");
        //customer1.addFrequentRenterPoints(88.88);
        customer1.addFrequentRenterPoints(10.00);
        //customer1.addFrequentRenterPoints(0.88);

        // Create movies
        Movie firstMovie1 = new Movie("nonono - regular", PriceStrategies.REGULAR);
        Movie firstMovie2 = new Movie("nonono 2 - children's", PriceStrategies.CHILDRENS);
        Movie firstMovie3 = new Movie("nonono 3 - new release", PriceStrategies.NEW_RELEASE);
        Movie firstMovie4 = new Movie("nonono 4 - new release also", PriceStrategies.NEW_RELEASE);

        // Assume we retrieve frequent renter points from the customer's profile

        // Create rentals with different coupons
        Rental movieRental1 = new Rental(firstMovie1, 12, 0);
        Rental movieRental2 = new Rental(firstMovie2, 2, 0);
        Rental movieRental3 = new Rental(firstMovie3, 20, 88.88);
        Rental movieRental4 = new Rental(firstMovie4, 12, 0);

        // Add rentals to the customer
        customer1.addRental(movieRental1, CouponList.NONE);
        customer1.addRental(movieRental2, CouponList.NONE);
        //customer1.addRental(movieRental3, CouponList.NONE);
        customer1.addRental(movieRental3, CouponList.ONE_BUCKS_OFF_MORE_THAN_10);
        customer1.addRental(movieRental4, CouponList.TEN_POINTS_FOR_FREE_MOVIE);
        //customer1.addRental(movieRental4, CouponList.ONE_BUCKS_OFF_MORE_THAN_10);
        //customer1.addRental(movieRental4, CouponList.TEN_POINTS_FOR_FREE_MOVIE);


        // Get customer details as XML
        String customerDetailsToPrint = XMLGenerator.getCustomerDetailsAsXMLString(customer1, false);

        // Format the XML to look pretty (assuming XMLTransformer is a utility class you've created)
        customerDetailsToPrint = XMLTransformer.prettyPrintByTransformer(customerDetailsToPrint, 4, false);

        // Print the formatted XML
        System.out.println("============");
        System.out.println(customerDetailsToPrint);
        System.out.println("============");
    }
}
