package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ocena implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private Predmet predmet;
	private int vrednostOcene;
	private Date datumPolaganja;
	
	public Ocena() {}
	
	public Ocena(Student student, Predmet predmet, int ocena, Date datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.vrednostOcene = ocena;
		this.datumPolaganja = datumPolaganja;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Predmet getPredmet() {
		return predmet;
	}
	
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	public int getVrednostOcene() {
		return vrednostOcene;
	}
	
	public void setVrednostOcene(int vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}
	
	public Date getDatumPolaganja() {
		return datumPolaganja;
	}
	
	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String prebaciDatumUString(Date date) { 
		try {
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
			return df.format(date);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
