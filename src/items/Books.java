package items;

public class Books extends Item<Books> {

	private String name;

	public Books(String name) {
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
