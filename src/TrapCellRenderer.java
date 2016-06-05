import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


public class TrapCellRenderer extends JPanel implements ListCellRenderer<TrapListCell>{
	
	@Override
	public Component getListCellRendererComponent(
			JList<? extends TrapListCell> list, TrapListCell value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		return value;
	}

}
