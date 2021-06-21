package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private String adresa;
	private String brojTelefona;
	private String email;
	private String adresaKanc;
	private String brLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> predmetiProfesora = new ArrayList<Predmet>();
	private ArrayList<Predmet> predmetiNedeklarisani = new ArrayList<Predmet>();

	public Profesor() {}
	
	public Profesor(String prezime, String ime) {
		super();
		this.prezime = prezime;
		this.ime = ime;
	}
	
	public Profesor(String prezime, String ime, LocalDate datumRodjenja, String adresa, String brojTelefona, String email,
			String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje, ArrayList<Predmet> predmetiProfesora) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.adresaKanc = adresaKanc;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmetiProfesora = predmetiProfesora;
	}
	

	
	public Profesor(String prezime, String ime, LocalDate datumRodjenja, String adresa, String brojTelefona, String email,
			String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje) {

		super();
		
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.adresaKanc = adresaKanc;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	

	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getBrojTelefona() {
		return brojTelefona;
	}
	
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAdresaKanc() {
		return adresaKanc;
	}
	
	public void setAdresaKanc(String adresaKanc) {
		this.adresaKanc = adresaKanc;
	}
	
	public String getBrLicneKarte() {
		return brLicneKarte;
	}
	
	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}
	
	public Titula getTitula() {
		return titula;
	}
	
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	
	public Zvanje getZvanje() {
		return zvanje;
	}
	
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
	public ArrayList<Predmet> getPredmetiProfesora() {
		return predmetiProfesora;
	}
	
	public void setPredmetiProfesora(ArrayList<Predmet> predmetiProfesora) {
		this.predmetiProfesora = predmetiProfesora;
	}	
	
	
	public int getIntTitula(Titula t) {
		if(t == Titula.dr) {
			return 0;
		} else if(t == Titula.mr) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public int getIntZvanje(Zvanje z) {
		if(z == Zvanje.DOCENT) {
			return 0;
		} else if(z == Zvanje.VANREDNI_PROFESOR) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public ArrayList<Predmet> getPredmetiNedeklarisani() {
		return predmetiNedeklarisani;
	}


	public void setPredmetiNedeklarisani(ArrayList<Predmet> predmetiNedeklarisani) {
		this.predmetiNedeklarisani = predmetiNedeklarisani;
	}
	
	public void dodajPredmetProfesoru(Predmet predmet) {
		predmetiProfesora.add(predmet);
	}
	
	public void izbrisiPredmetProfesoru(Predmet predmet) {
		predmetiProfesora.remove(predmet);
	}
	
	public ArrayList<Predmet> initPredmetiNedeklarisani(Profesor profesor) {
		ArrayList<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		ArrayList<Predmet> predmetiProfesora = profesor.getPredmetiProfesora();
		
		for(Predmet predmet : sviPredmeti) {
			if(predmetiProfesora.contains(predmet) == false) {
				predmetiNedeklarisani.add(predmet);
			}
		}
		
		return predmetiNedeklarisani;
		
	}
	


}
