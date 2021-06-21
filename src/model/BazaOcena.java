package model;

import java.util.ArrayList;

public class BazaOcena {
	
	private static BazaOcena instanca = null;
	private ArrayList<String> kolone = new ArrayList<String>();
	private ArrayList<Ocena> ocene = new ArrayList<Ocena>();
	private Student student = new Student();
	
	public static BazaOcena getInstance() {
		if(instanca == null) {
			instanca = new BazaOcena();
		}
		
		return instanca;
	}
	
	private BazaOcena() {
		
		initOcene();
		
		this.kolone.add("STUDENT");
		this.kolone.add("PREDMET");
		this.kolone.add("OCENA");
		this.kolone.add("DATUM");
	}
	
	private void initOcene() {
		
	
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(4), 9, Ocena.parseDate("14.01.2019.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(5), 7, Ocena.parseDate("15.01.2019.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(8), 6, Ocena.parseDate("25.06.2019.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(1), 10, Ocena.parseDate("15.04.2018.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(9), 10, Ocena.parseDate("03.02.2019.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(2), 8, Ocena.parseDate("10.04.2018.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(3), 9, Ocena.parseDate("23.02.2020.")));
		ocene.add(new Ocena(student, BazaPredmeta.getInstance().getPredmeti().get(6), 7, Ocena.parseDate("23.07.2020.")));
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.ocene.get(row);
		
		switch(column) {
		case 0:
			return String.valueOf(ocena.getStudent());
		case 1:
			return String.valueOf(ocena.getPredmet());
		case 2:
			return String.valueOf(ocena.getVrednostOcene());
		case 3:
			return Ocena.prebaciDatumUString(ocena.getDatumPolaganja());
			default:
				return null;
					
		}
	}

	public ArrayList<String> getKolone() {
		return kolone;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}

	public ArrayList<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(ArrayList<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}

}
