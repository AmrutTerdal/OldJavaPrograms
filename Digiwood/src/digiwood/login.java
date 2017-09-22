package digiwood;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.Icon;

public  class login {

	public static Object txtname;
	public  JFrame framelog;
  static JTextField textField;
	private JPasswordField passwordField;
	public static JComboBox comboorg;
static String r1,r2;
 static String queryorg,usernm;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.framelog.setVisible(true);
					combodata();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
protected static void combodata() {
	 try{
			String querycombo = "select org_id from user_table";
		
	        PreparedStatement st =  con.prepareStatement(querycombo);
		 ResultSet   rs1 = st.executeQuery();
			while(rs1.next()){
			comboorg.addItem(rs1.getString(1));  
//			System.out.println("Query"+rs1);
			}
	           rs1.close();
	           st.close();
     
	           
			}catch(Exception e1){
				e1.printStackTrace();						
	}
		
	}
static Connection con =null;
	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		combodata();
		con=logdb.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framelog = new JFrame();
		framelog.getContentPane().setBackground(Color.WHITE);
		framelog.setBounds(0, 0, 1356, 768);
		framelog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framelog.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framelog.getContentPane().setLayout(null);
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\madhu\\workspace\\digiwood\\img\\log.jpg"));
		framelog.setContentPane(label);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(SystemColor.textHighlight);
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 21));
		lblLogin.setBounds(487, 136, 249, 90);
		framelog.getContentPane().add(lblLogin);
		
		JLabel lblOrganisationId = new JLabel("ORGANISATION ID");
		lblOrganisationId.setForeground(Color.BLACK);
		lblOrganisationId.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrganisationId.setBounds(492, 267, 143, 30);
		framelog.getContentPane().add(lblOrganisationId);
		
	  comboorg = new JComboBox();
	  comboorg.setBackground(SystemColor.activeCaption);
		comboorg.setBounds(683, 274, 143, 30);
		framelog.getContentPane().add(comboorg);
		
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Arial", Font.BOLD, 14));
		lblUserName.setBounds(492, 333, 143, 30);
		framelog.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(683, 335, 143, 30);
		framelog.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(492, 389, 143, 30);
		framelog.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.activeCaption);
		passwordField.setBounds(683, 396, 143, 30);
		framelog.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\madhu\\workspace\\digiwood\\img\\button-round-arrow-right-icon.png"));
		btnLogin.setBackground(new Color(12,203,238));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 queryorg=comboorg.getSelectedItem().toString();
		  usernm=textField.getText();
				
				
				
				
				try{
					String query="select * from user_table where org_id=? and   short_name=? and password=? ";
					//organisation_id=? and 
					PreparedStatement pstmt=con.prepareStatement(query);
					
					pstmt.setString(1, comboorg.getSelectedItem().toString());
					pstmt.setString(2, textField.getText());
					pstmt.setString(3, passwordField.getText());
					ResultSet rs=pstmt.executeQuery();
					
					int count=0;
					while(rs.next()){

						count=count+1;
					}
					if(count==1)
					{
//						JOptionPane.showMessageDialog(null, "login succesfull");
						
						
						
						menuScreen window = new menuScreen();
						window.firstframe.setVisible(true);
						framelog.dispose();
						
						
						
					}
					else{
						JOptionPane.showMessageDialog(null, "please check username & password");
					}
				
					
				}catch(Exception e){ e.printStackTrace();}
			}
		});
		btnLogin.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		btnLogin.setBounds(676, 476, 135, 38);
		framelog.getContentPane().add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(465, 145, 475, 388);
		framelog.getContentPane().add(panel);
		
//		JPanel panel = new JPanel( );
////		(LayoutManager) new ImageIcon("C:\\Users\\madhu\\Desktop\\login_user1.jpg")
//
//		panel.setForeground(UIManager.getColor("scrollbar"));
//		panel.setBackground(Color.WHITE);
//		
//		panel.setBounds(0, 100, 655, 420);
//		framelog.getContentPane().add(panel);
	}
}
