import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


public class TrapListCell extends JPanel{
	
	MainWindow window;
	TrapStatusManager mgr;
	int index;
	
	TrapListCell(MainWindow window, int index){
		this.window = window;
		this.index = index;
		mgr = window.trapStatusManager;
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.add(createHeader(), BorderLayout.NORTH);
		this.add(createContent(), BorderLayout.CENTER);
		this.setOpaque(true); 
	}

	private JPanel createContent() {
		JPanel output = new JPanel();
		GridLayout gl = new GridLayout(1,3);
		output.setLayout(gl);
		
		// init components
		this.add(createEast());
		this.add(createCenter());
		this.add(createWest());
		
		return output;
	}

	private JPanel createEast() {
		JPanel output = new JPanel();
		BorderLayout bl = new BorderLayout();
		output.setLayout(bl);
		
		// init components
		this.add(new JLabel(mgr.getStatusColor(index)), BorderLayout.EAST);
		this.add(new JLabel(new ImageIcon(mgr.getImage(index))), BorderLayout.CENTER);
		
		return output;
	}

	private JPanel createCenter() {
		JPanel output = new JPanel();
		GridLayout gl = new GridLayout(3,1);
		output.setLayout(gl);
		
		// init components
		this.add(new JLabel("Area: " + mgr.getArea(index)));
		this.add(new JLabel("Room: " + mgr.getRoom(index)));
		this.add(mgr.getDesc(index));
		
		return output;
	}

	private JPanel createWest() {
		JPanel output = new JPanel();
		BorderLayout bl = new BorderLayout();
		output.setLayout(bl);
		
		// init components
		this.add(new JButton("More"), BorderLayout.SOUTH);
		
		return output;
	}

	private JPanel createHeader() {
		JPanel output = new JPanel();
		BorderLayout bl = new BorderLayout();
		output.setLayout(bl);
		
		// init components
		this.add(mgr.getName(index), BorderLayout.EAST);
		this.add(mgr.getMaintenance(index), BorderLayout.CENTER);
		this.add(mgr.getRating(index), BorderLayout.WEST);
		
		return output;
	}
}
