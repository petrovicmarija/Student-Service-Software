package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmetaStudenta;

public class AbstractTableModelPredmetiStudenta extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return BazaPredmetaStudenta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmetaStudenta.getInstance().getPredmetiStudenta().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmetaStudenta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmetaStudenta.getInstance().getColumnName(column);
	}

}
