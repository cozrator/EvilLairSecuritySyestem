import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TrapMapContent extends TrapContent implements ChangeListener {
	MainWindow window;
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

	public TrapMapContent(MainWindow window) {
		super();
		this.window = window;
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		loadImage("assets/outside.jpg");
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
		switch (this.getSelectedRoom()) {
		case ALL:
			addRoom01Buttons(panel);
			addRoom04Buttons(panel);
			break;
		case ROOM01:
			addRoom01Buttons(panel);
			break;
		case ROOM02:
			break;
		case ROOM03:
			break;
		case ROOM04:
			addRoom04Buttons(panel);
			break;
		case ROOM05:
			break;
		case ROOM06:
			break;
		case ROOM07:
			break;
		case ROOM08:
			break;
		case ROOM09:
			break;
		case ROOM10:
			break;
		default:
			break;

		}
	}

	private void addRoom04Buttons(JPanel panel) {
		JButton trap1 = new JButton();
		trap1.setMaximumSize(
				new Dimension(Math.round((CONTENT_WIDTH * scale) / 25), Math.round((CONTENT_HEIGHT * scale) / 25)));
		trap1.setAlignmentX(0.0f);
		trap1.setAlignmentY(0.0f);
		trap1.setBackground(window.trapStatusManager.getStatusColor(1));
		panel.add(trap1);
	}

	private void addRoom01Buttons(JPanel panel) {
		JButton trap2 = new JButton();
		trap2.setMaximumSize(
				new Dimension(Math.round((CONTENT_WIDTH * scale) / 25), Math.round((CONTENT_HEIGHT * scale) / 25)));
		trap2.setBackground(window.trapStatusManager.getStatusColor(2));
		trap2.setAlignmentX(1.0f);
		trap2.setAlignmentY(1.0f);
		panel.add(trap2);
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
}