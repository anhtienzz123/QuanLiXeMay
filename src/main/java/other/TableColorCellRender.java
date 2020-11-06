package other;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColorCellRender implements TableCellRenderer {
	private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component cell = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(row % 2 !=0) {
			cell.setBackground(Color.gray);
		}else {
			cell.setBackground(Color.WHITE);
		}
		return cell;
	}
}
