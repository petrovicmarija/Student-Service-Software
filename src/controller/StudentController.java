package controller;

import java.util.Date;

import model.BazaStudenata;
import model.Status;
import model.Student;
import view.Glavni_prozor;

public class StudentController {
	
	private static StudentController instanca = null;
	
	public static StudentController getInstance() {
		
		if(instanca == null) {
			instanca = new StudentController();
		}
		
		return instanca;
	}
	
	private StudentController() {}
	
	public void dodajStudenta(String ime, String prezime, Date datumRodjenja, String adresa,
			String brojTelefona, String email, String brIndeksa, int godinaUpisa, int trenutnaGodStudija, Status status) {
		
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datumRodjenja, adresa, brojTelefona, email, brIndeksa, godinaUpisa, trenutnaGodStudija, status);
		Glavni_prozor.getInstance().azurirajPrikazStudenta("DODAT", -1);
		
	}
	
	public void obrisiStudenta(String brojIndeksa) {
		
		BazaStudenata.getInstance().obrisiStudenta(brojIndeksa);
		Glavni_prozor.getInstance().azurirajPrikazStudenta("OBRISAN", -1);
		
	}
	
	public void izmeniStudenta(int rowSelectedIndex, String ime, String prezime, Date datumRodjenja, String adresa,
			String brojTelefona, String email, String brIndeksa,  int godinaUpisa, int trenutnaGodStudija, Status status) {
		
		if(rowSelectedIndex < 0) {
			return;
		}
		
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(ime, prezime, datumRodjenja, adresa, brojTelefona, email, student.getBrIndeksa(), godinaUpisa, trenutnaGodStudija, status);
		
		Glavni_prozor.getInstance().azurirajPrikazStudenta("IZMENJEN", -1);
	}
	
	public Student nadjiStudenta(String brojIndeksa) {
		
		Student student = BazaStudenata.getInstance().nadjiStudenta(brojIndeksa);
		return student;
		
	}

}
