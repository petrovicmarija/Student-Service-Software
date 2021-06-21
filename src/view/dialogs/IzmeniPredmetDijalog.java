package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import listeners.FocusListenerPredmet;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import view.Glavni_prozor;
import view.PredmetiJTable;

public class IzmeniPredmetDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int trenutniRed = PredmetiJTable.getInstance().getSelectedRow();
	private String izmeniPredmet = (String) PredmetiJTable.getInstance().getValueAt(trenutniRed, 0);
	private Predmet predmet = PredmetController.getInstance().nadjiPredmet(izmeniPredmet);
	private String profesorImePrz = predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime();
	private JTextField predmetniProfesor;
	
	public IzmeniPredmetDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(550, 450);
		setLocationRelativeTo(parent);
		
		Dimension dim = new Dimension(225, 20);
		
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSifra = new JLabel("Šifra predmeta*");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		txtSifra.setText(predmet.getSifraPredmeta());
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblNaziv = new JLabel("Naziv predmeta*");
		lblNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		txtNaziv.setText(predmet.getNazivPredmeta());
		
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSemestar = new JLabel("Semestar*");
		lblSemestar.setPreferredSize(dim);
		String[] semestar = {"Letnji", "Zimski"};
		final JComboBox<String> cbSemestar = new JComboBox<String>(semestar);
		cbSemestar.setBackground(Color.WHITE);
		cbSemestar.setPreferredSize(dim);
		panSemestar.add(lblSemestar);
		panSemestar.add(cbSemestar);
		
		JPanel panGodStudija = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblGodStudija = new JLabel("Godina studija na kojoj se izvodi*");
		lblGodStudija.setPreferredSize(dim);
		String[] godina = {"1", "2", "3", "4"};
		final JComboBox<String> cbGodine = new JComboBox<String>(godina);
		cbGodine.setBackground(Color.WHITE);
		cbGodine.setPreferredSize(dim);
		panGodStudija.add(lblGodStudija);
		panGodStudija.add(cbGodine);
		cbGodine.setSelectedIndex(predmet.getGodStudijaZaPredmet() - 1);
		
		JPanel panProfesor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblProfesor = new JLabel("Predmetni profesor*");
		lblProfesor.setPreferredSize(new Dimension(225, 25));
		JTextField txtProfesor = new JTextField();
		txtProfesor.setPreferredSize(new Dimension(140, 25));
		txtProfesor.setName("txtProfesor");
		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor); 
		txtProfesor.setText(profesorImePrz);
		predmetniProfesor = txtProfesor;
		
		JButton plusSign = new JButton("+");
		plusSign.setFont(new Font("Arial", Font.BOLD, 10));
		JButton minusSign = new JButton("-");
		minusSign.setFont(new Font("Arial", Font.BOLD, 10));
		plusSign.setPreferredSize(new Dimension(40,25));
		minusSign.setPreferredSize(new Dimension(40,25));
		
		plusSign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodajProfesoraNaPredmetDijalog dijalog = new DodajProfesoraNaPredmetDijalog(Glavni_prozor.getInstance(), "Odaberi profesora", true);
				dijalog.setVisible(true);
				
			}
		});
		

		minusSign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni?", "Ukloni profesora",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (option == JOptionPane.YES_OPTION) {
					txtProfesor.setText(" ");
					predmet.obrisiProfesora(predmet.getPredmetniProfesor());
					predmet.setPredmetniProfesor(new Profesor("",""));
					Glavni_prozor.getInstance().azurirajPrikazPredmetaProfesora("", -1);
					Glavni_prozor.getInstance().azurirajPrikazPredmeta("", -1);
				}
				
			}
		});

		panProfesor.add(plusSign);
		panProfesor.add(minusSign); 
		
		JPanel panBodovi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBodovi = new JLabel("Broj ESPB bodova*");
		lblBodovi.setPreferredSize(dim);
		JTextField txtBodovi = new JTextField();
		txtBodovi.setPreferredSize(dim);
		txtBodovi.setName("txtBodovi");
		panBodovi.add(lblBodovi);
		panBodovi.add(txtBodovi);
		txtBodovi.setText(String.valueOf(predmet.getBrojESPB()));
		
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(panSifra);
		box.add(panNaziv);
		box.add(panSemestar);
		box.add(panGodStudija);
		box.add(panBodovi);
		box.add(panProfesor);
		
		box.add(Box.createGlue());
		add(box, BorderLayout.NORTH);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");
		
		FocusListenerPredmet focusListener = new FocusListenerPredmet(potvrdiBtn);
		txtSifra.addFocusListener(focusListener);
		txtNaziv.addFocusListener(focusListener);
		txtProfesor.addFocusListener(focusListener);
		txtBodovi.addFocusListener(focusListener);
		
		odustaniBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Semestar semestar;
				
				if ((cbSemestar.getSelectedItem().toString()).equals("Letnji")) {
					semestar = Semestar.letnji;
				} else {
					semestar = Semestar.zimski;
				}
				
				predmet.setSifraPredmeta(txtSifra.getText());
				predmet.setNazivPredmeta(txtNaziv.getText());
				predmet.setSemestar(semestar);
				predmet.setGodStudijaZaPredmet(cbGodine.getSelectedIndex() + 1);
				predmet.setPredmetniProfesor(predmet.getPredmetniProfesor());
				predmet.setBrojESPB(Integer.parseInt(txtBodovi.getText()));
				PredmetController.getInstance().izmeniPredmet(predmet);
				
				dispose();
				
			}
		});
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panButtons.add(potvrdiBtn);
		panButtons.add(odustaniBtn);
		
		//box.add(panButtons);
		
		add(panButtons, BorderLayout.SOUTH);
		
	}
	public JTextField getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(JTextField predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
	

}
