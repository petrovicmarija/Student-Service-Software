package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfesoriJTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public static int rowSelectedIndex = -1;
	public static TableRowSorter<TableModel> sortiraj;
	public static ArrayList<RowFilter<Object,Object>> filteri =  new ArrayList<RowFilter<Object, Object>>();
	
	private static ProfesoriJTable instanca = null;

	private ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.setModel(new AbstractTableModelProfesori());

		
		sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		sortiraj.sort();
		
		//this.setAutoCreateRowSorter(true);
		
		
	}
	
	public static ProfesoriJTable getInstance () {
		if(instanca==null) {
			instanca = new ProfesoriJTable();
		}
		return instanca;
		
	}
	
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
}
