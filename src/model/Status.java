package model;

public enum Status {
	
	B("Budžet"),
	S("Samofinansiranje");
	
	public final String name;
	
	private Status(String name) {
		this.name = name;
	}

}
