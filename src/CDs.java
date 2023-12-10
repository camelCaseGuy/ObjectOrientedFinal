

public class CDs extends Item {

	private String name;

	public CDs(String name) {
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

}
