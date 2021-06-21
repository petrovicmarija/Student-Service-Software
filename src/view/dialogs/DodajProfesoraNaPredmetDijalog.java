package view.dialogs;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.PredmetController;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.Glavni_prozor;
import view.PredmetiJTable;

public class DodajProfesoraNaPredmetDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DodajProfesoraNaPredmetDijalog(JFrame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(350, 350);
		setLocationRelativeTo(parent);
		
		//JPanel panelLista = new JPanel();
		//panelLista.setPreferredSize(new Dimension(250, 200));
		
		List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		
		String[] prikazi;
		
		if(profesori.isEmpty()) { 
			prikazi = new String[1];
			prikazi[0] = "Nema profesora";
		} else {
			prikazi = new String[profesori.size()];
			int i = 0;
			for (Profesor profesor : profesori) {
				prikazi[i] = profesor.getIme() + " " + profesor.getPrezime();
				i++;
			}
		}
		
		JList<String> listaProfesora = new JList<String>();
		listaProfesora.setListData(prikazi);
		listaProfesora.setPreferredSize(new Dimension(250, 200));
		
		JScrollPane listaPanel = new JScrollPane(listaProfesora);
		
		listaPanel.setPreferredSize(new Dimension(250, 200));
		
		//panelLista.add(listaProfesora);

		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = listaProfesora.getSelectedIndex();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali profesora kojeg želite da dodate!");
				} else {
					
					Profesor profesor = profesori.get(index);
					//Predmet predmet = BazaPredmeta.getInstance().getRow(PredmetiJTable.getInstance().getSelectedRow());
					int trenutniRed = PredmetiJTable.getInstance().getSelectedRow();
					String sifra = (String) PredmetiJTable.getInstance().getValueAt(trenutniRed, 0);
					Predmet predmet = PredmetController.getInstance().nadjiPredmet(sifra);
					
					predmet.dodajProfesora(profesor);
					profesor.dodajPredmetProfesoru(predmet);
					IzmeniPredmetDijalog dijalog = new IzmeniPredmetDijalog(Glavni_prozor.getInstance(), "Izmena predmeta", true);
					dijalog.getPredmetniProfesor().setText(profesor.getIme() + " " + profesor.getPrezime());
					
					
					
				}
				
				dispose();
			}
		});
		
		panButtons.add(potvrdi);
		panButtons.add(odustani);
		
		add(listaPanel, BorderLayout.CENTER);
		add(panButtons, BorderLayout.SOUTH);
		
	}

}
