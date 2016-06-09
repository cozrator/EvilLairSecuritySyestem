import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Enumeration;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import java.awt.SystemColor;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SettingsScreen extends JPanel implements ActionListener {

	MainWindow window;
	JFrame frame;
	SettingsManager settingsMan;

	//Button groups for radio buttons
	private final ButtonGroup cbmButtonGroup = new ButtonGroup();
	private final ButtonGroup dysButtonGroup = new ButtonGroup();
	private final ButtonGroup cameraButtonGroup = new ButtonGroup();
	private final ButtonGroup trapRemoteAccessButtonGroup = new ButtonGroup();
	private final ButtonGroup trapEnabledButtonGroup = new ButtonGroup();

	//Text fields for user area
	private JTextField givenNameTB;
	private JTextField familyNameTB;
	private JTextField emailTB;

	//Background colors
	private Color primary; 
	private Color secondary; 

	//Boolean used to keep track of which color blind radio button is selected.
	private boolean cbmOn;
	//Boolean used to keep track of which dyslexic radio button is selected.
	private boolean dysOn;
	//Sets initial text size combo box to size 14;
	private int textSizeIndex;
	//Actual text size;
	private int actualTextSize;
	//Sets the initial value of the font combo box to Arial.
	private int currentFont = 0;

	//Initial fonts for the screen
	private Font titleFont;
	private Font subtitleFont;
	private Font textFont;


	public SettingsScreen(MainWindow window){
		this.window = window;
		this.frame = window.frame;
		this.settingsMan = window.settingsManager;
		
		//Initialise settings variables
		primary = settingsMan.getPrimary();
		secondary = settingsMan.getSecondary();
		cbmOn = settingsMan.isCbmOn();
		dysOn = settingsMan.isDysOn();
		textSizeIndex = settingsMan.getTextSizeIndex();
		actualTextSize = settingsMan.getActualTextSize();
		currentFont = settingsMan.getCurrentFont();
		titleFont = settingsMan.getTitleFont();
		subtitleFont = settingsMan.getSubtitleFont();
		textFont = settingsMan.getTextFont();
		
		this.setLayout(new BorderLayout());
		this.add(northArea(), BorderLayout.NORTH);
		this.add(createContentArea(), BorderLayout.CENTER);
	}


	JPanel northArea(){
		JPanel northPanel = new JPanel();
		northPanel.setBackground(primary);
		northPanel.setLayout(new BorderLayout());

		northPanel.add(createHeaderPanel(), BorderLayout.NORTH);
		northPanel.add(createMenuArea(), BorderLayout.SOUTH);

		return northPanel;
	}

	JPanel createHeaderPanel(){
		Map attributes = titleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

		JPanel headerPanel = new JPanel();
		JLabel settingsLabel = new JLabel("Settings");
		settingsLabel.setFont(titleFont);
		settingsLabel.setBorder(new EmptyBorder(5,5,5,10));
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBorder(new EmptyBorder(10,20,10,20));
		headerPanel.setBackground(primary);
		headerPanel.add(settingsLabel, BorderLayout.WEST);

		JButton logOut = new JButton("Log Out");
		logOut.setBackground(primary);
		logOut.setOpaque(true);
		logOut.setBorderPainted(false);
		logOut.setFont(titleFont.deriveFont(attributes));
		logOut.setForeground(Color.gray);
		logOut.setActionCommand("LogOut");
		logOut.addActionListener(this);		
		headerPanel.add(logOut, BorderLayout.EAST);

		return headerPanel;
	}


	//Creates the general area for the menu buttons to go in.
	JPanel createMenuArea(){
		JPanel menuArea = new JPanel();
		menuArea.setLayout(new BorderLayout());
		menuArea.setBackground(secondary);
		menuArea.setBorder(new EmptyBorder(10,20,10,20));
		menuArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menuArea.add(createMenuPanel(), BorderLayout.WEST);

		return menuArea;
	}


	//Crates the menu buttons used to switch between screens.
	JPanel createMenuPanel(){
		//Set underline for buttons
		Map attributes = subtitleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(secondary);
		menuPanel.setLayout(new FlowLayout());

		JButton mainMenuButton = new JButton("Main Menu");	
		mainMenuButton.setBorderPainted(false);
		mainMenuButton.setBackground(secondary);
		mainMenuButton.setFont(subtitleFont.deriveFont(attributes));
		mainMenuButton.addActionListener(this);
		mainMenuButton.setActionCommand("MainMenu");
		menuPanel.add(mainMenuButton);

		JLabel sep1 = new JLabel("|");
		sep1.setFont(subtitleFont);
		menuPanel.add(sep1);

		JButton cameraFeedButton = new JButton("Camera Feed");
		cameraFeedButton.setBorderPainted(false);
		cameraFeedButton.setBackground(secondary);
		cameraFeedButton.setFont(subtitleFont.deriveFont(attributes));
		cameraFeedButton.addActionListener(this);
		cameraFeedButton.setActionCommand("CameraFeed");
		menuPanel.add(cameraFeedButton);

		JLabel sep2 = new JLabel("|");
		sep2.setFont(subtitleFont);
		menuPanel.add(sep2);

		JButton trapFeedButton = new JButton("Trap Feed");
		trapFeedButton.setBorderPainted(false);
		trapFeedButton.setBackground(secondary);
		trapFeedButton.setFont(subtitleFont.deriveFont(attributes));
		trapFeedButton.addActionListener(this);
		trapFeedButton.setActionCommand("TrapFeed");
		menuPanel.add(trapFeedButton);

		JLabel sep3 = new JLabel("|");
		sep3.setFont(subtitleFont);
		menuPanel.add(sep3);

		JButton areaSummaryButton = new JButton("Area Summary");
		areaSummaryButton.setBorderPainted(false);
		areaSummaryButton.setBackground(secondary);
		areaSummaryButton.setFont(subtitleFont.deriveFont(attributes));
		areaSummaryButton.addActionListener(this);
		areaSummaryButton.setActionCommand("AreaSummary");
		menuPanel.add(areaSummaryButton);

		JLabel sep4 = new JLabel("|");
		sep4.setFont(subtitleFont);
		menuPanel.add(sep4);

		JButton securityNotificationsButton = new JButton("Security Notifications");
		securityNotificationsButton.setBorderPainted(false);
		securityNotificationsButton.setBackground(secondary);
		securityNotificationsButton.setFont(subtitleFont.deriveFont(attributes));
		securityNotificationsButton.addActionListener(this);
		securityNotificationsButton.setActionCommand("securityNotifications");
		menuPanel.add(securityNotificationsButton);

		//		JButton backButton = new JButton("Back");
		//		backButton.setBackground(secondary);
		//		backButton.setBorder(null);
		//		backButton.setFont(subtitleFont.deriveFont(attributes));
		//		mainMenuButton.addActionListener(this);
		//		mainMenuButton.setActionCommand("MainMenu");

		return menuPanel;
	}


	//Creates the large area where all of the content of the settings screen is shown in a grid layout.
	JPanel createContentArea(){
		JPanel contentPannel = new JPanel();
		contentPannel.setBackground(Color.WHITE);
		add(contentPannel, BorderLayout.CENTER);
		contentPannel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPannel.add(createGeneralPanel());
		contentPannel.add(createUserPanel());
		contentPannel.add(createCameraPanel());
		contentPannel.add(createTrapPanel());
		contentPannel.add(createSysBUPanel());

		return contentPannel;
	}


	//Creates the "General" section of the settings screen and defines space for the title and content.
	JPanel createGeneralPanel(){
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new BorderLayout());
		generalPanel.setBackground(primary);

		JLabel generalTitle = new JLabel("  General");
		generalTitle.setOpaque(true);
		generalTitle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		generalTitle.setBackground(Color.WHITE);
		generalTitle.setFont(subtitleFont);
		generalPanel.add(generalTitle, BorderLayout.NORTH);

		generalPanel.add(generalInfoArea(), BorderLayout.WEST);

		return generalPanel;
	}

	//Panel containing Grid Bag layout for all of the "General" settings components of the settings menu.
	JPanel generalInfoArea(){
		JPanel generalInfoPanel = new JPanel();
		generalInfoPanel.setBackground(primary);

		GridBagLayout gbl_generalInfoPanel = new GridBagLayout();
		gbl_generalInfoPanel.columnWidths = new int[]{95,95,95};
		generalInfoPanel.setLayout(gbl_generalInfoPanel);

		JLabel cbmLabel = new JLabel("Colorblind Mode:");
		cbmLabel.setFont(textFont);
		GridBagConstraints gbc_cbmLabel = new GridBagConstraints();
		gbc_cbmLabel.fill = GridBagConstraints.VERTICAL;
		gbc_cbmLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cbmLabel.gridx = 0;
		gbc_cbmLabel.gridy = 0;
		generalInfoPanel.add(cbmLabel, gbc_cbmLabel);

		JRadioButton rdbtnEnabled = new JRadioButton("Enabled");
		rdbtnEnabled.setBackground(primary);
		rdbtnEnabled.setFont(textFont);
		rdbtnEnabled.setActionCommand("cbmEnabled");
		rdbtnEnabled.addActionListener(this);	
		rdbtnEnabled.setFont(textFont);
		GridBagConstraints gbc_rdbtnEnabled = new GridBagConstraints();
		gbc_rdbtnEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEnabled.gridx = 0;
		gbc_rdbtnEnabled.gridy = 1;
		generalInfoPanel.add(rdbtnEnabled, gbc_rdbtnEnabled);
		cbmButtonGroup.add(rdbtnEnabled);
		rdbtnEnabled.setSelected(cbmOn);

		JRadioButton rdbtnDisabled = new JRadioButton("Disabled");
		rdbtnDisabled.setBackground(primary);
		rdbtnDisabled.setFont(textFont);
		rdbtnDisabled.addActionListener(this);
		rdbtnDisabled.setActionCommand("cbmDisabled");
		cbmButtonGroup.add(rdbtnDisabled);
		GridBagConstraints gbc_rdbtnDisabled = new GridBagConstraints();
		gbc_rdbtnDisabled.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnDisabled.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDisabled.gridx = 1;
		gbc_rdbtnDisabled.gridy = 1;
		rdbtnDisabled.setSelected(!(cbmOn));
		generalInfoPanel.add(rdbtnDisabled, gbc_rdbtnDisabled);

		JLabel dysLabel = new JLabel("Dyslexic Mode:");
		dysLabel.setFont(textFont);
		GridBagConstraints gbc_dysLabel = new GridBagConstraints();
		gbc_dysLabel.fill = GridBagConstraints.VERTICAL;
		gbc_dysLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dysLabel.gridx = 0;
		gbc_dysLabel.gridy = 3;
		generalInfoPanel.add(dysLabel, gbc_dysLabel);

		JRadioButton dysEnabled = new JRadioButton("Enabled");
		dysEnabled.setFont(textFont);
		dysEnabled.setBackground(primary);
		dysEnabled.addActionListener(this);
		dysEnabled.setActionCommand("dysEnabled");
		dysButtonGroup.add(dysEnabled);
		GridBagConstraints gbc_dysEnabled = new GridBagConstraints();
		gbc_dysEnabled.fill = GridBagConstraints.VERTICAL;
		gbc_dysEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_dysEnabled.gridx = 0;
		gbc_dysEnabled.gridy = 4;
		generalInfoPanel.add(dysEnabled, gbc_dysEnabled);
		dysEnabled.setSelected(dysOn);

		JRadioButton dysDisabled = new JRadioButton("Disabled");
		dysDisabled.setBackground(primary);
		dysDisabled.setFont(textFont);
		dysDisabled.addActionListener(this);
		dysDisabled.setActionCommand("dysDisabled");
		dysButtonGroup.add(dysDisabled);
		GridBagConstraints gbc_dysDisabled = new GridBagConstraints();
		gbc_dysDisabled.insets = new Insets(0, 0, 5, 5);
		gbc_dysDisabled.fill = GridBagConstraints.BOTH;
		gbc_dysDisabled.gridx = 1;
		gbc_dysDisabled.gridy = 4;
		generalInfoPanel.add(dysDisabled, gbc_dysDisabled);
		dysDisabled.setSelected(!(dysOn));

		JSeparator infoPanelSep = new JSeparator(SwingConstants.VERTICAL);
		infoPanelSep.setPreferredSize(new Dimension(1,110));
		infoPanelSep.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_infoPanelSep = new GridBagConstraints();
		gbc_infoPanelSep.insets = new Insets(5, 15, 5, 60);
		gbc_infoPanelSep.fill = GridBagConstraints.BOTH;
		gbc_infoPanelSep.gridx = 3;
		gbc_infoPanelSep.gridy = 0;
		gbc_infoPanelSep.gridheight = 5;
		generalInfoPanel.add(infoPanelSep, gbc_infoPanelSep);


		JLabel zoomLabel = new JLabel("Zoom:");
		zoomLabel.setFont(textFont);
		GridBagConstraints gbc_zoomLabel = new GridBagConstraints();
		gbc_zoomLabel.insets = new Insets(0, 0, 5, 5);
		gbc_zoomLabel.fill = GridBagConstraints.BOTH;
		gbc_zoomLabel.gridx = 5;
		gbc_zoomLabel.gridy = 0;
		generalInfoPanel.add(zoomLabel, gbc_zoomLabel);

		JComboBox<String> zoomCB = new JComboBox<String>();
		zoomCB.setFont(textFont);
		zoomCB.setBackground(new Color(255, 255, 255));
		zoomCB.setModel(new DefaultComboBoxModel<String>(new String[] {"80%", "90%", "100%", "110%", "120%", "130%", "140%", "150%"}));
		zoomCB.setSelectedIndex(2);
		zoomCB.addActionListener(this);
		GridBagConstraints gbc_zoomCB = new GridBagConstraints();
		gbc_zoomCB.insets = new Insets(0, 0, 5, 5);
		gbc_zoomCB.fill = GridBagConstraints.BOTH;
		gbc_zoomCB.gridx = 6;
		gbc_zoomCB.gridy = 0;
		generalInfoPanel.add(zoomCB, gbc_zoomCB);

		JLabel textSizeLabel = new JLabel("Text Size:");
		textSizeLabel.setFont(textFont);
		GridBagConstraints gbc_textSizeLabel = new GridBagConstraints();
		gbc_textSizeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_textSizeLabel.fill = GridBagConstraints.BOTH;
		gbc_textSizeLabel.gridx = 5;
		gbc_textSizeLabel.gridy = 2;
		generalInfoPanel.add(textSizeLabel, gbc_textSizeLabel);

		Integer[] textSize = {12, 14, 18};
		JComboBox textSizeCB = new JComboBox(textSize);
		textSizeCB.setBackground(new Color(255, 255, 255));
		textSizeCB.setFont(textFont);
		textSizeCB.setSelectedIndex(textSizeIndex);
		textSizeCB.setActionCommand("textSize");
		textSizeCB.addActionListener(this);
		GridBagConstraints gbc_textSizeCB = new GridBagConstraints();
		gbc_textSizeCB.insets = new Insets(0, 0, 5, 5);
		gbc_textSizeCB.fill = GridBagConstraints.BOTH;
		gbc_textSizeCB.gridx = 6;
		gbc_textSizeCB.gridy = 2;
		generalInfoPanel.add(textSizeCB, gbc_textSizeCB);


		JLabel fontLabel = new JLabel("Font:");
		fontLabel.setFont(textFont);
		GridBagConstraints gbc_fontLabel = new GridBagConstraints();
		gbc_fontLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fontLabel.fill = GridBagConstraints.BOTH;
		gbc_fontLabel.gridx = 5;
		gbc_fontLabel.gridy = 4;
		generalInfoPanel.add(fontLabel, gbc_fontLabel);

		String[] fonts = {"Arial", "Calibri", "Times New Roman", "Verdana"};
		JComboBox fontCB = new JComboBox(fonts);
		fontCB.setBackground(new Color(255, 255, 255));
		fontCB.setSelectedIndex(currentFont);
		fontCB.setFont(textFont);
		fontCB.addActionListener(this);
		fontCB.setActionCommand("changeFont");

		GridBagConstraints gbc_fontCB = new GridBagConstraints();
		gbc_fontCB.insets = new Insets(0, 0, 5, 5);
		gbc_fontCB.fill = GridBagConstraints.BOTH;
		gbc_fontCB.gridx = 6;
		gbc_fontCB.gridy = 4;
		gbc_fontCB.gridwidth = 2;
		generalInfoPanel.add(fontCB, gbc_fontCB);

		return generalInfoPanel;
	}


	//Creates the "User" section of the settings screen and defines space for the title and content.
	public JPanel createUserPanel(){
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		userPanel.setBackground(secondary);

		JLabel userLabel = new JLabel("  User");
		userLabel.setOpaque(true);
		userLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userLabel.setBackground(Color.WHITE);
		userLabel.setFont(subtitleFont);
		userPanel.add(userLabel, BorderLayout.NORTH);

		userPanel.add(createUserInfo(), BorderLayout.WEST);

		return userPanel;
	}


	//Panel containing Grid Bag layout for all of the "User" settings components of the settings menu.
	public JPanel createUserInfo(){
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBackground(secondary);

		GridBagLayout gbl_userInfoPanel = new GridBagLayout();
		gbl_userInfoPanel.columnWidths = new int[]{95,95,95};
		userInfoPanel.setLayout(gbl_userInfoPanel);

		JLabel givenNameLabel = new JLabel("Given Name:");
		givenNameLabel.setFont(textFont);
		GridBagConstraints gbc_givenNameLabel = new GridBagConstraints();
		gbc_givenNameLabel.fill = GridBagConstraints.VERTICAL;
		gbc_givenNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_givenNameLabel.gridx = 0;
		gbc_givenNameLabel.gridy = 0;
		userInfoPanel.add(givenNameLabel, gbc_givenNameLabel);

		givenNameTB = new JTextField();
		givenNameTB.setEditable(false);
		givenNameTB.setText("John");
		givenNameTB.setFont(textFont);
		givenNameTB.setColumns(18);
		GridBagConstraints gbc_givenNameTB = new GridBagConstraints();
		gbc_givenNameTB.fill = GridBagConstraints.VERTICAL;
		gbc_givenNameTB.insets = new Insets(0, 5, 5, 5);
		gbc_givenNameTB.gridx = 0;
		gbc_givenNameTB.gridy = 1;
		gbc_givenNameTB.gridwidth = 2;
		userInfoPanel.add(givenNameTB, gbc_givenNameTB);

		JLabel familyNameLabel = new JLabel("Family Name:");
		familyNameLabel.setFont(textFont);
		GridBagConstraints gbc_familyNameLabel = new GridBagConstraints();
		gbc_familyNameLabel.fill = GridBagConstraints.VERTICAL;
		gbc_familyNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_familyNameLabel.gridx = 0;
		gbc_familyNameLabel.gridy = 3;
		userInfoPanel.add(familyNameLabel, gbc_familyNameLabel);

		familyNameTB = new JTextField();
		familyNameTB.setEditable(false);
		familyNameTB.setText("Doe");
		familyNameTB.setFont(textFont);
		familyNameTB.setColumns(18);
		GridBagConstraints gbc_familyNameTB = new GridBagConstraints();
		gbc_familyNameTB.fill = GridBagConstraints.VERTICAL;
		gbc_familyNameTB.insets = new Insets(0, 5, 5, 5);
		gbc_familyNameTB.gridx = 0;
		gbc_familyNameTB.gridy = 4;
		gbc_familyNameTB.gridwidth = 2;
		userInfoPanel.add(familyNameTB, gbc_familyNameTB);

		JSeparator userSeparator = new JSeparator();
		userSeparator.setForeground(new Color(128, 128, 128));
		userSeparator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_userSeparator = new GridBagConstraints();
		gbc_userSeparator.insets = new Insets(5, 10, 5, 60);
		gbc_userSeparator.fill = GridBagConstraints.BOTH;
		gbc_userSeparator.gridx = 3;
		gbc_userSeparator.gridy = 0;
		gbc_userSeparator.gridheight = 5;
		userInfoPanel.add(userSeparator, gbc_userSeparator);

		JLabel emailLabel = new JLabel("Email Address:");
		emailLabel.setFont(textFont);
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.fill = GridBagConstraints.VERTICAL;
		gbc_emailLabel.insets = new Insets(0, 5, 5, 5);
		gbc_emailLabel.gridx = 5;
		gbc_emailLabel.gridy = 0;
		userInfoPanel.add(emailLabel, gbc_emailLabel);

		emailTB = new JTextField();
		emailTB.setEditable(false);
		emailTB.setText("example@email.com");
		emailTB.setFont(textFont);
		emailTB.setColumns(30);
		GridBagConstraints gbc_emailTB = new GridBagConstraints();
		gbc_emailTB.fill = GridBagConstraints.VERTICAL;
		gbc_emailTB.insets = new Insets(0, 5, 5, 5);
		gbc_emailTB.gridx = 5;
		gbc_emailTB.gridy = 1;
		gbc_emailTB.gridwidth = 3;
		userInfoPanel.add(emailTB, gbc_emailTB);

		JButton updUserDetailsButton = new JButton("Update User Details");
		updUserDetailsButton.setFont(textFont);
		updUserDetailsButton.setForeground(new Color(0, 0, 255));
		updUserDetailsButton.setBorder(null);
		updUserDetailsButton.setBackground(new Color(250, 250, 210));
		updUserDetailsButton.addActionListener(this);
		updUserDetailsButton.setActionCommand("updateUserDetails");
		GridBagConstraints gbc_updUserDetailsButton = new GridBagConstraints();
		gbc_updUserDetailsButton.anchor = GridBagConstraints.WEST;
		gbc_updUserDetailsButton.fill = GridBagConstraints.VERTICAL;
		gbc_updUserDetailsButton.insets = new Insets(0, 5, 5, 5);
		gbc_updUserDetailsButton.gridx = 5;
		gbc_updUserDetailsButton.gridy = 3;
		userInfoPanel.add(updUserDetailsButton, gbc_updUserDetailsButton);

		JButton chngPwdButton = new JButton("Change Password");
		chngPwdButton.setFont(textFont);
		chngPwdButton.setBorder(null);
		chngPwdButton.setBackground(new Color(250, 250, 210));
		chngPwdButton.setForeground(new Color(0, 0, 255));
		chngPwdButton.addActionListener(this);
		chngPwdButton.setActionCommand("changePwd");
		GridBagConstraints gbc_chngPwdButton = new GridBagConstraints();
		gbc_chngPwdButton.anchor = GridBagConstraints.WEST;
		gbc_chngPwdButton.fill = GridBagConstraints.VERTICAL;
		gbc_chngPwdButton.insets = new Insets(0, 5, 5, 5);
		gbc_chngPwdButton.gridx = 5;
		gbc_chngPwdButton.gridy = 4;
		userInfoPanel.add(chngPwdButton, gbc_chngPwdButton);

		return userInfoPanel;
	}


	//Creates the "Cameras" section of the settings screen and defines space for the title and content.
	public JPanel createCameraPanel(){
		JPanel cameraPanel = new JPanel();
		cameraPanel.setLayout(new BorderLayout());
		cameraPanel.setBackground(primary);

		JLabel camerasTitleLabel = new JLabel("  Cameras");
		camerasTitleLabel.setOpaque(true);
		camerasTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		camerasTitleLabel.setBackground(Color.WHITE);
		camerasTitleLabel.setFont(subtitleFont);
		cameraPanel.add(camerasTitleLabel, BorderLayout.NORTH);

		cameraPanel.add(createCameraSettings(), BorderLayout.WEST);

		return cameraPanel;
	}


	//Panel containing Grid Bag layout for all of the "Cameras" settings components of the settings menu.
	public JPanel createCameraSettings(){
		JPanel cameraSettingsPanel = new JPanel();
		cameraSettingsPanel.setBackground(primary);

		GridBagLayout gbl_cameraSettingsPanel = new GridBagLayout();
		gbl_cameraSettingsPanel.columnWidths = new int[]{95,95,95};
		cameraSettingsPanel.setLayout(gbl_cameraSettingsPanel);

		JRadioButton camerasEnabled = new JRadioButton("Enabled");
		camerasEnabled.setBackground(new Color(245, 245, 245));
		camerasEnabled.setFont(textFont);
		cameraButtonGroup.add(camerasEnabled);
		camerasEnabled.setEnabled(false);
		camerasEnabled.setSelected(true);
		GridBagConstraints gbc_camerasEnabled = new GridBagConstraints();
		gbc_camerasEnabled.fill = GridBagConstraints.VERTICAL;
		gbc_camerasEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_camerasEnabled.gridx = 0;
		gbc_camerasEnabled.gridy = 0;
		cameraSettingsPanel.add(camerasEnabled, gbc_camerasEnabled);

		JRadioButton camerasDisabled = new JRadioButton("Disabled");
		camerasDisabled.setBackground(new Color(245, 245, 245));
		camerasDisabled.setFont(textFont);
		cameraButtonGroup.add(camerasDisabled);
		camerasDisabled.setEnabled(false);
		GridBagConstraints gbc_camerasDisabled = new GridBagConstraints();
		gbc_camerasDisabled.fill = GridBagConstraints.VERTICAL;
		gbc_camerasDisabled.insets = new Insets(0, 0, 5, 5);
		gbc_camerasDisabled.gridx = 0;
		gbc_camerasDisabled.gridy = 1;
		cameraSettingsPanel.add(camerasDisabled, gbc_camerasDisabled);

		JSeparator camerasSep = new JSeparator();
		camerasSep.setForeground(new Color(128, 128, 128));
		camerasSep.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_camerasSep = new GridBagConstraints();
		gbc_camerasSep.insets = new Insets(0, 30, 0, 60);
		gbc_camerasSep.fill = GridBagConstraints.BOTH;
		gbc_camerasSep.gridx = 3;
		gbc_camerasSep.gridy = 0;
		gbc_camerasSep.gridheight = 6;
		cameraSettingsPanel.add(camerasSep, gbc_camerasSep);

		JLabel cameraRotateSpeedLabel = new JLabel("Camera Rotate Speed:");
		cameraRotateSpeedLabel.setFont(textFont);
		GridBagConstraints gbc_cameraRotateSpeedLabel = new GridBagConstraints();
		gbc_cameraRotateSpeedLabel.fill = GridBagConstraints.VERTICAL;
		gbc_cameraRotateSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cameraRotateSpeedLabel.gridx = 4;
		gbc_cameraRotateSpeedLabel.gridy = 0;
		cameraSettingsPanel.add(cameraRotateSpeedLabel, gbc_cameraRotateSpeedLabel);

		JSlider rotateSpeedSlider = new JSlider();
		rotateSpeedSlider.setBackground(new Color(245, 245, 245));
		rotateSpeedSlider.setEnabled(false);
		GridBagConstraints gbc_rotateSpeedSlider = new GridBagConstraints();
		gbc_rotateSpeedSlider.fill = GridBagConstraints.VERTICAL;
		gbc_rotateSpeedSlider.insets = new Insets(0, 0, 5, 5);
		gbc_rotateSpeedSlider.gridx = 4;
		gbc_rotateSpeedSlider.gridy = 1;
		gbc_rotateSpeedSlider.gridwidth = 3;
		cameraSettingsPanel.add(rotateSpeedSlider, gbc_rotateSpeedSlider);

		return cameraSettingsPanel;
	}


	//Creates the "Traps" section of the settings screen and defines space for the title and content.
	public JPanel createTrapPanel(){
		JPanel trapPanel = new JPanel();
		trapPanel.setLayout(new BorderLayout());
		trapPanel.setBackground(secondary);

		JLabel trapsTitleLabel = new JLabel("  Traps");
		trapsTitleLabel.setOpaque(true);
		trapsTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		trapsTitleLabel.setBackground(Color.WHITE);
		trapsTitleLabel.setFont(subtitleFont);
		trapPanel.add(trapsTitleLabel, BorderLayout.NORTH);

		trapPanel.add(createTrapSettings(), BorderLayout.WEST);

		return trapPanel;
	}


	//Panel containing Grid Bag layout for all of the "Traps" settings components of the settings menu.
	public JPanel createTrapSettings(){
		JPanel trapSettingsPanel = new JPanel();
		trapSettingsPanel.setBackground(secondary);

		GridBagLayout gbl_trapSettingsPanel = new GridBagLayout();
		gbl_trapSettingsPanel.columnWidths = new int[]{95,95,95};
		trapSettingsPanel.setLayout(gbl_trapSettingsPanel);

		JRadioButton trapsEnabled = new JRadioButton("Enabled");
		trapsEnabled.setBackground(new Color(250, 250, 210));
		trapsEnabled.setFont(textFont);
		trapEnabledButtonGroup.add(trapsEnabled);
		trapsEnabled.setEnabled(false);
		trapsEnabled.setSelected(true);
		GridBagConstraints gbc_trapsEnabled = new GridBagConstraints();
		gbc_trapsEnabled.fill = GridBagConstraints.VERTICAL;
		gbc_trapsEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_trapsEnabled.gridx = 0;
		gbc_trapsEnabled.gridy = 0;
		trapSettingsPanel.add(trapsEnabled, gbc_trapsEnabled);

		JRadioButton trapsDisabled = new JRadioButton("Disabled");
		trapsDisabled.setBackground(new Color(250, 250, 210));
		trapsDisabled.setFont(textFont);
		trapEnabledButtonGroup.add(trapsDisabled);
		trapsDisabled.setEnabled(false);
		GridBagConstraints gbc_trapsDisabled = new GridBagConstraints();
		gbc_trapsDisabled.fill = GridBagConstraints.VERTICAL;
		gbc_trapsDisabled.insets = new Insets(0, 0, 5, 5);
		gbc_trapsDisabled.gridx = 0;
		gbc_trapsDisabled.gridy = 1;
		trapSettingsPanel.add(trapsDisabled, gbc_trapsDisabled);

		JLabel remoteAccessLabel = new JLabel("    Allow Remote Access:");
		remoteAccessLabel.setFont(textFont);
		GridBagConstraints gbc_remoteAccessLabel = new GridBagConstraints();
		gbc_remoteAccessLabel.fill = GridBagConstraints.VERTICAL;
		gbc_remoteAccessLabel.insets = new Insets(0, 0, 5, 5);
		gbc_remoteAccessLabel.gridx = 0;
		gbc_remoteAccessLabel.gridy = 4;
		trapSettingsPanel.add(remoteAccessLabel, gbc_remoteAccessLabel);

		JRadioButton remoteAccessYes = new JRadioButton("Yes");
		remoteAccessYes.setBackground(new Color(250, 250, 210));
		remoteAccessYes.setFont(textFont);
		remoteAccessYes.setEnabled(false);
		remoteAccessYes.setSelected(true);
		trapRemoteAccessButtonGroup.add(remoteAccessYes);
		GridBagConstraints gbc_remoteAccessYes = new GridBagConstraints();
		gbc_remoteAccessYes.fill = GridBagConstraints.VERTICAL;
		gbc_remoteAccessYes.insets = new Insets(0, 0, 5, 5);
		gbc_remoteAccessYes.gridx = 0;
		gbc_remoteAccessYes.gridy = 5;
		trapSettingsPanel.add(remoteAccessYes, gbc_remoteAccessYes);

		JRadioButton remoteAccessNo = new JRadioButton("No");
		remoteAccessNo.setBackground(new Color(250, 250, 210));
		remoteAccessNo.setFont(textFont);
		remoteAccessNo.setEnabled(false);
		trapRemoteAccessButtonGroup.add(remoteAccessNo);
		GridBagConstraints gbc_remoteAccessNo = new GridBagConstraints();
		gbc_remoteAccessNo.anchor = GridBagConstraints.WEST;
		gbc_remoteAccessNo.fill = GridBagConstraints.VERTICAL;
		gbc_remoteAccessNo.insets = new Insets(0, 0, 5, 5);
		gbc_remoteAccessNo.gridx = 1;
		gbc_remoteAccessNo.gridy = 5;
		trapSettingsPanel.add(remoteAccessNo, gbc_remoteAccessNo);

		JSeparator trapsSep = new JSeparator();
		trapsSep.setForeground(new Color(128, 128, 128));
		trapsSep.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_trapsSep = new GridBagConstraints();
		gbc_trapsSep.insets = new Insets(0, -36, 0, 60);
		gbc_trapsSep.fill = GridBagConstraints.BOTH;
		gbc_trapsSep.gridx = 3;
		gbc_trapsSep.gridy = 0;
		gbc_trapsSep.gridheight = 7;
		trapSettingsPanel.add(trapsSep, gbc_trapsSep);

		JLabel maintenanceTimeLabel = new JLabel("Automated Maintenance Time:");
		maintenanceTimeLabel.setFont(textFont);
		GridBagConstraints gbc_maintenanceTimeLabel = new GridBagConstraints();
		gbc_maintenanceTimeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_maintenanceTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_maintenanceTimeLabel.gridx = 4;
		gbc_maintenanceTimeLabel.gridy = 1;
		trapSettingsPanel.add(maintenanceTimeLabel, gbc_maintenanceTimeLabel);

		JComboBox<String> maintenanceCB = new JComboBox<String>();
		maintenanceCB.setBackground(new Color(255, 255, 255));
		maintenanceCB.setEnabled(false);
		maintenanceCB.setFont(textFont);
		maintenanceCB.setModel(new DefaultComboBoxModel<String>(new String[] {"00:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM", "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM"}));
		maintenanceCB.setSelectedIndex(1);
		GridBagConstraints gbc_maintenanceCB = new GridBagConstraints();
		gbc_maintenanceCB.fill = GridBagConstraints.VERTICAL;
		gbc_maintenanceCB.insets = new Insets(0, 0, 5, 5);
		gbc_maintenanceCB.gridx = 4;
		gbc_maintenanceCB.gridy = 2;
		gbc_maintenanceCB.gridwidth = 2;
		trapSettingsPanel.add(maintenanceCB, gbc_maintenanceCB);

		return trapSettingsPanel;
	}


	//Creates the "System Backup" section of the settings screen and defines space for the title and content.
	public JPanel createSysBUPanel(){
		JPanel sysBUPanel = new JPanel();
		sysBUPanel.setLayout(new BorderLayout());
		sysBUPanel.setBackground(primary);

		JLabel sysBULabel = new JLabel("  System Backup");
		sysBULabel.setOpaque(true);
		sysBULabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sysBULabel.setBackground(Color.WHITE);
		sysBULabel.setFont(subtitleFont);
		sysBUPanel.add(sysBULabel, BorderLayout.NORTH);

		sysBUPanel.add(createSysBUSettings(), BorderLayout.WEST);

		return sysBUPanel;
	}


	//Panel containing Grid Bag layout for all of the "System Backup" settings components of the settings menu.
	public JPanel createSysBUSettings(){
		JPanel sysBUSettingsPanel = new JPanel();
		sysBUSettingsPanel.setBackground(primary);

		GridBagLayout gbl_trapSettingsPanel = new GridBagLayout();
		gbl_trapSettingsPanel.columnWidths = new int[]{95,95,95};
		sysBUSettingsPanel.setLayout(gbl_trapSettingsPanel);

		JLabel backupTimeLabel = new JLabel("    Automated Backup Time:");
		backupTimeLabel.setFont(textFont);
		GridBagConstraints gbc_backupTimeLabel = new GridBagConstraints();
		gbc_backupTimeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_backupTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_backupTimeLabel.gridx = 0;
		gbc_backupTimeLabel.gridy = 0;
		sysBUSettingsPanel.add(backupTimeLabel, gbc_backupTimeLabel);

		JComboBox<String> backupTimeCB = new JComboBox<String>();
		backupTimeCB.setBackground(new Color(255, 255, 255));
		backupTimeCB.setFont(textFont);
		backupTimeCB.setEnabled(false);
		backupTimeCB.setModel(new DefaultComboBoxModel<String>(new String[] {"00:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM", "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM"}));
		backupTimeCB.setSelectedIndex(1);
		GridBagConstraints gbc_backupTimeCB = new GridBagConstraints();
		gbc_backupTimeCB.fill = GridBagConstraints.VERTICAL;
		gbc_backupTimeCB.insets = new Insets(0, 0, 5, 5);
		gbc_backupTimeCB.gridx = 0;
		gbc_backupTimeCB.gridy = 1;
		sysBUSettingsPanel.add(backupTimeCB, gbc_backupTimeCB);

		JSeparator bUSep = new JSeparator();
		bUSep.setForeground(new Color(128, 128, 128));
		bUSep.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_bUSep = new GridBagConstraints();
		gbc_bUSep.insets = new Insets(0, 38, 0, 60);
		gbc_bUSep.fill = GridBagConstraints.BOTH;
		gbc_bUSep.gridx = 2;
		gbc_bUSep.gridy = 0;
		gbc_bUSep.gridheight = 4;
		sysBUSettingsPanel.add(bUSep, gbc_bUSep);

		JButton btnBackupNow = new JButton("Backup Now");
		btnBackupNow.setEnabled(false);
		btnBackupNow.setBorder(UIManager.getBorder("Button.border"));
		GridBagConstraints gbc_btnBackupNow = new GridBagConstraints();
		gbc_btnBackupNow.fill = GridBagConstraints.VERTICAL;
		gbc_btnBackupNow.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackupNow.gridx = 3;
		gbc_btnBackupNow.gridy = 0;
		sysBUSettingsPanel.add(btnBackupNow, gbc_btnBackupNow);

		JProgressBar buProgressBar = new JProgressBar();
		GridBagConstraints gbc_buProgressBar = new GridBagConstraints();
		gbc_buProgressBar.fill = GridBagConstraints.VERTICAL;
		gbc_buProgressBar.insets = new Insets(0, 0, 5, 5);
		gbc_buProgressBar.gridx = 3;
		gbc_buProgressBar.gridy = 1;
		gbc_buProgressBar.gridwidth = 2;
		sysBUSettingsPanel.add(buProgressBar, gbc_buProgressBar);

		return sysBUSettingsPanel;
	}


	//Events
	@Override
	public void actionPerformed(ActionEvent e) {
		//Change screen to the main menu screen.
		if (e.getActionCommand().equals("MainMenu")){
			window.screenTransition(new MainMenuScreen(this.window));
		}
		//Change Screen to the area summary screen.
		else if(e.getActionCommand().equals("AreaSummary")){

		}
		//Change Screen to the security notifications screen.
		else if(e.getActionCommand().equals("SecurityNotifications")){

		}
		//Change Screen to the camera feed screen.
		else if(e.getActionCommand().equals("CameraFeed")){
			window.screenTransition(new MainCameraFeed(this.window));
		}
		//Change screen to the login screen.
		else if(e.getActionCommand().equals("LogOut")){
			window.screenTransition(new LogInScreen(this.window));
		}
		//Shows the trap feed screen.
		else if(e.getActionCommand().equals("TrapFeed")){
			window.screenTransition(new TrapFeedScreen(this.window));
		}
		//Shows the update user details screen.
		else if(e.getActionCommand().equals("updateUserDetails")){
			UserDetailsScreen uds = new UserDetailsScreen(this);
		}
		//Shows the change password screen.
		else if(e.getActionCommand().equals("changePwd")){
			System.out.println("here");
			ChangePwdScreen cpwd = new ChangePwdScreen();
		}
		//Changes the primary and secondary colors to colors which are easily distinguishable, for people who are color blind.
		else if(e.getActionCommand().equals("cbmEnabled")){
			cbmOn = true; 
			settingsMan.setCbmOn(true);
			Color check = new Color(240,228,66);
			if (!(primary.equals(check))){
				this.removeAll();
				primary = check;
				secondary = new Color (86, 180,233);
				settingsMan.setPrimary(primary);
				settingsMan.setSecondary(secondary);
				this.add(northArea(), BorderLayout.NORTH);
				this.add(createContentArea(), BorderLayout.CENTER);
				this.revalidate();
				this.repaint();
			}
		}
		//Changes the primary and secondary colors back to their default.
		else if(e.getActionCommand().equals("cbmDisabled")){
			cbmOn = false; 
			settingsMan.setCbmOn(false);
			Color check = new Color(255,242,242);
			if (!(primary.equals(check))){
				this.removeAll();
				primary = check;
				secondary = new Color (255,243,221);
				settingsMan.setPrimary(primary);
				settingsMan.setSecondary(secondary);
				this.add(northArea(), BorderLayout.NORTH);
				this.add(createContentArea(), BorderLayout.CENTER);
				this.revalidate();
				this.repaint();
			}
		}
		//Changes the font to Arial, with size 14 font (Enabled by default).
		else if (e.getActionCommand().equals("dysEnabled")){
			dysOn = true;
			settingsMan.setDysOn(true);
			textSizeIndex = 1;
			currentFont = 0;
			Font titleFontTemp = new Font("Arial", Font.BOLD, 20);
			Font subtitleFontTemp = new Font("Arial", Font.PLAIN, 18);
			Font textFontTemp = new Font("Arial", Font.PLAIN, 14);
			if (!(titleFontTemp.equals(titleFont) && subtitleFontTemp.equals(subtitleFont) && textFontTemp.equals(textFont))){
				this.removeAll();
				titleFont = titleFontTemp;
				subtitleFont = subtitleFontTemp;
				textFont = textFontTemp;
				settingsMan.setTextFont(textFontTemp);
				settingsMan.setSubtitleFont(subtitleFontTemp);
				settingsMan.setTitleFont(titleFontTemp);
				this.add(northArea(), BorderLayout.NORTH);
				this.add(createContentArea(), BorderLayout.CENTER);
				this.validate();
				this.repaint();
			}
		}
		//Sets the disabled button to be selected in the "dysButtonGroup" button group.
		else if (e.getActionCommand().equals("dysDisabled")){
			dysOn = false;
			settingsMan.setDysOn(false);
		}
		//Sets the text size to the selected size in the combo box.
		else if (e.getActionCommand().equals("textSize")){
			JComboBox tempCB = (JComboBox) e.getSource();
			int size = (int) tempCB.getSelectedItem();
			Font titleFontTemp = titleFont.deriveFont(Font.BOLD, (size + 6));
			Font subtitleFontTemp = subtitleFont.deriveFont(Font.PLAIN, (size + 4));
			Font textFontTemp = textFont.deriveFont(Font.PLAIN, size);
			if (size != 14){
				dysOn = false;
				settingsMan.setDysOn(false);
			}
			actualTextSize = size;
			textSizeIndex = tempCB.getSelectedIndex();
			titleFont = titleFontTemp;
			subtitleFont = subtitleFontTemp;
			textFont = textFontTemp;
			settingsMan.setActualTextSize(size);
			settingsMan.setTextSizeIndex(tempCB.getSelectedIndex());
			settingsMan.setTitleFont(titleFontTemp);
			settingsMan.setSubtitleFont(subtitleFontTemp);
			settingsMan.setTextFont(textFontTemp);
			this.removeAll();
			this.add(northArea(), BorderLayout.NORTH);
			this.add(createContentArea(), BorderLayout.CENTER);
			this.validate();
		}
		//Sets the text font to the selected font in the combo box.
		else if (e.getActionCommand().equals("changeFont")){
			JComboBox tempCB = (JComboBox) e.getSource();
			String font = (String) tempCB.getSelectedItem();
			Font titleFontTemp = new Font(font, Font.BOLD, (actualTextSize + 6));
			Font subtitleFontTemp = new Font(font, Font.PLAIN, (actualTextSize + 4));
			Font textFontTemp = new Font(font, Font.PLAIN, (actualTextSize));
			if (!(font.equals("Arial"))){
				dysOn = false;
				settingsMan.setDysOn(false);
			}
			currentFont = tempCB.getSelectedIndex();
			titleFont = titleFontTemp;
			subtitleFont = subtitleFontTemp;
			textFont = textFontTemp;
			settingsMan.setCurrentFont(tempCB.getSelectedIndex());
			settingsMan.setTitleFont(titleFontTemp);
			settingsMan.setSubtitleFont(subtitleFontTemp);
			settingsMan.setTextFont(textFontTemp);
			this.removeAll();
			this.add(northArea(), BorderLayout.NORTH);
			this.add(createContentArea(), BorderLayout.CENTER);
			this.validate();
		}

	}


	//Getters and Setters used for both the user details screen and the change password screen.
	public String getGivenNameTB() {
		return givenNameTB.getText();
	}

	public void setGivenNameTB(String value) {
		givenNameTB.setText(value);
	}

	public String getFamilyNameTB() {
		return familyNameTB.getText();
	}

	public void setFamilyNameTB(String value) {
		familyNameTB.setText(value);
	}

	public String getEmailTB() {
		return emailTB.getText();
	}

	public void setEmailTB(String value) {
		emailTB.setText(value);
	}

}
