import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.second;
import com.mysql.jdbc.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JTextField textuname;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * 
	 */
	java.sql.Connection connection = null;
	public login() {
		
		
		initialize();
		connection = dataBaseConnector.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 127));
		frame.setBounds(100, 100, 586, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(149, 101, 112, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(149, 150, 112, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		textuname = new JTextField();
		textuname.setBounds(291, 103, 136, 24);
		frame.getContentPane().add(textuname);
		textuname.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		java.awt.Image img1= new ImageIcon(this.getClass().getResource("/submit.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1) );
		
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try{
					
					String query="select * from registration Where Runame=? and Rpwd=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textuname.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count=count++;
						
						if(count==1){
							JOptionPane.showMessageDialog(null, "Login Successful");
							
							
							
							
						}
			//			else if(count>=1)
			//			{
				//			JOptionPane.showMessageDialog(null, "duplicate User name and password");
				//		}
						
						else{
							
							JOptionPane.showMessageDialog(null, "UserName and password is correct");
						
							
							
							
							// frame.dispose(); 
						//	   secondForm sec = new secondForm();
						//	   sec.setVisible(true);
						}
					}
					
					rs.close();
					pst.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
			
		});
		btnNewButton.setBounds(251, 196, 112, 96);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(291, 152, 136, 24);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Login Page");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(224, 23, 159, 51);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
