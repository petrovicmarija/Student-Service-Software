package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import controller.ProfesoriController;
import model.BazaPredmetaProfesora;
import model.Predmet;
import model.Profesor;
import view.dialogs.DodajPredmetProfesoruDijalog;
import view.dialogs.IzmeniProfesoraDijalog;

public class TabbedPaneIzmeniProf extends JTabbedPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TabbedPaneIzmeniProf instanca = null;
	
	private static IzmeniProfPanelInfo info;
	private static PredmetiProfesoraJTable predmeti;
	
	
	public static TabbedPaneIzmeniProf getInstance() {
		if(instanca == null) {
			instanca = new TabbedPaneIzmeniProf();
		}
		return instanca;
	}
	
	
	
	private TabbedPaneIzmeniProf() {
		
		info = IzmeniProfPanelInfo.getInstance();
		
		JScrollPane panelInfo = new JScrollPane(info);
		JScrollPane panelPredmeti = new JScrollPane(predmeti());
		
		add("Info", panelInfo);
		add("Predmeti", panelPredmeti);
		
	}
	
	private JPanel predmeti() {
		JPanel panelPredmeti = new JPanel();
		panelPredmeti.setLayout(new BorderLayout());
		
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnDodajPredmet = new JButton("Dodaj predmet");
		
		btnDodajPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
				String licnaKarta = (String) ProfesoriJTable.getInstance().getValueAt(trenutniRed, 4);
				Profesor profesor = ProfesoriController.getInstance().nadjiProfesora(licnaKarta);
				
				ArrayList<Predmet> nedeklarisaniPredmeti = profesor.initPredmetiNedeklarisani(profesor);
				
				DodajPredmetProfesoruDijalog dijalog = new DodajPredmetProfesoruDijalog(IzmeniProfesoraDijalog.getInstance(), "Dodaj predmet", true, nedeklarisaniPredmeti, profesor);
				dijalog.setVisible(true);
				
				nedeklarisaniPredmeti.clear();
				
				
			}
		});
		
		JButton btnUkloniPredmet = new JButton("Ukloni predmet");
		
		btnUkloniPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (PredmetiProfesoraJTable.getInstance().getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(IzmeniProfesoraDijalog.getInstance(), "Niste izabrali predmet koji želite da uklonite!");
				} else {
					
					int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni?",
							"Ukloni predmet", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (option == JOptionPane.YES_OPTION) {
						
					int trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
					String brLicne = (String) ProfesoriJTable.getInstance().getValueAt(trenutniRed, 4);
					Profesor profesor = ProfesoriController.getInstance().nadjiProfesora(brLicne);
					
					Predmet predmet = BazaPredmetaProfesora.getInstance().getRow(PredmetiProfesoraJTable.getInstance().getSelectedRow());
					//Profesor profesor = BazaProfesora.getInstance().getRow(ProfesoriJTable.getInstance().getSelectedRow());
					
					profesor.izbrisiPredmetProfesoru(predmet);
					predmet.obrisi();
					Glavni_prozor.getInstance().azurirajPrikazPredmeta("", -1);
					Glavni_prozor.getInstance().azurirajPrikazPredmetaProfesora("OBRISAN", -1);
					}
				}
				
			}
		});
		
		panelBtn.add(btnDodajPredmet);
		panelBtn.add(btnUkloniPredmet);
		
		panelPredmeti.add(panelBtn, BorderLayout.NORTH);
		
		predmeti = PredmetiProfesoraJTable.getInstance();
		JScrollPane panel = new JScrollPane(predmeti);
		
		panelPredmeti.add(panel, BorderLayout.CENTER);
		
		return panelPredmeti;
	}
	

}
