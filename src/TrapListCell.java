import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class TrapListCell extends JPanel {
	
	MainWindow window;
	TrapStatusManager mgr;
	int index;
	
	TrapListCell(MainWindow window, int index){
		this.window = window;
		mgr = window.trapStatusManager;
		this.add(createHeader(), BorderLayout.NORTH);
	}

	private JPanel createHeader() {
		JPanel output = new JPanel();
		// init components
		this.add(mgr.getName(index), BorderLayout.EAST);
		this.add(mgr.getRating(index), BorderLayout.WEST);
		
		return output;
	}
}
