import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JProgressBar;

public class SettingsScreen extends JPanel implements ActionListener {

	MainWindow window;
	JFrame frame;
	private final ButtonGroup cbmButtonGroup = new ButtonGroup();
	private final ButtonGroup dysButtonGroup = new ButtonGroup();
	private JTextField givenNameTB;
	private JTextField familyNameTB;
	private JTextField emailTB;
	private final ButtonGroup cameraButtonGroup = new ButtonGroup();
	private final ButtonGroup trapRemoteAccessButtonGroup = new ButtonGroup();
	private final ButtonGroup trapEnabledButtonGroup = new ButtonGroup();



	public SettingsScreen(MainWindow window){
		this.window = window;
		this.frame = window.frame;
		setLayout(new BorderLayout(0, 0));
		
		JPanel titlePannel = new JPanel();
		titlePannel.setBackground(new Color(255, 255, 255));
		add(titlePannel, BorderLayout.NORTH);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(255, 255, 255));
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setBorder(null);
		mainMenuButton.setBackground(new Color(255, 255, 255));
		mainMenuButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		mainMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton areaSummaryButton = new JButton("Area Summary");
		areaSummaryButton.setBorder(null);
		areaSummaryButton.setBackground(new Color(255, 255, 255));
		areaSummaryButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		areaSummaryButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton cameraFeedButton = new JButton("Camera Feed");
		cameraFeedButton.setBorder(null);
		cameraFeedButton.setBackground(new Color(255, 255, 255));
		cameraFeedButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		cameraFeedButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(255, 255, 255));
		backButton.setBorder(null);
		backButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JSeparator menuSeparator1 = new JSeparator();
		menuSeparator1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator menuSeparator2 = new JSeparator();
		menuSeparator2.setOrientation(SwingConstants.VERTICAL);
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainMenuButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuSeparator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(areaSummaryButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuSeparator2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(cameraFeedButton)
					.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
					.addComponent(backButton)
					.addContainerGap())
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addComponent(menuSeparator2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_menuPanel.createSequentialGroup()
								.addComponent(menuSeparator1)
								.addContainerGap())
							.addGroup(gl_menuPanel.createSequentialGroup()
								.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(mainMenuButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(areaSummaryButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_menuPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cameraFeedButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGap(13)))))
		);
		menuPanel.setLayout(gl_menuPanel);
		GroupLayout gl_titlePannel = new GroupLayout(titlePannel);
		gl_titlePannel.setHorizontalGroup(
			gl_titlePannel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePannel.createSequentialGroup()
					.addGroup(gl_titlePannel.createParallelGroup(Alignment.LEADING)
						.addComponent(menuPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 452, Short.MAX_VALUE)
						.addGroup(gl_titlePannel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSettings, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		gl_titlePannel.setVerticalGroup(
			gl_titlePannel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePannel.createSequentialGroup()
					.addComponent(lblSettings)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		titlePannel.setLayout(gl_titlePannel);
		
		JScrollBar scrollBar = new JScrollBar();
		add(scrollBar, BorderLayout.EAST);
		
		JPanel contentPannel = new JPanel();
		contentPannel.setBackground(Color.WHITE);
		add(contentPannel, BorderLayout.CENTER);
		contentPannel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel generalPanel = new JPanel();
		contentPannel.add(generalPanel);
		generalPanel.setBackground(new Color(245, 245, 245));
		
		JLabel cbmLabel = new JLabel("Colorblind Mode:");
		cbmLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JRadioButton rdbtnEnabled = new JRadioButton("Enabled");
		rdbtnEnabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbmButtonGroup.add(rdbtnEnabled);
		
		JRadioButton rdbtnDisabled = new JRadioButton("Disabled");
		rdbtnDisabled.setSelected(true);
		rdbtnDisabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbmButtonGroup.add(rdbtnDisabled);
		
		JLabel dysLabel = new JLabel("Dyslexic Mode:");
		dysLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JRadioButton dysEnabled = new JRadioButton("Enabled");
		dysEnabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		dysButtonGroup.add(dysEnabled);
		
		JRadioButton dysDisabled = new JRadioButton("Disabled");
		dysDisabled.setSelected(true);
		dysDisabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		dysButtonGroup.add(dysDisabled);
		
		JSeparator generalVertSeparator = new JSeparator();
		generalVertSeparator.setForeground(new Color(128, 128, 128));
		generalVertSeparator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel zoomLabel = new JLabel("Zoom:");
		zoomLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JComboBox zoomCB = new JComboBox();
		zoomCB.setFont(new Font("Calibri", Font.PLAIN, 12));
		zoomCB.setBackground(new Color(255, 255, 255));
		zoomCB.setModel(new DefaultComboBoxModel(new String[] {"80%", "90%", "100%", "110%", "120%", "130%", "140%", "150%"}));
		zoomCB.setSelectedIndex(2);
		
		JLabel textSizeLabel = new JLabel("Text Size");
		textSizeLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JComboBox textSizeCB = new JComboBox();
		textSizeCB.setBackground(new Color(255, 255, 255));
		textSizeCB.setFont(new Font("Calibri", Font.PLAIN, 12));
		textSizeCB.setModel(new DefaultComboBoxModel(new String[] {"12", "14", "18", "24", "30", "36", "48"}));
		
		JLabel fontLabel = new JLabel("Font");
		fontLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JComboBox fontCB = new JComboBox();
		fontCB.setBackground(new Color(255, 255, 255));
		fontCB.setFont(new Font("Calibri", Font.PLAIN, 12));
		fontCB.setModel(new DefaultComboBoxModel(new String[] {"Arial", "Calibri", "Times New Roman", "Verdana"}));
		fontCB.setSelectedIndex(1);
		
		JLabel generalTitle = new JLabel("  General");
		generalTitle.setOpaque(true);
		generalTitle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		generalTitle.setBackground(Color.WHITE);
		generalTitle.setFont(new Font("Calibri", Font.BOLD, 22));
		GroupLayout gl_generalPanel = new GroupLayout(generalPanel);
		gl_generalPanel.setHorizontalGroup(
			gl_generalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generalPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_generalPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addGap(33)
							.addComponent(cbmLabel))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addGap(32)
							.addComponent(dysLabel))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addComponent(dysEnabled)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dysDisabled))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addComponent(rdbtnEnabled)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnDisabled)))
					.addGap(53)
					.addComponent(generalVertSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(gl_generalPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_generalPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_generalPanel.createSequentialGroup()
								.addComponent(zoomLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(zoomCB, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_generalPanel.createSequentialGroup()
								.addComponent(textSizeLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textSizeCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addComponent(fontLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
				.addComponent(generalTitle, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_generalPanel.setVerticalGroup(
			gl_generalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generalPanel.createSequentialGroup()
					.addComponent(generalTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_generalPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(cbmLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_generalPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnEnabled)
								.addComponent(rdbtnDisabled))
							.addGap(39)
							.addComponent(dysLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_generalPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(dysEnabled)
								.addComponent(dysDisabled)))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(generalVertSeparator, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_generalPanel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_generalPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(zoomLabel)
								.addComponent(zoomCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_generalPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textSizeLabel)
								.addComponent(textSizeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_generalPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(fontLabel)
								.addComponent(fontCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		generalPanel.setLayout(gl_generalPanel);
		
		JPanel userPanel = new JPanel();
		contentPannel.add(userPanel);
		userPanel.setBackground(new Color(250, 250, 210));
		
		JLabel givenNameLabel = new JLabel("Given Name:");
		givenNameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		givenNameTB = new JTextField();
		givenNameTB.setFont(new Font("Calibri", Font.PLAIN, 12));
		givenNameTB.setColumns(10);
		
		JLabel familyNameLabel = new JLabel("Family Name:");
		familyNameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		familyNameTB = new JTextField();
		familyNameTB.setFont(new Font("Calibri", Font.PLAIN, 12));
		familyNameTB.setColumns(10);
		
		JSeparator userVertSeparator = new JSeparator();
		userVertSeparator.setForeground(new Color(128, 128, 128));
		userVertSeparator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel emailLabel = new JLabel("Email Address:");
		emailLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		emailTB = new JTextField();
		emailTB.setFont(new Font("Calibri", Font.PLAIN, 12));
		emailTB.setColumns(10);
		
		JButton updUserDetailsButton = new JButton("Update User Details");
		updUserDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		updUserDetailsButton.setForeground(new Color(0, 0, 255));
		updUserDetailsButton.setBorder(null);
		updUserDetailsButton.setBackground(new Color(250, 250, 210));
		
		JButton chngPwdButton = new JButton("Change Password");
		chngPwdButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		chngPwdButton.setBorder(null);
		chngPwdButton.setBackground(new Color(250, 250, 210));
		chngPwdButton.setForeground(new Color(0, 0, 255));
		
		JLabel lblUser = new JLabel("  User");
		lblUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblUser.setOpaque(true);
		lblUser.setBackground(Color.WHITE);
		lblUser.setFont(new Font("Calibri", Font.BOLD, 22));
		GroupLayout gl_userPanel = new GroupLayout(userPanel);
		gl_userPanel.setHorizontalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(familyNameLabel)
							.addComponent(givenNameTB, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addComponent(familyNameTB))
						.addComponent(givenNameLabel, Alignment.TRAILING))
					.addGap(67)
					.addComponent(userVertSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(emailLabel)
						.addComponent(updUserDetailsButton)
						.addComponent(chngPwdButton)
						.addComponent(emailTB, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
					.addGap(0))
				.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_userPanel.setVerticalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addComponent(lblUser)
					.addGap(6)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_userPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(givenNameLabel)
							.addGap(18)
							.addComponent(givenNameTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(familyNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(familyNameTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_userPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_userPanel.createSequentialGroup()
									.addComponent(emailLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(emailTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(updUserDetailsButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chngPwdButton))
								.addComponent(userVertSeparator, GroupLayout.PREFERRED_SIZE, 141, Short.MAX_VALUE))))
					.addContainerGap())
		);
		userPanel.setLayout(gl_userPanel);
		
		JPanel camerasPanel = new JPanel();
		contentPannel.add(camerasPanel);
		camerasPanel.setBackground(new Color(245, 245, 245));
		
		JLabel cameraRotateSpeedLabel = new JLabel("Camera Rotate Speed:");
		cameraRotateSpeedLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JRadioButton camerasEnabled = new JRadioButton("Enabled");
		camerasEnabled.setBackground(new Color(245, 245, 245));
		camerasEnabled.setSelected(true);
		camerasEnabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		cameraButtonGroup.add(camerasEnabled);
		camerasEnabled.setEnabled(false);
		
		JRadioButton camerasDisabled = new JRadioButton("Disabled");
		camerasDisabled.setBackground(new Color(245, 245, 245));
		camerasDisabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		cameraButtonGroup.add(camerasDisabled);
		camerasDisabled.setEnabled(false);
		
		JSlider rotateSpeedSlider = new JSlider();
		rotateSpeedSlider.setBackground(new Color(245, 245, 245));
		
		JSeparator camerasVertSeparator = new JSeparator();
		camerasVertSeparator.setForeground(new Color(128, 128, 128));
		camerasVertSeparator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel camerasTitleLabel = new JLabel("  Cameras");
		camerasTitleLabel.setOpaque(true);
		camerasTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		camerasTitleLabel.setBackground(Color.WHITE);
		camerasTitleLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		GroupLayout gl_camerasPanel = new GroupLayout(camerasPanel);
		gl_camerasPanel.setHorizontalGroup(
			gl_camerasPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_camerasPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_camerasPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(camerasEnabled)
						.addComponent(camerasDisabled))
					.addGap(120)
					.addComponent(camerasVertSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_camerasPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cameraRotateSpeedLabel)
						.addComponent(rotateSpeedSlider, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
				.addComponent(camerasTitleLabel, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_camerasPanel.setVerticalGroup(
			gl_camerasPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_camerasPanel.createSequentialGroup()
					.addComponent(camerasTitleLabel)
					.addGap(17)
					.addGroup(gl_camerasPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_camerasPanel.createSequentialGroup()
							.addComponent(cameraRotateSpeedLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rotateSpeedSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(camerasVertSeparator, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
						.addGroup(gl_camerasPanel.createSequentialGroup()
							.addComponent(camerasEnabled)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(camerasDisabled)))
					.addContainerGap())
		);
		camerasPanel.setLayout(gl_camerasPanel);
		
		JPanel trapsPanel = new JPanel();
		contentPannel.add(trapsPanel);
		trapsPanel.setBackground(new Color(250, 250, 210));
		
		JRadioButton trapsEnabled = new JRadioButton("Enabled");
		trapsEnabled.setBackground(new Color(250, 250, 210));
		trapsEnabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		trapEnabledButtonGroup.add(trapsEnabled);
		trapsEnabled.setEnabled(false);
		trapsEnabled.setSelected(true);
		
		JRadioButton trapsDisabled = new JRadioButton("Disabled");
		trapsDisabled.setBackground(new Color(250, 250, 210));
		trapsDisabled.setFont(new Font("Calibri", Font.PLAIN, 12));
		trapEnabledButtonGroup.add(trapsDisabled);
		trapsDisabled.setEnabled(false);
		
		JLabel remoteAccessLabel = new JLabel("Allow Remote Access:");
		remoteAccessLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JRadioButton remoteAccessYes = new JRadioButton("Yes");
		remoteAccessYes.setBackground(new Color(250, 250, 210));
		remoteAccessYes.setFont(new Font("Calibri", Font.PLAIN, 12));
		remoteAccessYes.setEnabled(false);
		remoteAccessYes.setSelected(true);
		trapRemoteAccessButtonGroup.add(remoteAccessYes);
		
		JRadioButton remoteAccessNo = new JRadioButton("No");
		remoteAccessNo.setBackground(new Color(250, 250, 210));
		remoteAccessNo.setFont(new Font("Calibri", Font.PLAIN, 12));
		remoteAccessNo.setEnabled(false);
		trapRemoteAccessButtonGroup.add(remoteAccessNo);
		
		JSeparator trapsVertSeparator = new JSeparator();
		trapsVertSeparator.setForeground(new Color(128, 128, 128));
		trapsVertSeparator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel maintenanceTimeLabel = new JLabel("Automated Maintenance Time:");
		maintenanceTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JComboBox maintenanceCB = new JComboBox();
		maintenanceCB.setBackground(new Color(255, 255, 255));
		maintenanceCB.setEnabled(false);
		maintenanceCB.setFont(new Font("Calibri", Font.PLAIN, 12));
		maintenanceCB.setModel(new DefaultComboBoxModel(new String[] {"00:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM", "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM"}));
		maintenanceCB.setSelectedIndex(1);
		
		JLabel trapsTitleLabel = new JLabel("  Traps");
		trapsTitleLabel.setOpaque(true);
		trapsTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		trapsTitleLabel.setBackground(Color.WHITE);
		trapsTitleLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		GroupLayout gl_trapsPanel = new GroupLayout(trapsPanel);
		gl_trapsPanel.setHorizontalGroup(
			gl_trapsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_trapsPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_trapsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(remoteAccessNo)
						.addComponent(remoteAccessYes)
						.addComponent(remoteAccessLabel)
						.addComponent(trapsDisabled)
						.addComponent(trapsEnabled))
					.addGap(71)
					.addComponent(trapsVertSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(gl_trapsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(maintenanceTimeLabel)
						.addGroup(gl_trapsPanel.createSequentialGroup()
							.addGap(30)
							.addComponent(maintenanceCB, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addComponent(trapsTitleLabel, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_trapsPanel.setVerticalGroup(
			gl_trapsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_trapsPanel.createSequentialGroup()
					.addComponent(trapsTitleLabel)
					.addGap(17)
					.addGroup(gl_trapsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_trapsPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_trapsPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(trapsVertSeparator, GroupLayout.PREFERRED_SIZE, 137, Short.MAX_VALUE)
								.addGroup(gl_trapsPanel.createSequentialGroup()
									.addComponent(trapsEnabled)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(trapsDisabled)
									.addGap(18)
									.addComponent(remoteAccessLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(remoteAccessYes)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(remoteAccessNo))))
						.addGroup(gl_trapsPanel.createSequentialGroup()
							.addGap(55)
							.addComponent(maintenanceTimeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maintenanceCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		trapsPanel.setLayout(gl_trapsPanel);
		
		JPanel sysBUPanel = new JPanel();
		contentPannel.add(sysBUPanel);
		
		JLabel backupTimeLabel = new JLabel("Automated Backup Time:");
		backupTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JComboBox backupTimeCB = new JComboBox();
		backupTimeCB.setBackground(new Color(255, 255, 255));
		backupTimeCB.setFont(new Font("Calibri", Font.PLAIN, 12));
		backupTimeCB.setEnabled(false);
		backupTimeCB.setModel(new DefaultComboBoxModel(new String[] {"00:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM", "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM"}));
		backupTimeCB.setSelectedIndex(1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnBackupNow = new JButton("Backup Now");
		btnBackupNow.setBorder(UIManager.getBorder("Button.border"));
		
		JProgressBar buProgressBar = new JProgressBar();
		
		JLabel systemBackupLabel = new JLabel("  System Backup");
		systemBackupLabel.setOpaque(true);
		systemBackupLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		systemBackupLabel.setBackground(Color.WHITE);
		systemBackupLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		GroupLayout gl_sysBUPanel = new GroupLayout(sysBUPanel);
		gl_sysBUPanel.setHorizontalGroup(
			gl_sysBUPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sysBUPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_sysBUPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sysBUPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(backupTimeCB, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(backupTimeLabel))
					.addGap(57)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_sysBUPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBackupNow)
						.addComponent(buProgressBar, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addGap(75))
				.addComponent(systemBackupLabel, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_sysBUPanel.setVerticalGroup(
			gl_sysBUPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sysBUPanel.createSequentialGroup()
					.addComponent(systemBackupLabel)
					.addGap(6)
					.addGroup(gl_sysBUPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sysBUPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(backupTimeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(backupTimeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_sysBUPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE))
						.addGroup(gl_sysBUPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnBackupNow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		sysBUPanel.setLayout(gl_sysBUPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
