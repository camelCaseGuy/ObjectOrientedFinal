/**
 * Represents a rental transaction for an item.
 * Implements "transaction" interface (could be a "sale" or a "rental")
 */
public class Rental implements Transaction {
    private Item item;
    private int daysRented;
    private boolean isReturned;
    private Charge rentalCharge;
    // New FRPs are NOT able to be used with the 10 points for free movie:
    private Double newFrequentRentalPointsToAdd;
    private PriceStrategy priceStrategy;
    private FrequentRenterPointsStrategy frequentRentalPointsStrategy;
    private CouponList appliedCoupon;


    /**
     * Constructs a new Rental instance.
     *
     * @param item          The item being rented.
     * @param daysRented    The duration of the rental in days.
     * @param amountPaidNow The amount paid at the start of the rental.
     */    
    public Rental(Item item, int daysRented, double amountPaidNow) {

        this.item = item;
        this.daysRented = daysRented;
        this.isReturned = false;

        // Initialize frequent rental points using a strategy factory [based on item's priceStrategyCode]:
        FrequentRentalPointsStrategyFactory frpStratFactory = new FrequentRentalPointsStrategyFactory();
        this.frequentRentalPointsStrategy = frpStratFactory.getFRPStrategy(item.getPriceStrategyCode());
        this.newFrequentRentalPointsToAdd = frequentRentalPointsStrategy.getPoints(daysRented);

        // Get rental price using a factory [based on item's priceStrategyCode]:
        PriceStrategyFactory priceStrategyFactory = new PriceStrategyFactory();
        this.priceStrategy = priceStrategyFactory.getPriceStrategy(item.getPriceStrategyCode());
        this.rentalCharge = createCharge(priceStrategy.calculatePrice(daysRented), amountPaidNow);
    }




    /**
     * Gets the number of days the item is rented for.
     *
     * @return The number of days rented.
     */
    public int getDaysRented() {
        return daysRented;
    }

    /**
     * Gets the rented item.
     *
     * @return The rented item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Checks if the rental has been returned.
     *
     * @return True if the rental has been returned, false otherwise.
     */
    public boolean getIsReturned() {
        return isReturned;
    }

    /**
     * Implements getCharge() from the interface "Transaction".
     * Gets the charge associated with the rental.
     *
     * @return The charge for the rental.
     */
    @Override
    public Charge getCharge() {
        return rentalCharge;
    }

    /**
     * Gets the new frequent rental points to add based on the rental.
     *
     * @return The number of frequent rental points to add.
     */
    public Double getNewFrequentRenterPointsToAdd() {
        return newFrequentRentalPointsToAdd;
    }

    /**
     * Sets the rental as returned.
     */
    public void setReturned() {
        isReturned = true;
    }


    /**
     * Calculates the rental charge based on the total amount and the amount paid at the time of rental.
     *
     * @param totalAmount     The total rental amount.
     * @param amountPaidNow   The amount paid at the time of rental.
     * @return The rental charge.
     */
    private Charge createCharge(Double totalAmount, double amountPaidNow) {
        return new Charge(totalAmount, amountPaidNow);
    }


    /**
     * Applies a coupon to the rental, modifying the price and tracking the coupon used.
     * 
     * (**Any Frequent renter points operations based on coupon will be made in Customer.addrental()).
     * 
     * @param coupon                   The coupon to apply.
     * @param customersFrequentRenterPoints The current frequent renter points of the customer.
     */
    public void applyCoupon(CouponList coupon, double customersFrequentRenterPoints) {
        // Logic to apply the coupon to the rental's price
        CouponFactory couponFactory = new CouponFactory();
        
        //this.newFrequentRentalPointsToAdd
        this.priceStrategy = couponFactory.getCouponDecorator(this.priceStrategy, coupon, customersFrequentRenterPoints);
        
        // Recalculate the charge after applying the coupon
        this.rentalCharge = createCharge(this.priceStrategy.calculatePrice(this.daysRented), this.rentalCharge.getAmountPaid());
        
        this.appliedCoupon = coupon;
    }

    public CouponList getAppliedCoupon() {
        return appliedCoupon;
    }

}
