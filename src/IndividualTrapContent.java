import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IndividualTrapContent extends JPanel implements ActionListener{
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
		primary = window.settingsManager.getPrimary();
		secondary = window.settingsManager.getSecondary();
		titleFont = window.settingsManager.getTitleFont();
		subtitleFont = window.settingsManager.getSubtitleFont();
		textFont = window.settingsManager.getTextFont();
		this.setLayout(new BorderLayout());
		this.add(createNorthArea(), BorderLayout.NORTH);
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
	        name.setFont(window.settingsManager.getTitleFont());

	        maintenanceStatus.setHorizontalAlignment(SwingConstants.TRAILING);
	        maintenanceStatus.setText(mgr.getMaintenance(index));
	        maintenanceStatus.setVerticalAlignment(SwingConstants.CENTER);
	        maintenanceStatus.setFont(window.settingsManager.getSubtitleFont());

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
	        areaNumber.setFont(window.settingsManager.getSubtitleFont());
	        
	        prefix = "Room: ";
	        int roomNum = mgr.getRoomNum(index);
	        if (roomNum < 10){
	        	prefix = prefix + "0";
	        }
	        roomNumber.setText(prefix + roomNum);
	        roomNumber.setVerticalAlignment(SwingConstants.TOP);
	        roomNumber.setFont(window.settingsManager.getSubtitleFont());

	        description.setText(mgr.getDesc(index));
	        description.setVerticalAlignment(SwingConstants.TOP);
	        description.setFont(window.settingsManager.getSubtitleFont());

	        
	}
	
	
	private JPanel createNorthArea(){
		JPanel northArea = new JPanel();

		northArea.setLayout(new BorderLayout());
		northArea.add(createHeader(), BorderLayout.NORTH);
		northArea.add(createSecondaryArea(), BorderLayout.SOUTH);
		return northArea;
	}

	/**
	 * TOP NORTH
	 * Creates top(red) section
	 * @return
	 */
	private JPanel createHeader(){
		JPanel headerArea = new JPanel();

		String titleText = "Main Camera Feed";
		//JLabel title = new JLabel("<html><div style='text-align: center;'><div style='text-align: center;'>" + titleText + "</html>", SwingConstants.CENTER);
		JLabel title = new JLabel(titleText);
		title.setFont(window.settingsManager.getTextFont());
		headerArea.setBackground(window.settingsManager.getPrimary());
		headerArea.setLayout(new BorderLayout());
		headerArea.setBorder(new EmptyBorder(10,20,10,20));

		headerArea.add(title, BorderLayout.WEST);
		headerArea.add(createButtonArea(), BorderLayout.EAST);
		return headerArea;
	}

	/**
	 * TOP NORTH
	 * Creates buttons in top(red) left area
	 * @return
	 */
	private JPanel createButtonArea(){
		//Set underline for buttons
		Map attributes = window.settingsManager.getTitleFont().getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

		JButton logOut = new JButton("Log Out");
		JPanel buttonArea = new JPanel();

		//Log out initializers
		logOut.setBackground(window.settingsManager.getPrimary());
		logOut.setOpaque(true);
		logOut.setBorderPainted(false);
		logOut.setFont(window.settingsManager.getTitleFont().deriveFont(attributes));
		logOut.setForeground(Color.gray);
		logOut.setActionCommand("LogOut");
		logOut.addActionListener(this);

		buttonArea.setBackground(window.settingsManager.getPrimary());
		buttonArea.setLayout(new BorderLayout());
		buttonArea.add(logOut, BorderLayout.EAST);

		return buttonArea;
	}

	/**
	 * BOTTOM NORTH
	 * Creates bottom(yellow) of northern area
	 * @return
	 */
	private JPanel createSecondaryArea(){
		JPanel secondaryArea = new JPanel();
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("assets/back.png"));
		JButton back = new JButton("Back", icon);
		back = createSecondaryButtons(back, "Back");
		back.setHorizontalTextPosition(JButton.RIGHT);

		secondaryArea.setBackground(window.settingsManager.getSecondary());
		secondaryArea.setLayout(new BorderLayout());
		secondaryArea.setBorder(new EmptyBorder(10,20,10,20));
		secondaryArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		secondaryArea.add(createLinkArea(), BorderLayout.WEST);
		secondaryArea.add(back, BorderLayout.EAST);
		return secondaryArea;
	}

	/**
	 * BOTTOM NORTH
	 * Creates the links in the bottom(yellow) west section
	 * @return
	 */
	private JPanel createLinkArea(){
		JPanel linkArea = new JPanel();
		JButton menuButton = new JButton("Main Menu");
		JButton areaButton = new JButton("Area Summary");
		JButton securityButton = new JButton("Security Notifications");
		JButton settingsButton = new JButton("Settings");
		FlowLayout layout = new FlowLayout();
		JLabel line1 = new JLabel("|");
		JLabel line2 = new JLabel("|");
		JLabel line3 = new JLabel("|");
		line1.setFont(window.settingsManager.getSubtitleFont());
		line2.setFont(window.settingsManager.getSubtitleFont());
		line3.setFont(window.settingsManager.getSubtitleFont());

		//Button Initialization
		menuButton = createSecondaryButtons(menuButton, "MainMenu");
		areaButton = createSecondaryButtons(areaButton, "AreaSummary");
		securityButton = createSecondaryButtons(securityButton, "SecurityNotifications");
		settingsButton = createSecondaryButtons(settingsButton, "Settings");

		linkArea.setBackground(window.settingsManager.getSecondary());
		linkArea.setLayout(layout);
		linkArea.add(menuButton);
		linkArea.add(line1);
		linkArea.add(areaButton);
		linkArea.add(line2);
		linkArea.add(securityButton);
		linkArea.add(line3);
		linkArea.add(settingsButton);

		return linkArea;
	}

	/**
	 * BOTTOM NORTH
	 * Initializes buttons for createLinkArea()
	 * @param button
	 * @param txt
	 * @return
	 */
	private JButton createSecondaryButtons(JButton button, String txt){
		Map attributes = window.settingsManager.getSubtitleFont().getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button.setBackground(window.settingsManager.getSecondary());
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setFont(window.settingsManager.getSubtitleFont().deriveFont(attributes));
		button.setForeground(Color.black);
		button.setActionCommand(txt);
		button.addActionListener(this);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
