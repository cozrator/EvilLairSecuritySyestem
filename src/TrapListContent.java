
public class TrapListContent extends TrapContent {
	
	MainWindow window;

	public TrapListContent(MainWindow window, SelectedArea area, SelectedRoom room) {
		super();
		this.setSelectedArea(area);
		this.setSelectedRoom(room);
		this.window = window;
	}

}
