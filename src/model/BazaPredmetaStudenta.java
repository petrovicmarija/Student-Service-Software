package model;

import java.util.ArrayList;

import controller.StudentController;
import view.StudentiJTable;

public class BazaPredmetaStudenta {
	
	private static BazaPredmetaStudenta instanca = null;
	private ArrayList<String> kolone = new ArrayList<String>();
	private ArrayList<Predmet> predmetiStudenta = new ArrayList<Predmet>();
	
	
	public static BazaPredmetaStudenta getInstance() {
		instanca = new BazaPredmetaStudenta();
		return instanca;
	}
	
	private BazaPredmetaStudenta() {
		
		initPredmete();
		
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
	}
	
	private void initPredmete() {
		int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
		String brojIndeksa = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
		Student student = StudentController.getInstance().nadjiStudenta(brojIndeksa);
		
		ArrayList<Predmet> predmeti = student.getSpisakPredmeta();
		
		for (Predmet predmet : predmeti) {
			predmetiStudenta.add(predmet);
		}
		
	}

	public ArrayList<String> getKolone() {
		return kolone;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}

	public ArrayList<Predmet> getPredmetiStudenta() {
		return predmetiStudenta;
	}

	public void setPredmetiStudenta(ArrayList<Predmet> predmetiStudenta) {
		this.predmetiStudenta = predmetiStudenta;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmetiStudenta.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmetiStudenta.get(row);
		switch(column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return String.valueOf(predmet.getGodStudijaZaPredmet());
		case 3:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		}
	}

}
