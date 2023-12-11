// Decorator Abstract Class for coupons implementaion:
public abstract class RentalDecorator implements Transaction {
    protected Transaction rental;

    public RentalDecorator(Transaction rental) {
        this.rental = rental;
    }
}