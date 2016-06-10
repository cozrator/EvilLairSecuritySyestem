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
import javax.swing.JButton;
import javax.swing.JScrollPane;
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
        ToggleArmed = new javax.swing.JButton();
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
        description.setText(mgr.getDesc(index)+ "\n Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tempor purus. Nam rhoncus quam non tincidunt vulputate. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed et nulla sed ante facilisis rutrum. Mauris laoreet ante ac dapibus volutpat. Aliquam ipsum leo, sollicitudin sed fringilla eu, accumsan ac lectus. Praesent non leo pulvinar, egestas enim faucibus, maximus risus. Integer convallis, eros ac malesuada bibendum, nisl metus aliquam nunc, pretium fringilla lectus lacus et ex. Nulla imperdiet accumsan quam vulputate fermentum. Sed sollicitudin eget nunc sit amet iaculis. Fusce ut ex vitae ex fermentum varius. Ut congue tincidunt odio at porttitor. Phasellus elementum tempor dolor eu suscipit. Sed tristique ut mi sit amet dignissim. Nam faucibus sagittis lacus nec elementum. Cras sollicitudin tincidunt metus mattis iaculis.Etiam semper odio ligula, eu varius est viverra in. Nunc at nisi at nulla ve nenatis tincidunt. Nulla maximus fringilla mauris a suscipit. Aliquam quis mi viverra, auctor diam tristique, eleifend leo. Morbi ultrices dolor ut odio iaculis luctus. Maecenas sed nisl tortor. Etiam ut velit auctor nunc aliquet euismod. Donec quis ante metus. Sed urna quam, dapibus in arcu eu, consectetur luctus nibh. Ut sed erat vitae ante auctor porta sed quis risus. Nunc ac ultrices tortor, sit amet mattis eros. Phasellus facilisis felis ac urna mattis, eget dignissim neque cursus.Aliquam eu eleifend sem. Praesent magna urna, efficitur sed condimentum vel, sodales nec quam. Fusce vel sem est. Aliquam erat volutpat. Nulla nisi eros, efficitur vel magna porttitor, tempor rutrum est. Donec ac risus laoreet, facilisis arcu sit amet, dapibus eros. Vestibulum est justo, venenatis eget dui vel, lobortis volutpat eros. Sed semper neque dolor, id interdum quam semper sed. Duis sit amet nulla nunc. Donec neque nibh, efficitur vel consectetur at, pellentesque vel nisi. Praesent varius, eros vel porta eleifend, elit lorem blandit velit, id fermentum ex mauris sed risus. Etiam dolor nulla, varius porttitor venenatis id, vestibulum quis nulla. Etiam maximus volutpat scelerisque. Curabitur egestas eros vel placerat volutpat. Suspendisse potenti.Quisque et libero fringilla, finibus tortor in, aliquet mauris. Morbi tempor mauris a imperdiet tempus. Aenean dignissim enim urna, non sagittis ante consectetur pulvinar. Aliquam erat volutpat. Phasellus rutrum felis eu augue varius sollicitudin. Integer sem neque, tristique pretium augue nec, varius iaculis elit. Duis molestie urna nulla, et scelerisque tellus consectetur id. Vestibulum non turpis ut nibh semper posuere eget in ex. Etiam finibus sed sapien a convallis. Sed sit amet lorem massa. Integer id luctus diam. Sed vitae mauris neque. Donec id elit volutpat, vehicula enim nec, sollicitudin leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.");
        description.setFont(window.settingsManager.getSubtitleFont());
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setFocusable(false);
        description.setOpaque(false);
        jScrollPane1 = new JScrollPane(description,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); ;

        MaintenanceReqBtn.setText("Maintenance request");
        MaintenanceReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaintenanceReqBtnActionPerformed(evt);
            }
        });
        if (mgr.getStatus(index) == TrapStatusManager.Status.ACTIVATED){
        	ToggleArmed.setText("Dearm");
        	statusColour.setText("Enabled");
        } else if (mgr.getStatus(index) == TrapStatusManager.Status.DEACTIVATED){
        	ToggleArmed.setText("Arm");
        	statusColour.setText("Disabled");
        } else {
        	ToggleArmed.setText("Out of Order");
        	ToggleArmed.setEnabled(false);
        	statusColour.setText("Malfunctioning");
        }
        
        ToggleArmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleArmedActionPerformed(evt);
            }
        });

        performanceReport.setColumns(20);
        performanceReport.setRows(5);
        performanceReport.setText("PerformanceReport:\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tempus ante a odio eleifend, at mollis elit rutrum. Nullam vehicula suscipit quam at pharetra. Curabitur placerat eu dolor eu vestibulum. Suspendisse potenti. Aenean sit amet est vitae nibh ultrices dapibus eget sed risus. Maecenas commodo metus sit amet justo pulvinar, ac tincidunt risus interdum. Vivamus et eros porttitor, sagittis felis et, vehicula nisi. Praesent at massa et arcu imperdiet lacinia quis a magna. Duis vestibulum viverra turpis in tempor. Sed ac dui in leo dignissim dapibus. Proin posuere hendrerit volutpat. Praesent egestas interdum blandit. Sed facilisis suscipit hendrerit. Integer a enim vitae arcu facilisis accumsan. Fusce eleifend lobortis elit, et vehicula dolor rhoncus a. Praesent scelerisque consectetur placerat. Suspendisse fermentum iaculis orci. Vestibulum facilisis eget nisl ut sollicitudin. Suspendisse maximus ac massa sit amet viverra. Aliquam ultrices risus sit amet dignissim maximus. Nullam a velit consequat, dapibus quam et, sodales est.");
        performanceReport.setWrapStyleWord(true);
        performanceReport.setLineWrap(true);
        performanceReport.setEditable(false);
        performanceReport.setFocusable(false);
        performanceReport.setOpaque(false);
        jScrollPane2 = new JScrollPane(performanceReport,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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
        if (mgr.getStatus(index) == TrapStatusManager.Status.ACTIVATED){
        	mgr.setStatus(index, TrapStatusManager.Status.DEACTIVATED);
        	ToggleArmed.setText("Arm");
        	statusColour.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        	statusColour.setText("Disabled");
        } else if (mgr.getStatus(index) == TrapStatusManager.Status.DEACTIVATED){
        	mgr.setStatus(index, TrapStatusManager.Status.ACTIVATED);
        	ToggleArmed.setText("Dearm");
        	statusColour.setIcon(new ImageIcon(mgr.getStatusColor(index).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        	statusColour.setText("Enabled");
        }
    }//GEN-LAST:event_ToggleArmedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MaintenanceReqBtn;
    private JButton ToggleArmed;
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
