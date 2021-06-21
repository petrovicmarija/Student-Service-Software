package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDijalog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(700, 400);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel(new GridLayout());
		
		JTextArea tekst = new JTextArea();
		tekst.setFont(new Font("Italic", Font.BOLD, 12));
		tekst.setText("Aplikacija 'Studentska služba' je namenjena za evidenciju informacija o studentima, profesorima, predmetima.\n"
				+ "Pri pokretanju aplikacije otvara se glavni prozor gde se nalaze tabovi za svaki od entiteta.\n"
				+ "U zavisnosti od toga na kom tabu se nalazi korisnik, omogućene su operacije za rad nad željenim entitetima (dodavanje, izmena i brisanje).\n"
				+ "Opcije je moguće izabrati iz menija ili toolbar-a.\n"
				+ "\nPrečice:\n\n"
				+ "   [CTRL + N] - Opcija za dodavanje novog entiteta\n"
				+ "   [CTRL + C] - Opcija za zatvaranje programa\n"
				+ "   [CTRL + E] - Opcija za izmene entiteta\n"
				+ "   [CTRL + D] - Opcija za brisanje entiteta\n"
				+ "   [CTRL + H] - Help\n"
				+ "   [CTRL + A] - About\n");
		
		tekst.setEditable(false);
		tekst.setLineWrap(true);
		
		JScrollPane skrol = new JScrollPane(tekst);
		skrol.setPreferredSize(new Dimension(600, 300));
		panel.add(skrol);
		
		this.add(panel, BorderLayout.CENTER);
	}

}
