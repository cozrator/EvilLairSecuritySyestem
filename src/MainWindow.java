import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 
 */

/**
 * @author marct002
 *
 */
public class MainWindow {
	
	JFrame frame = new JFrame();
	JComponent currentScreen;
	TrapStatusManager trapStatusManager = new TrapStatusManager();
	
	/**
	 * 
	 */
	public MainWindow() {
		currentScreen = new TrapFeedScreen(this);
		frame.add(currentScreen);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
