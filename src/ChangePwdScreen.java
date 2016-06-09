import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ChangePwdScreen extends JDialog implements ActionListener {

	//Global variables
	int width = 400;
	int height = 110;
	BorderLayout bl = new BorderLayout();
	int x = ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (width/2));
	int y = ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (height/2));



	ChangePwdScreen(){
		this.setModal(true);
		this.setSize(width, height);
		this.setLocation(x,y);
		getContentPane().setLayout(bl);
		this.setMinimumSize(new Dimension(width, height));
		getContentPane().add(createInfoPane(), BorderLayout.CENTER);
		getContentPane().add(createButtonPane(), BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
		this.setVisible(true);

	}


	/**
	 * Creates the 'OK' button at the bottom of the about panel.
	 * @return - A JPanel containing the 'OK' button.
	 */
	private JPanel createButtonPane(){
		JPanel buttonPane = new JPanel();
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(this);

		buttonPane.add(okButton);

		return buttonPane;
	}


	private JPanel createInfoPane(){
		JPanel infoPane = new JPanel();
		JLabel pwdMessage = new JLabel("A request to change your password has been sent.");

		infoPane.add(pwdMessage);
		
		return infoPane;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("OK")){
			this.setVisible(false);
		}

	}



}
