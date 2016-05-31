import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public abstract class TrapContent extends JDesktopPane {

	private SelectedArea selectedArea;
	private SelectedRoom selectedRoom;
	
	public TrapContent() {
		super();
		selectedArea = SelectedArea.OUTSIDE;
		selectedRoom = SelectedRoom.ALL;
	}
	
	public void setSelectedArea(SelectedArea area) {
		selectedArea = area;
	}
	
	public void setSelectedRoom(SelectedRoom room) {
		selectedRoom = room;
	}
	
	public SelectedArea getSelectedArea() {
		return selectedArea;
	}
	
	public SelectedRoom getSelectedRoom() {
		return selectedRoom;
	}
	
	public void remake() {
	}

}
