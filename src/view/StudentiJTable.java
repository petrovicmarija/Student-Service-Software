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


public class StudentiJTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentiJTable instanca = null;
	
	public static StudentiJTable getInstance() {
		if(instanca == null) {
			instanca = new StudentiJTable();
		}
		return instanca;
	}
	
	public static AbstractTableModelStudenti model;
	public static TableRowSorter<TableModel> sortiraj;
	

	private StudentiJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		
		sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		sortiraj.sort();
		
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component component = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			component.setBackground(Color.LIGHT_GRAY);
		} else {
			component.setBackground(Color.WHITE);
		}
		
		return component;
	}
	

	/** REFERENCA: 
	 *  https://stackoverflow.com/questions/2494868/rowfilter-regexfilter-multiple-columns
	 * */
	
	public static ArrayList<RowFilter<Object,Object>> filteri =  new ArrayList<RowFilter<Object, Object>>();

	
}
