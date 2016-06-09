import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class SettingsManager {
	
	//Background colors
	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);


	//Boolean used to keep track of which color blind radio button is selected.
	private boolean cbmOn = false;
	//Boolean used to keep track of which dyslexic radio button is selected.
	private boolean dysOn = true;
	//Sets initial text size combo box to size 14;
	private int textSizeIndex = 1;
	//Actual text size;
	private int actualTextSize = 14;
	//Sets the initial value of the font combo box to Arial.
	private int currentFont = 0;

	//Initial fonts for the screen
	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	

	public Color getPrimary() {
		return primary;
	}
	public void setPrimary(Color primary) {
		this.primary = primary;
	}
	public Color getSecondary() {
		return secondary;
	}
	public void setSecondary(Color secondary) {
		this.secondary = secondary;
	}
	public boolean isCbmOn() {
		return cbmOn;
	}
	public void setCbmOn(boolean cbmOn) {
		this.cbmOn = cbmOn;
	}
	public boolean isDysOn() {
		return dysOn;
	}
	public void setDysOn(boolean dysOn) {
		this.dysOn = dysOn;
	}
	public int getTextSizeIndex() {
		return textSizeIndex;
	}
	public void setTextSizeIndex(int textSizeIndex) {
		this.textSizeIndex = textSizeIndex;
	}
	public int getActualTextSize() {
		return actualTextSize;
	}
	public void setActualTextSize(int actualTextSize) {
		this.actualTextSize = actualTextSize;
	}
	public int getCurrentFont() {
		return currentFont;
	}
	public void setCurrentFont(int currentFont) {
		this.currentFont = currentFont;
	}
	public Font getTitleFont() {
		return titleFont;
	}
	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}
	public Font getSubtitleFont() {
		return subtitleFont;
	}
	public void setSubtitleFont(Font subtitleFont) {
		this.subtitleFont = subtitleFont;
	}
	public Font getTextFont() {
		return textFont;
	}
	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}

}
