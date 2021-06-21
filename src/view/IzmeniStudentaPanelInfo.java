package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.StudentController;
import listeners.FocusListenerStudent;
import model.Ocena;
import model.Status;
import model.Student;
import view.dialogs.IzmeniStudentaDijalog;

public class IzmeniStudentaPanelInfo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private static IzmeniStudentaPanelInfo instanca = null;
	
	public static IzmeniStudentaPanelInfo getInstance() {
		if(instanca == null) {
			instanca = new IzmeniStudentaPanelInfo();
		}
		return instanca;
	}
	
	private JTextField imeTxtField;
	private JTextField prezimeTxtField;
	private JTextField datumRodjenjaTxtField;
	private JTextField adresaTxtField;
	private JTextField brojTelefonaTxtField;
	private JTextField emailTxtField;
	private JTextField brojIndeksaTxtField;
	private JTextField godinaUpisaTxtField;
	private final JComboBox<String> cbGodStudija;
	private final JComboBox<String> cbStatus;
	private JTable tabelaStudenata;

	private double prosek;
	private int brojESPB;

	
    private IzmeniStudentaPanelInfo() {
		
	Dimension dim = new Dimension(225, 20);
	
	JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblIme = new JLabel("Ime*");
	lblIme.setPreferredSize(dim);
	imeTxtField = new JTextField();
	imeTxtField.setPreferredSize(dim);
	imeTxtField.setName("txtIme");
	panIme.add(lblIme);
	panIme.add(imeTxtField);
	
	JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblPrezime = new JLabel("Prezime*");
	lblPrezime.setPreferredSize(dim);
	prezimeTxtField = new JTextField();
	prezimeTxtField.setPreferredSize(dim);
	prezimeTxtField.setName("txtPrezime");
	panPrezime.add(lblPrezime);
	panPrezime.add(prezimeTxtField);
	
	JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblDatum = new JLabel("Datum rođenja*");
	lblDatum.setPreferredSize(dim);
	datumRodjenjaTxtField = new JTextField();
	datumRodjenjaTxtField.setPreferredSize(dim);
	datumRodjenjaTxtField.setName("txtDatum");
	panDatum.add(lblDatum);
	panDatum.add(datumRodjenjaTxtField);
	
	JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblAdresa = new JLabel("Adresa stanovanja*");
	lblAdresa.setPreferredSize(dim);
	adresaTxtField = new JTextField();
	adresaTxtField.setPreferredSize(dim);
	adresaTxtField.setName("txtAdresa");
	panAdresa.add(lblAdresa);
	panAdresa.add(adresaTxtField);
	
	JPanel panBrTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblBrTel = new JLabel("Broj telefona*");
	lblBrTel.setPreferredSize(dim);
	brojTelefonaTxtField = new JTextField();
	brojTelefonaTxtField.setPreferredSize(dim);
	brojTelefonaTxtField.setName("txtBrTel");
	panBrTel.add(lblBrTel);
	panBrTel.add(brojTelefonaTxtField);
	
	JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblEmail = new JLabel("E-mail adresa*");
	lblEmail.setPreferredSize(dim);
	emailTxtField = new JTextField();
	emailTxtField.setPreferredSize(dim);
	emailTxtField.setName("txtEmail");
	panEmail.add(lblEmail);
	panEmail.add(emailTxtField);
	
	JPanel panBrIndeksa = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblBrIndeksa = new JLabel("Broj indeksa*");
	lblBrIndeksa.setPreferredSize(dim);
	brojIndeksaTxtField = new JTextField();
	brojIndeksaTxtField.setPreferredSize(dim);
	brojIndeksaTxtField.setName("txtBrIndeksa");
	panBrIndeksa.add(lblBrIndeksa);
	panBrIndeksa.add(brojIndeksaTxtField);
	
	JPanel panGodUpisa = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblGodUpisa = new JLabel("Godina upisa*");
	lblGodUpisa.setPreferredSize(dim);
	godinaUpisaTxtField = new JTextField();
	godinaUpisaTxtField.setPreferredSize(dim);
	godinaUpisaTxtField.setName("txtGodUpisa");
	panGodUpisa.add(lblGodUpisa);
	panGodUpisa.add(godinaUpisaTxtField);
	
	JPanel panTrenGodStudija = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblTrenGodStudija = new JLabel("Trenutna godina studija*");
	lblTrenGodStudija.setPreferredSize(dim);
	String[] godine = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
	cbGodStudija= new JComboBox<String>(godine);
	cbGodStudija.setBackground(Color.WHITE);
	cbGodStudija.setPreferredSize(dim);
	panTrenGodStudija.add(lblTrenGodStudija);
	panTrenGodStudija.add(cbGodStudija);
	
	JPanel panFinansiranje = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel lblFinansiranje = new JLabel("Način finansiranja*");
	lblFinansiranje.setPreferredSize(dim);
	String[] finansiranje = {"Budžet", "Samofinansiranje"};
	cbStatus = new JComboBox<String>(finansiranje);
	cbStatus.setBackground(Color.WHITE);
	cbStatus.setPreferredSize(dim);
	panFinansiranje.add(lblFinansiranje);
	panFinansiranje.add(cbStatus);
	
	Box box = Box.createVerticalBox();
	box.add(Box.createVerticalStrut(20));
	box.add(panIme);
	box.add(panPrezime);
	box.add(panDatum);
	box.add(panAdresa);
	box.add(panBrTel);
	box.add(panEmail);
	box.add(panBrIndeksa);
	box.add(panGodUpisa);
	box.add(panTrenGodStudija);
	box.add(panFinansiranje);
	
	box.add(Box.createGlue());
	//add(box, BorderLayout.NORTH);
	
	JButton potvrdiBtn = new JButton("Potvrdi");
	JButton odustaniBtn = new JButton("Odustani");
	
	FocusListenerStudent focusListener = new FocusListenerStudent(potvrdiBtn);
	imeTxtField.addFocusListener(focusListener);
	prezimeTxtField.addFocusListener(focusListener);
	datumRodjenjaTxtField.addFocusListener(focusListener);
	adresaTxtField.addFocusListener(focusListener);
	brojTelefonaTxtField.addFocusListener(focusListener);
	emailTxtField.addFocusListener(focusListener);
	brojIndeksaTxtField.addFocusListener(focusListener);
	godinaUpisaTxtField.addFocusListener(focusListener);
	
	odustaniBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			IzmeniStudentaDijalog.getInstance().dispose();
		}
	});
	
	potvrdiBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Status status;
			
			if ((cbStatus.getSelectedItem().toString()).equals("Samofinansiranje")) {
				status = Status.S;
			} else {
				status = Status.B;
			}	
			
			tabelaStudenata = StudentiJTable.getInstance();
			
			StudentController.getInstance().izmeniStudenta(tabelaStudenata.getSelectedRow(), imeTxtField.getText(),
					prezimeTxtField.getText(), Student.parseDate(datumRodjenjaTxtField.getText()), adresaTxtField.getText(), brojTelefonaTxtField.getText(),
					emailTxtField.getText(), brojIndeksaTxtField.getText(), Integer.parseInt(godinaUpisaTxtField.getText()), cbGodStudija.getSelectedIndex() + 1, status);
			
			IzmeniStudentaDijalog.getInstance().dispose();
			
		}
	});
	
	JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	panButtons.add(potvrdiBtn);
	panButtons.add(odustaniBtn);
	
	box.add(panButtons);
	
	add(box, BorderLayout.SOUTH);

    }

	public JTextField getImeTxtField() {
		return imeTxtField;
	}

	public void setImeTxtField(JTextField imeTxtField) {
		this.imeTxtField = imeTxtField;
	}

	public JTextField getPrezimeTxtField() {
		return prezimeTxtField;
	}

	public void setPrezimeTxtField(JTextField prezimeTxtField) {
		this.prezimeTxtField = prezimeTxtField;
	}

	public JTextField getDatumRodjenjaTxtField() {
		return datumRodjenjaTxtField;
	}

	public void setDatumRodjenjaTxtField(JTextField datumRodjenjaTxtField) {
		this.datumRodjenjaTxtField = datumRodjenjaTxtField;
	}

	public JTextField getAdresaTxtField() {
		return adresaTxtField;
	}

	public void setAdresaTxtField(JTextField adresaTxtField) {
		this.adresaTxtField = adresaTxtField;
	}

	public JTextField getBrojTelefonaTxtField() {
		return brojTelefonaTxtField;
	}

	public void setBrojTelefonaTxtField(JTextField brojTelefonaTxtField) {
		this.brojTelefonaTxtField = brojTelefonaTxtField;
	}

	public JTextField getEmailTxtField() {
		return emailTxtField;
	}

	public void setEmailTxtField(JTextField emailTxtField) {
		this.emailTxtField = emailTxtField;
	}

	public JTextField getBrojIndeksaTxtField() {
		return brojIndeksaTxtField;
	}

	public void setBrojIndeksaTxtField(JTextField brojIndeksaTxtField) {
		this.brojIndeksaTxtField = brojIndeksaTxtField;
	}

	public JTextField getGodinaUpisaTxtField() {
		return godinaUpisaTxtField;
	}

	public void setGodinaUpisaTxtField(JTextField godinaUpisaTxtField) {
		this.godinaUpisaTxtField = godinaUpisaTxtField;
	}

	public JTable getTabelaStudenata() {
		return tabelaStudenata;

	}

	public void setTabelaStudenata(JTable tabelaStudenata) {
		this.tabelaStudenata = tabelaStudenata;
	}

	public JComboBox<String> getCbGodStudija() {
		return cbGodStudija;
	}

	public JComboBox<String> getCbStatus() {
		return cbStatus;
	}
    
	public void izracunaj(List<Ocena> spisakOcena) {
		
		int cnt = 0;
		double zbir = 0;
		
		for (int i = 0; i < spisakOcena.size(); i++) {
			zbir += spisakOcena.get(i).getVrednostOcene();
			cnt++;
		}
		
		prosek = Math.round((zbir/cnt) * 100.0) / 100.0;
		
		brojESPB = 0;
		
		for (int i = 0; i < spisakOcena.size(); i++) {
			brojESPB += spisakOcena.get(i).getPredmet().getBrojESPB();
		}
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public int getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}
	
	
    
}
