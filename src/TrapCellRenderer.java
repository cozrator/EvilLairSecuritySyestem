import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


public class TrapCellRenderer extends JPanel implements ListCellRenderer<TrapCell>{
	
	@Override
	public Component getListCellRendererComponent(
			JList<? extends TrapCell> list, TrapCell value, int index,
			boolean isSelected, boolean cellHasFocus) {
		return value;
	}

}
