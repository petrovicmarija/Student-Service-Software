package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPolozenihPredmeta;

public class AbstractTableModelPolozeniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return BazaPolozenihPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPolozenihPredmeta.getInstance().getPolozeniPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPolozenihPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPolozenihPredmeta.getInstance().getColumnName(column);
	}
	

}
