package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiStudentaJTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PredmetiStudentaJTable instanca = null;
	
	public static PredmetiStudentaJTable getInstance() {
		if(instanca == null) {
			instanca = new PredmetiStudentaJTable();
		}
		
		return instanca;
	}
	
	private PredmetiStudentaJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new AbstractTableModelPredmetiStudenta());
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
