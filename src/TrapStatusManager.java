import java.awt.*;
import java.util.Hashtable;

import javax.swing.JLabel;

public class TrapStatusManager {

	public enum Status {
		DEACTIVATED, ACTIVATED, MALFUNTIONING;
	}
	
	Hashtable<Integer, Status> trapStatusTable = new Hashtable<Integer, Status>();
	Hashtable<Integer, String> trapNameTable = new Hashtable<Integer, String>();
	Hashtable<Integer, String> trapDescTable = new Hashtable<Integer, String>();
	Hashtable<Integer, Integer> trapRoomTable = new Hashtable<Integer, Integer>();
	Hashtable<Integer, Integer> trapAreaTable = new Hashtable<Integer, Integer>();
	
	public TrapStatusManager() {
		initTraps();
	}
	
	private void initTraps() {
		this.addTrap(1, 1, 4, Status.ACTIVATED, "Flamethrower Trap", "Perfect for roasting marshmallows!");
		this.addTrap(2, 1, 1, Status.DEACTIVATED, "Pitfall Trap", "Anyone fancy a kebab?");
	}

	public void addTrap(int trapID, int areaID, int roomID, Status status, String name, String description) {
		trapAreaTable.put(trapID, areaID);
		trapRoomTable.put(trapID, roomID);
		trapStatusTable.put(trapID, status);
		trapNameTable.put(trapID, name);
		trapDescTable.put(trapID, description);
	}
	
	public Color getStatusColor(int i){
		Status currentStatus = trapStatusTable.get(i);
		
		switch (currentStatus) {
		case ACTIVATED:
			return Color.GREEN;
		case DEACTIVATED:
			return Color.GRAY;
		case MALFUNTIONING:
			return Color.RED;
		default:
			return Color.ORANGE;
		}
	}

}
