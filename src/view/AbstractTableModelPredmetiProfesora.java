package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmetaProfesora;

public class AbstractTableModelPredmetiProfesora extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmetaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmetaProfesora.getInstance().getPredmetiProfesora().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaPredmetaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmetaProfesora.getInstance().getColumnName(column);
	}
	

}
