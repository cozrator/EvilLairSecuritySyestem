import java.awt.*;
import javax.swing.*;

/**
 * * @author Corey
 */
@SuppressWarnings("serial")
public class TrapCell extends TrapContent {
	
	MainWindow window;
	TrapStatusManager mgr;
	int index;
	
    private JLabel areaLabel;
    private JLabel descLabel;
    private JLabel imageLabel;
    private JButton moreButton;
    private JPanel contentPanel;
    private JLabel maintenanceLabel;
    private JLabel nameLabel;
    private JPanel ratingPanel;
    private JLabel roomLabel;
    private JLabel statusLabel;

    /**
     * Creates new form TrapCell
     */
    public TrapCell(MainWindow window, int index) {
    	this.window = window;
    	this.index = index;
    	this.mgr = window.trapStatusManager;
        initComponents();
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */                 
    private void initComponents() {
  
        ratingPanel = mgr.getRating(index, new Dimension(40,40));
        nameLabel = new JLabel();
        maintenanceLabel = new JLabel();
        statusLabel = new JLabel();
        imageLabel = new JLabel();
        contentPanel = new JPanel();
        areaLabel = new JLabel();
        roomLabel = new JLabel();
        descLabel = new JLabel();
        moreButton = new JButton();

//        GroupLayout ratingPanelLayout = new GroupLayout(ratingPanel);
//        ratingPanel.setLayout(ratingPanelLayout);
//        ratingPanelLayout.setHorizontalGroup(
//            ratingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 341, Short.MAX_VALUE)
//        );
//        ratingPanelLayout.setVerticalGroup(
//            ratingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 0, Short.MAX_VALUE)
//        );

        nameLabel.setText(mgr.getName(index));
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(window.titleFont);

        maintenanceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        maintenanceLabel.setText(mgr.getMaintenance(index));
        maintenanceLabel.setVerticalAlignment(SwingConstants.CENTER);
        maintenanceLabel.setFont(window.subtitleFont);

        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon(mgr.getImage(index).getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

        String prefix = "Area: ";
        int areaNum = mgr.getAreaNum(index);
        if (areaNum < 10){
        	prefix = prefix + "0";
        }
        areaLabel.setText(prefix + areaNum);
        areaLabel.setVerticalAlignment(SwingConstants.TOP);
        areaLabel.setFont(window.subtitleFont);
        
        prefix = "Room: ";
        int roomNum = mgr.getRoomNum(index);
        if (roomNum < 10){
        	prefix = prefix + "0";
        }
        roomLabel.setText(prefix + roomNum);
        roomLabel.setVerticalAlignment(SwingConstants.TOP);
        roomLabel.setFont(window.subtitleFont);

        descLabel.setText(mgr.getDesc(index));
        descLabel.setVerticalAlignment(SwingConstants.TOP);
        descLabel.setFont(window.subtitleFont);

        moreButton.setText("MORE");
        moreButton.setFont(window.subtitleFont);

        GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(roomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(areaLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moreButton)
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descLabel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moreButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(maintenanceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ratingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maintenanceLabel, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ratingPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(imageLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }                 
}
