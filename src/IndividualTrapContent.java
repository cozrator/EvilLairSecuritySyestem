/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harre002
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IndividualTrapContent extends javax.swing.JPanel{
	MainWindow window;
	TrapStatusManager mgr;
	private int index;
	
	private JPanel headerPanel;
	private JPanel footerPanel;
	private JComponent mainContent;
	
	private Color primary = new Color(255,242,242);
	private Color secondary = new Color(255,243,221);

	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
	private Font textFont = new Font("Arial", Font.PLAIN, 14);
	
	public IndividualTrapContent(MainWindow window, int index) {
		this.window = window;
		this.index = index;
		this.mgr = window.trapStatusManager;
		primary = window.settingsManager.getPrimary();
		secondary = window.settingsManager.getSecondary();
		titleFont = window.settingsManager.getTitleFont();
		subtitleFont = window.settingsManager.getSubtitleFont();
		textFont = window.settingsManager.getTextFont();
		
		//this.add(mainContent, BorderLayout.CENTER);
		initComponents();
		
	}
    //@SuppressWarnings("unchecked")
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
        jTextArea1 = new javax.swing.JTextArea();
        mapPanel = new javax.swing.JLabel();

        name.setText(mgr.getName(index));
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(window.settingsManager.getTitleFont());

        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setIcon(new ImageIcon(mgr.getImage(index).getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

        javax.swing.GroupLayout ratingStarsLayout = new javax.swing.GroupLayout(ratingStars);
        ratingStars.setLayout(ratingStarsLayout);
        ratingStarsLayout.setHorizontalGroup(
            ratingStarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        ratingStarsLayout.setVerticalGroup(
            ratingStarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        maintenenceStatus.setText("maintenence status");

        statusColour.setText("indicator");

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

        description.setText(mgr.getDesc(index));
        description.setFont(window.settingsManager.getSubtitleFont());
        description.setColumns(20);
        description.setRows(5);
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        mapPanel.setText("Map");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(areaNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roomNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(111, 111, 111)
                                        .addComponent(ratingStars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MaintenanceReqBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(maintenenceStatus))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(statusColour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ToggleArmed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ratingStars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maintenenceStatus)
                            .addComponent(MaintenanceReqBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(areaNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomNumber)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ToggleArmed, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusColour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel maintenenceStatus;
    private javax.swing.JLabel mapPanel;
    private javax.swing.JLabel name;
    private javax.swing.JPanel ratingStars;
    private javax.swing.JLabel roomNumber;
    private javax.swing.JLabel statusColour;
    // End of variables declaration//GEN-END:variables

}
