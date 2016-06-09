import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 * @author watce001
 */
public class IndividualCameraFeed extends JPanel implements ActionListener{
	MainWindow window;
	
	JCheckBox toggleLockdown;
	JCheckBox toggleInfaRed;
	JCheckBox toggleNightVision;

	JLabel infaRed;
	JLabel nightVision;
	JLabel lockdownOn;
	JLabel lockdownOff;
	JLabel processing;

	boolean inLockdown;

	long start = 0;
	long countdown = 0;

	public IndividualCameraFeed(MainWindow window, JButton button, int population, boolean inLockdown){
		this.window = window;

		this.setLayout(new BorderLayout());

		this.inLockdown = inLockdown;

		//Setting up button
		button.setBackground(Color.WHITE);
		button.setOpaque(true);
		button.setBorderPainted(false);

		this.add(createNorthArea(), BorderLayout.NORTH);
		this.add(createIndividualArea(button,population,inLockdown), BorderLayout.CENTER);
		this.setVisible(true);
	}

	/**
	 * CENTER CENTER
	 * Creates the live feed for the camera
	 * @param button - inherits camera feed image
	 * @return
	 */
	private JPanel createIndividualFeed(JButton button){
		JPanel streamArea = new JPanel();

		streamArea.setBackground(Color.WHITE);
		//streamArea.setLayout(new BorderLayout());

		ImageIcon image = resizeImage((ImageIcon) button.getIcon(), 1780, 910);
		ImageIcon ir = new ImageIcon(getClass().getClassLoader().getResource("assets/infaredOverlay.png"));
		ImageIcon nv = new ImageIcon(getClass().getClassLoader().getResource("assets/nightvisionOverlay.png"));

		JLabel lbl = new JLabel(image);
		infaRed = new JLabel(ir);
		nightVision = new JLabel(nv);

		streamArea.setLayout(null);

		lbl.setBounds(0, 0, 1780, 910);
		infaRed.setBounds(0, 0, 1780, 910);
		nightVision.setBounds(0, 0, 1780, 910);

		infaRed.setVisible(false);
		nightVision.setVisible(false);

		streamArea.add(nightVision);
		streamArea.add(infaRed);
		streamArea.add(lbl);

		return streamArea;
	}

	/**
	 * EAST NORTH
	 * Create text information area
	 * @param population
	 * @param inLockdown
	 * @return
	 */
	private JPanel createInfoArea(int population, boolean inLockdown){
		JPanel infoArea = new JPanel();
		GridLayout gl = new GridLayout (0,1);
		

		gl.setVgap(20);

		infoArea.setBackground(Color.white);
		infoArea.setBorder(new EmptyBorder(50,20,50,20));
		infoArea.setLayout(gl);
		infoArea.add(createTextArea("Population in Room: " + population));

		return infoArea;
	}

