import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class TrapListContent extends TrapContent {
	
	MainWindow window;

	public TrapListContent(MainWindow window, SelectedArea area, SelectedRoom room) {
		super();
		this.setSelectedArea(area);
		this.setSelectedRoom(room);
		this.window = window;
		createContent();
	}

	private void createContent() {
		DefaultListModel<TrapListCell> trapListModel = new DefaultListModel<TrapListCell>();
		for(int index = 1; index <= window.trapStatusManager.ids.size(); index++) {
			trapListModel.addElement(new TrapListCell(window, index));
			System.out.println("added" + index);
		}
		
		//create the list
        JList<TrapListCell> trapList = new JList<TrapListCell>(trapListModel);
        trapList.setCellRenderer(new TrapCellRenderer());
        this.add(new JScrollPane(trapList), BorderLayout.CENTER);
	}

}
