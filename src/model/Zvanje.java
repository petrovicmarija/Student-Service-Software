package model;

public enum Zvanje {
	
	DOCENT("DOCENT"),
	VANREDNI_PROFESOR("VANREDNI PROFESOR"),
	REDOVNI_PROFESOR("REDOVNI PROFESOR");
	
	
	public final String name;
	
	private Zvanje(String name) {
		this.name = name;
	}

}
