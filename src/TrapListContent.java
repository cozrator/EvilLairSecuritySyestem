import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TrapListContent extends TrapContent {
	
	MainWindow window;
	TrapStatusManager mgr;
	JScrollPane scroll;
	
	static class PanListener extends MouseAdapter {
		private final Point pp = new Point();

		@Override
		public void mouseDragged(MouseEvent e) {
			JViewport vport = (JViewport) e.getSource();
			JComponent label = (JComponent) vport.getView();
			Point cp = e.getPoint();
			Point vp = vport.getViewPosition();
			vp.translate(pp.x - cp.x, pp.y - cp.y);
			label.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
			pp.setLocation(cp);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			pp.setLocation(e.getPoint());
		}
	}

	public TrapListContent(MainWindow window, SelectedArea area, SelectedRoom room) {
		super();
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.setSelectedArea(area);
		this.setSelectedRoom(room);
		this.window = window;
		this.mgr = window.trapStatusManager;
		createContent();
	}

	private void createContent() {
		JPanel content = new JPanel();
		GridLayout gl = new GridLayout(mgr.ids.size(),0);
		content.setLayout(gl);
		//DefaultListModel<TrapCell> trapListModel = new DefaultListModel<TrapCell>();
		for(int index = 1; index <= mgr.ids.size(); index++) {
			if(this.getSelectedArea() == SelectedArea.OUTSIDE || mgr.getArea(index) == this.getSelectedArea()) {
				if(this.getSelectedRoom() == SelectedRoom.ALL || mgr.getRoom(index) == this.getSelectedRoom()) {
					content.add(new TrapCell(window, index));
					System.out.println("added" + index);
				}
			}
		}
		
		//create the list
        //JList<TrapCell> trapList = new JList<TrapCell>(trapListModel);
        //trapList.setCellRenderer(new TrapCellRenderer());
        //content.add(trapList);
		scroll = new JScrollPane(content);
		JViewport vport = scroll.getViewport();
		MouseAdapter ma = new PanListener();
		vport.addMouseMotionListener(ma);
		vport.addMouseListener(ma);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	@Override
	public void remake() {
		this.remove(scroll);
		createContent();
		this.validate();
	}

}
