package controller;

import model.BazaProfesora;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import view.Glavni_prozor;

public class ProfesoriController {
	
	private static ProfesoriController instanca = null;
	
	public static ProfesoriController getInstance() {
		if(instanca == null) {
			instanca = new ProfesoriController();
		}
		return instanca;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresa, String brojTelefona,
			String email, String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje) {
		BazaProfesora.getInstance().dodajProfesora(prezime, ime, datumRodjenja, adresa, brojTelefona, email, adresaKanc, brLicneKarte, titula, zvanje);
		Glavni_prozor.getInstance().azurirajPrikazProfesora("DODAT", -1);
	}
	
	public void obrisiProfesora(String brojLicneKarte) {
		
		BazaProfesora.getInstance().obrisiProfesora(brojLicneKarte);
		Glavni_prozor.getInstance().azurirajPrikazProfesora("OBRISAN", -1);
	
	}
	
	public void izmeniProfesora(int rowSelectedIndex, String prezime, String ime, String datumRodjenja, String adresa,
			String brojTelefona, String email, String adresaKanc, String brLicneKarte, Titula titula, Zvanje zvanje) {
		if(rowSelectedIndex < 0) {
			return;
		}
		
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izmeniProfesora(prezime, ime, datumRodjenja, adresa, brojTelefona, email, adresaKanc, profesor.getBrLicneKarte(), titula, zvanje);
		
		Glavni_prozor.getInstance().azurirajPrikazProfesora("IZMENA", -1);

	}
	
	public Profesor nadjiProfesora(String brojLicneKarte) {
		Profesor profesor = BazaProfesora.getInstance().nadjiProfesora(brojLicneKarte);
		return profesor;
	}
	
}
