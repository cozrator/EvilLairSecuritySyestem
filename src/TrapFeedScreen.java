import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TrapFeedScreen extends JPanel implements ActionListener {
	
	MainWindow window;

	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);

	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);

	public TrapFeedScreen(MainWindow window) {
		this.window = window;
		primary = window.getPrimary();
		secondary = window.getSecondary();
		titleFont = window.getTitleFont();
		subtitleFont = window.getSubtitleFont();
		textFont = window.getTextFont();
		this.setLayout(new BorderLayout());
		this.add(createNorthArea(), BorderLayout.NORTH);
		this.add(new TrapFeedMasterContent(window), BorderLayout.CENTER);
	}
	
	/**
	 * NORTH AREA
	 * Combines top(red) and bottom(yellow) of north area
	 * @return
	 */
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

		String titleText = "Trap Feed";
		//JLabel title = new JLabel("<html><div style='text-align: center;'><div style='text-align: center;'>" + titleText + "</html>", SwingConstants.CENTER);
		JLabel title = new JLabel(titleText);
		title.setFont(titleFont);
		headerArea.setBackground(primary);
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
		Map attributes = titleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

		JButton logOut = new JButton("Log Out");
		JPanel buttonArea = new JPanel();

		//Log out initializers
		logOut.setBackground(primary);
		logOut.setOpaque(true);
		logOut.setBorderPainted(false);
		logOut.setFont(titleFont.deriveFont(attributes));
		logOut.setForeground(Color.gray);
		logOut.setActionCommand("LogOut");
		logOut.addActionListener(this);

		buttonArea.setBackground(primary);
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

		secondaryArea.setBackground(secondary);
		secondaryArea.setLayout(new BorderLayout());
		secondaryArea.setBorder(new EmptyBorder(10,20,10,20));
		secondaryArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		secondaryArea.add(createLinkArea(), BorderLayout.WEST);
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
		JButton cameraButton = new JButton("Camera Feed");
		JButton areaButton = new JButton("Area Summary");
		JButton securityButton = new JButton("Security Notifications");
		JButton settingsButton = new JButton("Settings");
		FlowLayout layout = new FlowLayout();
		JLabel line1 = new JLabel("|");
		JLabel line2 = new JLabel("|");
		JLabel line3 = new JLabel("|");
		JLabel line4 = new JLabel("|");
		line1.setFont(subtitleFont);
		line2.setFont(subtitleFont);
		line3.setFont(subtitleFont);
		line4.setFont(subtitleFont);

		//Button Initialization
		menuButton = createSecondaryButtons(menuButton, "MainMenu");
		cameraButton = createSecondaryButtons(cameraButton, "CameraFeed");
		areaButton = createSecondaryButtons(areaButton, "AreaSummary");
		securityButton = createSecondaryButtons(securityButton, "SecurityNotifications");
		settingsButton = createSecondaryButtons(settingsButton, "Settings");

		linkArea.setBackground(secondary);
		linkArea.setLayout(layout);
		linkArea.add(menuButton);
		linkArea.add(line1);
		linkArea.add(cameraButton);
		linkArea.add(line2);
		linkArea.add(areaButton);
		linkArea.add(line3);
		linkArea.add(securityButton);
		linkArea.add(line4);
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
		Map attributes = subtitleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button.setBackground(secondary);
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setFont(subtitleFont.deriveFont(attributes));
		button.setForeground(Color.black);
		button.setActionCommand(txt);
		button.addActionListener(this);
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("MainMenu")){
			window.screenTransition(new MainMenuScreen(this.window));
		}
		else if (e.getActionCommand().equals("CameraFeed")){
			window.screenTransition(new MainCameraFeed(this.window));
		}
		else if(e.getActionCommand().equals("AreaSummary")){

		}
		else if(e.getActionCommand().equals("SecurityNotifications")){

		}
		else if(e.getActionCommand().equals("Settings")){
			window.screenTransition(new SettingsScreen(this.window));
		}
		//Logout button
		else if(e.getActionCommand().equals("LogOut")){
			window.screenTransition(new LogInScreen(this.window));
		}

	}

}
