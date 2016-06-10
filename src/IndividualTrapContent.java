/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class IndividualTrapContent extends javax.swing.JPanel{
	MainWindow window;
	TrapStatusManager mgr;
	private int index;
	
	public IndividualTrapContent(MainWindow window, int index) {
		this.window = window;
		this.index = index;
		this.mgr = window.trapStatusManager;
		initComponents();
	}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        ratingStars = new javax.swing.JPanel();
        maintenenceStatus = new javax.swing.JLabel();
        statusColour = new javax.swing.JLabel();
        areaNumber = new javax.swing.JLabel();
        roomNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        MaintenanceReqBtn = new javax.swing.JButton();
        ToggleArmed = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        performanceReport = new javax.swing.JTextArea();
        mapPanel = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1080, 1920));

        name.setText(mgr.getName(index));
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(window.settingsManager.getTitleFont());

        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setIcon(new ImageIcon(mgr.getImage(index).getScaledInstance(400, 400, Image.SCALE_DEFAULT)));

        ratingStars = mgr.getRating(index, new Dimension(40,40));

        maintenenceStatus.setText(mgr.getMaintenance(index));
        
        statusColour.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));


        String prefix = "Area: ";
        int areaNum = mgr.getAreaNum(index);
        if (areaNum < 10){
            prefix = prefix + "0";
        }
        areaNumber.setText(prefix + areaNum);
        areaNumber.setVerticalAlignment(SwingConstants.TOP);
        areaNumber.setFont(window.settingsManager.getSubtitleFont());

        prefix = "Room: ";
        int roomNum = mgr.getRoomNum(index);
        if (roomNum < 10){
            prefix = prefix + "0";
        }
        roomNumber.setText(prefix + roomNum);
        roomNumber.setVerticalAlignment(SwingConstants.TOP);
        roomNumber.setFont(window.settingsManager.getSubtitleFont());

        description.setColumns(20);
        description.setRows(5);
        description.setText(mgr.getDesc(index));
        description.setFont(window.settingsManager.getSubtitleFont());
        jScrollPane1.setViewportView(description);

        MaintenanceReqBtn.setText("Maintenance request");
        MaintenanceReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaintenanceReqBtnActionPerformed(evt);
            }
        });

        ToggleArmed.setText("Arm");
        ToggleArmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleArmedActionPerformed(evt);
            }
        });

        performanceReport.setColumns(20);
        performanceReport.setRows(5);
        jScrollPane2.setViewportView(performanceReport);

        BufferedImage img = null;
		try {
		    img = ImageIO.read(getClass().getResourceAsStream("assets/EvilLairTrapLocation.png"));
		} catch (IOException e) {
			System.out.println("failed");
		}
        mapPanel.setIcon(new ImageIcon(img));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ratingStars, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MaintenanceReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                        .addComponent(maintenenceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(areaNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roomNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(statusColour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ToggleArmed, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ratingStars, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maintenenceStatus)
                                .addGap(7, 7, 7)
                                .addComponent(areaNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomNumber))
                            .addComponent(MaintenanceReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ToggleArmed, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusColour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MaintenanceReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaintenanceReqBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaintenanceReqBtnActionPerformed

    private void ToggleArmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToggleArmedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ToggleArmedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MaintenanceReqBtn;
    private javax.swing.JToggleButton ToggleArmed;
    private javax.swing.JLabel areaNumber;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel maintenenceStatus;
    private javax.swing.JLabel mapPanel;
    private javax.swing.JLabel name;
    private javax.swing.JTextArea performanceReport;
    private javax.swing.JPanel ratingStars;
    private javax.swing.JLabel roomNumber;
    private javax.swing.JLabel statusColour;
    // End of variables declaration//GEN-END:variables

}
