import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TrapMapContent extends TrapContent implements ChangeListener, ActionListener {
	MainWindow window;
	TrapStatusManager mgr;
	JSlider zoom = new JSlider(JSlider.VERTICAL);
	BufferedImage img;
	float scale = 1;
	JComponent content;
	JLabel label;
	JScrollPane scroll;
	static int CONTENT_WIDTH = 2000;
	static int CONTENT_HEIGHT = 2000;

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

	protected void loadImage(String location) {
		try {
			img = ImageIO.read(getClass().getResourceAsStream(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TrapMapContent(MainWindow window, SelectedArea area, SelectedRoom room) {
		super();
		this.window = window;
		mgr = window.trapStatusManager;
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.setSelectedArea(area);
		this.setSelectedRoom(room);
		switch (area) {
		case AREA01:
			loadImage("assets/inside1.jpg");
			break;
		case AREA02:
			loadImage("assets/inside2.jpg");
			break;
		case OUTSIDE:
			loadImage("assets/outside.jpg");
			break;
		default:
			loadImage("assets/outside.jpg");
			break;

		}
		content = makeUI();
		this.add(content, BorderLayout.CENTER);

		// init zoom slider
		zoom.setPaintTicks(true);
		zoom.setMaximum(200);
		zoom.setMinimum(50);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(50, new JLabel("0.5x "));
		labelTable.put(100, new JLabel("1.0x "));
		labelTable.put(150, new JLabel("1.5x "));
		labelTable.put(200, new JLabel("2.0x "));
		zoom.setLabelTable(labelTable);
		zoom.setPaintLabels(true);
		zoom.setMinorTickSpacing(5);
		zoom.setMajorTickSpacing(50);
		zoom.setValue(100);
		zoom.addChangeListener(this);

		this.add(zoom, BorderLayout.WEST);
	}

	public JComponent makeUI() {
		Image newimg = img.getScaledInstance(Math.round(CONTENT_WIDTH * scale), Math.round(CONTENT_HEIGHT * scale),
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);
		label = new JLabel(icon, JLabel.CENTER);
		label.setBackground(Color.BLACK);
		JPanel panel = drawPanelWithButtons(label);
		scroll = new JScrollPane(panel);
		JViewport vport = scroll.getViewport();
		MouseAdapter ma = new PanListener();
		vport.addMouseMotionListener(ma);
		vport.addMouseListener(ma);
		return scroll;
	}

	private JPanel drawPanelWithButtons(JLabel label) {
		JPanel output = new JPanel() {
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};
		output.setLayout(new OverlayLayout(output));

		// add buttons
		switch (this.getSelectedArea()) {
		case AREA01:
			addArea01Buttons(output);
			break;
		case AREA02:
			addArea02Buttons(output);
			break;
		case OUTSIDE:
			break;
		default:
			break;

		}

		// center main item
		label.setAlignmentX(0.5f);
		label.setAlignmentY(0.5f);
		// add main item
		output.add(label);

		return output;
	}

	private void addArea01Buttons(JPanel panel) {
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		for (Integer index : mgr.ids) {
			if (mgr.getAreaNum(index) == 1) {
				indexArray.add(index);
			}
		}
		SelectedRoom room = this.getSelectedRoom();
		addRoomButtons(panel, indexArray, room);
	}

	private void addArea02Buttons(JPanel panel) {
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		for (Integer index : mgr.ids) {
			if (mgr.getAreaNum(index) == 2) {
				indexArray.add(index);
			}
		}
		SelectedRoom room = this.getSelectedRoom();
		addRoomButtons(panel, indexArray, room);
	}

	// 0 is all rooms
	private void addRoomButtons(JPanel panel, ArrayList<Integer> areaIndexArray, SelectedRoom roomNum) {
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		for (Integer index : areaIndexArray) {
			if (roomNum == SelectedRoom.ALL) {
				indexArray.add(index);
			} else {
				if (mgr.getRoom(index) == roomNum) {
					indexArray.add(index);
				}
			}
		}
		for (Integer index : indexArray) {
			JButton button = new JButton();
			button.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(
					(int) (CONTENT_WIDTH * scale / 20), (int) (CONTENT_HEIGHT * scale / 20), Image.SCALE_DEFAULT)));
			button.setPressedIcon(new ImageIcon(mgr.getStatusPressed(index).getImage().getScaledInstance(
					(int) (CONTENT_WIDTH * scale / 20), (int) (CONTENT_HEIGHT * scale / 20), Image.SCALE_DEFAULT)));
			button.setRolloverIcon(new ImageIcon(mgr.getStatusHovered(index).getImage().getScaledInstance(
					(int) (CONTENT_WIDTH * scale / 20), (int) (CONTENT_HEIGHT * scale / 20), Image.SCALE_DEFAULT)));
			button.setBorder(BorderFactory.createEmptyBorder());
			button.setContentAreaFilled(false);
			button.setAlignmentX(mgr.getHorizontalAlignment(index));
			button.setAlignmentY(mgr.getVerticalAlignment(index));
			button.setActionCommand("" + index);
			button.addActionListener(this);
			panel.add(button);
		}
	}

	@Override
	public void remake() {
		this.remove(content);
		content = makeUI();
		this.add(content, BorderLayout.CENTER);
		this.validate();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		scale = source.getValue() / 100f;
		remake();
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		try {
			int index = Integer.parseInt(a.getActionCommand());

			if (index > 0 && index <= mgr.ids.size()) {
				JDialog popUp = new JDialog();
				popUp.setUndecorated(true);
				popUp.setLayout(new BorderLayout());
				popUp.add(new TrapCell(window, index));
				popUp.addWindowFocusListener(new WindowFocusListener() {

					@Override
					public void windowGainedFocus(WindowEvent a) {
					}

					@Override
					public void windowLostFocus(WindowEvent a) {
						// when user click off of the dialog, close it.
						//popUp.dispose();	
					}
					
				});
				popUp.pack();
				popUp.setResizable(false);
				popUp.setLocationRelativeTo((Component) a.getSource());
				popUp.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}