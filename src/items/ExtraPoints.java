package items;

public class ExtraPoints extends Item<ExtraPoints> {

	private String name;

	public ExtraPoints(String name) {
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
