package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FocusListenerProfesor implements FocusListener{
	
	boolean flagPrezime = false;
	boolean flagIme = false;
	boolean flagDatumRodj = false;
	boolean flagAdresa = false;
	boolean flagTelefon = false;
	boolean flagEmail = false;
	boolean flagAdresaKanc = false;
	boolean flagBrojLicne = false;
	JButton btn;
	
	

	public FocusListenerProfesor(JButton btn) {
		this.btn = btn;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);	
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		
		if(txt.getName().equals("txtPrezime")) {
			String prezime = txt.getText();
			flagPrezime = Pattern.matches("[A-ZŠĐŽĆČ][a-zđščćž]+", prezime);
			if(flagPrezime==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtIme")) {
			String ime = txt.getText();
			flagIme = Pattern.matches("[A-ZŠĐŽĆČ][a-zđščćž]+", ime);
			if(flagIme==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtDatum")) {
			String datum = txt.getText();
			flagDatumRodj = Pattern.matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4}[.]", datum);
			if(flagDatumRodj==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtAdresa")) {
			String adresa = txt.getText();
			flagAdresa = Pattern.matches("[A-Ž][a-ž]+[ ]?[A-Ž]?[a-ž]*[ ]?[A-Ž]?[a-ž]*[ ]?[0-9]*[,][ ]?[A-Ž][a-ž]+[ ]?[A-Ž]?[a-ž]*", adresa);
			if(flagAdresa==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtTelefon")) {
			String telefon = txt.getText();
			flagTelefon = Pattern.matches("[0-9]{3,3}[- . /]?[0-9]{3,4}[- . /]?[0-9]{3,4}", telefon);
			if(flagTelefon==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtEmail")) {
			String email = txt.getText();
			flagEmail = Pattern.matches("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", email);
			if(flagEmail==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtAdresaK")) {
			String adresaKanc = txt.getText();
			flagAdresaKanc = Pattern.matches("[A-Ž]?[a-ž]*[ ]?[A-Ž]?[a-ž]*[ ]?[A-Ž]?[a-ž]*[ ]?[0-9]*[,][ ]?[A-Ž][a-ž]+[ ]?[A-Ž]?[a-ž]*[,]?\\s?[A-Ž]*[a-ž]*\\s?[0-9]{0,5}[A-Ža-ž]*", adresaKanc);
			if(flagAdresaKanc==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if(txt.getName().equals("txtBrojLicne")) {
			String brojLicne = txt.getText();
			flagBrojLicne = Pattern.matches("[0-9]{9}", brojLicne);
			if(flagBrojLicne==true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		}
		
		boolean flag = validacija();
		
		if(flag == false) {
			btn.setEnabled(false);
		} else {
			btn.setEnabled(true);
		}
		
		
	}
	
	public boolean validacija() {
		if(flagPrezime == true && flagIme == true && flagDatumRodj == true && flagAdresa == true &&
				flagAdresaKanc == true && flagBrojLicne == true && flagEmail == true && flagTelefon == true) {
			return true;
		}
		return false;
	}

}
