package controller;

import java.util.ArrayList;
import java.util.List;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import view.Glavni_prozor;
import view.PredmetiJTable;

public class PredmetController {
	
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	
	private static PredmetController instanca = null;
	
	private PredmetController() {}
	
	public static PredmetController getInstance() {
		if(instanca == null) {
			instanca = new PredmetController();
		}
		return instanca;
	}

	public void izbrisiPredmet(String sifraPredmeta) {

		BazaPredmeta.getInstance().izbrisiPredmet(sifraPredmeta);
		
		Glavni_prozor.getInstance().azurirajPrikazPredmeta("OBRISAN", -1);
	}
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godStudija, Profesor profesor, int brojBodova) {
		
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godStudija, profesor, brojBodova);
		Glavni_prozor.getInstance().azurirajPrikazPredmeta("DODAT", -1);
	}
	
	public void izmeniPredmet(Predmet predmet) {
		if (PredmetiJTable.getInstance().getSelectedRow() < 0) {
			return;
		}
		BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifraPredmeta(), predmet.getNazivPredmeta(), predmet.getSemestar(),
				predmet.getGodStudijaZaPredmet(), predmet.getPredmetniProfesor(), predmet.getBrojESPB());
		Glavni_prozor.getInstance().azurirajPrikazPredmeta("IZMENJEN", -1);
		
	}
	
	public void dodajStudentaNaPredmet(Predmet predmet, String brojIndeksa) {
		if(PredmetiJTable.getInstance().getSelectedRow() < 0) 
			return;
		
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(predmet, brojIndeksa);
		Glavni_prozor.getInstance().azurirajPrikazPredmeta("Dodat", -1);
	}

	public Predmet nadjiPredmet(String sifraPredmeta) {
		
		Predmet predmet = BazaPredmeta.getInstance().nadjiPredmet(sifraPredmeta);
		
		return predmet;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public void izbrisiPredmet(int selectedRowIndex) {
		if(selectedRowIndex < 0) {
			return;
		}
	}

}
