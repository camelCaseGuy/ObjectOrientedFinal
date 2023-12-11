/**
 * Represents a charge (for a rental in our case).
 */
public class Charge {
    private double amountTotal; // The total amount of the charge.
    private double amountPaid;  // The amount paid for the charge.

    /**
     * Constructs a charge object with the specified total amount and amount paid.
     *
     * @param amountTotal  The total amount of the charge.
     * @param amountPaid   The amount paid for the charge.
     */
    public Charge(double amountTotal, double amountPaid) {
        this.amountTotal = amountTotal;
        this.amountPaid = amountPaid;
    }

    /**
     * Gets the total amount of the charge.
     *
     * @return The total amount.
     */
    public double getAmountTotal() {
        return amountTotal;
    }

    /**
     * Gets the amount paid for the charge.
     *
     * @return The amount paid.
     */
    public double getAmountPaid() {
        return amountPaid;
    }
}
