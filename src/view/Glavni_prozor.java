package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Glavni_prozor extends JFrame {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Glavni_prozor instanca = null;
	
	private Glavni_prozor() {
		initialise();
		}

	private void initialise() {
	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight *3/4);
		setTitle("Studentska služba");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		Menu_bar menu = new Menu_bar();
		this.setJMenuBar(menu);
	
		Toolbar1 toolbar = new Toolbar1();
		add(toolbar, BorderLayout.NORTH);
	
		Status_bar statusBar = new Status_bar();
		this.add(statusBar, BorderLayout.SOUTH);
		statusBar.datumVreme();
		
		TabbedPane tabbedPane = TabbedPane.getInstance();
		this.add(tabbedPane);
		
		this.addWindowListener(new WindowListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				ArrayList<Student> studenti = (ArrayList<Student>) BazaStudenata.getInstance().getStudenti();
				ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
				ArrayList<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
				
				File fStud = new File("Studenti.txt");
				File fProf = new File("Profesori.txt");
				File fPred = new File("Predmeti.txt");
				
				ObjectInputStream in = null;
				
				try {
					
					in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fStud)));
					studenti = (ArrayList<Student>) in.readObject();
					BazaStudenata.getInstance().setStudenti(studenti);
					azurirajPrikazStudenta("", -1);
					
				} catch(Exception e) {					
					e.printStackTrace();
					
				} finally {					
					try {				
						in.close();					
					} catch(IOException e) {						
						e.printStackTrace();
					}
				}
				
				
				try {
					
					in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fProf)));
					profesori = (ArrayList<Profesor>) in.readObject();
					BazaProfesora.getInstance().setProfesori(profesori);
					azurirajPrikazProfesora("", -1);
					
				} catch(Exception e) {
					e.printStackTrace();
					
				} finally {
					try {
						in.close();
					} catch(IOException e) {
						e.printStackTrace();
					}
					
				}
				
				
				try {
					
					in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fPred)));
					predmeti = (ArrayList<Predmet>) in.readObject();
					BazaPredmeta.getInstance().setPredmeti(predmeti);
					azurirajPrikazPredmeta("", -1);
					
				} catch(Exception e) {				
					e.printStackTrace();
					
				} finally {
					try {
						in.close();
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
				
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				int option = JOptionPane.showConfirmDialog(Glavni_prozor.getInstance(), "Da li ste sigurni da želite zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
				if (option == JOptionPane.YES_OPTION) {
						
					
					
					ArrayList<Student> studenti = (ArrayList<Student>) BazaStudenata.getInstance().getStudenti();
					ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
					ArrayList<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
					
					File fStud = new File("Studenti.txt");
					File fProf = new File("Profesori.txt");
					File fPred = new File("Predmeti.txt");
					
					ObjectOutputStream oos = null;
					
					try {
						oos = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(fStud)));
						oos.writeObject(studenti);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							oos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
			        oos = null;
					
					try {
						oos = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(fProf)));
						oos.writeObject(profesori);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							oos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					
			        oos = null;
					
					try {
						oos = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(fPred)));
						oos.writeObject(predmeti);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							oos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	
	public static Glavni_prozor getInstance() {
		if(instanca == null) {
			instanca = new Glavni_prozor();
		}
		return instanca;
	}
	
	public void azurirajPrikazProfesora(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) ProfesoriJTable.getInstance().getModel();
		model.fireTableDataChanged();
		//ProfesoriJTable.rowSelectedIndex = -1;
		validate();
	}
	
	public void azurirajPrikazStudenta(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) StudentiJTable.getInstance().getModel();
		model.fireTableDataChanged();
		//StudentiJTable.rowSelectedIndex = -1;
		validate();
	}
	
	public void azurirajPrikazPredmeta(String akcija, int vrednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazNepolozenihPredmeta(String akcija, int vrednost) {
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti)  NepolozeniPredmetiJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPolozenihPredmeta(String akcija, int vrednost) {
		AbstractTableModelPolozeniPredmeti model = (AbstractTableModelPolozeniPredmeti) PolozeniPredmetiJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmetaProfesora(String akcija, int vrednost) {
		AbstractTableModelPredmetiProfesora model = (AbstractTableModelPredmetiProfesora) PredmetiProfesoraJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmetaStudenta(String akcija, int vrednost) {
		AbstractTableModelPredmetiStudenta model = (AbstractTableModelPredmetiStudenta) PredmetiStudentaJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
	}

}

