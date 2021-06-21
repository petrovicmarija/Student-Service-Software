package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.StudentController;
import model.Status;
import model.Student;
import listeners.FocusListenerStudent;

public class DodajStudentaDijalog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodajStudentaDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(550, 450);
		setLocationRelativeTo(parent);
		
		Dimension dim = new Dimension(225, 20);		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDatum = new JLabel("Datum rođenja*");
		lblDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("txtDatum");
		panDatum.add(lblDatum);
		panDatum.add(txtDatum);
		
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblAdresa = new JLabel("Adresa stanovanja*");
		lblAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("txtAdresa");
		panAdresa.add(lblAdresa);
		panAdresa.add(txtAdresa);
		
		JPanel panBrTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBrTel = new JLabel("Broj telefona*");
		lblBrTel.setPreferredSize(dim);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dim);
		txtBrTel.setName("txtBrTel");
		panBrTel.add(lblBrTel);
		panBrTel.add(txtBrTel);
		
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		JPanel panBrIndeksa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBrIndeksa = new JLabel("Broj indeksa*");
		lblBrIndeksa.setPreferredSize(dim);
		JTextField txtBrIndeksa = new JTextField();
		txtBrIndeksa.setPreferredSize(dim);
		txtBrIndeksa.setName("txtBrIndeksa");
		panBrIndeksa.add(lblBrIndeksa);
		panBrIndeksa.add(txtBrIndeksa);
		
		JPanel panGodUpisa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblGodUpisa = new JLabel("Godina upisa*");
		lblGodUpisa.setPreferredSize(dim);
		JTextField txtGodUpisa = new JTextField();
		txtGodUpisa.setPreferredSize(dim);
		txtGodUpisa.setName("txtGodUpisa");
		panGodUpisa.add(lblGodUpisa);
		panGodUpisa.add(txtGodUpisa);
		
		JPanel panTrenGodStudija = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTrenGodStudija = new JLabel("Trenutna godina studija*");
		lblTrenGodStudija.setPreferredSize(dim);
		String[] godine = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		final JComboBox<String> comboBox = new JComboBox<String>(godine);
		comboBox.setBackground(Color.WHITE);
		comboBox.setPreferredSize(dim);
		panTrenGodStudija.add(lblTrenGodStudija);
		panTrenGodStudija.add(comboBox);
		
		JPanel panFinansiranje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblFinansiranje = new JLabel("Način finansiranja*");
		lblFinansiranje.setPreferredSize(dim);
		String[] finansiranje = {"Budžet", "Samofinansiranje"};
		final JComboBox<String> comboBox2 = new JComboBox<String>(finansiranje);
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setPreferredSize(dim);
		panFinansiranje.add(lblFinansiranje);
		panFinansiranje.add(comboBox2);
		
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
		add(box, BorderLayout.NORTH);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");
		
		FocusListenerStudent focusListener = new FocusListenerStudent(potvrdiBtn);
		txtIme.addFocusListener(focusListener);
		txtPrezime.addFocusListener(focusListener);
		txtDatum.addFocusListener(focusListener);
		txtAdresa.addFocusListener(focusListener);
		txtBrTel.addFocusListener(focusListener);
		txtEmail.addFocusListener(focusListener);
		txtBrIndeksa.addFocusListener(focusListener);
		txtGodUpisa.addFocusListener(focusListener);
		
		odustaniBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Status status;
				
				if ((comboBox2.getSelectedItem().toString()).equals("Samofinansiranje")) {
					status = Status.S;
				} else {
					status = Status.B;
				}	
				
				StudentController.getInstance().dodajStudenta(txtIme.getText(), txtPrezime.getText(), Student.parseDate(txtDatum.getText()), txtAdresa.getText(), txtBrTel.getText(), 
						txtEmail.getText(), txtBrIndeksa.getText(), Integer.parseInt(txtGodUpisa.getText()), comboBox.getSelectedIndex() + 1, status);
				
				dispose();
				
			}
		});
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panButtons.add(potvrdiBtn);
		panButtons.add(odustaniBtn);
		
		add(panButtons, BorderLayout.SOUTH);
	}

}
