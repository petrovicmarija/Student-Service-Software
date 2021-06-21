package model;


import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {
	private static BazaPredmeta instanca = null;
	
	private Profesor profesor = new Profesor("","");
	
	public static BazaPredmeta getInstance() {
		if(instanca == null) {
			instanca = new BazaPredmeta();
		}
		return instanca;
	}
	
	private ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	private ArrayList<String> kolone = new ArrayList<String>();
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		
		initPredmete();
		
		this.kolone.add("ŠIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		this.kolone.add("PROFESOR");
		
	}
	
	private void initPredmete() {
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		Profesor  profesor1 = new Profesor("Čeliković", "Milan", LocalDate.parse("25.01.1970.", formatter), "Nikole Pašića 12, Novi Sad", "0658791423", "celikovic@gmail.com", "Železnička 15, Novi Sad", "03214569", Titula.profDr, Zvanje.REDOVNI_PROFESOR);
		Profesor  profesor2 = new Profesor("Dimitrieski", "Vladimir", LocalDate.parse("06.05.1975.", formatter), "Marka Oreškovića 25, Novi Sad", "062266460", "dimitrieski@hotmail.com", "Železnička 15, Novi Sad", "16547893", Titula.profDr, Zvanje.REDOVNI_PROFESOR);
		Profesor  profesor3 = new Profesor("Jeličić", "Zoran", LocalDate.parse("16.11.1972.", formatter), "Koste Racina 15, Novi Sad", "0658886407", "zoran.jelicic@uns.com", "Železnička 15, Novi Sad", "54793125", Titula.profDr, Zvanje.REDOVNI_PROFESOR);
		Profesor  profesor4 = new Profesor("Kovačević", "Aleksandar", LocalDate.parse("12.10.1969.", formatter), "Vojvode Šupljikca 120, Bačka Palanka", "0658444218", "kovacevic@uns.rs", "Železnička 15, Novi Sad", "78912365", Titula.profDr, Zvanje.REDOVNI_PROFESOR);
		Profesor  profesor5 = new Profesor("Vrbaški", "Dunja", LocalDate.parse("27.12.1981.", formatter), "Miloša Obilića 12, Apatin", "0637319010", "dunja@gmail.com", "Železnička 15, Novi Sad", "79130254", Titula.profDr, Zvanje.VANREDNI_PROFESOR);
		

		predmeti.add(new Predmet("MA2", "Matematička analiza 1", Semestar.zimski, 1, profesor1, 9));
		predmeti.add(new Predmet("SE3", "OISISI", Semestar.zimski, 3, profesor1, 6));
		predmeti.add(new Predmet("PR1", "Objektno programiranje", Semestar.zimski, 2, profesor3, 8));
		predmeti.add(new Predmet("MA3", "Matematička analiza 2", Semestar.zimski, 2,profesor4 , 8));
		predmeti.add(new Predmet("OE1", "Osnovi elektrotehnike", Semestar.letnji, 1, profesor2, 9));
		predmeti.add(new Predmet("AL1", "Algebra", Semestar.zimski, 1, profesor5, 9));
		predmeti.add(new Predmet("BP1", "Baze podataka 1", Semestar.zimski, 3, profesor2, 8));
		predmeti.add(new Predmet("SA1", "Sistemi automatskog upravljanja", Semestar.letnji, 2,profesor3, 6));
		predmeti.add(new Predmet("FI1", "Fizika", Semestar.letnji, 1,profesor5, 9));
		predmeti.add(new Predmet("EN2", "Engleski jezik 2", Semestar.letnji, 1, profesor1,3));
		*/

		
		for(Predmet predmet : BazaGlavna.getInstance().getPredmeti()) {
			predmeti.add(predmet);
		}
		
		
	}
	
	public Predmet dodajPredmet(String sifraPredmeta) {
		for(Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				return predmet;
			}
		}
		return null;
	}
	
	/*private Profesor nadjiProfesoraPoBrLicne(String brLicneKarte) {
		Profesor profesorNadjen = null;
		for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			if(profesor.getBrLicneKarte().equals(brLicneKarte)) {
				profesorNadjen = profesor;
				break;
			}
		}
		
		return profesorNadjen;
	}*/

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public ArrayList<String> getKolone() {
		return kolone;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return String.valueOf(predmet.getBrojESPB());
		case 3:
			return String.valueOf(predmet.getGodStudijaZaPredmet());
		case 4:
			return String.valueOf(predmet.getSemestar());
		case 5:
			if(predmet.getPredmetniProfesor() == null) {
				return profesor.getIme() + profesor.getPrezime();
			} else {
				return predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime();
			}
		default:
			return null;
		}
		
	}
	
	public void izbrisiPredmet(String sifraPredmeta) {
		for(Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta() == sifraPredmeta) {
				predmeti.remove(predmet);
				break;
			}
		}
	}
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godStudija, Profesor profesor, int brojBodova) {
		
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godStudija, profesor, brojBodova));
	}
	
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godStudija, Profesor profesor, int brojBodova) {
		
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmet.setSifraPredmeta(sifraPredmeta);
				predmet.setNazivPredmeta(nazivPredmeta);
				predmet.setSemestar(semestar);
				predmet.setGodStudijaZaPredmet(godStudija);
				predmet.setPredmetniProfesor(profesor);
				predmet.setBrojESPB(brojBodova);
			}
		}
	}
	
	public List<Predmet> predmetiZaStudenta(Student student) {
		
		List<Predmet> odgovarajuciPredmeti = new ArrayList<Predmet>();
		List<Student> sviStudenti = new ArrayList<Student>();
		
		for (Predmet predmet : this.predmeti) {
			
			//List<Student> sviStudenti = new ArrayList<Student>();
			sviStudenti.addAll(predmet.getStudentiPolozili());
			sviStudenti.addAll(predmet.getStudentiNisuPolozili());
			
			if (sviStudenti.contains(student) == false && predmet.getGodStudijaZaPredmet() == student.getTrenutnaGodStudija()) {
				
				odgovarajuciPredmeti.add(predmet);
			}

		}
		return odgovarajuciPredmeti;
	} 
	
	
	public void dodajStudentaNaPredmet(Predmet predmet, String brojIndeksa) {
		
		//Predmet predmet = BazaPredmeta.getInstance().getRow(PredmetiJTable.getInstance().getSelectedRow());
		List<Student> studenti = BazaStudenata.getInstance().getStudenti();
		ArrayList<Student> odgovarajuci = new ArrayList<Student>();
		odgovarajuci = predmet.getSpisakStudenata();
		
		for (Student student : studenti) {
			if (student.getBrIndeksa().equals(brojIndeksa) && predmet.getGodStudijaZaPredmet() == student.getTrenutnaGodStudija()) {
				
				odgovarajuci.add(student);
				predmet.setSpisakStudenata(odgovarajuci);
			}
		}
		
	}

	public Predmet nadjiPredmet(String sifraPredmeta) {
		Predmet predmetRet = null;
		
		for(Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmetRet = predmet;
				break;
			}
		}
		
		return predmetRet;

	}


}
