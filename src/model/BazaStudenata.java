package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class BazaStudenata {

	private static BazaStudenata instanca = null;
	
	public static BazaStudenata getInstance() {
		
		if (instanca == null) {
			instanca = new BazaStudenata();
		}
		return instanca;
	}
	
	private List<Student> studenti = new ArrayList<Student>();
	private List<String> kolone = new ArrayList<String>();
	/*private List<Predmet> nepolozeni1 = new ArrayList<Predmet>();
	private List<Predmet> nepolozeni2 = new ArrayList<Predmet>();
	private List<Predmet> nepolozeni3 = new ArrayList<Predmet>();
	private List<Ocena> ocene1 = new ArrayList<Ocena>();
	private List<Ocena> ocene2 = new ArrayList<Ocena>();
	private List<Ocena> ocene3 = new ArrayList<Ocena>();*/
	
	private BazaStudenata() {
		
		this.studenti = new ArrayList<Student>();
		
		initStudente();
		
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
	}
	
	private void initStudente() {
		
		/*nepolozeni1.add(BazaPredmeta.getInstance().getPredmeti().get(1));
		nepolozeni1.add(BazaPredmeta.getInstance().getPredmeti().get(2));
		nepolozeni1.add(BazaPredmeta.getInstance().getPredmeti().get(3));
		
		nepolozeni2.add(BazaPredmeta.getInstance().getPredmeti().get(4));
		nepolozeni2.add(BazaPredmeta.getInstance().getPredmeti().get(5));
		nepolozeni2.add(BazaPredmeta.getInstance().getPredmeti().get(6));
		nepolozeni2.add(BazaPredmeta.getInstance().getPredmeti().get(7));
		
		nepolozeni3.add(BazaPredmeta.getInstance().getPredmeti().get(8));
		nepolozeni3.add(BazaPredmeta.getInstance().getPredmeti().get(9));
		
		ocene1.add(BazaOcena.getInstance().getOcene().get(1));
		ocene1.add(BazaOcena.getInstance().getOcene().get(2));
		
		ocene2.add(BazaOcena.getInstance().getOcene().get(3));
		ocene2.add(BazaOcena.getInstance().getOcene().get(4));
		ocene2.add(BazaOcena.getInstance().getOcene().get(5));
		
		ocene3.add(BazaOcena.getInstance().getOcene().get(6));
		ocene3.add(BazaOcena.getInstance().getOcene().get(7));
		
		
		studenti.add(new Student("ra-12-2017", "Stefan", "Popov", 3 , Status.B, 8.75, Student.parseDate("12.10.1998."), "Šekspirova 26, Novi Sad", "0621785632", "stefanp@gmail.com", 2017, nepolozeni1, ocene1));
		studenti.add(new Student("ra-78-2019", "Ana", "Janković", 2 , Status.S, 6.75, Student.parseDate("28.03.2000."), "Koste Trifkovića 3, Novi Sad", "0668005021", "ana@gmail.com", 2019, nepolozeni2, ocene2));
		studenti.add(new Student("ra-123-2019", "Petar", "Petrović", 2 , Status.B, 9.00, Student.parseDate("07.11.2000."), "Branka Radičevića 17, Sombor", "0641563245", "petar@gmail.com", 2019, nepolozeni3, ocene3));*/	
		
		for(Student student : BazaGlavna.getInstance().getStudenti()) {
			studenti.add(student);
		}
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getCoulmnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValuesAt(int row, int column) {
		Student studenti = this.studenti.get(row);
		
		switch (column) {
		case 0:
			return studenti.getBrIndeksa();
		case 1:
			return studenti.getIme();
		case 2:
			return studenti.getPrezime();
		case 3:
			return String.valueOf(studenti.getTrenutnaGodStudija());
		case 4:
			return String.valueOf(studenti.getStatus());
		case 5:
			return String.valueOf(studenti.getProsecnaOcena());
		default:
				return null;
		}
	}
	
	public void dodajStudenta(String ime, String prezime, Date datumRodjenja, String adresa,
			String brojTelefona, String email, String brIndeksa, int godinaUpisa, int trenutnaGodStudija, Status status){
		
		this.studenti.add(new Student(ime, prezime, datumRodjenja, adresa, brojTelefona, email, brIndeksa, godinaUpisa, trenutnaGodStudija, status));
	}
	
	public void obrisiStudenta(String brojIndeksa) {
		
		for (Student student : studenti) {
			
			if(student.getBrIndeksa().equals(brojIndeksa)) {
				studenti.remove(student);
				break;
			}
		}
	}
	
	
	public void izmeniStudenta(String ime, String prezime, Date datumRodjenja, String adresa,
			String brojTelefona, String email, String brIndeksa,  int godinaUpisa, int trenutnaGodStudija, Status status) {
		
		for (Student student : studenti) {
			if(student.getBrIndeksa().equals(brIndeksa)) {
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setDatumRodjenja(datumRodjenja);
				student.setAdresa(adresa);
				student.setBrTel(brojTelefona);
				student.setEmail(email);
				student.setBrIndeksa(brIndeksa);
				student.setGodUpisa(godinaUpisa);
				student.setTrenutnaGodStudija(trenutnaGodStudija);
				student.setStatus(status);
			}
		}
		
	} 
	
	public Student nadjiStudenta(String brojIndeksa) {
		
		Student pronadjen = null;
		
		for (Student student : studenti) {
			if(student.getBrIndeksa().equals(brojIndeksa)) {
				pronadjen = student;
				break;
			}
		}
		
		return pronadjen;
		
	}
}
