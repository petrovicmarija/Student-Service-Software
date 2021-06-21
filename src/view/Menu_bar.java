package view;

import javax.swing.*;

import controller.PredmetController;
import controller.StudentController;
import model.Predmet;
import model.Profesor;
import model.Status;
import model.Student;
import model.Titula;
import model.Zvanje;
import controller.ProfesoriController;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.format.DateTimeFormatter;

import view.dialogs.HelpDijalog;
import view.dialogs.IzmeniPredmetDijalog;
import view.dialogs.IzmeniProfesoraDijalog;
import view.dialogs.IzmeniStudentaDijalog;
import view.dialogs.AboutDijalog;
import view.dialogs.DodajPredmetDijalog;
import view.dialogs.DodajProfesoraDijalog;
import view.dialogs.DodajStudentaDijalog;

public class Menu_bar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable tabelaPredmeta;

	public Menu_bar() {
		
		//FILE
		JMenu file = new JMenu ("File");
		JMenuItem mNew = new JMenuItem ("New", new ImageIcon("images" + File.separator + "add.png"));
		JMenuItem mClose = new JMenuItem ("Close", new ImageIcon("images" + File.separator + "cancel.png"));
		
		mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		mNew.setMnemonic(KeyEvent.VK_N);
		mClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		mClose.setMnemonic(KeyEvent.VK_C);
				
		mNew.setPreferredSize(new Dimension (150, mNew.getPreferredSize().height));
		mClose.setPreferredSize(new Dimension (150, mClose.getPreferredSize().height));
		
		mNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					DodajStudentaDijalog dodajStudentaDijalog = new DodajStudentaDijalog(Glavni_prozor.getInstance(), "Dodavanje studenta", true);
					dodajStudentaDijalog.setVisible(true);
					
				} else if (TabbedPane.getInstance().getSelectedIndex() == 1){
					DodajProfesoraDijalog dijalog = new DodajProfesoraDijalog(Glavni_prozor.getInstance(), "Dodavanje profesora", true);
					dijalog.setVisible(true);
					
				} else if(TabbedPane.getInstance().getSelectedIndex() == 2) {
					DodajPredmetDijalog dodajPredmetDijalog = new DodajPredmetDijalog(Glavni_prozor.getInstance(), "Dodavanje predmeta", true);
					dodajPredmetDijalog.setVisible(true);
				}
		
			}
		});
		
		file.add(mNew);
		file.addSeparator();
		file.add(mClose);
		file.addSeparator();
		
		add(file);
		
		//EDIT
		JMenu edit = new JMenu ("Edit");
		JMenuItem mEdit = new JMenuItem ("Edit", new ImageIcon("images" + File.separator + "pencil.png"));
		JMenuItem mDelete = new JMenuItem ("Delete", new ImageIcon("images" + File.separator + "trash.png"));
		
		mEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		mEdit.setMnemonic(KeyEvent.VK_E);
		mDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		mDelete.setMnemonic(KeyEvent.VK_D);
		
		mEdit.setPreferredSize(new Dimension (150, mEdit.getPreferredSize().height));
		mDelete.setPreferredSize(new Dimension (150, mDelete.getPreferredSize().height));
		
		mEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(TabbedPane.getInstance().getSelectedIndex() == 1) {
					
					if(ProfesoriJTable.getInstance().getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali profesora kojeg želite da izmenite!");
					
					} else {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
						
						int trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
						String brojLicne = (String) ProfesoriJTable.getInstance().getValueAt(trenutniRed, 4);
						Profesor profesor = ProfesoriController.getInstance().nadjiProfesora(brojLicne);
						
						IzmeniProfPanelInfo.getInstance().getPrezimeTxtField().setText(profesor.getPrezime());
						IzmeniProfPanelInfo.getInstance().getImeTxtField().setText(profesor.getIme());
						IzmeniProfPanelInfo.getInstance().getDatumTxtField().setText(profesor.getDatumRodjenja().format(formatter));
						IzmeniProfPanelInfo.getInstance().getAdresaTxtField().setText(profesor.getAdresa());
						IzmeniProfPanelInfo.getInstance().getTelefonTxtField().setText(profesor.getBrojTelefona());
						IzmeniProfPanelInfo.getInstance().getEmailTxtField().setText(profesor.getEmail());
						IzmeniProfPanelInfo.getInstance().getAdrKancTxtField().setText(profesor.getAdresaKanc());
						IzmeniProfPanelInfo.getInstance().getBrLicneTxtField().setText(profesor.getBrLicneKarte());
						
						if(profesor.getTitula() == Titula.bsc) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(0);
						} else if (profesor.getTitula() ==  Titula.msc) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(1);
						} else if (profesor.getTitula() == Titula.mr) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(2);
						} else if(profesor.getTitula() == Titula.dr) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(3);
						} else {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(4);
						}
						
						if(profesor.getZvanje() == Zvanje.DOCENT) {
							IzmeniProfPanelInfo.getInstance().getComboBox2().setSelectedIndex(0);
						} else if(profesor.getZvanje() == Zvanje.VANREDNI_PROFESOR) {
							IzmeniProfPanelInfo.getInstance().getComboBox2().setSelectedIndex(1);
						} else {
							IzmeniProfPanelInfo.getInstance().getComboBox2().setSelectedIndex(2);
						}
						Glavni_prozor.getInstance().azurirajPrikazPredmetaProfesora("Azuriraj", -1);
						
						IzmeniProfesoraDijalog.getInstance().setVisible(true);
						
					}
				} else if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					
					if(StudentiJTable.getInstance().getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali studenta kojeg želite da izmenite!");
					} else {
						
						int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
						String izmeniStudenta = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
						Student student = StudentController.getInstance().nadjiStudenta(izmeniStudenta);
						
						IzmeniStudentaPanelInfo.getInstance().getImeTxtField().setText(student.getIme());
						IzmeniStudentaPanelInfo.getInstance().getPrezimeTxtField().setText(student.getPrezime());
						IzmeniStudentaPanelInfo.getInstance().getDatumRodjenjaTxtField().setText(Student.prebaciDatumUString(student.getDatumRodjenja()));
						IzmeniStudentaPanelInfo.getInstance().getAdresaTxtField().setText(student.getAdresa());
						IzmeniStudentaPanelInfo.getInstance().getBrojTelefonaTxtField().setText(student.getBrTel());
						IzmeniStudentaPanelInfo.getInstance().getEmailTxtField().setText(student.getEmail());
						IzmeniStudentaPanelInfo.getInstance().getBrojIndeksaTxtField().setText(student.getBrIndeksa());
						IzmeniStudentaPanelInfo.getInstance().getGodinaUpisaTxtField().setText(String.valueOf(student.getGodUpisa()));
						
						if (student.getTrenutnaGodStudija() == 1) {
							IzmeniStudentaPanelInfo.getInstance().getCbGodStudija().setSelectedIndex(0);
						} else if (student.getTrenutnaGodStudija() == 2) {
							IzmeniStudentaPanelInfo.getInstance().getCbGodStudija().setSelectedIndex(1);
						} else if (student.getTrenutnaGodStudija() == 3) {
							IzmeniStudentaPanelInfo.getInstance().getCbGodStudija().setSelectedIndex(2);
						} else if (student.getTrenutnaGodStudija() == 4) {
							IzmeniStudentaPanelInfo.getInstance().getCbGodStudija().setSelectedIndex(3);
						}
						
						if(student.getStatus() == Status.B) {
							IzmeniStudentaPanelInfo.getInstance().getCbStatus().setSelectedIndex(0);
						} else if (student.getStatus() == Status.S) {
							IzmeniStudentaPanelInfo.getInstance().getCbStatus().setSelectedIndex(1);
						}
						
						IzmeniStudentaDijalog.getInstance().setVisible(true);
					}
				} else if (TabbedPane.getInstance().getSelectedIndex() == 2) {
					
					if(PredmetiJTable.getInstance().getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali predmet koji želite da izmenite!");
					} else {
						IzmeniPredmetDijalog izmeniPredmetDijalog = new IzmeniPredmetDijalog(Glavni_prozor.getInstance(), "Izmena predmeta", true);
						izmeniPredmetDijalog.setVisible(true);
					}
				}
				
			}
		});
		
		mDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					
					if (StudentiJTable.getInstance().getSelectedRow() < 0 ) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali studenta kojeg želite da obrišete!");
						
					} else {
						
						int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
						String obrisiStudenta = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
						Student student = StudentController.getInstance().nadjiStudenta(obrisiStudenta);
						
						int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite da obrišete studenta?", "Brisanje studenta",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (option == JOptionPane.YES_OPTION) {
							StudentController.getInstance().obrisiStudenta(student.getBrIndeksa());
						}
					}
				} else if (TabbedPane.getInstance().getSelectedIndex() == 2){
					tabelaPredmeta = PredmetiJTable.getInstance();
					
					if(tabelaPredmeta.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali predmet koji želite da obrišete!");
					} else {
						int trenutniRed = PredmetiJTable.getInstance().getSelectedRow();
						String obrisiPredmet = (String) PredmetiJTable.getInstance().getValueAt(trenutniRed, 0);
						Predmet predmet = PredmetController.getInstance().nadjiPredmet(obrisiPredmet);
						
						int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite da obrišete predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if(option == JOptionPane.YES_OPTION) {
							PredmetController.getInstance().izbrisiPredmet(predmet.getSifraPredmeta());
						}
						
					}
				} else if (TabbedPane.getInstance().getSelectedIndex() == 1) {
					
					if (ProfesoriJTable.getInstance().getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali profesora kojeg želite da obrišete!");
					} else {
						int trenutniRed = ProfesoriJTable.getInstance().getSelectedRow();
						String brojLicne = (String) ProfesoriJTable.getInstance().getValueAt(trenutniRed, 4);
						Profesor profesor = ProfesoriController.getInstance().nadjiProfesora(brojLicne);
						
						int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite da obrišete profesora?", "Brisanje profesora",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (option == JOptionPane.YES_OPTION) {
							ProfesoriController.getInstance().obrisiProfesora(profesor.getBrLicneKarte());
						}
					}
				}
			}
		});
	
		edit.add(mEdit);
		edit.addSeparator();
		edit.add(mDelete);
		edit.addSeparator();
		
		add(edit);
		
		//HELP
		JMenu help = new JMenu ("Help");
		JMenuItem mHelp = new JMenuItem ("Help", new ImageIcon("images" + File.separator + "help.png"));
		JMenuItem mAbout = new JMenuItem ("About", new ImageIcon("images" + File.separator + "information.png"));
		
		mHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		mHelp.setMnemonic(KeyEvent.VK_H);
		mAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		mAbout.setMnemonic(KeyEvent.VK_A);
		
		mHelp.setPreferredSize(new Dimension (150, mHelp.getPreferredSize().height));
		mAbout.setPreferredSize(new Dimension (150, mAbout.getPreferredSize().height));
		
		mHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDijalog dHelp = new HelpDijalog(Glavni_prozor.getInstance(), "Help", true);
				dHelp.setVisible(true);
				
			}
		});
		
		mAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDijalog dAbout = new AboutDijalog(Glavni_prozor.getInstance(), "About", true);
				dAbout.setVisible(true);
				
			}
		});
		
		help.add(mHelp);
		help.addSeparator();
		help.add(mAbout);
		help.addSeparator();
		
		add(help);
	}

	
}
