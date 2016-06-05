import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TrapStatusManager {

	public enum Status {
		DEACTIVATED, ACTIVATED, MALFUNTIONING;
	}
	
	ArrayList<Integer> ids = new ArrayList<Integer>();
	Hashtable<Integer, Status> trapStatusTable = new Hashtable<Integer, Status>();
	Hashtable<Integer, String> trapNameTable = new Hashtable<Integer, String>();
	Hashtable<Integer, String> trapDescTable = new Hashtable<Integer, String>();
	Hashtable<Integer, SelectedRoom> trapRoomTable = new Hashtable<Integer, SelectedRoom>();
	Hashtable<Integer, Integer> trapAreaTable = new Hashtable<Integer, Integer>();
	Hashtable<Integer, BufferedImage>  trapImageTable = new Hashtable<Integer, BufferedImage>();
	Hashtable<Integer, Float> trapHorizontalAlignmentTable = new Hashtable<Integer, Float>();
	Hashtable<Integer, Float> trapVerticalAlignmentTable = new Hashtable<Integer, Float>();
	Hashtable<Integer, Integer> trapRatingTable = new Hashtable<Integer, Integer>();
	Hashtable<Integer, String> trapMaintenanceDateTable = new Hashtable<Integer, String>();
	
	TrapStatusManager() {
		initTraps();
	}
	
	private void initTraps() {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(getClass().getResourceAsStream("assets/flame.jpg"));
		} catch (IOException e) {
			System.out.println("failed");
		}
		this.addTrap(1, 1, SelectedRoom.ROOM04, Status.ACTIVATED, "Flamethrower Trap", "Perfect for roasting marshmallows!", img, 0f, 0f, 3, "05/03/2016");
		System.out.println(ids);
	}

	public void addTrap(int trapID, int areaID, SelectedRoom roomID, Status status, String name, String description, BufferedImage image, float horizontalAlignment, float verticalAlignment, int rating, String date) {
		trapAreaTable.put(trapID, areaID);
		trapRoomTable.put(trapID, roomID);
		trapStatusTable.put(trapID, status);
		trapNameTable.put(trapID, name);
		trapDescTable.put(trapID, description);
		trapImageTable.put(trapID, image);
		trapHorizontalAlignmentTable.put(trapID, horizontalAlignment);
		trapVerticalAlignmentTable.put(trapID, verticalAlignment);
		if(rating > 5) {
			rating = 5;
		}
		else if(rating < 0) {
			rating = 0;
		}
		trapRatingTable.put(trapID, rating);
		trapMaintenanceDateTable.put(trapID, date);
		ids.add(trapID);
	}
	
	public ImageIcon getStatusColor(int i){
		Status currentStatus = trapStatusTable.get(i);
		ImageIcon output = new ImageIcon();
		switch (currentStatus) {
		case ACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButton.png")));
				System.out.println("gotHere");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return output;
	}
	
	public ImageIcon getStatusHovered(int i){
		Status currentStatus = trapStatusTable.get(i);
		ImageIcon output = new ImageIcon();
		
		switch (currentStatus) {
		case ACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonHovered.png")));
				System.out.println("gotHere");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return output;
	}
	
	public ImageIcon getStatusPressed(int i){
		Status currentStatus = trapStatusTable.get(i);
		ImageIcon output = new ImageIcon();
		
		switch (currentStatus) {
		case ACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonPressed.png")));
				System.out.println("gotHere");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return output;
	}
	
	public JLabel getName(int i){
		return new JLabel(trapNameTable.get(i));
	}
	
	public JLabel getDesc(int i){
		return new JLabel(trapDescTable.get(i));
	}
	
	public SelectedRoom getRoom(int i){
		return trapRoomTable.get(i);
	}
	
	public Integer getArea(int i){
		return trapAreaTable.get(i);
	}
	
	public BufferedImage getImage(int i){
		return trapImageTable.get(i);
	}
	
	public JPanel getRating(int i){
		JPanel output = new JPanel();
		System.out.println(i);
		System.out.println(trapRatingTable.get(i));
		int rating = trapRatingTable.get(i);
		FlowLayout fl = new FlowLayout();
		output.setLayout(fl);
		BufferedImage goldStar = null;
		try {
			goldStar = ImageIO.read(getClass().getResourceAsStream("assets/goldStar.png"));
		} catch (IOException e) {
		}
		BufferedImage greyStar = null;
		try {
			greyStar = ImageIO.read(getClass().getResourceAsStream("assets/greyStar.png"));
		} catch (IOException e) {
		}
		
		for(int index = 1; index <= 5; index++) {
			JLabel label = new JLabel();
			label.setSize(10, 10);
			if(index <= rating) {
				label.setIcon(new ImageIcon(goldStar));
			}
			else {
				label.setIcon(new ImageIcon(greyStar));
			}
			output.add(label);
		}
		return output;
	}
	
	public float getHorizontalAlignment(int i){
		return trapHorizontalAlignmentTable.get(i);
	}
	
	public float getVerticalAlignment(int i){
		return trapVerticalAlignmentTable.get(i);
	}
	
	public JLabel getMaintenance(int i) {
		return new JLabel("Maintenance last performed on: " + trapMaintenanceDateTable.get(i));
	}

}
