package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BazaProfesora {
	
	private static BazaProfesora instanca = null;
	
	public static BazaProfesora getInstance() {
		if(instanca == null) {
			instanca = new BazaProfesora();
		}
		return instanca;
	}
	
	private ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	private ArrayList<String> kolone = new ArrayList<String>();
	/*private ArrayList<Predmet> predmeti1 = new ArrayList<Predmet>();
	private ArrayList<Predmet> predmeti2 = new ArrayList<Predmet>();
	private ArrayList<Predmet> predmeti3 = new ArrayList<Predmet>();
	private ArrayList<Predmet> predmeti4 = new ArrayList<Predmet>();
	private ArrayList<Predmet> predmeti5 = new ArrayList<Predmet>();*/
	
	
	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		
		initProfesore();
		
		this.kolone.add("PREZIME");
		this.kolone.add("IME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		this.kolone.add("LIČNA KARTA");
		
		
	}
	
	private void initProfesore() {
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		predmeti1.add(BazaPredmeta.getInstance().getPredmeti().get(6));
		predmeti1.add(BazaPredmeta.getInstance().getPredmeti().get(0));
		
		predmeti2.add(BazaPredmeta.getInstance().getPredmeti().get(6));
		predmeti2.add(BazaPredmeta.getInstance().getPredmeti().get(2));
		
		
		predmeti3.add(BazaPredmeta.getInstance().getPredmeti().get(7));
		predmeti3.add(BazaPredmeta.getInstance().getPredmeti().get(0));
		predmeti3.add(BazaPredmeta.getInstance().getPredmeti().get(5));
		predmeti3.add(BazaPredmeta.getInstance().getPredmeti().get(8));
		
		predmeti4.add(BazaPredmeta.getInstance().getPredmeti().get(4));
		predmeti4.add(BazaPredmeta.getInstance().getPredmeti().get(1));
		predmeti4.add(BazaPredmeta.getInstance().getPredmeti().get(2));
		
		predmeti5.add(BazaPredmeta.getInstance().getPredmeti().get(2));
		
		profesori.add(new Profesor("Čeliković", "Milan", LocalDate.parse("25.01.1970.", formatter), "Nikole Pašića 12, Novi Sad", "0658791423", "celikovic@gmail.com", "Železnička 15, Novi Sad", "032145691", Titula.profDr, Zvanje.REDOVNI_PROFESOR, predmeti1));
		profesori.add(new Profesor("Dimitrieski", "Vladimir", LocalDate.parse("06.05.1975.", formatter), "Marka Oreškovića 25, Novi Sad", "062266460", "dimitrieski@hotmail.com", "Železnička 15, Novi Sad", "165478293", Titula.profDr, Zvanje.REDOVNI_PROFESOR, predmeti2));
		profesori.add(new Profesor("Jeličić", "Zoran", LocalDate.parse("16.11.1972.", formatter), "Koste Racina 15, Novi Sad", "0658886407", "zoran.jelicic@uns.com", "Železnička 15, Novi Sad", "547933125", Titula.profDr, Zvanje.REDOVNI_PROFESOR, predmeti3));
		profesori.add(new Profesor("Kovačević", "Aleksandar", LocalDate.parse("12.10.1969.", formatter), "Vojvode Šupljikca 120, Bačka Palanka", "0658444218", "kovacevic@uns.rs", "Železnička 15, Novi Sad", "789412365", Titula.profDr, Zvanje.REDOVNI_PROFESOR, predmeti4));
		profesori.add(new Profesor("Vrbaški", "Dunja", LocalDate.parse("27.12.1981.", formatter), "Miloša Obilića 12, Apatin", "0637319010", "dunja@gmail.com", "Železnička 15, Novi Sad", "759130254", Titula.profDr, Zvanje.VANREDNI_PROFESOR, predmeti5));
		*/
		for(Profesor profesor : BazaGlavna.getInstance().getProfesori()) {
			profesori.add(profesor);
		}
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getPrezime();
		case 1:
			return profesor.getIme();
		case 2:
			return String.valueOf(profesor.getTitula());
		case 3:
			return String.valueOf(profesor.getZvanje());
		case 4:
			return profesor.getBrLicneKarte();
		default:
			return null;
		
		}
	}
	
	public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresa, String brojTelefona, String email, String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate datum = LocalDate.parse(datumRodjenja, formatter);
		
		this.profesori.add(new Profesor(prezime, ime, datum, adresa, brojTelefona, email, adresaKanc, brLicneKarte, titula, zvanje));
	}
	
	public void obrisiProfesora(String brLicneKarte) {
		for (Profesor profesor : profesori) {
			if (profesor.getBrLicneKarte().equals(brLicneKarte)) {
				profesori.remove(profesor);
				break;
			}
		}
	}

	public void izmeniProfesora(String prezime, String ime, String datumRodjenja, String adresa,
			String brojTelefona, String email, String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate datum = LocalDate.parse(datumRodjenja, formatter);
		
		for(Profesor p : profesori) {
			if(p.getBrLicneKarte() == brLicneKarte) {
				p.setPrezime(prezime);
				p.setIme(ime);
				p.setDatumRodjenja(datum);
				p.setAdresa(adresa);
				p.setBrojTelefona(brojTelefona);
				p.setEmail(email);
				p.setAdresaKanc(adresaKanc);
				p.setBrLicneKarte(brLicneKarte);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}
	
	public Profesor nadjiProfesora(String brojLicneKarte) {
		Profesor profesorRet = null;
		
		for(Profesor profesor : profesori) {
			if(profesor.getBrLicneKarte().equals(brojLicneKarte)) {
				profesorRet = profesor;
				break;
			}
		}
		
		return profesorRet;
	}


}
