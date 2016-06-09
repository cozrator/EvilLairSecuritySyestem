import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class UserDetailsScreen extends JDialog implements ActionListener {

	//Global variables
		int width = 400;
		int height = 210;
		BorderLayout bl = new BorderLayout();
		SettingsScreen setScr;

		
		private JTextField fnTB;
		private JTextField gnTB;
		private JTextField eaTB;
		
		int x = ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (width/2));
		int y = ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (height/2));

		

		UserDetailsScreen(SettingsScreen ss){
			this.setScr = ss;
			this.setModal(true);
			this.setSize(width, height);
			this.setTitle("Update User Details");
			this.setLocation(x,y);
			getContentPane().setLayout(bl);
			this.setMinimumSize(new Dimension(width, height));
			getContentPane().add(createInfoPane(), BorderLayout.CENTER);
			getContentPane().add(createButtonPane(), BorderLayout.SOUTH);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
			
		}
		
		
		private JPanel createButtonPane(){
			JPanel buttonPane = new JPanel();
			JButton saveButton = new JButton("Save");
			saveButton.setActionCommand("Save");
			saveButton.addActionListener(this);
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("Cancel");
			cancelButton.addActionListener(this);
			
			buttonPane.add(saveButton);
			buttonPane.add(cancelButton);
			
			return buttonPane;
		}
		
		
		private JPanel createInfoPane(){
			JPanel infoPane = new JPanel();
			GridBagLayout gbl_infoPane = new GridBagLayout();
			gbl_infoPane.columnWeights = new double[]{0.0, 1.0, 0.0};
			gbl_infoPane.columnWidths = new int[]{50, 192, 0};
			gbl_infoPane.rowHeights = new int[]{30, 30, 30};
			infoPane.setLayout(gbl_infoPane);
			

			
			JLabel givenNameLabel = new JLabel("Given Name:");
			GridBagConstraints gbc_givenNameLabel = new GridBagConstraints();
			gbc_givenNameLabel.anchor = GridBagConstraints.EAST;
			gbc_givenNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_givenNameLabel.fill = GridBagConstraints.VERTICAL;
			gbc_givenNameLabel.gridx = 0;
			gbc_givenNameLabel.gridy = 0;
			infoPane.add(givenNameLabel, gbc_givenNameLabel);
			
			gnTB = new JTextField();
			gnTB.setText(setScr.getGivenNameTB());
			GridBagConstraints gbc_gnTB = new GridBagConstraints();
			gbc_gnTB.anchor = GridBagConstraints.BELOW_BASELINE;
			gbc_gnTB.insets = new Insets(0, 0, 5, 5);
			gbc_gnTB.fill = GridBagConstraints.HORIZONTAL;
			gbc_gnTB.gridx = 1;
			gbc_gnTB.gridy = 0;
			infoPane.add(gnTB, gbc_gnTB);
			gnTB.setColumns(20);
			
			JLabel familyNameLabel = new JLabel("Family Name:");
			GridBagConstraints gbc_familyNameLabel = new GridBagConstraints();
			gbc_familyNameLabel.anchor = GridBagConstraints.EAST;
			gbc_familyNameLabel.fill = GridBagConstraints.VERTICAL;
			gbc_familyNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_familyNameLabel.gridx = 0;
			gbc_familyNameLabel.gridy = 1;
			infoPane.add(familyNameLabel, gbc_familyNameLabel);
			
			fnTB = new JTextField();
			fnTB.setText(setScr.getFamilyNameTB());
			GridBagConstraints gbc_fnTB = new GridBagConstraints();
			gbc_fnTB.insets = new Insets(0, 0, 5, 5);
			gbc_fnTB.fill = GridBagConstraints.HORIZONTAL;
			gbc_fnTB.gridx = 1;
			gbc_fnTB.gridy = 1;
			infoPane.add(fnTB, gbc_fnTB);
			fnTB.setColumns(20);
			
			JLabel emailLabel = new JLabel("Email Address:");
			GridBagConstraints gbc_emailLabel = new GridBagConstraints();
			gbc_emailLabel.anchor = GridBagConstraints.EAST;
			gbc_emailLabel.fill = GridBagConstraints.VERTICAL;
			gbc_emailLabel.insets = new Insets(0, 0, 0, 5);
			gbc_emailLabel.gridx = 0;
			gbc_emailLabel.gridy = 2;
			infoPane.add(emailLabel, gbc_emailLabel);
			
			eaTB = new JTextField();
			eaTB.setText(setScr.getEmailTB());
			GridBagConstraints gbc_eaTB = new GridBagConstraints();
			gbc_eaTB.insets = new Insets(0, 0, 0, 5);
			gbc_eaTB.fill = GridBagConstraints.HORIZONTAL;
			gbc_eaTB.gridx = 1;
			gbc_eaTB.gridy = 2;
			infoPane.add(eaTB, gbc_eaTB);
			eaTB.setColumns(30);
			
			return infoPane;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Save")){
				setScr.setGivenNameTB(gnTB.getText());
				setScr.setFamilyNameTB(fnTB.getText());
				setScr.setEmailTB(eaTB.getText());
				this.setVisible(false);
			}
			
			else if (e.getActionCommand().equals("Cancel")){
				this.setVisible(false);
			}
			
		}
		
}
