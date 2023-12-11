package items;

public class ConsoleGames extends Item<ConsoleGames> {

	private String name;

	public ConsoleGames(String name) {
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