	/**
	 * EAST SOUTH
	 * Create toggle information area
	 */
	private JPanel createToggleArea(){
		JPanel toggleArea = new JPanel();
		GridLayout gl = new GridLayout(0,2);
		toggleLockdown = new JCheckBox();
		toggleInfaRed = new JCheckBox();
		toggleNightVision = new JCheckBox();
		JTextField lockdownLbl = new JTextField("Enable Lockdown: ");
		JTextField infaRedLbl = new JTextField("Enable Infa-Red: ");
		JTextField nightVisionLbl = new JTextField("Enable Night-Vision: ");

		gl.setVgap(20);

		//Initialize Text Areas
		lockdownLbl.setBackground(Color.WHITE);
		lockdownLbl.setFont(window.settingsManager.getTextFont());
		lockdownLbl.setBorder(null);

		infaRedLbl.setBackground(Color.WHITE);
		infaRedLbl.setFont(window.settingsManager.getTextFont());
		infaRedLbl.setBorder(null);

		nightVisionLbl.setBackground(Color.WHITE);
		nightVisionLbl.setFont(window.settingsManager.getTextFont());
		nightVisionLbl.setBorder(null);

		//Initialize Checkboxes
		toggleLockdown.setBackground(Color.WHITE);
		ActionListener lockdownAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				System.out.println(selected);
				// abstractButton.setText(newLabel);
				if (selected == true){
					lockdownOff.setVisible(false);
					processing.setVisible(true);
					
					Timer timer = new Timer(2000, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {            
							processing.setVisible(false);
							lockdownOn.setVisible(true);
						}
					});
					timer.setRepeats(false);
					timer.start();
					inLockdown = true;
				}
				if (selected == false){
					lockdownOn.setVisible(false);
					processing.setVisible(true);
					
					Timer timer = new Timer(2000, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {            
							processing.setVisible(false);
							lockdownOff.setVisible(true);
						}
					});
					timer.setRepeats(false);
					timer.start();
					inLockdown = false;
				}
			}
		};
		toggleLockdown.addActionListener(lockdownAction);

		toggleInfaRed.setBackground(Color.WHITE);
		ActionListener infaRedAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				System.out.println(selected);
				// abstractButton.setText(newLabel);
				if (selected == true){
					infaRed.setVisible(true);
					toggleNightVision.setSelected(false);
					nightVision.setVisible(false);
				}
				if (selected == false){
					infaRed.setVisible(false);
				}
			}
		};
		toggleInfaRed.addActionListener(infaRedAction);

		toggleNightVision.setBackground(Color.WHITE);
		ActionListener nightvisionAction = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				System.out.println(selected);
				// abstractButton.setText(newLabel);
				if (selected == true){
					nightVision.setVisible(true);
					toggleInfaRed.setSelected(false);
					infaRed.setVisible(false);
				}
				if (selected == false){
					nightVision.setVisible(false);
				}
			}
		};
		toggleNightVision.addActionListener(nightvisionAction);

		//Initialize JPanel
		toggleArea.setBackground(Color.WHITE);
		toggleArea.setLayout(gl);
		toggleArea.setBorder(new EmptyBorder(50,20,50,20));
		toggleArea.add(lockdownLbl);
		toggleArea.add(toggleLockdown);
		toggleArea.add(infaRedLbl);
		toggleArea.add(toggleInfaRed);
		toggleArea.add(nightVisionLbl);
		toggleArea.add(toggleNightVision);

		return toggleArea;
	}

	/**
	 * EAST CENTRE
	 * Creates lockdown image in centre east area
	 */
	private JPanel createLockdownImageArea(){
		JPanel lockdownArea = new JPanel();

		ImageIcon active = new ImageIcon(getClass().getClassLoader().getResource("assets/locked.png"));
		ImageIcon inactive = new ImageIcon(getClass().getClassLoader().getResource("assets/unlocked.png"));
		ImageIcon loading = new ImageIcon(getClass().getClassLoader().getResource("assets/loadingAnimation.gif"));

		lockdownOn = new JLabel(active);
		lockdownOff = new JLabel(inactive);
		processing = new JLabel(loading);

		lockdownOn.setVisible(false);
		lockdownOff.setVisible(false);
		processing.setVisible(false);

		if (inLockdown == true){
			toggleLockdown.setSelected(true);
			lockdownOn.setVisible(true);
			lockdownOff.setVisible(false);
		}
		if (inLockdown == false){
			lockdownOn.setVisible(false);
			toggleLockdown.setSelected(false);
			lockdownOff.setVisible(true);
		}

		lockdownArea.setLayout(new BorderLayout());

		lockdownArea.add(lockdownOn, BorderLayout.EAST);
		lockdownArea.add(lockdownOff, BorderLayout.WEST);
		lockdownArea.add(processing, BorderLayout.CENTER);

		return lockdownArea;
	}

	/**
	 * CENTER EAST
	 * Creates information area in the east
	 * @param population
	 * @param inLockdown
	 * @return
	 */
	private JPanel createContentArea(int population, boolean inLockdown){
		JPanel contentArea = new JPanel();

		contentArea.setLayout(new BorderLayout());
		contentArea.add(createToggleArea(), BorderLayout.SOUTH);
		contentArea.add(createInfoArea(population, inLockdown), BorderLayout.NORTH);
		contentArea.add(createLockdownImageArea(), BorderLayout.CENTER);

		return contentArea;
	}

	/**
	 * CENTER EAST
	 * Initializes text for createContentArea()
	 * @param txt - String to turn into JTextField
	 * @return
	 */
	private JTextField createTextArea(String txt){
		JTextField txtArea = new JTextField();
		txtArea.setBackground(Color.WHITE);
		txtArea.setFont(window.settingsManager.getTextFont());
		txtArea.setText(txt);
		txtArea.setEditable(false);
		txtArea.setBorder(null);
		return txtArea;
	}

	/**
	 * CENTER
	 * Creates entire individual area out of createIndividualFeed() & createContentArea()
	 * @param button - used for image inheritance
	 * @param population - population in room
	 * @param inLockdown - if the room is in lockdown
	 * @return
	 */
	private JPanel createIndividualArea(JButton button, int population, boolean inLockdown){
		JPanel individualArea = new JPanel();

		individualArea.setBackground(Color.WHITE);
		individualArea.setLayout(new BorderLayout());
		individualArea.add(createIndividualFeed(button), BorderLayout.CENTER);
		individualArea.add(createContentArea(population, inLockdown), BorderLayout.EAST);

		return individualArea;
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

	private ImageIcon resizeImage(ImageIcon image, int width, int height){

		Image img = image.getImage();
		Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT);
		ImageIcon newImage = new ImageIcon(newImg);

		return newImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("MainMenu")){
			window.screenTransition(new MainMenuScreen(this.window));
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
		else if(e.getActionCommand().equals("Back")){
			window.screenTransition(new MainCameraFeed(this.window));
		}
		else if(e.getActionCommand().equals("InfaRed")){
			System.out.println("EY");
		}
	}
}


