package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ProfesoriController;
import listeners.FocusListenerProfesor;
import model.Titula;
import model.Zvanje;
import view.dialogs.IzmeniProfesoraDijalog;

public class IzmeniProfPanelInfo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField prezimeTxtField;
	private JTextField imeTxtField;
	private JTextField datumTxtField;
	private JTextField adresaTxtField;
	private JTextField telefonTxtField;
	private JTextField emailTxtField;
	private JTextField adrKancTxtField;
	private JTextField brLicneTxtField;
	private final JComboBox<String> comboBox1;
	private final JComboBox<String> comboBox2;
	
	private JTable tabelaProfesora;
	
	private static IzmeniProfPanelInfo instanca = null;
	
	public static IzmeniProfPanelInfo getInstance() {
		if(instanca == null) {
			instanca = new IzmeniProfPanelInfo();
		}
		return instanca;
	}
	
	private IzmeniProfPanelInfo() {
		
		Dimension dim = new Dimension(225,20);
		
		JPanel panelPrezime =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel prezimeLabel = new JLabel("Prezime* ");
		prezimeLabel.setPreferredSize(dim);
		prezimeTxtField = new JTextField();
		prezimeTxtField.setName("txtPrezime");
		prezimeTxtField.setPreferredSize(dim);
		
		
		panelPrezime.add(prezimeLabel);
		panelPrezime.add(prezimeTxtField);
		
		JPanel panelIme =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel imeLabel = new JLabel("Ime* ");
		imeLabel.setPreferredSize(dim);
		imeTxtField = new JTextField();
		imeTxtField.setName("txtIme");
		imeTxtField.setPreferredSize(dim);
		
		
		panelIme.add(imeLabel);
		panelIme.add(imeTxtField);
		
		JPanel panelDatRodj =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel datRodjLabel = new JLabel("Datum rođenja* ");
		datRodjLabel.setPreferredSize(dim);
		datumTxtField = new JTextField();
		datumTxtField.setName("txtDatum");
		datumTxtField.setPreferredSize(dim);
		
		panelDatRodj.add(datRodjLabel);
		panelDatRodj.add(datumTxtField);
		
		JPanel panelAdresa =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel adresaLabel = new JLabel("Adresa stanovanja* ");
		adresaLabel.setPreferredSize(dim);
		adresaTxtField = new JTextField();
		adresaTxtField.setName("txtAdresa");
		adresaTxtField.setPreferredSize(dim);
	
		
		panelAdresa.add(adresaLabel);
		panelAdresa.add(adresaTxtField);
		
		JPanel panelTelefon =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel telefonLabel = new JLabel("Kontakt telefon* ");
		telefonLabel.setPreferredSize(dim);
		telefonTxtField = new JTextField();
		telefonTxtField.setName("txtTelefon");
		telefonTxtField.setPreferredSize(dim);
		
		panelTelefon.add(telefonLabel);
		panelTelefon.add(telefonTxtField);
		
		JPanel panelEmail =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel emailLabel = new JLabel("E-mail adresa* ");
		emailLabel.setPreferredSize(dim);
		emailTxtField = new JTextField();
		emailTxtField.setName("txtEmail");
		emailTxtField.setPreferredSize(dim);
		
		panelEmail.add(emailLabel);
		panelEmail.add(emailTxtField);
		
		JPanel panelAdresaKanc =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel adrKancLabel = new JLabel("Adresa kancelarije* ");
		adrKancLabel.setPreferredSize(dim);
		adrKancTxtField = new JTextField();
		adrKancTxtField.setName("txtAdresaK");
		adrKancTxtField.setPreferredSize(dim);
		
		
		panelAdresaKanc.add(adrKancLabel);
		panelAdresaKanc.add(adrKancTxtField);
		
		JPanel panelBrLicne =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel brLicneLabel = new JLabel("Broj lične karte* ");
		brLicneLabel.setPreferredSize(dim);
		brLicneTxtField = new JTextField();
		brLicneTxtField.setName("txtBrojLicne");
		brLicneTxtField.setPreferredSize(dim);
		
		panelBrLicne.add(brLicneLabel);
		panelBrLicne.add(brLicneTxtField);
		
		JPanel panelTitula =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel titulaLabel = new JLabel("Titula* ");
		titulaLabel.setPreferredSize(dim);
		String[] titule = {"DR", "MR", "PROF DR", "MSc", "BSc"};
		comboBox1 = new JComboBox<String>(titule);
		comboBox1.setBackground(Color.WHITE);
		comboBox1.setPreferredSize(dim);
		
		
		panelTitula.add(titulaLabel);
		panelTitula.add(comboBox1);
		
		JPanel panelZvanje =  new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel zvanjeLabel = new JLabel("Zvanje* ");
		zvanjeLabel.setPreferredSize(dim);
		String[] zvanja = {"DOCENT", "VANREDNI PROFESOR", "REDOVNI PROFESOR"};
		comboBox2 = new JComboBox<String>(zvanja);
		comboBox2.setPreferredSize(dim);
		comboBox2.setBackground(Color.WHITE);
		
		
		panelZvanje.add(zvanjeLabel);
		panelZvanje.add(comboBox2);
		
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelPrezime);
		boxCentar.add(panelIme);
		boxCentar.add(panelDatRodj);
		boxCentar.add(panelAdresa);
		boxCentar.add(panelTelefon);
		boxCentar.add(panelEmail);
		boxCentar.add(panelAdresaKanc);
		boxCentar.add(panelBrLicne);
		boxCentar.add(panelTitula);
		boxCentar.add(panelZvanje);
		boxCentar.add(Box.createGlue());
		add(boxCentar, BorderLayout.NORTH);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		
		FocusListenerProfesor listener = new FocusListenerProfesor(potvrdiBtn);
		prezimeTxtField.addFocusListener(listener);
		imeTxtField.addFocusListener(listener);
		datumTxtField.addFocusListener(listener);
		adresaTxtField.addFocusListener(listener);
		telefonTxtField.addFocusListener(listener);
		emailTxtField.addFocusListener(listener);
		adrKancTxtField.addFocusListener(listener);
		brLicneTxtField.addFocusListener(listener);
		
		potvrdiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Titula titula;
				
				if((comboBox1.getSelectedItem().toString()).equals("DR")) {
					titula = Titula.dr;
				} else if ((comboBox1.getSelectedItem().toString()).equals("MR")) {
					titula = Titula.mr;
				} else if((comboBox1.getSelectedItem().toString()).equals("PROF DR")){
					titula = Titula.profDr;
				} else if((comboBox1.getSelectedItem().toString()).equals("BSc")){
					titula = Titula.bsc;
				} else {
					titula = Titula.msc;
				}

				Zvanje zvanje;
				
				if((comboBox2.getSelectedItem().toString()).equals("DOCENT")) {
					zvanje = Zvanje.DOCENT;
				} else if ((comboBox2.getSelectedItem().toString()).equals("VANREDNI PROFESOR")) {
					zvanje = Zvanje.VANREDNI_PROFESOR;
				} else {
					zvanje = Zvanje.REDOVNI_PROFESOR;
				}
				tabelaProfesora = ProfesoriJTable.getInstance();
				
				ProfesoriController.getInstance().izmeniProfesora(tabelaProfesora.getSelectedRow(), prezimeTxtField.getText(),
						imeTxtField.getText(), datumTxtField.getText(), adresaTxtField.getText(), telefonTxtField.getText(),
						emailTxtField.getText(), adrKancTxtField.getText(), brLicneTxtField.getText(), titula, zvanje);
				
			}
		});
		
		
		
		JButton odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IzmeniProfesoraDijalog.getInstance().dispose();
				
			}
		});
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel.add(potvrdiBtn);
		btnPanel.add(odustaniBtn);
		
		boxCentar.add(btnPanel);
		
		//add(btnPanel, BorderLayout.CENTER);
		
		add(boxCentar, BorderLayout.NORTH);
		
	}
	
	public JTextField getPrezimeTxtField() {
		return prezimeTxtField;
	}

	public void setPrezimeTxtField(JTextField prezimeTxtField) {
		this.prezimeTxtField = prezimeTxtField;
	}

	public JTextField getImeTxtField() {
		return imeTxtField;
	}

	public void setImeTxtField(JTextField imeTxtField) {
		this.imeTxtField = imeTxtField;
	}

	public JTextField getDatumTxtField() {
		return datumTxtField;
	}

	public void setDatumTxtField(JTextField datumTxtField) {
		this.datumTxtField = datumTxtField;
	}

	public JTextField getAdresaTxtField() {
		return adresaTxtField;
	}

	public void setAdresaTxtField(JTextField adresaTxtField) {
		this.adresaTxtField = adresaTxtField;
	}

	public JTextField getTelefonTxtField() {
		return telefonTxtField;
	}

	public void setTelefonTxtField(JTextField telefonTxtField) {
		this.telefonTxtField = telefonTxtField;
	}

	public JTextField getEmailTxtField() {
		return emailTxtField;
	}

	public void setEmailTxtField(JTextField emailTxtField) {
		this.emailTxtField = emailTxtField;
	}

	public JTextField getAdrKancTxtField() {
		return adrKancTxtField;
	}

	public void setAdrKancTxtField(JTextField adrKancTxtField) {
		this.adrKancTxtField = adrKancTxtField;
	}

	public JTextField getBrLicneTxtField() {
		return brLicneTxtField;
	}

	public void setBrLicneTxtField(JTextField brLicneTxtField) {
		this.brLicneTxtField = brLicneTxtField;
	}

	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public JComboBox<String> getComboBox2() {
		return comboBox2;
	}
	

}
