import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author marct002
 *
 */
@SuppressWarnings("serial")
public class MainMenuScreen extends JPanel implements ActionListener {

	MainWindow window;
	JFrame frame;
	
	/**
	 * 
	 */
	public MainMenuScreen(MainWindow window) {
		this.window = window;
		this.frame = window.frame;
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		// components list
		JLabel title = new JLabel("Main Menu");
		
		// initialize components
		title.setFont(new Font("Calibri", Font.BOLD, 64));
		
		this.add(title);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
