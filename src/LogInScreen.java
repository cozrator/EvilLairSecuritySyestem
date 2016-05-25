/**
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author watce001
 */
@SuppressWarnings("serial")
public class LogInScreen extends JPanel implements ActionListener {
	
MainWindow window;
	

	private JTextField usernameArea = new JTextField();
	private JPasswordField passwordArea = new JPasswordField();

	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);
	
	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	
	/**
	 * Constructor, Creating a window of specified width and height.
	 */
	public LogInScreen(MainWindow window) {
		this.window = window;
		
		this.setLayout(new BorderLayout());
		
		this.add(headerArea(), BorderLayout.NORTH);
		this.add(createLoginArea(), BorderLayout.CENTER);
	}
	
	public JPanel createLoginArea(){
		//Sets underline
		Map attributes = textFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		JPanel loginArea = new JPanel();
		GridLayout gl = new GridLayout(0,2);
		
		JTextField username = createTextArea("Username: ");
		JTextField password = createTextArea("Password: ");
		
		JButton enter = new JButton("Enter");
		JButton clear = new JButton("Clear");
		
		gl.setVgap(10);
		gl.setHgap(10);
		
		//Initializing buttons
		enter.setBackground(secondary);
		enter.setOpaque(true);
		enter.setBorderPainted(false);
		enter.setFont(textFont.deriveFont(attributes));
		enter.setForeground(Color.black);
		enter.setActionCommand("Enter");
		enter.addActionListener(this);
		
		clear.setBackground(secondary);
		clear.setOpaque(true);
		clear.setBorderPainted(false);
		clear.setFont(textFont.deriveFont(attributes));
		clear.setForeground(Color.black);
		clear.setActionCommand("Clear");
		clear.addActionListener(this);
		
		
		password.setBackground(secondary);
		username.setBackground(secondary);
		
		passwordArea.setEchoChar('*');
		
		loginArea.setBackground(secondary);
		loginArea.setBorder(new EmptyBorder(430,800,430,800));
		loginArea.setLayout(gl);
		loginArea.add(username);
		loginArea.add(usernameArea);
		loginArea.add(password);
		loginArea.add(passwordArea);
		loginArea.add(enter);
		loginArea.add(clear);
		
		return loginArea;
	}
	
	public JPanel headerArea(){
		JPanel headerArea = new JPanel();
		
		String titleText = "Evil OS";
		JLabel title = new JLabel("<html><div style='text-align: center;'><div style='text-align: center;'>" + titleText + "</html>", SwingConstants.CENTER);
		title.setFont(titleFont);
		
		headerArea.setBackground(primary);
		headerArea.setBorder(new EmptyBorder(20,0,20,0));
		headerArea.add(title);
		
		return headerArea;
	}
	
	/**
	 * creates text field
	 * @param txt - 
	 * @return
	 */
	private JTextField createTextArea(String txt){
		JTextField txtArea = new JTextField();
		txtArea.setFont(textFont);
		txtArea.setText(txt);
		txtArea.setEditable(false);
		txtArea.setBorder(null);
		return txtArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enter")){
			window.screenTransition(new MainMenuScreen(this.window));
		}
		else if(e.getActionCommand().equals("Clear")){
			usernameArea.setText("");
			passwordArea.setText("");
			
		}
	}

//  /**
//	 * @author marct002
//	 */
//	MainWindow window;
//	JFrame frame;
//	
//	JTextField usernameField = new JTextField();
//	JPasswordField passwordField = new JPasswordField();
//
//	/**
//	 * Constructor, Creating a window of specified width and height.
//	 */
//	public LogInScreen(MainWindow window) {
//		
//		this.window = window;
//		this.frame = window.frame;
//		
//		// components list
//		String titleText = "EVIL OS";
//		JLabel title = new JLabel("<html><div style='text-align: center;'><div style='text-align: center;'>" + titleText + "</html>", SwingConstants.CENTER);
//		JLabel usernameLabel = new JLabel("Username: ");
//		JLabel passwordLabel = new JLabel("Password: ");
//		JButton loginButton = new JButton("Login");		
//		JButton cancelButton = new JButton("Cancel");
//		
//		// initialize components
//		title.setFont(new Font("Calibri", Font.BOLD, 64));
//		loginButton.setActionCommand("Login");
//		loginButton.addActionListener(this);
//		cancelButton.setActionCommand("Cancel");
//		cancelButton.addActionListener(this);
//		
//		GroupLayout gl = new GroupLayout(this);
//		this.setLayout(gl);	
//		gl.setAutoCreateGaps(true);
//		gl.setAutoCreateContainerGaps(true);
//		
//		gl.setHorizontalGroup(
//				gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING))
//						.addComponent(title)
//						.addGroup(gl.createSequentialGroup()
//							.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//								.addComponent(usernameLabel)
//								.addComponent(passwordLabel)
//								.addComponent(cancelButton))
//							.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
//								.addComponent(usernameField)
//								.addComponent(passwordField)
//								.addComponent(loginButton)))
//					
//		);
//		gl.setVerticalGroup(
//				gl.createSequentialGroup()
//					.addComponent(title)
//					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//						.addComponent(usernameLabel)
//						.addComponent(usernameField))
//					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//						.addComponent(passwordLabel)
//						.addComponent(passwordField))
//					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
//						.addComponent(loginButton)
//						.addComponent(cancelButton))
//		);
//		
//		gl.linkSize(SwingConstants.HORIZONTAL, loginButton, cancelButton, usernameLabel, usernameField, passwordLabel, passwordField);
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("Cancel")) {
//			window.dispose();
//		}
//		else if(e.getActionCommand().equals("Login")) {
//			//this is where database checking would occur but for the prototype it will just compare here for the expected result.
//			boolean expectedResult = false;
//
//			if(passwordField.getPassword().equals(retrievePassword(usernameField.getText()))); {
//				System.out.println("Login Correct");
//				expectedResult = true;
//			}
//			
//			if(expectedResult) {
//				window.screenTransition(new MainMenuScreen(this.window));
//			}
//			
//		}
//	}
//	
//	private char[] retrievePassword(String username) {
//		if(username.equals("admin"));
//		{
//			char[] password = {'p','a','s','s','w','o','r','d'};
//			return password;
//		}
//	}
}