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
	Hashtable<Integer, SelectedArea> trapAreaTable = new Hashtable<Integer, SelectedArea>();
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
		this.addTrap(1, SelectedArea.AREA01, SelectedRoom.ROOM04, Status.ACTIVATED, "Flamethrower Trap", "Perfect for roasting marshmallows!", img, 0.5f, 0.5f, 5, "05/03/2016");
		
		try {
		    img = ImageIO.read(getClass().getResourceAsStream("assets/pitTrap.png"));
		} catch (IOException e) {
			System.out.println("failed");
		}
		this.addTrap(2, SelectedArea.AREA02, SelectedRoom.ROOM02, Status.DEACTIVATED, "PitFall Trap", "Anyone fancy a shish kebab?", img, 0.9f, 0.9f, 3, "23/09/2015");
		
		try {
		    img = ImageIO.read(getClass().getResourceAsStream("assets/pendulumTrap.png"));
		} catch (IOException e) {
			System.out.println("failed");
		}
		this.addTrap(3, SelectedArea.AREA02, SelectedRoom.ROOM05, Status.MALFUNTIONING, "Pendulum Trap", "Finely chopped!", img, 0.5f, 0.5f, 1, "06/07/1996");
		
		try {
		    img = ImageIO.read(getClass().getResourceAsStream("assets/spearTrap.jpg"));
		} catch (IOException e) {
			System.out.println("failed");
		}
		this.addTrap(4, SelectedArea.AREA02, SelectedRoom.ROOM03, Status.ACTIVATED, "Spear Trap", "Stick them full of holes!", img, 0.1f, 0.1f, 4, "09/08/2014");
	}

	public void addTrap(int trapID, SelectedArea areaID, SelectedRoom roomID, Status status, String name, String description, BufferedImage image, float horizontalAlignment, float verticalAlignment, int rating, String date) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButton.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonHovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case DEACTIVATED:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greyButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case MALFUNTIONING:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/redButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				output = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("assets/greenButtonPressed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		
		return output;
	}
	
	public String getName(int i){
		return trapNameTable.get(i);
	}
	
	public String getDesc(int i){
		return trapDescTable.get(i);
	}
	
	public SelectedRoom getRoom(int i){
		return trapRoomTable.get(i);
	}
	
	public int getRoomNum(int i){
		int output = -1;
		switch(trapRoomTable.get(i)){
		case ALL:
			output = 0;
			break;
		case ROOM01:
			output = 1;
			break;
		case ROOM02:
			output = 2;
			break;
		case ROOM03:
			output = 3;
			break;
		case ROOM04:
			output = 4;
			break;
		case ROOM05:
			output = 5;
			break;
		case ROOM06:
			output = 6;
			break;
		case ROOM07:
			output = 7;
			break;
		case ROOM08:
			output = 8;
			break;
		case ROOM09:
			output = 9;
			break;
		case ROOM10:
			output = 10;
			break;
		default:
			output = 0;
			break;
		
		}
		return output;	
	}
	
	public Integer getAreaNum(int i){
		int output = -1;
		switch(trapAreaTable.get(i)) {
		case AREA01:
			output = 1;
			break;
		case AREA02:
			output = 2;
			break;
		case OUTSIDE:
			output = 0;
			break;
		default:
			break;
		}
		return output;
	}
	
	public SelectedArea getArea(int i){
		return trapAreaTable.get(i);
	}
	
	public BufferedImage getImage(int i){
		return trapImageTable.get(i);
	}
	
	public JPanel getRating(int i, Dimension size){
		JPanel output = new JPanel();
		System.out.println(trapRatingTable.get(i));
		int rating = trapRatingTable.get(i);
		FlowLayout fl = new FlowLayout();
		output.setLayout(fl);
		Image goldStar = null;
		try {
			goldStar = ImageIO.read(getClass().getResourceAsStream("assets/goldStar.png"));
			goldStar = goldStar.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
		} catch (IOException e) {
		}
		Image greyStar = null;
		try {
			greyStar = ImageIO.read(getClass().getResourceAsStream("assets/greyStar.png"));
			greyStar = greyStar.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
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
	
	public String getMaintenance(int i) {
		return "Maintenance last performed on: " + trapMaintenanceDateTable.get(i);
	}
	
	public void setStatus(Integer index, Status status){
		this.trapStatusTable.put(index, status);
	}

}
