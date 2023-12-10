package movieRentalPackage;

public class Movie implements Item {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		priceCode = arg;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public double getRentalPrice(int daysRented) {
		return daysRented * 2;
	}

	@Override
	public double getSalesPrice() {
		return 10;
	}
}