package model;

import java.util.ArrayList;

import controller.StudentController;
import view.StudentiJTable;

public class BazaNepolozenihPredmeta {
	
	private static BazaNepolozenihPredmeta instanca = null;
	private ArrayList<Predmet> nepolozeniPredmeti =  new ArrayList<Predmet>();
	private ArrayList<String> kolone = new ArrayList<String>();
	
	public static BazaNepolozenihPredmeta getInstanca() {
		instanca = new BazaNepolozenihPredmeta(); 
		return instanca;
	}
	
	private BazaNepolozenihPredmeta() {
		
		initNepolozenePredmete();
		
		this.kolone.add("ŠIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		

	}
	
	private void initNepolozenePredmete() {
		
		int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
		String brIndeksa = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
		Student student = StudentController.getInstance().nadjiStudenta(brIndeksa);
		
		//Student student = BazaStudenata.getInstance().getStudenti().get(StudentiJTable.getInstance().getSelectedRow());
		
		ArrayList<Predmet> predmeti = (ArrayList<Predmet>) student.getNepolozeniPred();
		for(Predmet predmet : predmeti) {
			if(predmet.getGodStudijaZaPredmet() <= student.getTrenutnaGodStudija()) {
				nepolozeniPredmeti.add(predmet);
			}
		}
		
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
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
		return this.nepolozeniPredmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.nepolozeniPredmeti.get(row);
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
		default:
			return null;
		}
	}
	
	/*public void obrisiNepolozeniPredmet(String sifraPredmeta) {
		for(Predmet predmet : nepolozeniPredmeti) {

	public void dodajNepolozenPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, int espb) {
		
		this.nepolozeniPredmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, null, espb));
	}
	
	public void ukloniStudentaSaPredmeta(String sifraPredmeta) {
		
		for (Predmet predmet : nepolozeniPredmeti) {

			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				nepolozeniPredmeti.remove(predmet);
				//BazaStudenata.getInstance().getStudenti().get(StudentiJTable.getInstance().getSelectedRow()).getNepolozeniPred().remove(predmet);
				break;
			}
		}
	}*/

}
