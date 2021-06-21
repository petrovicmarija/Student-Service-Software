package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//enum Status {B, S};

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa;
	private String brTel;
	private String email;
	private String brIndeksa;
	private int godUpisa;
	private int trenutnaGodStudija;
	protected Status status;
	private double prosecnaOcena;
	private List<Ocena> spisakOcena = new ArrayList<Ocena>();
	private List<Predmet> nepolozeniPredmeti = new ArrayList<Predmet>();
	private ArrayList<Predmet> spisakPredmeta = new ArrayList<Predmet>();
	
	public Student() {}
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresa, String brTel, String email,
			String brIndeksa, int godUpisa, int trenutnaGodStudija, Status status, double prosecnaOcena,
			List<Ocena> spisakOcena, List<Predmet> nepolozeniPredmeti) {
		
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brTel = brTel;
		this.email = email;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakOcena = spisakOcena;
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresa, String brTel, String email,
			String brIndeksa, int godUpisa, int trenutnaGodStudija, Status status, double prosecnaOcena,
			 List<Predmet> nepolozeniPredmeti) {
		
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brTel = brTel;
		this.email = email;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}
	
	public Student(String ime, String prezime, Date datumRodjenja, String adresa,
			String brojTelefona, String email, String brIndeksa, int godinaUpisa, int trenutnaGodStudija, Status status) {
		
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brTel = brojTelefona;
		this.email = email;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godinaUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		
	}
	
	public Student(String brIndeksa, String ime, String prezime, int trenutnaGodStudija, Status status, double prosecnaOcena, 
			Date datumRodjenja, String adresa, String brTelefona, String email, int godUpisa, List<Predmet> nepolozeniPredmeti, List<Ocena> spisakOcena) {
		
		this.brIndeksa = brIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brTel = brTelefona;
		this.email = email;
		this.godUpisa = godUpisa;
		this.nepolozeniPredmeti = nepolozeniPredmeti;
		this.spisakOcena = spisakOcena;
	}
	
	public Student(String brIndeksa, String ime, String prezime, int trenutnaGodStudija, Date datumRodjenja, 
			String adresa, String brTelefona, String email, Status status, int godUpisa, double prosecnaOcena) {
		
		this.brIndeksa = brIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brTel = brTelefona;
		this.email = email;
		this.status = status;
		this.godUpisa = godUpisa;
		this.prosecnaOcena = prosecnaOcena;
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
	
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getBrTel() {
		return brTel;
	}
	
	public void setBrTel(String brTel) {
		this.brTel = brTel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBrIndeksa() {
		return brIndeksa;
	}
	
	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}
	
	public int getGodUpisa() {
		return godUpisa;
	}
	
	public void setGodUpisa(int godUpisa) {
		this.godUpisa = godUpisa;
	}
	
	public int getTrenutnaGodStudija() {
		return trenutnaGodStudija;
	}
	
	public void setTrenutnaGodStudija(int trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public List<Ocena> getSpisakOcena() {
		return spisakOcena;
	}

	public void setSpisakOcena(List<Ocena> spisakOcena) {
		this.spisakOcena = spisakOcena;
	}

	public List<Predmet> getNepolozeniPred() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPred(List<Predmet> nepolozeniPred) {
		this.nepolozeniPredmeti = nepolozeniPred;
	}
	
	
	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
	/** REFERENCA:
	 * 	https://www.javatpoint.com/java-string-to-date 
	 * */
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** REFERENCA:
	 * 	https://www.javatpoint.com/java-date-to-string
	 * */
	
	public static String prebaciDatumUString(Date date) {
		try {
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
			return df.format(date);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void izbaciNepolozeni(String sifraPredmeta) {
		for(Predmet predmet : nepolozeniPredmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				nepolozeniPredmeti.remove(predmet);
				break;
			}
		}
	}
	
	public void dodajPolozeni(Student student, Predmet predmet, int vrednostOcene, Date datumPolaganja) {
		Ocena ocena = new Ocena(student, predmet, vrednostOcene, datumPolaganja);
		spisakOcena.add(ocena);
		
	}
	
	public void dodajPredmetStudentu(Predmet predmet) {
		nepolozeniPredmeti.add(predmet);
	}
	
	public List<Predmet> predmetiZaStudenta(Student student) {
		
		List<Predmet> odgovarajuciPredmeti = student.getSpisakPredmeta();
		List<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		List<Predmet> nepolozeni = student.getNepolozeniPred();

		for (Predmet predmet : sviPredmeti) {
			
			if (odgovarajuciPredmeti.contains(predmet) == false && predmet.getGodStudijaZaPredmet() <= student.getTrenutnaGodStudija() 
					&& nepolozeni.contains(predmet) == false) {	
				spisakPredmeta.add(predmet);
			}

		}
		return spisakPredmeta;
	}
	
	public void izbaciNepolozen(Predmet predmet) {
		nepolozeniPredmeti.remove(predmet);
	}
	
	public void izbaciPolozen(Ocena ocena) {
		spisakOcena.remove(ocena);
	}

	
}
