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


public class AboutDijalog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(700, 400);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel(new GridLayout());
		
		JTextArea opis = new JTextArea();
		opis.setFont(new Font("Italic", Font.BOLD, 12));
		opis.setText("Aplikacija predstavlja studentsku službu.\n"
				+ "U okviru nje je omogućen rad sa studentima, profesorima, predmetima i ocenama.\n\n"
				+ "Autori:\n"
				+ "Marija Petrović. Rođena 9.4.1999. u Novom Sadu.\n"
				+ "Trenutno je student na Fakultetu tehničkih nauka u Novom Sadu, na smeru Računarstvo i automatika.\n\n"
				+ "Nikolina Pavković. Rođena 15.2.2000. u Somboru. \nTrenutno je student na Fakultetu tehničkih nauka u Novom Sadu, na smeru Računarstvo i automatika.");
		
		opis.setEditable(false);
		opis.setLineWrap(true);
		
		JScrollPane skrol = new JScrollPane(opis);
		skrol.setPreferredSize(new Dimension(600, 300));
		panel.add(skrol);
		
		this.add(panel, BorderLayout.CENTER);
	}

}
