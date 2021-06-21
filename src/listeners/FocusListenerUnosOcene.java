package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FocusListenerUnosOcene implements FocusListener{
	
	boolean flagDatum = false;
	JButton btn;
	
	public FocusListenerUnosOcene(JButton btn) {
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
		
		if(txt.getName().equals("txtDatum")) {
			String datum = txt.getText();
			flagDatum = Pattern.matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4}[.]", datum);
			if(flagDatum==true) {
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
		if(flagDatum == true) {
			return true;
		}
		return false;
	}


}
