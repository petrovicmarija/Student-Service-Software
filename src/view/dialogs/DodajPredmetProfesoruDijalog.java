package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Predmet;
import model.Profesor;
import view.Glavni_prozor;

public class DodajPredmetProfesoruDijalog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodajPredmetProfesoruDijalog(JDialog parent, String title, boolean modal, ArrayList<Predmet> nedeklarisaniPredmeti, Profesor profesor) {
		
		super(parent, title, modal);
		
		setSize(350, 350);
		setLocationRelativeTo(parent);
		
		String[] prikazi;
		
		if(nedeklarisaniPredmeti.isEmpty()) {
			prikazi = new String[1];
			prikazi[0] = "Profesor nema nedeklarisani predmet. ";
		} else {
			prikazi = new String[nedeklarisaniPredmeti.size()];
			int i = 0;
			
			for(Predmet predmet : nedeklarisaniPredmeti) {
				prikazi[i] = predmet.getSifraPredmeta() +"-"+ predmet.getNazivPredmeta();
				i++;
			}
		}
		
		JList<String> listaPredmeta = new JList<String>();
		listaPredmeta.setListData(prikazi);
		
		JScrollPane panelLista = new JScrollPane(listaPredmeta);
		panelLista.setPreferredSize(new Dimension(250,200));
		
		JPanel btnPanel = new JPanel();
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = listaPredmeta.getSelectedIndex();
				
				if(index == -1) {
					JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali predmet koji želite da dodate!");
				} else {
				
					Predmet predmet = nedeklarisaniPredmeti.get(index);
					profesor.dodajPredmetProfesoru(predmet);
					predmet.dodajProfesora(profesor);
				
					Glavni_prozor.getInstance().azurirajPrikazPredmetaProfesora("", 10);
					dispose();
				}
				
			}
		});
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		btnPanel.add(potvrdi);
		btnPanel.add(odustani);
		
		add(new Label("Predmeti: "), BorderLayout.NORTH);
		add(panelLista, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
	}

}
