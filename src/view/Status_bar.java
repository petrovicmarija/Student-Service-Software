package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Status_bar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Status_bar() {

		BoxLayout box = new BoxLayout (this, BoxLayout.X_AXIS);
		this.setLayout(box);
		
		JPanel panelNaziv = new JPanel (new FlowLayout(FlowLayout.LEFT));
		JLabel naziv = new JLabel ("Studentska služba");
		naziv.setPreferredSize(new Dimension (200,20));
		panelNaziv.add(naziv);		
		this.add(panelNaziv);

	}
	
	public void datumVreme() {
		Thread sat = new Thread() {
			public void run() {
				
				JPanel panelDatum = new JPanel (new FlowLayout(FlowLayout.RIGHT));
				JLabel datum = new JLabel();
				datum.setPreferredSize(new Dimension (120, 20));
				panelDatum.add(datum);
				add(panelDatum);
				
				/** REFERENCA: 
				 * Ideja za implementaciju dinamickog sata je preuzeta sa:
				 * https://jskod.wordpress.com/2012/07/19/simple-jlabel-clock-using-a-thread/ */
				
				try {
					
					while(true) {
						Calendar kalendar = new GregorianCalendar();
						
						int dan = kalendar.get(Calendar.DAY_OF_MONTH);
						int mesec = kalendar.get(Calendar.MONTH) + 1;
						int godina = kalendar.get(Calendar.YEAR);
						
						int cas = kalendar.get(Calendar.HOUR_OF_DAY);
						int minuti = kalendar.get(Calendar.MINUTE);
						
						String vreme = dodajNulu(cas) + ":" + dodajNulu(minuti);
						
						datum.setText(vreme + " " + dan + "." + mesec + "." + godina + ".");
						
						sleep(1000);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		sat.start();
	}
	
	public String dodajNulu(int num) {
		String nula;
		if (num < 10) {
			nula = "0" + num;
		} else {
			nula = "" + num;
		}
		
		return nula;
	}

}
