import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author marct002
 *
 */
public class MainWindow {
	
	JFrame frame = new JFrame();
	JPanel currentScreen; 
	
	/**
	 * 
	 */
	public MainWindow() {
		currentScreen = new LogInScreen(this);
		frame.add(currentScreen);
		frame.setTitle("Evil Lair Security System");
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting Evil Lair Security System...");
		
		// call constructor to instantiate mainWindow.
		new MainWindow();
	}
	
	public void screenTransition(JPanel newScreen) {
		if (newScreen != null) {
			frame.remove(currentScreen);
			frame.add(newScreen);
			currentScreen = newScreen;
			frame.validate();
			frame.setVisible(true);
		}
	}

	public void dispose() {
		frame.dispose();
		System.exit(0);
	}
}
