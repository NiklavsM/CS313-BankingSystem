package tm;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ThreadTableModel extends AbstractTableModel {


	static protected String[] columnNames = { "Thread Group", "Thread Name", "ID", "State", "Priority", "isDaemon" };

	static protected Class<?>[] columnTypes = { String.class, String.class, long.class, Thread.State.class, int.class, boolean.class };

	private List<ThreadInfo> threadInfos;

	public ThreadTableModel(List<ThreadInfo> tis){
		threadInfos = tis;
	}

	public int getRowCount() {
		return threadInfos.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}


	public String getColumnName(int column) {
		return columnNames[column];
	}


	public Class<?> getColumnClass(int column) {
		return columnTypes[column];
	}

	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0:
				return threadInfos.get(row).getTgName();
			case 1:
				return threadInfos.get(row).getName();
			case 2:
				return threadInfos.get(row).getId();
			case 3:
				return threadInfos.get(row).getState();
			case 4:
				return threadInfos.get(row).getPriority();
			case 5:
				return threadInfos.get(row).isDaemon();
			default:
				break;
		}
		return null;
	}

	public boolean isCellEditable(Object node, int column) {
		return true; // Important to activate TreeExpandListener
	}

	public void setValueAt(Object aValue, Object node, int column) {
	}

}