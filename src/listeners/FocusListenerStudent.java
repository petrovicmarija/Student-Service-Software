package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.util.regex.Pattern;

public class FocusListenerStudent implements FocusListener {
	
	boolean flagIme = false;
	boolean flagPrezime = false;
	boolean flagDatumRodjenja = false;
	boolean flagAdresa = false;
	boolean flagBrojTelefona = false;
	boolean flagEmail = false;
	boolean flagBrojIndeksa = false;
	boolean flagGodinaUpisa = false;

	JButton btn;
	
	public FocusListenerStudent(JButton btn) {
		this.btn = btn;
	}

	@Override
	public void focusGained(FocusEvent e) {
		
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		JTextField txt = (JTextField) e.getComponent();
		
		if (txt.getName().equals("txtIme")) {
			
			String ime = txt.getText();
			flagIme = Pattern.matches("[A-Ž][a-ž]+", ime);
			
			if (flagIme == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtPrezime")) {
			
			String prezime = txt.getText();
			flagPrezime = Pattern.matches("[A-Ž][a-ž]+", prezime);
			
			if (flagPrezime == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtDatum")) {
			
			String datumRodjenja = txt.getText();
			flagDatumRodjenja = Pattern.matches("[0-3][0-9][.][0-1][0-9][.][0-9]{4}[.]", datumRodjenja);
			
			if (flagDatumRodjenja == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtAdresa")) {
			
			String adresa = txt.getText();
			flagAdresa = Pattern.matches("[A-Ž][a-ž]+[ ]?[A-Ž]?[a-ž]*[ ]?[A-Ž]?[a-ž]*[ ]?[0-9]*[,][ ]?[A-Ž][a-ž]+[ ]?[A-Ž]?[a-ž]*", adresa);
			
			if (flagAdresa == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtBrTel")) {
			
			String brojTelefona = txt.getText();
			flagBrojTelefona = Pattern.matches("[0-9]{3,3}[- . /]?[0-9]{3,4}[- . /]?[0-9]{3,4}", brojTelefona);
			
			if (flagBrojTelefona == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtEmail")) {
			
			String email = txt.getText();
			flagEmail = Pattern.matches("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", email);
			
			if (flagEmail == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtBrIndeksa")) {
			
			String brojIndeksa = txt.getText();

			flagBrojIndeksa = Pattern.matches("[A-Za-z]+\\s[0-9]+\\/[0-9]{4}+", brojIndeksa);

			
			if (flagBrojIndeksa == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
			
		} else if (txt.getName().equals("txtGodUpisa")) {
			
			String godinaUpisa = txt.getText();
			flagGodinaUpisa = Pattern.matches("[2][0][0-2][0-9]", godinaUpisa);
			
			if (flagGodinaUpisa == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		}
		
		boolean flag = validacija();
		
		if (flag == false) {
			btn.setEnabled(false);
		} else {
			btn.setEnabled(true);
		}
		
	}
	
	public boolean validacija() {
		
		if (flagIme == true && flagPrezime == true && flagDatumRodjenja == true && flagAdresa == true && flagBrojTelefona == true 
				&& flagEmail == true && flagBrojIndeksa == true && flagGodinaUpisa == true ) {
			
			return true;
		}
		return false;
	}

}
