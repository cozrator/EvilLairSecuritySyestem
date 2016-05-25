import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * @author watce001
 */
public class MainCameraFeed extends JPanel implements ActionListener, MouseListener{

	MainWindow window;
	
	JFrame feeds;
	
	JFrame cameraFeed;
	ArrayList cameraFeeds;
	GridLayout gl;
	BorderLayout bl;
	int count = 1;
	int num = 0;
	
	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);
	
	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	
	public MainCameraFeed(MainWindow window){
		this.window = window;
		
		cameraFeeds = new ArrayList<JButton>(); // temporary as this may not be necessary
		cameraFeed = new JFrame();
		
		//frame = new JFrame();
		feeds = new JFrame();
		
		gl = new GridLayout();
		gl.setColumns(5);
		gl.setRows(0);
	
		gl.setHgap(10);
		gl.setVgap(10);
		
		bl = new BorderLayout();
		
		this.setLayout(bl);
		
		this.add(createBody(), bl.CENTER);
		this.add(createNorthArea(), bl.NORTH);
		feeds.setVisible(true);
		this.setVisible(true);
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
		JButton areaButton = new JButton("Area Summary");
		JButton securityButton = new JButton("Security Notifications");
		JButton settingsButton = new JButton("Settings");
		FlowLayout layout = new FlowLayout();
		JLabel line1 = new JLabel("|");
		JLabel line2 = new JLabel("|");
		JLabel line3 = new JLabel("|");
		line1.setFont(subtitleFont);
		line2.setFont(subtitleFont);
		line3.setFont(subtitleFont);
		
		//Button Initialization
		menuButton = createSecondaryButtons(menuButton, "MainMenu");
		areaButton = createSecondaryButtons(areaButton, "AreaSummary");
		securityButton = createSecondaryButtons(securityButton, "SecurityNotifications");
		settingsButton = createSecondaryButtons(settingsButton, "Settings");
		
		linkArea.setBackground(secondary);
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

	/**
	 * CENTER
	 * Creates center area
	 * @return
	 */
	private JPanel createBody(){
		JPanel frame = new JPanel();
		frame.setLayout(gl);
		frame.setBackground(Color.WHITE);
		frame.setBorder(new EmptyBorder(100,100,100,100));
		
		//add individual camera feeds to frame
		for(int i = 0; i < 15; i ++){
			JButton newFeed = createCameras();
			newFeed.setActionCommand("OpenCamera"+(count-1));
			newFeed.addActionListener(this);
			//System.out.println(newFeed.getActionCommand());
			frame.add(newFeed);
			cameraFeeds.add(newFeed);
		}
		return frame;
	}
	
	/**
	 * CENTER
	 * Creates all camera feeds in centre area
	 * @return
	 */
	private JButton createCameras(){
		JButton cameraFrame = new JButton();
		if (num == 10){
			num = 3;
		}
		switch(num){
		case(0):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack1.gif")));	
			break;
		case(1):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack2.gif")));
			break;
		case(2):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack3.gif")));
			break;
		case(3):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack4.gif")));
			break;
		case(4):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack5.gif")));
			break;
		case(5):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack6.gif")));
			break;
		case(6):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack7.gif")));
			break;
		case(7):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack8.gif")));
			break;
		case(8):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack9.gif")));
			break;
		case(9):
			cameraFrame = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/jack10.gif")));
			break;
		}
		cameraFrame.addMouseListener(this);
		num++;
		count++;
		return cameraFrame;
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Link Table transitions
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
		//Camera Feed buttons
		else if(e.getActionCommand().equals("OpenCamera1")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(0);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera2")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(1);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 2, false));
		}
		else if(e.getActionCommand().equals("OpenCamera3")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(2);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 6, true));
		}
		else if(e.getActionCommand().equals("OpenCamera4")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(3);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera5")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(4);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera6")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(5);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera7")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(6);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera8")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(7);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera9")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(8);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera10")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(9);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera11")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(10);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera12")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(11);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera13")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(12);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera14")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(13);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		else if(e.getActionCommand().equals("OpenCamera15")){
			JButton camera = new JButton();
			camera = (JButton) cameraFeeds.get(14);
			window.screenTransition(new IndividualCameraFeed(this.window, camera, 4, false));
		}
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("clicked");
//		JPanel singleFeed = (JPanel)frame.getComponentAt(e.getX(), e.getY());
//		
//		System.out.println(singleFeed.getToolTipText());
//		frame.setVisible(false);
//		
//		singleFeed.setVisible(true);
//		this.add(singleFeed, bl.CENTER);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
