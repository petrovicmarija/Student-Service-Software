package view.dialogs;

import java.awt.Frame;

import javax.swing.JDialog;

import view.Glavni_prozor;
import view.TabbedPaneIzmeniProf;

public class IzmeniProfesoraDijalog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static IzmeniProfesoraDijalog instanca = null;

	
	public static IzmeniProfesoraDijalog getInstance() {
		if(instanca == null) {
			instanca = new IzmeniProfesoraDijalog(Glavni_prozor.getInstance(), "Izmena profesor", true);
		}
		
		return instanca;
	}

	private IzmeniProfesoraDijalog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(550, 450);
		setLocationRelativeTo(parent);
		
		TabbedPaneIzmeniProf tabProf = TabbedPaneIzmeniProf.getInstance();
		this.add(tabProf);
		
		
		
	}
	
	

}
