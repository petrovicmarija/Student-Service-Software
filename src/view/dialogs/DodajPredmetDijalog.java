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

import controller.PredmetController;
import listeners.FocusListenerPredmet;
import model.Semestar;

public class DodajPredmetDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DodajPredmetDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(600, 500);
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
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblNaziv = new JLabel("Naziv predmeta*");
		lblNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
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
		
		JPanel panProfesor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblProfesor = new JLabel("Predmetni profesor*");
		lblProfesor.setPreferredSize(dim);
		JTextField txtProfesor = new JTextField();
		txtProfesor.setPreferredSize(dim);
		txtProfesor.setName("txtProfesor");
		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor); 
		
		JPanel panBodovi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBodovi = new JLabel("Broj ESPB bodova*");
		lblBodovi.setPreferredSize(dim);
		JTextField txtBodovi = new JTextField();
		txtBodovi.setPreferredSize(dim);
		txtBodovi.setName("txtBodovi");
		panBodovi.add(lblBodovi);
		panBodovi.add(txtBodovi);
		
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(panSifra);
		box.add(panNaziv);
		box.add(panSemestar);
		box.add(panGodStudija);
		box.add(panProfesor);
		box.add(panBodovi);
		
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
				//Profesor profesor = new Profesor();
				
				if ((cbSemestar.getSelectedItem().toString()).equals("Letnji")) {
					semestar = Semestar.letnji;
				} else {
					semestar = Semestar.zimski;
				}
				
				PredmetController.getInstance().dodajPredmet(txtSifra.getText(), txtNaziv.getText(), 
						semestar, cbGodine.getSelectedIndex() + 1, null, Integer.parseInt(txtBodovi.getText()));
				dispose();
			}
		});
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panButtons.add(potvrdiBtn);
		panButtons.add(odustaniBtn);
		
		add(panButtons, BorderLayout.SOUTH);
		
	}

}
