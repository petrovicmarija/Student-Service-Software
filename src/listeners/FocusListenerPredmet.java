package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FocusListenerPredmet implements FocusListener {
	
	boolean flagSifra = false;
	boolean flagNaziv = false;
	boolean flagGodStudija = false;
	boolean flagPredmetniProfesor = false;
	boolean flagBrojBodova = false;
	
	JButton btn;
	
	public FocusListenerPredmet(JButton btn) {
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
		
		if (txt.getName().equals("txtSifra")) {
			
			String sifra = txt.getText();
			flagSifra = Pattern.matches("[A-Z]{1,3}[a-z]{0,2}[1-9]{1,3}", sifra);
			if (flagSifra == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		} else if (txt.getName().equals("txtNaziv")) {
			
			String naziv = txt.getText();
			flagNaziv = Pattern.matches("[A-Ž]+[a-ž ]*[a-z0-9]*", naziv);
			
			if (flagNaziv == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			}
		/*} else if (txt.getName().equals("txtGodStudija")) {
			
			String godinaStudija = txt.getText();
			flagGodStudija = Pattern.matches("[1-4]", godinaStudija);
			
			if (flagGodStudija == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			} */
		} else if (txt.getName().equals("txtProfesor")) { 
			
			String predmetniProfesor = txt.getText();
			flagPredmetniProfesor = Pattern.matches("[A-Ž][a-ž]*\s[A-Ž][a-ž]*", predmetniProfesor);
			flagPredmetniProfesor = Pattern.matches("\s", predmetniProfesor);
			
			if (flagPredmetniProfesor == true) {
				txt.setBackground(Color.LIGHT_GRAY);
			} 
			
		} else if (txt.getName().equals("txtBodovi")) {
			
			String bodovi = txt.getText();
			flagBrojBodova = Pattern.matches("[1-9][0-9]?", bodovi);
			
			if (flagBrojBodova == true) {
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
		
		if (flagSifra == true && flagNaziv == true && flagPredmetniProfesor == true && flagBrojBodova == true) {
			return true;
		}
		return false;
	}
	

}
