package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.StudentController;
import view.StudentiJTable;

public class BazaPolozenihPredmeta {
	
	private static BazaPolozenihPredmeta instanca = null;
	private ArrayList<String> kolone = new ArrayList<String>();
	private ArrayList<Ocena> polozeniPredmeti = new ArrayList<Ocena>();
	private int espb;
	
	public static BazaPolozenihPredmeta getInstance() {
		instanca = new BazaPolozenihPredmeta();
		return instanca;
	}
	
	private BazaPolozenihPredmeta() {
		
		initPolozenePredmete();
		
		this.kolone.add("ŠIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("OCENA");
		this.kolone.add("DATUM");
		
		izracunajBrojESPB();
	}
	
	private void initPolozenePredmete() {
		
		int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
		String brIndeksa = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
		Student student = StudentController.getInstance().nadjiStudenta(brIndeksa);
		
		List<Ocena> ocene = student.getSpisakOcena();
		
		for (Ocena ocena : ocene) {
			polozeniPredmeti.add(ocena);
		}
		
	//	izracunajBrojESPB();
		
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.polozeniPredmeti.get(row);

		switch(column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(ocena.getPredmet().getBrojESPB());
		case 3:
			return String.valueOf(ocena.getVrednostOcene());
		case 4:
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

	
	public ArrayList<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmeti(ArrayList<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public int getColumnCount() {
		return this.kolone.size();
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int rowIndex) {
		return this.polozeniPredmeti.get(rowIndex);
	}
	
	public void dodajPolozeniPredmet(Student student, Predmet predmet, int vrednostOcene, Date datumPolaganja) {
		this.polozeniPredmeti.add(new Ocena(student, predmet, vrednostOcene, datumPolaganja));
		
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public double izracunajProsecnuOcenu() {
		
		double prosek = 0;
		double zbir = 0;
		double cnt = 0;
		
		for(Ocena ocena : polozeniPredmeti) {

			zbir += ocena.getVrednostOcene();
			cnt++;
		}
	
		prosek = Math.round((zbir/cnt) * 100.0) / 100.0;
		return prosek;
	}
	
	public int izracunajBrojESPB() {
		
		espb = 0;
		
		for (Ocena ocena : polozeniPredmeti) {
			espb += ocena.getPredmet().getBrojESPB();
		}
		
		return espb;
	}
	
	public void ponistiOcenu(String sifraPredmeta) {
		
		for (Ocena ocena : polozeniPredmeti) {
			if (ocena.getPredmet().getSifraPredmeta() == sifraPredmeta) {
				polozeniPredmeti.remove(ocena);
				break;
			}
		}
	}

}
