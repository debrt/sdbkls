import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ModifiedCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = -2737623794052328229L;

	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		Component lbl = super.getTableCellRendererComponent(
				arg0, arg1, arg2, arg3, arg4, arg5);
		
		lbl.setBackground(Color.yellow);
		
		return lbl;
	}

}
