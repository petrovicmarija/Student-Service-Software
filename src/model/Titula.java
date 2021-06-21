package model;

public enum Titula {
	bsc("BSc"),
	msc("MSc"),
	mr("MR"),
	dr("DR"),
	profDr("PROF DR");
	
	public final String name;
	
	private Titula(String name) {
		this.name = name;
	}

}
