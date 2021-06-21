package view;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozenihPredmeta;

public class AbstractTableModelNepolozeniPredmeti  extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return BazaNepolozenihPredmeta.getInstanca().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaNepolozenihPredmeta.getInstanca().getNepolozeniPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaNepolozenihPredmeta.getInstanca().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaNepolozenihPredmeta.getInstanca().getColumnName(column);
	}
	

}
