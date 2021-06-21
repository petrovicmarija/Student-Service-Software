package view.dialogs;

import java.awt.Frame;

import javax.swing.JDialog;

import view.Glavni_prozor;
import view.TabbedPaneIzmeniStudenta;

public class IzmeniStudentaDijalog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static IzmeniStudentaDijalog instanca = null;
	
	public static IzmeniStudentaDijalog getInstance() {
		if(instanca == null) {
			instanca = new IzmeniStudentaDijalog(Glavni_prozor.getInstance(), "Izmena studenta", true);
		}
		return instanca;
	}
	
	private IzmeniStudentaDijalog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(550, 450);
		setLocationRelativeTo(parent);
		
		TabbedPaneIzmeniStudenta tabs = TabbedPaneIzmeniStudenta.getInstance();
		this.add(tabs);
		
	}

}
