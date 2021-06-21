package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godStudijaZaPredmet;
	private Profesor predmetniProfesor;
	private int brojESPB;
	private ArrayList<Student> studentiPolozili = new ArrayList<Student>();
	private ArrayList<Student> studentiNisuPolozili = new ArrayList<Student>();
	private ArrayList<Student> spisakStudenata = new ArrayList<Student>();
	
	
	public Predmet() {}

	public Predmet (String sifrPredmeta, String nazivPredmeta, Semestar semestar, int godStudijaZaPredmet,
			Profesor predmetniProfesor, int brojESPB) {
		
		this.sifraPredmeta = sifrPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godStudijaZaPredmet = godStudijaZaPredmet;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPB = brojESPB;
		predmetniProfesor.dodajPredmetProfesoru(this);
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godStudijaZaPredmet,
			Profesor predmetniProfesor, int brojESPB, ArrayList<Student> studentiPolozili,
			ArrayList<Student> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godStudijaZaPredmet = godStudijaZaPredmet;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPB = brojESPB;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public Semestar getSemestar() {
		return semestar;
	}
	
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	
	public int getGodStudijaZaPredmet() {
		return godStudijaZaPredmet;
	}
	
	public void setGodStudijaZaPredmet(int godStudijaZaPredmet) {
		this.godStudijaZaPredmet = godStudijaZaPredmet;
	}
	
	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
	public int getBrojESPB() {
		return brojESPB;
	}
	
	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}
	
	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}
	
	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}
	
	public ArrayList<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}
	
	public void setStudentiNisuPolozili(ArrayList<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	public ArrayList<Student> getSpisakStudenata() {
		return spisakStudenata;
	}

	public void setSpisakStudenata(ArrayList<Student> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}
	
	public void dodajNisuPolozili(Student student) {
		studentiNisuPolozili.add(student);
	}

	public void obrisiProfesora(Profesor profesor1) {
		profesor1 = new Profesor("", "");
	}
	
	
	public void dodajPolozili(Student student) {
		studentiPolozili.add(student);
	}
	
	public void dodajProfesora(Profesor profesor) {
		predmetniProfesor = profesor;
	}
	
	public void obrisi() {
		predmetniProfesor.setIme("");
		predmetniProfesor.setPrezime("");
	}
	
}
