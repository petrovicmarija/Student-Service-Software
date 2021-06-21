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

public class PredmetiJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static PredmetiJTable instanca = null;
	public static TableRowSorter<TableModel> sortiraj;
	public static ArrayList<RowFilter<Object,Object>> filteri =  new ArrayList<RowFilter<Object, Object>>();
	
	private PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new AbstractTableModelPredmeti());
		
		sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		sortiraj.sort();
		
		
	}
	
	public static PredmetiJTable getInstance() {
		if(instanca == null) {
			instanca = new PredmetiJTable();
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
