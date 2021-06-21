package model;

import java.util.ArrayList;

import view.ProfesoriJTable;

public class BazaPredmetaProfesora {
	
	private static BazaPredmetaProfesora instanca = null;
	private ArrayList<Predmet> predmetiProfesora = new ArrayList<Predmet>();
	private ArrayList<String> kolone = new ArrayList<String>();
	
	public static BazaPredmetaProfesora getInstance() {
		instanca = new BazaPredmetaProfesora();
		return instanca;
	}
	
	private BazaPredmetaProfesora() {
		initPredmete();
		
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
	}
	
	private void initPredmete() {
		int trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
		String licnaKarta = (String) ProfesoriJTable.getInstance().getValueAt(trenutniRed, 4);
		//Profesor profesor = ProfesoriController.getInstance().nadjiProfesora(licnaKarta);
		
		ArrayList<Predmet> predmeti = nadjiPremdetePoProfesoru(licnaKarta); //profesor.getPredmetiProfesora();
		for(Predmet predmet : predmeti) {
			predmetiProfesora.add(predmet);
		}
	}
	

	public ArrayList<Predmet> getPredmetiProfesora() {
		return predmetiProfesora;
	}

	public void setPredmetiProfesora(ArrayList<Predmet> predmetiProfesora) {
		this.predmetiProfesora = predmetiProfesora;
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
		return this.predmetiProfesora.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmetiProfesora.get(row);
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
	
	public ArrayList<Predmet> nadjiPremdetePoProfesoru(String brlicne) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getPredmetniProfesor().getBrLicneKarte() != null) {
				if(p.getPredmetniProfesor().getBrLicneKarte().equals(brlicne)) {
					predmeti.add(p);
				}
			}
		}
		
		return predmeti;	
	}
	
	

}
