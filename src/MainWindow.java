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
	SettingsManager settingsManager = new SettingsManager();
	
	//variables for all content colors and fonts
	private Color primary;
	private Color secondary;
	
//	private Color primary = new Color(255,242,242);
//	private Color secondary = new Color(255,243,221);
	
	private Font titleFont;
	private Font subtitleFont;
	private Font textFont;

//	private Font titleFont = new Font("Arial", Font.BOLD, 20);
//	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
//	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	
	/**
	 * 
	 */
	public MainWindow() {
		currentScreen = new IndividualTrapContent(this, 1);
		primary = settingsManager.getPrimary();
		secondary = settingsManager.getSecondary();
		titleFont = settingsManager.getTitleFont();
		subtitleFont = settingsManager.getSubtitleFont();
		textFont = settingsManager.getTextFont();
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
