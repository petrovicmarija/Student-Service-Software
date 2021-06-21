package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PolozeniPredmetiJTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PolozeniPredmetiJTable instanca = null;
	
	public static PolozeniPredmetiJTable getInstance() {
		if(instanca == null) {
			instanca = new PolozeniPredmetiJTable();
		}
		return instanca;
	}
	
	private PolozeniPredmetiJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new AbstractTableModelPolozeniPredmeti());
		
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component component = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			component.setBackground(Color.LIGHT_GRAY);
		} else {
			component.setBackground(Color.WHITE);
		}
		
		return component;
	}

}
