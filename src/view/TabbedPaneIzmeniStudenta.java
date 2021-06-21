package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import controller.StudentController;
import model.BazaPolozenihPredmeta;
import model.BazaStudenata;
import model.Ocena;
import view.dialogs.DodajPredmetStudentuDijalog;
import view.dialogs.IzmeniStudentaDijalog;

import model.BazaNepolozenihPredmeta;
import model.Predmet;
import view.dialogs.UnosOceneDijalog;
import model.Student;



public class TabbedPaneIzmeniStudenta extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TabbedPaneIzmeniStudenta instanca = null;
	private static IzmeniStudentaPanelInfo informacije;
	private static NepolozeniPredmetiJTable nepolozeniPredmeti;
	private static PolozeniPredmetiJTable polozeniPredmeti;
    private int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
	private String izmeniStudenta = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
	private Student student = StudentController.getInstance().nadjiStudenta(izmeniStudenta);
	
	private JLabel labProsek;
	private JLabel labESPB;
	
	public static TabbedPaneIzmeniStudenta getInstance() {
		if (instanca == null) {
			instanca = new TabbedPaneIzmeniStudenta();
		}
		return instanca;
	}
	
	private TabbedPaneIzmeniStudenta() {
		
		informacije = IzmeniStudentaPanelInfo.getInstance();
		
		JScrollPane panInfo = new JScrollPane(informacije);
		JScrollPane panPolozeni = new JScrollPane(polozeni());
		JScrollPane panNepolozeni = new JScrollPane(nepolozeni());
		
		add("Informacije", panInfo);
		add("Položeni", panPolozeni);
		add("Nepoloženi", panNepolozeni);
	}
	
	private JPanel nepolozeni() {
		JPanel panelNepolozeni =  new JPanel();
		panelNepolozeni.setLayout(new BorderLayout());
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnDodaj = new JButton("Dodaj");
		JButton btnObrisi = new JButton("Obriši");
		JButton btnPolaganje = new JButton("Polaganje");
		btnPolaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(NepolozeniPredmetiJTable.getInstance().getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(IzmeniStudentaDijalog.getInstance(), "Niste odabrali predmet kome želite da dodelite ocenu!");
				} else {
					Predmet nepolozeniPredmet = BazaNepolozenihPredmeta.getInstanca().getRow(NepolozeniPredmetiJTable.getInstance().getSelectedRow());
					UnosOceneDijalog unosOceneDijalog = new UnosOceneDijalog(IzmeniStudentaDijalog.getInstance(), "Unos ocene", true);
					
					unosOceneDijalog.getSifraTxtField().setText(nepolozeniPredmet.getSifraPredmeta());
					unosOceneDijalog.getSifraTxtField().setEditable(false);
					unosOceneDijalog.getNazivTxtField().setText(nepolozeniPredmet.getNazivPredmeta());
					unosOceneDijalog.getNazivTxtField().setEditable(false);
					
					unosOceneDijalog.setVisible(true);
					
					
				}
				
			}
		});
		
		panelBtn.add(btnDodaj);
		panelBtn.add(btnObrisi);
		panelBtn.add(btnPolaganje);
		
		panelNepolozeni.add(panelBtn, BorderLayout.NORTH);
		
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
				String brojIndeksa = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
				Student student = StudentController.getInstance().nadjiStudenta(brojIndeksa);
				
				List<Predmet> odgovarajuciPredmeti = student.predmetiZaStudenta(student);
				
				DodajPredmetStudentuDijalog dijalog = new DodajPredmetStudentuDijalog(IzmeniStudentaDijalog.getInstance(), "Dodavanje predmeta", true, odgovarajuciPredmeti, student);
				dijalog.setVisible(true);
				
				odgovarajuciPredmeti.clear();
				
				//Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
			}
		});
			
		btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int index = NepolozeniPredmetiJTable.getInstance().getSelectedRow();
				
				if (index < 0) {
					JOptionPane.showMessageDialog(IzmeniStudentaDijalog.getInstance(), "Niste izabrali predmet!");
				
				} else {
					
					int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite da uklonite predmet?", 
							"Uklanjanje predmeta",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (option == JOptionPane.YES_OPTION) {

						//Predmet predmet = nepolozeni.get(index);
						//student1.izbaciNepolozeni(predmet.getSifraPredmeta());
						
						Predmet p = BazaNepolozenihPredmeta.getInstanca().getRow(NepolozeniPredmetiJTable.getInstance().getSelectedRow());
						Student s = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow());
						
						s.izbaciNepolozen(p);
						
						Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
						
					}
				}
			}
		});
		
		nepolozeniPredmeti = NepolozeniPredmetiJTable.getInstance();
		JScrollPane panel = new JScrollPane(nepolozeniPredmeti);
		
		panelNepolozeni.add(panel, BorderLayout.CENTER);

		return panelNepolozeni;
	} 
	
	private JPanel polozeni() {
		
		JPanel panelPolozeni = new JPanel();
		panelPolozeni.setLayout(new BorderLayout());
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton ponistiOcenu = new JButton("Poništi ocenu");
		ponistiOcenu.setBackground(Color.BLUE);
		ponistiOcenu.setForeground(Color.WHITE);
		
		btnPanel.add(ponistiOcenu);
		
		polozeniPredmeti = PolozeniPredmetiJTable.getInstance();
		JScrollPane panel = new JScrollPane();
		panel.setViewportView(polozeniPredmeti);
		panel.setPreferredSize(new Dimension(100, 100));
		
		panelPolozeni.add(panel, BorderLayout.CENTER);
		
		JPanel panelLabele = new JPanel();
		panelLabele.setLayout(new BorderLayout());
		panelLabele.setPreferredSize(new Dimension(200, 60));
		
		JPanel panProsek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblProsecnaOcena = new JLabel("Prosečna ocena: ");
		labProsek = new JLabel();
		lblProsecnaOcena.setPreferredSize(new Dimension(100, 20));
		labProsek.setPreferredSize(new Dimension(100, 20));
		panProsek.add(lblProsecnaOcena);
		panProsek.add(labProsek);
		student.setProsecnaOcena(IzmeniStudentaPanelInfo.getInstance().getProsek());
		
		JPanel panESPB = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojESPB = new JLabel("Ukupno ESPB: ");
		labESPB = new JLabel();
		lblBrojESPB.setPreferredSize(new Dimension(100, 20));
		labESPB.setPreferredSize(new Dimension(100, 20));
		panESPB.add(lblBrojESPB);
		panESPB.add(labESPB);
		
		panelLabele.add(panProsek);
		panelLabele.add(panESPB, BorderLayout.AFTER_LAST_LINE);
		
		//Glavni_prozor.getInstance().azurirajPrikazPolozenihPredmeta("", -1);
		//azurirajPolozene();

		Glavni_prozor.getInstance().azurirajPrikazPolozenihPredmeta("", -1);
		
		ponistiOcenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (PolozeniPredmetiJTable.getInstance().getSelectedRow() < 0) {
					
					JOptionPane.showMessageDialog(IzmeniStudentaDijalog.getInstance(), "Niste izabrali ocenu koju želite da poništite!");
					
				} else {
					
					int option = JOptionPane.showConfirmDialog(IzmeniStudentaDijalog.getInstance(), "Da li ste sigurni da želite da poništite ocenu?",
								"Poništavanje ocene", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(option == JOptionPane.YES_OPTION) {
						
						Ocena ocena = BazaPolozenihPredmeta.getInstance().getRow(PolozeniPredmetiJTable.getInstance().getSelectedRow());
						Student student = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow());
						
						student.izbaciPolozen(ocena);
						student.dodajPredmetStudentu(ocena.getPredmet());
						
						Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
						Glavni_prozor.getInstance().azurirajPrikazPolozenihPredmeta("", -1);
						
						IzmeniStudentaPanelInfo.getInstance().izracunaj(student.getSpisakOcena());
						labProsek.setText(String.valueOf(IzmeniStudentaPanelInfo.getInstance().getProsek()));
						labESPB.setText(String.valueOf(IzmeniStudentaPanelInfo.getInstance().getBrojESPB()));
						student.setProsecnaOcena(Double.parseDouble(labProsek.getText()));
						
					}
				}
				
			}
		});
		
		panelPolozeni.add(btnPanel, BorderLayout.NORTH);
		panelPolozeni.add(panelLabele, BorderLayout.SOUTH);
		return panelPolozeni;
		
	} 
	
	public void azurirajPolozene() {
		
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow());
		IzmeniStudentaPanelInfo.getInstance().izracunaj(s.getSpisakOcena());
		labProsek.setText(String.valueOf(IzmeniStudentaPanelInfo.getInstance().getProsek()));
		labESPB.setText(String.valueOf(IzmeniStudentaPanelInfo.getInstance().getBrojESPB()));
		s.setProsecnaOcena(Double.parseDouble(labProsek.getText()));
		AbstractTableModelPolozeniPredmeti model = (AbstractTableModelPolozeniPredmeti) polozeniPredmeti.getModel();
		model.fireTableDataChanged();
		//validate();
		
	}

	public JLabel getLabProsek() {
		return labProsek;
	}

	public void setLabProsek(JLabel labProsek) {
		this.labProsek = labProsek;
	}
	
	

}
