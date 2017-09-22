import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.sql.*;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registeration1 {

	
	
	private JFrame frame;
	private JTextField textName;
	private JTextField textLname;
	private JTextField textUname;
	private JPasswordField txtpassword;
	private JList list;
	private JLabel l2;
	private JTextArea textArea;
	private JRadioButton radiofemale;
	private JRadioButton radio;
	private JComboBox comboBox;
	private JLabel gnd;
	String numbers = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registeration1 window = new Registeration1();
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
	
	Connection con = null;
	private JTable table;
	
	public Registeration1() {
		
		
		
		initialize();
		con = dataBaseConnector.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 13));
		frame.setBounds(100, 100, 754, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Registeration Page");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 87, 220, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(44, 134, 78, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textName.setBounds(156, 139, 109, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 170, 78, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		textLname = new JTextField();
		textLname.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textLname.setBounds(155, 174, 109, 20);
		frame.getContentPane().add(textLname);
		textLname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(42, 211, 94, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		textUname = new JTextField();
		textUname.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textUname.setBounds(154, 205, 109, 20);
		frame.getContentPane().add(textUname);
		textUname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(42, 238, 78, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		 gnd = new JLabel("Gender");
		gnd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		gnd.setBounds(42, 269, 78, 26);
		frame.getContentPane().add(gnd);
		
		JRadioButton radio = new JRadioButton("Male");
		radio.setBounds(154, 271, 57, 23);
		frame.getContentPane().add(radio);
		
		JRadioButton radiofemale = new JRadioButton("female");
		radiofemale.setBounds(210, 271, 109, 23);
		frame.getContentPane().add(radiofemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(radio);
		bg.add(radiofemale);
		
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtpassword.setBounds(154, 236, 109, 20);
		frame.getContentPane().add(txtpassword);
		
		comboBox = new JComboBox();
		comboBox.setBounds(154, 301, 109, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Australia");
		comboBox.addItem("Bangladesh");
		comboBox.addItem("China");
		comboBox.addItem("England");
		comboBox.addItem("India");
		comboBox.addItem("Japan");
		
		
		JLabel lblNewLabel_6 = new JLabel("Country");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_6.setBounds(42, 301, 78, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(42, 343, 68, 26);
		frame.getContentPane().add(lblNewLabel_7);
		
		 textArea = new JTextArea();
		textArea.setBounds(154, 344, 109, 84);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			/*	JOptionPane.showMessageDialog(null, "Registration Successful");
				
			   System.out.println("Name:"+textName.getText());
			   System.out.println("Last Name:"+textLname.getText());
			   System.out.println("User Name"+textUname.getText());
			   
			  
			   
			   System.out.println("The Entered Password is"+txtpassword.getText());
			   System.out.println("You Selected Country"+comboBox.getSelectedItem());
			   System.out.println("Address is"+textArea.getText());    */
			   
			  //	String data = "Name :"+textName.getText();
			//	data += ", Last Name:"+textLname.getText(); l2.setText(data);
				
				//list.setToolTipText(name);
				
				//l2.setText(name);
				
				//l2.setText(textName.getText());
				
				//textArea_1.setText(name);
				
				try{
					
					// Class.forName("com.mysql.jdbc.Driver"); //accessing driver from jar
					
					String query = "insert into registration (Rname,Rlname,Runame,Rpwd,Rgender,Rcountry,Raddress) values(?,?,?,?,?,?,?)";
					PreparedStatement pst= con.prepareStatement(query);
					
					pst.setString(1,textName.getText());
					pst.setString(2,textLname.getText());
					pst.setString(3,textUname.getText());
					pst.setString(4,txtpassword.getText());
					pst.setString(5, radio.getText());
					pst.setString(5, radiofemale.getText());
					pst.setString(6,comboBox.getSelectedItem().toString());
					pst.setString(7,textArea.getText());
					pst.execute();
				   JOptionPane.showMessageDialog(null, "Data saved");
				   
				  // frame.dispose();
				  // JtableDb db= new JtableDb();
				  // db.setVisible(true);
					
				   pst.close();
				   con.close();
					
					
				}
				
				catch(Exception e) 
				{
					e.printStackTrace();
				}
				
				
			
				
				
				
			
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(117, 439, 94, 31);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 141, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("Menu");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnNew.setIcon(new ImageIcon("C:\\Users\\amrut\\Downloads\\Ok.png"));
		mnFile.add(mnNew);
		
		JMenuItem mntmUser = new JMenuItem("User");
		mnNew.add(mntmUser);
		
		JMenuItem mntmUserLogin = new JMenuItem("User Login");
		mnNew.add(mntmUserLogin);
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.setBackground(new Color(51, 255, 255));
		mnFile.add(mntmRegister);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenuItem mntmCloseAll = new JMenuItem("Close All");
		mnFile.add(mntmCloseAll);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Edit");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmName = new JMenuItem("Update");
		mnNewMenu.add(mntmName);
		
		JMenuItem mntmUsername = new JMenuItem("Delete");
		mnNewMenu.add(mntmUsername);
		
		JMenu mnResources = new JMenu("Resources");
		menuBar.add(mnResources);
		
		JCheckBoxMenuItem chckbxmntmCheckIt = new JCheckBoxMenuItem("Check It");
		mnResources.add(chckbxmntmCheckIt);
		
		JRadioButtonMenuItem rdbtnmntmRadio = new JRadioButtonMenuItem("Radio");
		mnResources.add(rdbtnmntmRadio);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                 
				try{
					
					
					
					String query = "update registration set Rlname='"+textLname.getText()+"',Runame='"+textUname.getText()+"',Rpwd='"+txtpassword.getText()+"',RGender='"+gnd.getText()+"',Rcountry='"+comboBox.getSelectedItem().toString()+"',Raddress='"+textArea.getText()+"' where Rname='"+textName.getText()+"' ";
					PreparedStatement pst= con.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated ");
					
					pst.close();
					
				}
			catch(Exception e1)
				{
				e1.printStackTrace();
				
				}
	
				
			}
				
			});
		btnNewButton_1.setBounds(117, 495, 94, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try{
					
					String query = "delete from registration where Rname='"+textName.getText()+"' ";
					PreparedStatement pst= con.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();
					
				}
			catch(Exception e2)
				{
				e2.printStackTrace();
				
				}
			}
		});
		btnNewButton_2.setBounds(122, 542, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Show Table Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            try{
					
					String query = "select Rname,Rlname,Runame,Rpwd,Rgender,Rcountry,Raddress from registration";
					PreparedStatement pst= con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
			
					
					
				}
			catch(Exception e1 )
				{
				e1.printStackTrace();
				
				}
			
				
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_3.setBounds(369, 87, 253, 32);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String name = table.getValueAt(table.getSelectedRow(), 0).toString();
				String lname = table.getValueAt(table.getSelectedRow(), 1).toString();
				String uname = table.getValueAt(table.getSelectedRow(), 2).toString();
				String pwd = table.getValueAt(table.getSelectedRow(), 3).toString();
				String gender = table.getValueAt(table.getSelectedRow(), 4).toString();
				String country = table.getValueAt(table.getSelectedRow(), 5).toString();
				String address = table.getValueAt(table.getSelectedRow(), 6).toString();
				
				
				
				
				
				textName.setText(name);
				textLname.setText(lname);
				textUname.setText(uname);
				txtpassword.setText(pwd);
				radio.setText(gender);
				comboBox.setSelectedItem(country);
				textArea.setText(address);
				
			}
		});
		scrollPane.setBounds(294, 140, 444, 309);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\amrut\\Downloads\\Background-with-light-blue-watercolor-texture\\1679.jpg"));
		lblNewLabel_5.setBounds(0, 0, 738, 708);
		frame.getContentPane().add(lblNewLabel_5);
		
	
	
		
	}
}
