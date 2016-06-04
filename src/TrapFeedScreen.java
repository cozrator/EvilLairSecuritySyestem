import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * * @author Corey
 */
public class TrapFeedScreen extends JPanel {

	MainWindow window;
	private JButton searchButton;
	private JComboBox<String> areaFilterCB;
	private JComboBox<String> roomFilterCB;
	private JLabel filterLabel;
	private JPanel headerPanel;
	private JPanel footerPanel;
	private JComponent mainContent;
	private JRadioButton mapModeRB;
	private JRadioButton listModeRB;
	private ButtonGroup modeButtonGroup;
	private JTextField searchField;
	private SelectedArea selectedArea;
	private SelectedRoom selectedRoom;

	/**
	 * Creates new form NewJPanel
	 */
	public TrapFeedScreen(MainWindow window) {
		this.window = window;
		selectedArea = selectedArea.OUTSIDE;
		selectedRoom = SelectedRoom.ALL;
		mainContent = new TrapMapContent(window, this.selectedArea, this.selectedRoom);
		initComponents();
	}

	private void initComponents() {

		modeButtonGroup = new javax.swing.ButtonGroup();
		headerPanel = new javax.swing.JPanel();
		areaFilterCB = new javax.swing.JComboBox<>();
		searchField = new javax.swing.JTextField();
		searchButton = new javax.swing.JButton();
		filterLabel = new javax.swing.JLabel();
		roomFilterCB = new javax.swing.JComboBox<>();
		roomFilterCB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				roomSelected(evt);
			}
		});
		footerPanel = new javax.swing.JPanel();
		listModeRB = new javax.swing.JRadioButton();
		mapModeRB = new javax.swing.JRadioButton();

		areaFilterCB
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Area", "Area01", "Area02" }));
		areaFilterCB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				areaSelected(evt);
			}
		});

		searchField.setText("search");

		searchButton.setText("Go");

		filterLabel.setText("Filter:");

		roomFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Select Room", "Room01", "Room02", "Room03", "Room04", "Room05" }));
		roomFilterCB.setEnabled(false);

		javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(headerPanel);
		headerPanel.setLayout(headerLayout);
		headerLayout.setHorizontalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						headerLayout.createSequentialGroup().addContainerGap()
								.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(searchButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21,
										Short.MAX_VALUE)
								.addComponent(filterLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(areaFilterCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(roomFilterCB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		headerLayout.setVerticalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(headerLayout.createSequentialGroup().addContainerGap().addGroup(headerLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addComponent(searchField)
						.addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(areaFilterCB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(filterLabel).addComponent(roomFilterCB,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(14, Short.MAX_VALUE)));

		modeButtonGroup.add(listModeRB);
		listModeRB.setText("ListMode");
		listModeRB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				listModeRBActionPerformed(evt);
			}
		});

		modeButtonGroup.add(mapModeRB);
		mapModeRB.setSelected(true);
		mapModeRB.setText("Map Mode");
		mapModeRB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mapModeRBActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footerPanel);
		footerPanel.setLayout(footerLayout);
		footerLayout.setHorizontalGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						footerLayout.createSequentialGroup().addContainerGap().addComponent(mapModeRB)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(listModeRB).addContainerGap()));
		footerLayout
				.setVerticalGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								footerLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(footerLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(listModeRB).addComponent(mapModeRB))
										.addContainerGap()));

		javax.swing.GroupLayout mainContentLayout = new javax.swing.GroupLayout(mainContent);
		mainContentLayout.setHorizontalGroup(mainContentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		mainContentLayout.setVerticalGroup(mainContentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 303, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(footerPanel,
						javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));
		
		mainContent.setBackground(new Color(235,235,235));
		
		switch (selectedArea) {
		case AREA01:
			areaFilterCB.setSelectedIndex(1);
			break;
		case AREA02:
			areaFilterCB.setSelectedIndex(2);
			break;
		case OUTSIDE:
			areaFilterCB.setSelectedIndex(0);
			break;
		default:
			break;
		}
		
		switch (selectedRoom) {
		case ALL:
			areaFilterCB.setSelectedIndex(0);
			break;
		case ROOM01:
			areaFilterCB.setSelectedIndex(1);
			break;
		case ROOM02:
			areaFilterCB.setSelectedIndex(2);
			break;
		case ROOM03:
			areaFilterCB.setSelectedIndex(3);
			break;
		case ROOM04:
			areaFilterCB.setSelectedIndex(4);
			break;
		case ROOM05:
			areaFilterCB.setSelectedIndex(5);
			break;
		case ROOM06:
			areaFilterCB.setSelectedIndex(6);
			break;
		default:
			break;
		}
	}

	private void areaSelected(java.awt.event.ActionEvent evt) {
		int index = areaFilterCB.getSelectedIndex();
		if (mainContent instanceof TrapMapContent) {
			if (index > 0) {
				roomFilterCB.setEnabled(true);
				if (index == 1) {
					((TrapMapContent) mainContent).loadImage("assets/inside1.jpg");
					((TrapMapContent) mainContent).setSelectedArea(SelectedArea.AREA01);
					selectedArea = SelectedArea.AREA01;
					roomFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(
							new String[] { "Select Room", "Room01", "Room02", "Room03", "Room04", "Room05" }));
				} else if (index == 2) {
					((TrapMapContent) mainContent).loadImage("assets/inside2.jpg");
					((TrapMapContent) mainContent).setSelectedArea(SelectedArea.AREA02);
					selectedArea = SelectedArea.AREA02;
					roomFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room", "Room01",
							"Room02", "Room03", "Room04", "Room05", "Room06" }));
				}
			} else {
				roomFilterCB.setEnabled(false);
				((TrapMapContent) mainContent).setSelectedArea(SelectedArea.OUTSIDE);
				selectedArea = SelectedArea.OUTSIDE;
				((TrapMapContent) mainContent).loadImage("assets/outside.jpg");
			}
			((TrapMapContent) mainContent).remake();
		}
	}

	private void roomSelected(ActionEvent evt) {
		int index = roomFilterCB.getSelectedIndex();
		if (mainContent instanceof TrapContent) {
			switch (index) {
			case 0:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ALL);
				selectedRoom = SelectedRoom.ALL;
				break;
			case 1:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM01);
				selectedRoom = SelectedRoom.ROOM01;
				break;
			case 2:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM02);
				selectedRoom = SelectedRoom.ROOM02;
				break;
			case 3:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM03);
				selectedRoom = SelectedRoom.ROOM03;
				break;
			case 4:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM04);
				selectedRoom = SelectedRoom.ROOM04;
				break;
			case 5:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM05);
				selectedRoom = SelectedRoom.ROOM05;
				break;
			case 6:
				((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM06);
				selectedRoom = SelectedRoom.ROOM06;
				break;
			}

			((TrapContent) mainContent).remake();
		}
	}

	private void mapModeRBActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("map");
		this.remove(mainContent);
		mainContent = new TrapMapContent(window, this.selectedArea, this.selectedRoom);
		initComponents();
		this.validate();
	}

	private void listModeRBActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("list");
		this.remove(mainContent);
		mainContent = new TrapListContent(window, this.selectedArea, this.selectedRoom);
		initComponents();
		mainContent.validate();
	}
}
