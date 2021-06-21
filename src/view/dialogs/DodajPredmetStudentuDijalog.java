package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Predmet;
import model.Student;
import view.Glavni_prozor;

public class DodajPredmetStudentuDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public DodajPredmetStudentuDijalog(JDialog parent, String title, boolean modal, List<Predmet> odgovarajuciPredmeti, Student student) {
		
		super(parent, title, modal);
		
		setSize(350, 350);
		setLocationRelativeTo(parent);

		
		//JPanel panelLista = new JPanel();


		//Student student = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow());
		//String brojIndeksa = BazaStudenata.getInstance().getRow(StudentiJTable.getInstance().getSelectedRow()).getBrIndeksa();
		//List<Predmet> odgovarajuciPredmeti = BazaPredmeta.getInstance().predmetiZaStudenta(student);
		//int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
		//String brojIndeksa = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
		//Student student = StudentController.getInstance().nadjiStudenta(brojIndeksa);
		//List<Predmet> odgovarajuciPredmeti = student.predmetiZaStudenta(student);
		
		Object[] prikazi;
		
		if (odgovarajuciPredmeti.isEmpty()) {
			prikazi = new Object[1];
			prikazi[0] = "Nema nijedan predmet za slusanje.";
		} else {
			prikazi = new Object[odgovarajuciPredmeti.size()];
			int i = 0;
			
			for (Predmet predmet : odgovarajuciPredmeti) {
				prikazi[i] = predmet.getSifraPredmeta() + " " + predmet.getNazivPredmeta();
				i++;
			}
		}
		
		JLabel nepolozeniPredmetiLab = new JLabel("Nepoloženi predmeti: ");
		
		/** REFERENCA:
		 * 	https://faculty.gcsu.edu/custom-website/gita-phelps/1302/1302JListToolTips.pdf
		 * */
		
		@SuppressWarnings({ "rawtypes" })
		JList listaPredmeta = new JList(prikazi);
		listaPredmeta.setListData(prikazi);
		
		JScrollPane listaPanel = new JScrollPane(listaPredmeta);
		
		listaPanel.setPreferredSize(new Dimension(250, 200));
				
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dodajBtn = new JButton("Dodaj");
		JButton odustaniBtn = new JButton("Odustani");
		
		panelBtn.add(dodajBtn);
		panelBtn.add(odustaniBtn);		
		
		dodajBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int index = listaPredmeta.getSelectedIndex();
				
				if(index == -1) {
					JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali predmet koji želite da dodate!");
				} else {
					
					Predmet predmet = odgovarajuciPredmeti.get(index);
					student.dodajPredmetStudentu(predmet);
					//odgovarajuciPredmeti.remove(index);
					
					Glavni_prozor.getInstance().azurirajPrikazPredmetaStudenta("", -1);
					Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
					dispose();
				}
			}
		});
		

		add(nepolozeniPredmetiLab, BorderLayout.NORTH);
		add(listaPanel, BorderLayout.CENTER);

		add(panelBtn, BorderLayout.SOUTH);
	}
}
