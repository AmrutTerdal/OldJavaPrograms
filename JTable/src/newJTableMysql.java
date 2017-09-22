import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;

public class newJTableMysql {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newJTableMysql window = new newJTableMysql();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Connection getConnection()
	{
		Connection con;
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/compay","root","root");
			return con;
		}
		catch(Exception ex)
		{
		
			ex.printStackTrace();
			return null;
		}
	}
	
	   public ArrayList<User> usersList()
	   {
		   ArrayList<User>usersList = new ArrayList<User>();
		   Connection connection = getConnection();
		   
		   String query = "select * from user";
		   java.sql.Statement st ;
		   ResultSet rs;
		   try
		   {
			   st = connection.createStatement();
			   rs =st.executeQuery(query);
			   User user;
			   while(rs.next())
			   {
				   user = new User(rs.getInt(""),rs.getString(""),rs.getString(""),rs.getInt(""));
				   usersList.add(user);
			       
				   
				   
			   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   return usersList;
	   }
	   
	   public void Show_Users_In_JTable()
	   {
		   ArrayList<User> list = getusersList();
		   DefaultTableModel model = (DefaultTableModel)tableShow_Users_In_JTable.getModel();
		   Objec[] row = new Object[4];
		   for(int i = 0;i<list.size();i++)
		   {
			   row[0] = list.get(i).getid();
			   row[0] = list.get(i).getfirstName();
			   row[0] = list.get(i).getlastName();
			   row[0] = list.get(i).getage();
			   
			   model.addRow(rowData);
		   }
		   
				   
		   
	   }

	/**
	 * Create the application.
	 */
	public newJTableMysql() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(97, 45, 33, 34);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(46, 90, 112, 34);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(47, 135, 112, 34);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(86, 180, 33, 34);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblAge);
		
		textField = new JTextField();
		textField.setBounds(140, 47, 175, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 93, 174, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 142, 174, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 187, 176, 32);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		table = new JTable();
		table.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		table.setBounds(328, 13, 437, 406);
		frame.getContentPane().add(table);
		
		btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 255, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update ");
		btnNewButton_1.setBounds(109, 255, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(205, 255, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
