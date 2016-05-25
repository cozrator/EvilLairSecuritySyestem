/**
 * 
 */
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author marct002
 *
 */
@SuppressWarnings("serial")
public class LogInScreen extends JPanel implements ActionListener {
	
	MainWindow window;
	JFrame frame;
	
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();

	/**
	 * Constructor, Creating a window of specified width and height.
	 */
	public LogInScreen(MainWindow window) {
		
		this.window = window;
		this.frame = window.frame;
		
		// components list
		String titleText = "EVIL OS";
		JLabel title = new JLabel("<html><div style='text-align: center;'><div style='text-align: center;'>" + titleText + "</html>", SwingConstants.CENTER);
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JButton loginButton = new JButton("Login");		
		JButton cancelButton = new JButton("Cancel");
		
		// initialize components
		title.setFont(new Font("Calibri", Font.BOLD, 64));
		loginButton.setActionCommand("Login");
		loginButton.addActionListener(this);
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);	
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);
		
		gl.setHorizontalGroup(
				gl.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING))
						.addComponent(title)
						.addGroup(gl.createSequentialGroup()
							.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(usernameLabel)
								.addComponent(passwordLabel)
								.addComponent(cancelButton))
							.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(usernameField)
								.addComponent(passwordField)
								.addComponent(loginButton)))
					
		);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
					.addComponent(title)
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameField))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(passwordLabel)
						.addComponent(passwordField))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(cancelButton))
		);
		
		gl.linkSize(SwingConstants.HORIZONTAL, loginButton, cancelButton, usernameLabel, usernameField, passwordLabel, passwordField);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancel")) {
			window.dispose();
		}
		else if(e.getActionCommand().equals("Login")) {
			//this is where database checking would occur but for the prototype it will just compare here for the expected result.
			boolean expectedResult = false;

			if(passwordField.getPassword().equals(retrievePassword(usernameField.getText()))); {
				System.out.println("Login Correct");
				expectedResult = true;
			}
			
			if(expectedResult) {
				window.screenTransition(new MainMenuScreen(this.window));
			}
			
		}
	}
	
	private char[] retrievePassword(String username) {
		if(username.equals("admin"));
		{
			char[] password = {'p','a','s','s','w','o','r','d'};
			return password;
		}
	}
}
