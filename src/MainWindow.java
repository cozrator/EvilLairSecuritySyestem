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
	
	//variables for all content colors and fonts
	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);

	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	
	/**
	 * 
	 */
	public MainWindow() {
		currentScreen = new LogInScreen(this);
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
	
	/**
	 * @return the primary color
	 */
	public Color getPrimary() {
		return primary;
	}

	/**
	 * @param primary, the Color to set as the primary color.
	 */
	public void setPrimary(Color primary) {
		this.primary = primary;
	}

	/**
	 * @return the secondary color
	 */
	public Color getSecondary() {
		return secondary;
	}

	/**
	 * @param secondary, the Color to set as the secondary color.
	 */
	public void setSecondary(Color secondary) {
		this.secondary = secondary;
	}

	/**
	 * @return the titleFont
	 */
	public Font getTitleFont() {
		return titleFont;
	}

	/**
	 * @param titleFont, the Font to set for titles
	 */
	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}

	/**
	 * @return the subtitleFont
	 */
	public Font getSubtitleFont() {
		return subtitleFont;
	}

	/**
	 * @param subtitleFont, the Font to set for the sub titles.
	 */
	public void setSubtitleFont(Font subtitleFont) {
		this.subtitleFont = subtitleFont;
	}

	/**
	 * @return the textFont
	 */
	public Font getTextFont() {
		return textFont;
	}

	/**
	 * @param textFont, the Font to set for text
	 */
	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}

	public void dispose() {
		frame.dispose();
		System.exit(0);
	}
}
