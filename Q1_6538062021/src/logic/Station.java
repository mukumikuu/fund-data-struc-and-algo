package logic;

public class Station {
	private String name;
	private int number;
	
	public Station(String name, int number) {
		setName(name);
		setNumber(number);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(int number) {
		if (number < 0) {
			this.number = 0;
		} else {
			this.number = number;
		}
	}
}
