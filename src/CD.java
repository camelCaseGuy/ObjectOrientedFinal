

public class CD extends Item {

	private String name;

	public CD(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemName() {
		return this.name;
	}

	@Override
	public double getRentalPrice(int daysRented) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getRentalPrice'");
	}

	@Override
	public double getSellingPrice(int quantity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSellingPrice'");
	}

}
