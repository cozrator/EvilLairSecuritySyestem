import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class IndividualTrapContent extends JPanel{
	MainWindow window;
	TrapStatusManager mgr;
	private int index;
	
	private JPanel headerPanel;
	private JPanel footerPanel;
	private JComponent mainContent;
	
	private JLabel areaNumber;
    private JLabel description;
    private JLabel image;
    private JLabel maintenanceStatus;
    private JLabel name;
    private JPanel ratingStars;
    private JLabel roomNumber;
    private JLabel statusColour;
	
	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);

	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	
	public IndividualTrapContent(MainWindow window, int index) {
		this.window = window;
		this.index = index;
		this.mgr = window.trapStatusManager;
		primary = window.getPrimary();
		secondary = window.getSecondary();
		titleFont = window.getTitleFont();
		subtitleFont = window.getSubtitleFont();
		textFont = window.getTextFont();
		setup();
	}
	
	private void setup() {
	        ratingStars = mgr.getRating(index, new Dimension(40,40));
	        name = new JLabel();
	        maintenanceStatus = new JLabel();
	        statusColour = new JLabel();
	        image = new JLabel();
	        areaNumber = new JLabel();
	        roomNumber = new JLabel();
	        description = new JLabel();
	        
	        name.setText(mgr.getName(index));
	        name.setVerticalAlignment(SwingConstants.CENTER);
	        name.setFont(window.getTitleFont());

	        maintenanceStatus.setHorizontalAlignment(SwingConstants.TRAILING);
	        maintenanceStatus.setText(mgr.getMaintenance(index));
	        maintenanceStatus.setVerticalAlignment(SwingConstants.CENTER);
	        maintenanceStatus.setFont(window.getSubtitleFont());

	        statusColour.setHorizontalAlignment(SwingConstants.CENTER);
	        statusColour.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));

	        image.setHorizontalAlignment(SwingConstants.CENTER);
	        image.setIcon(new ImageIcon(mgr.getImage(index).getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

	        String prefix = "Area: ";
	        int areaNum = mgr.getAreaNum(index);
	        if (areaNum < 10){
	        	prefix = prefix + "0";
	        }
	        areaNumber.setText(prefix + areaNum);
	        areaNumber.setVerticalAlignment(SwingConstants.TOP);
	        areaNumber.setFont(window.getSubtitleFont());
	        
	        prefix = "Room: ";
	        int roomNum = mgr.getRoomNum(index);
	        if (roomNum < 10){
	        	prefix = prefix + "0";
	        }
	        roomNumber.setText(prefix + roomNum);
	        roomNumber.setVerticalAlignment(SwingConstants.TOP);
	        roomNumber.setFont(window.getSubtitleFont());

	        description.setText(mgr.getDesc(index));
	        description.setVerticalAlignment(SwingConstants.TOP);
	        description.setFont(window.getSubtitleFont());

	}

}
