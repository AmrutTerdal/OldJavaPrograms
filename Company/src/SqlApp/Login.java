package SqlApp;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;

import com.java.second;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textUn;
	private JPasswordField passwordField;
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		
		connection=SqlLiteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(143, 64, 80, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(143, 115, 80, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		textUn = new JTextField();
		textUn.setBounds(277, 53, 177, 28);
		frame.getContentPane().add(textUn);
		textUn.setColumns(10);
		
		JButton BtnLogin = new JButton("Login");
		BtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query="select * from Employee Where UserName=? and Password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textUn.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count=count++;
						
						if(count==1){
							JOptionPane.showMessageDialog(null, "UserName and password is correct");
							
						}
			//			else if(count>=1)
			//			{
				//			JOptionPane.showMessageDialog(null, "duplicate User name and password");
				//		}
						
						else{
							
							JOptionPane.showMessageDialog(null, "Username and Password is not correct try again");
							
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
		BtnLogin.setBounds(213, 199, 89, 23);
		frame.getContentPane().add(BtnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 119, 180, 24);
		frame.getContentPane().add(passwordField);
	}
}
