package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.FocusListenerUnosOcene;
import model.BazaNepolozenihPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import view.Glavni_prozor;
import view.StudentiJTable;

public class UnosOceneDijalog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField sifraTxtField;
	private JTextField nazivTxtField;
	private final JComboBox<String> comboBox;

	public UnosOceneDijalog(JDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(300,300);
		setLocationRelativeTo(parent);
		Dimension dim = new Dimension(120, 20);
		
		JPanel panelSifra =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel sifraLabel = new JLabel("Šifra* ");
		sifraLabel.setPreferredSize(dim);
		sifraTxtField = new JTextField();
		sifraTxtField.setName("txtSifra");
		sifraTxtField.setPreferredSize(dim);
		
		panelSifra.add(sifraLabel);
		panelSifra.add(sifraTxtField);
		
		JPanel panelNaziv =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel nazivLabel = new JLabel("Naziv* ");
		nazivLabel.setPreferredSize(dim);
		nazivTxtField = new JTextField();
		nazivTxtField.setName("txtNaziv");
		nazivTxtField.setPreferredSize(dim);
		
		panelNaziv.add(nazivLabel);
		panelNaziv.add(nazivTxtField);
		
		JPanel panelOcena = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ocenaLabel = new JLabel("Ocena* ");
		ocenaLabel.setPreferredSize(dim);
		String[] ocene = {"6", "7", "8", "9", "10"};
		comboBox = new JComboBox<String>(ocene);
		comboBox.setBackground(Color.WHITE);
		comboBox.setPreferredSize(dim);
		
		panelOcena.add(ocenaLabel);
		panelOcena.add(comboBox);
		
		
		JPanel panelDatum =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel datumLabel = new JLabel("Datum* ");
		datumLabel.setPreferredSize(dim);
		JTextField datumTxtField = new JTextField();
		datumTxtField.setName("txtDatum");
		datumTxtField.setPreferredSize(dim);
		
		panelDatum.add(datumLabel);
		panelDatum.add(datumTxtField);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelSifra);
		boxCentar.add(panelNaziv);
		boxCentar.add(panelOcena);
		boxCentar.add(panelDatum);
		add(boxCentar, BorderLayout.NORTH);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		FocusListenerUnosOcene listener = new FocusListenerUnosOcene(potvrdiBtn);
		datumTxtField.addFocusListener(listener);
		
		potvrdiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String sifraPredmeta = sifraTxtField.getText();
				int ocena;
				if(comboBox.getSelectedItem().toString().equals("6")) {
					ocena = 6;
				} else if(comboBox.getSelectedItem().toString().equals("7")) {
					ocena = 7;
				} else if(comboBox.getSelectedItem().toString().equals("8")) {
					ocena = 8;
				} else if(comboBox.getSelectedItem().toString().equals("9")) {
					ocena = 9;
				} else {
					ocena = 10;
				}
				Date datum =  Student.parseDate(datumTxtField.getText());

				Student student = BazaStudenata.getInstance().getStudenti().get(StudentiJTable.getInstance().getSelectedRow());

				
				Predmet polozenPredmet = null;
				for(Predmet predmet : BazaNepolozenihPredmeta.getInstanca().getNepolozeniPredmeti()) {
					if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
						polozenPredmet = predmet;
						break;
					}
				}
				

				student.dodajPolozeni(student, polozenPredmet, ocena, datum);
				student.izbaciNepolozeni(sifraPredmeta);
				Glavni_prozor.getInstance().azurirajPrikazPolozenihPredmeta("", -1);
				Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
				
				dispose();
				
			}
		});
		
		JButton odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel.add(potvrdiBtn);
		btnPanel.add(odustaniBtn);
		add(btnPanel, BorderLayout.SOUTH);
		
		
	}
	
	public JTextField getSifraTxtField() {
		return sifraTxtField;
	}

	public void setSifraTxtField(JTextField sifraTxtField) {
		this.sifraTxtField = sifraTxtField;
	}

	public JTextField getNazivTxtField() {
		return nazivTxtField;
	}

	public void setNazivTxtField(JTextField nazivTxtField) {
		this.nazivTxtField = nazivTxtField;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}


}
