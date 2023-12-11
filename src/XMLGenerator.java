import java.util.List;

public class XMLGenerator {
    /**
     * Generates an XML representation of customer details.
     *
     * @param customer The customer object to be converted to XML.
     * @param printCharges Set to "true" to include a list of charges in the XML.
     * @return An XML string representing the customer details.
     */
    public static String getCustomerDetailsAsXMLString(Customer customer, Boolean printCharges) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<customer>");
        xmlBuilder.append("<name>").append(customer.getName()).append("</name>");
        xmlBuilder.append("<frequentRenterPoints>").append(customer.getFrequentRenterPoints())
                .append("</frequentRenterPoints>");

        // List rentals, if applicable
        List<Rental> customerRentals = customer.getRentals();

        if (!customerRentals.isEmpty()) {
            xmlBuilder.append("<rentals>");
            for (Rental rental : customerRentals) {
                xmlBuilder.append("<rental>");
                xmlBuilder.append("<item>");
                xmlBuilder.append("<itemType>").append(rental.getItem().getType()).append("</itemType>");
                xmlBuilder.append("<itemName>").append(rental.getItem().getTitle()).append("</itemName>");
                xmlBuilder.append("</item>");

                xmlBuilder.append("<daysRented>").append(rental.getDaysRented()).append("</daysRented>");
                xmlBuilder.append("<chargeAmountTotal>").append(rental.getCharge().getAmountTotal())
                        .append("</chargeAmountTotal>");
                xmlBuilder.append("</rental>");
            }
            xmlBuilder.append("</rentals>");
        }

        // Add an explicit list of charges, if applicable
        if (printCharges) {
            List<Charge> customerCharges = customer.getCharges();

            if (!customerCharges.isEmpty()) {
                xmlBuilder.append("<charges>");
                for (Charge charge : customerCharges) {
                    xmlBuilder.append("<charge>");
                    xmlBuilder.append("<total>").append(charge.getAmountTotal()).append("</total>");
                    xmlBuilder.append("<paid>").append(charge.getAmountPaid()).append("</paid>");
                    xmlBuilder.append("</charge>");
                }
                xmlBuilder.append("</charges>");
            }
        }

        xmlBuilder.append("</customer>");
        return xmlBuilder.toString();
    }
}
