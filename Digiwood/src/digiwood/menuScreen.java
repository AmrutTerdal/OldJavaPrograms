package digiwood;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class menuScreen {

	JFrame firstframe;
	JLabel lblgetuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuScreen window = new menuScreen();
					window.firstframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection con=null;

	/**
	 * Create the application.
	 */
	public menuScreen() {
		initialize();
		con=logdb.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		firstframe = new JFrame();
		firstframe.getContentPane().setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		firstframe.getContentPane().setBackground(Color.WHITE);
		firstframe.setBounds(0, 0, 1366, 768);
		firstframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 22, 117, 79);
		firstframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\madhu\\workspace\\Digiwood\\img\\digy.png"));
		lblNewLabel_1.setBounds(239, 3, 926, 112);
		lblNewLabel_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		firstframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblUserid = new JLabel("USERID :");
		lblUserid.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 17));
		lblUserid.setBounds(20, 112, 73, 34);
		firstframe.getContentPane().add(lblUserid);
		
		 lblgetuser = new JLabel("");
		 lblgetuser.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 17));
		lblgetuser.setBounds(102, 112, 193, 34);
		firstframe.getContentPane().add(lblgetuser);
		lblgetuser.setText(login.textField.getText());
		
		
		JLabel lblNewLabel_3 = new JLabel("SCREEN NAME");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(433, 112, 433, 34);
		firstframe.getContentPane().add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 112, 1334, 43);
		firstframe.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(212, 157, 1122, 524);
		firstframe.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Customer Activities");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				panel_2.removeAll();
				panel_2.revalidate();
				panel_2.repaint();
				JButton btncust=new JButton("Customer");
				btncust.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						CustCategory window = new CustCategory();
						window.frame.setVisible(true);
						
					}
				
			});
				btncust.setBounds(0, 0, 250, 50);
				panel_2.add(btncust);
				JButton btncontact=new JButton("Contact person");
				btncust.setBounds(354, 273, 131, 29);
				panel_2.add(btncontact);
//				panel.removeAll();
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(0, 155, 211, 57);
		firstframe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Transactions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					panel_2.removeAll();
					panel_2.revalidate();
					panel_2.repaint();
					JButton btncontract=new JButton("Contract");
					btncontract.setBounds(354, 233, 131, 29);
					panel_2.add(btncontract);
					JButton btnequp=new JButton("Equipment Training");
					btnequp.setBounds(354, 273, 131, 29);
					panel_2.add(btnequp);
					JButton btnschedule=new JButton("Schedulury");
					btnschedule.setBounds(354, 233, 131, 29);
					panel_2.add(btnschedule);
					JButton btnbreak=new JButton("Break Down");
					btnbreak.setBounds(354, 273, 131, 29);
					panel_2.add(btnbreak);
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(0, 210, 211, 57);
		firstframe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Master");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.removeAll();
				panel_2.revalidate();
				panel_2.repaint();
				JButton btnequipmaster=new JButton("Equipment Master");
				btnequipmaster.setBounds(354, 233, 131, 29);
				panel_2.add(btnequipmaster);
				JButton btnequpset=new JButton("Equipment Set");
				btnequpset.setBounds(354, 273, 131, 29);
				panel_2.add(btnequpset);
				JButton btnlocation=new JButton("Location");
				btnlocation.setBounds(354, 233, 131, 29);
				panel_2.add(btnlocation);
				JButton btncategory=new JButton("Category");
				btncategory.setBounds(354, 273, 131, 29);
				panel_2.add(btncategory);
			}
		});
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(0, 266, 211, 57);
		firstframe.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("User Management");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.removeAll();
				panel_2.revalidate();
				panel_2.repaint();
				JButton btnuser=new JButton("User");
				btnuser.setBounds(354, 233, 131, 29);
				panel_2.add(btnuser);
				JButton btnrole=new JButton("Role");
				btnrole.setBounds(354, 273, 131, 29);
				panel_2.add(btnrole);
				JButton btnscreen=new JButton("Screen");
				btnscreen.setBounds(354, 233, 131, 29);
				panel_2.add(btnscreen);
				JButton btnaction=new JButton("Action");
				btnaction.setBounds(354, 273, 131, 29);
				panel_2.add(btnaction);
				JButton btnroleaction=new JButton("Role Action");
				btnroleaction.setBounds(354, 273, 131, 29);
				panel_2.add(btnroleaction);
			}
		});
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBounds(0, 322, 211, 55);
		firstframe.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Are you sure you want to exit?");
				
				firstframe.dispose();
				login window = new login();
			window.framelog.setVisible(true);
			
			
			
			
			
//JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?","Confirm",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
//
//			       if(result == JOptionPane.YES_OPTION){
//			    	   
//			    	   firstframe.dispose();
////			    	   new login().set;
////			               login window = new login();
////							window.framelog.setVisible(true);
//			       }else{
//			               //Do nothing
//			       }
			 
			}
	});
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(-1, 376, 213, 50);
		firstframe.getContentPane().add(btnNewButton_4);
		
		JButton btnSearchon = new JButton("SEARCHON");
		btnSearchon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchon window = new searchon();
				window.framesearch.setVisible(true);
				firstframe.dispose();
			}
		});
		btnSearchon.setBounds(1214, 695, 89, 23);
		firstframe.getContentPane().add(btnSearchon);
		
		
		
		
	}
}
