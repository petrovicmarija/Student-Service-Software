package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;

import controller.PredmetController;
import controller.ProfesoriController;
import controller.StudentController;
import model.Predmet;
import model.Profesor;
import model.Status;
import model.Student;
import model.Titula;
import model.Zvanje;
import view.dialogs.DodajPredmetDijalog;
import view.dialogs.DodajProfesoraDijalog;
import view.dialogs.DodajStudentaDijalog;
import view.dialogs.IzmeniPredmetDijalog;
import view.dialogs.IzmeniProfesoraDijalog;
import view.dialogs.IzmeniStudentaDijalog;

public class Toolbar1 extends JToolBar{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable tabelaPredmeta;

public Toolbar1() {
	
		super(SwingConstants.HORIZONTAL);
		
		JButton createButton = new JButton();
		createButton.setIcon(new ImageIcon("images"+ File.separator + "add.png"));
		createButton.setToolTipText("Click this button if you want to create");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					DodajStudentaDijalog dodajStudentaDijalog = new DodajStudentaDijalog(Glavni_prozor.getInstance(), "Dodavanje studenta", true);
					dodajStudentaDijalog.setVisible(true);
					
				} else if (TabbedPane.getInstance().getSelectedIndex() == 1) {
					DodajProfesoraDijalog dijalog = new DodajProfesoraDijalog(Glavni_prozor.getInstance(), "Dodavanje profesora", true);
					dijalog.setVisible(true);				
				} else if (TabbedPane.getInstance().getSelectedIndex() == 2) {
					DodajPredmetDijalog dodajPredmetDijalog = new DodajPredmetDijalog(Glavni_prozor.getInstance(), "Dodavanje predmeta", true);
					dodajPredmetDijalog.setVisible(true);
				}
				
			}
		});
		add(createButton);
		
		addSeparator();
		
		JButton editButton = new JButton();
		editButton.setIcon(new ImageIcon("images" + File.separator + "pencil.png"));
		editButton.setToolTipText("Click this button if you want to edit");
		editButton.addActionListener(new ActionListener() {
			
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
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(4);
						} else if (profesor.getTitula() ==  Titula.msc) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(3);
						} else if (profesor.getTitula() == Titula.mr) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(1);
						} else if(profesor.getTitula() == Titula.dr) {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(0);
						} else {
							IzmeniProfPanelInfo.getInstance().getComboBox1().setSelectedIndex(2);
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
						
						Glavni_prozor.getInstance().azurirajPrikazNepolozenihPredmeta("", -1);
						TabbedPaneIzmeniStudenta.getInstance().azurirajPolozene();
						
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
		
		
		
		add(editButton);
		
		addSeparator();
		
		JButton deleteButton = new JButton();
		deleteButton.setIcon(new ImageIcon("images" + File.separator + "trash.png"));
		deleteButton.setToolTipText("Click this button if you want to delete");
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					
					if (StudentiJTable.getInstance().getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(Glavni_prozor.getInstance(), "Niste izabrali studenta kojeg želite da obrišete!");
						
					} else {
						
					    int trenutniRed = StudentiJTable.getInstance().getSelectedRow();
						String izmeniStudenta = (String) StudentiJTable.getInstance().getValueAt(trenutniRed, 0);
						Student student = StudentController.getInstance().nadjiStudenta(izmeniStudenta);
						
						int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite da obrišete studenta?", "Brisanje studenta",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if (option == JOptionPane.YES_OPTION) {
							StudentController.getInstance().obrisiStudenta(student.getBrIndeksa());
						}
					}
				} else if(TabbedPane.getInstance().getSelectedIndex() == 2) {
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
		
		add(deleteButton);
		
		Dimension dim1 = new Dimension(150,20);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JTextField searchField = new JTextField();
		searchField.setPreferredSize(dim1);
		panel.add(searchField);
		
		
		JButton searchButton = new JButton();
		searchButton.setIcon(new ImageIcon("images" + File.separator + "magnifying-glass.png"));	
		searchButton.setToolTipText("Click this button if you want to search");
		searchButton.addActionListener(new ActionListener() {
			
			
			/** REFERENCA:
			 * 	https://www.tutorialspoint.com/how-to-implement-the-search-functionality-of-a-jtable-in-java 
			 * */
			

			/** REFERENCE:
			 *  https://www.programcreek.com/java-api-examples/?class=javax.swing.RowFilter&method=regexFilter
			 *  https://stackoverflow.com/questions/5194948/java-swing-combine-rowfilter-andfilter-with-rowfilter-orfilter?fbclid=IwAR0Y9jc4Beo3Ijpl_qC3X5UCnCzp-vw8ljiQCYNglADphoIhBEhFtqKw8yE
			 *  
			 * */
			

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (TabbedPane.getInstance().getSelectedIndex() == 0) {
					String[] tekst = searchField.getText().split(" ");
					if(tekst.length == 0) {
						StudentiJTable.getInstance();
						StudentiJTable.sortiraj.setRowFilter(null);
					} else {
						if(tekst.length == 1) {
							
							try {
								StudentiJTable.getInstance();
								StudentiJTable.sortiraj.setRowFilter(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)", 2));
							} catch (PatternSyntaxException pse) {
								System.out.println("Greska!");
							}
							
						} else {
							if(tekst.length == 2) {
								
								try {
									StudentiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)",2));
									StudentiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[1] + ".*$)", 1));
									StudentiJTable.getInstance().sortiraj.setRowFilter(RowFilter.andFilter(StudentiJTable.getInstance().filteri));
									
								} catch (PatternSyntaxException pse) {
									System.out.println("Greska!");
								}
								for(int i = 0; i < StudentiJTable.getInstance().filteri.size(); i++) {
									StudentiJTable.getInstance().filteri.remove(i);
								}
							} else {
								try {
									StudentiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)", 2));
									StudentiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[1] + ".*$)", 1));
									StudentiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[2] + ".*$)", 0));
									StudentiJTable.getInstance().sortiraj.setRowFilter(RowFilter.andFilter(StudentiJTable.getInstance().filteri));
								} catch (PatternSyntaxException pse) {
									System.out.println("Greska!");
								}
								for(int i = 0; i < StudentiJTable.getInstance().filteri.size(); i++) {
									StudentiJTable.getInstance().filteri.remove(i);
								}
							}
						}
					}
					
					


					
				} else if(TabbedPane.getInstance().getSelectedIndex() == 1){
					
					String[] tekst = searchField.getText().split(" ");
					if(tekst.length == 0) {
						ProfesoriJTable.getInstance();
						ProfesoriJTable.sortiraj.setRowFilter(null);
					} else {
						if(tekst.length == 1) {
							
							try {
								ProfesoriJTable.getInstance();
								ProfesoriJTable.sortiraj.setRowFilter(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)", 0));
							} catch (PatternSyntaxException pse) {
								System.out.println("Greska!");
							}
							
						} else {
							if(tekst.length == 2) {
								
								try {
									ProfesoriJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)",0));
									ProfesoriJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[1] + ".*$)", 1));
									ProfesoriJTable.getInstance().sortiraj.setRowFilter(RowFilter.andFilter(ProfesoriJTable.getInstance().filteri));
									
								} catch (PatternSyntaxException pse) {
									System.out.println("Greska!");
								}
								for(int i = 0; i < StudentiJTable.getInstance().filteri.size(); i++) {
									ProfesoriJTable.getInstance().filteri.remove(i);
								}
							} else {
								try {
									ProfesoriJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)", 0));
									ProfesoriJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[1] + ".*$)", 1));
									ProfesoriJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[2] + ".*$)", 4));
									ProfesoriJTable.getInstance().sortiraj.setRowFilter(RowFilter.andFilter(ProfesoriJTable.getInstance().filteri));
								} catch (PatternSyntaxException pse) {
									System.out.println("Greska!");
								}
								for(int i = 0; i < StudentiJTable.getInstance().filteri.size(); i++) {
									ProfesoriJTable.getInstance().filteri.remove(i);
								}
							}
						}
					}
					
					
					
					
				} else if(TabbedPane.getInstance().getSelectedIndex() == 2){
					
					String[] tekst = searchField.getText().split(" ");
					if(tekst.length == 0) {
						PredmetiJTable.getInstance();
						PredmetiJTable.sortiraj.setRowFilter(null);
					} else {
						if(tekst.length == 1) {
							
							try {
								PredmetiJTable.getInstance();
								PredmetiJTable.sortiraj.setRowFilter(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)", 0));
							} catch (PatternSyntaxException pse) {
								System.out.println("Greska!");
							}
							
						} else {
							if(tekst.length == 2) {
								
								try {
									PredmetiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[0] + ".*$)",0));
									PredmetiJTable.getInstance().filteri.add(RowFilter.regexFilter("(?i)" + "(^.*" + tekst[1] + ".*$)", 1));
									PredmetiJTable.getInstance().sortiraj.setRowFilter(RowFilter.andFilter(PredmetiJTable.getInstance().filteri));
									
								} catch (PatternSyntaxException pse) {
									System.out.println("Greska!");
								}
								for(int i = 0; i < StudentiJTable.getInstance().filteri.size(); i++) {
									PredmetiJTable.getInstance().filteri.remove(i);
								}
							}
						}
					}

				}
				
			}
		});
		
		panel.add(searchButton);
		add(panel);
		
		
	}
	

}
