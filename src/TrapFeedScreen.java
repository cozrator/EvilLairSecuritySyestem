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
	private JRadioButton listModeRB;
	private JRadioButton mapModeRB;
	private ButtonGroup modeButtonGroup;
	private JTextField searchField;

	/**
	 * Creates new form NewJPanel
	 */
	public TrapFeedScreen(MainWindow window) {
		this.window = window;
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
		mapModeRB = new javax.swing.JRadioButton();
		listModeRB = new javax.swing.JRadioButton();
		mainContent = new TrapMapContent(window);

		areaFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Area", "Area01", "Area02" }));
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

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(headerPanel);
		headerPanel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap()
								.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(searchButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21,
										Short.MAX_VALUE)
								.addComponent(filterLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(areaFilterCB, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(roomFilterCB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout
										.createSequentialGroup().addContainerGap()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(searchField)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(searchButton,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 0,
																Short.MAX_VALUE)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(areaFilterCB,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(filterLabel).addComponent(roomFilterCB,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(14, Short.MAX_VALUE)));

		modeButtonGroup.add(mapModeRB);
		mapModeRB.setText("ListMode");
		mapModeRB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mapModeRBActionPerformed(evt);
			}
		});

		modeButtonGroup.add(listModeRB);
		listModeRB.setSelected(true);
		listModeRB.setText("Map Mode");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(footerPanel);
		footerPanel.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(listModeRB)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(mapModeRB).addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(mapModeRB).addComponent(listModeRB))
										.addContainerGap()));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(mainContent);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 303, Short.MAX_VALUE));

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
	}

	private void areaSelected(java.awt.event.ActionEvent evt) {
		int index = areaFilterCB.getSelectedIndex();
		if (mainContent instanceof TrapMapContent) {
			if (index > 0) {
				roomFilterCB.setEnabled(true);
				System.out.println(index);
				if (index == 1) {
					((TrapMapContent) mainContent).loadImage("assets/inside1.jpg");
					((TrapMapContent) mainContent).setSelectedArea(SelectedArea.AREA01);
					roomFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(
							new String[] { "Select Room", "Room01", "Room02", "Room03", "Room04", "Room05" }));
				} else if (index == 2) {
					((TrapMapContent) mainContent).loadImage("assets/inside2.jpg");
					((TrapMapContent) mainContent).setSelectedArea(SelectedArea.AREA02);
					roomFilterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room", "Room01",
							"Room02", "Room03", "Room04", "Room05", "Room06" }));
				}
			} else {
				roomFilterCB.setEnabled(false);
				((TrapMapContent) mainContent).setSelectedArea(SelectedArea.OUTSIDE);
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
					break;
				case 1:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM01);
					break;
				case 2:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM02);
					break;
				case 3:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM03);
					break;
				case 4:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM04);
					break;
				case 5:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM05);
					break;
				case 6:
					((TrapContent) mainContent).setSelectedRoom(SelectedRoom.ROOM06);
					break;
				}
				
			((TrapContent) mainContent).remake();
		}
	}

	private void mapModeRBActionPerformed(java.awt.event.ActionEvent evt) {

	}
}
