package view;



import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentiJTable studentiTabela;
	private static ProfesoriJTable profesoriTabela;
	private static PredmetiJTable predmetiTabela;
	
	private static TabbedPane instanca = null;
	
	public static TabbedPane getInstance() {
		
		if(instanca == null) {
			instanca = new TabbedPane();
		}
		return instanca;
	}

	private TabbedPane() {
		
		studentiTabela = StudentiJTable.getInstance();
		profesoriTabela = ProfesoriJTable.getInstance();
		predmetiTabela = PredmetiJTable.getInstance();
		
		JScrollPane panelStudenti = new JScrollPane(studentiTabela);
		JScrollPane panelProfesori = new JScrollPane(profesoriTabela);
		JScrollPane panelPredmeti = new JScrollPane(predmetiTabela);
		
		add("Studenti", panelStudenti);
		add("Profesori", panelProfesori);
		add("Predmeti", panelPredmeti);

	}
	
	

}
