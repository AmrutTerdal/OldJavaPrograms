package digiwood;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Role {

	public JFrame framerole;
	 static   JTextField txtRole;
	private static JTextField txtName;
	private static JTextField txtshortname;
	private static JComboBox combostatus;
	String r1,r2;
	String orgid=login.queryorg;
	String username=login.usernm;
	String modify;
	     static String comp_role;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Role window = new Role();
					window.framerole.setVisible(true);
					setTextBoxVal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
protected static void setTextBoxVal() {
	
	try
	{
		String query1="Select MAX(role_id)FROM role_master";
		PreparedStatement pst=con.prepareStatement(query1);
		ResultSet rs=pst.executeQuery(query1);
		rs.next();
		String hh=rs.getString(1);
		String[] part = hh.split("(?<=\\D)(?=\\d)");
		
		int rolea = Integer.valueOf(part[1]);
		String roleb=part[0];
		int role1=rolea+001;
		String comp_role = roleb+role1;
		
		System.out.println(comp_role);
	
		
		
		
		txtRole.setText(comp_role);
		
	}catch(SQLException e1){
		e1.printStackTrace();
		
	}

	
	
	
	
//	String query1="select org_id from user_table";
//	String orgid=login.queryorg;
//	String username=login.usernm;
//	try{
//		PreparedStatement pstmt=con.prepareStatement(query1);
//		pstmt.setString(1, txtshortname.getText());
//		ResultSet rs=pstmt.executeQuery();
//		while(rs.next()){
//			  r1=rs.getString(1);
//			 r2=rs.getString(2);
//			System.out.println(r1);
//			System.out.println(r2);
//		}
//	}catch(Exception e2){e2.printStackTrace();}
		
	}
static Connection con=null;
	/**
	 * Create the application.
	 */
	public Role() {
		initialize();
		con=logdb.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framerole = new JFrame();
		framerole.getContentPane().setForeground(UIManager.getColor("RadioButton.foreground"));
		framerole.getContentPane().setBackground(SystemColor.textHighlightText);
		framerole.getContentPane().setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 19));
		framerole.setBounds(0, 0, 1366, 768);
		framerole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framerole.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DIGYWOOD ADS");
		lblNewLabel_1.setBounds(433, 11, 732, 79);
		lblNewLabel_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		framerole.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setForeground(SystemColor.textHighlight);
		lblRole.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblRole.setBounds(291, 164, 84, 29);
		framerole.getContentPane().add(lblRole);
		
		JLabel lblRoleId = new JLabel("ROLE ID");
		lblRoleId.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblRoleId.setForeground(UIManager.getColor("RadioButton.foreground"));
		lblRoleId.setBounds(354, 233, 131, 29);
		framerole.getContentPane().add(lblRoleId);
		
		txtRole = new JTextField();
		txtRole.setBounds(495, 233, 150, 29);
		framerole.getContentPane().add(txtRole);
		txtRole.setColumns(10);
		txtRole.setText(searchon.comp_role);

		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblName.setBounds(354, 296, 131, 29);
		framerole.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(495, 299, 150, 29);
		framerole.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblShortName = new JLabel("SHORT NAME");
		 lblShortName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblShortName.setBounds(354, 360, 131, 29);
		framerole.getContentPane().add(lblShortName);
		
		txtshortname = new JTextField();
		txtshortname.setBounds(495, 360, 150, 29);
		framerole.getContentPane().add(txtshortname);
		txtshortname.setColumns(10);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblStatus.setBounds(354, 416, 131, 29);
		framerole.getContentPane().add(lblStatus);
		
	  combostatus = new JComboBox();
	  combostatus.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		combostatus.setBounds(495, 410, 150, 29);
		framerole.getContentPane().add(combostatus);
		
		JPanel panel = new JPanel();
		panel.setBounds(275, 140, 569, 384);
		framerole.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 modify=txtshortname.getText();
//				String query1="select org_id,user_id from user_table where short_name=?";
//				try{
//					PreparedStatement pstmt=con.prepareStatement(query1);
//					pstmt.setString(1, txtshortname.getText());
//					ResultSet rs=pstmt.executeQuery();
//					while(rs.next()){
//						  r1=rs.getString(1);
//						 r2=rs.getString(2);
//						System.out.println(r1);
//						System.out.println(r2);
//					}
//				}catch(Exception e2){e2.printStackTrace();}
				
				String query="INSERT INTO role_master(org_id,created_by,role_id,role_name,role_shortname,status,creted_datetime,modified_by,modified_datetime)values(?,?,?,?,?,?,now(),?,now())";
				
				try {
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1, orgid);
					stmt.setString(2, username);
					stmt.setString(3, txtRole.getText());
					stmt.setString(4, txtName.getText());
					stmt.setString(5, txtshortname.getText());
     				stmt.setString(6, combostatus.getSelectedItem().toString());
     				stmt.setString(7, modify);
     				stmt.execute();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(866, 211, 131, 29);
		framerole.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(866, 279, 131, 29);
		framerole.getContentPane().add(btnNewButton_1);
	}
}
