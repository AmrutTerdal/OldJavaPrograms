package SqlApp;




import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class secondForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondForm frame = new secondForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Connection connection= null;
	private JTextField textUid;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textAge;
	
	public void refreshTable()
	{
		try{
			
			String query = "select Eid,Name,Surname,Age from Employee";
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
	
		}
	catch(Exception e)
		{
		e.printStackTrace();
		
		}
	}
	
	public void fillComboBox()
	{
		try
		{
			String query="select * from Employee";
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				
				comboNames.addItem(rs.getString("Name"));
				
			}
			
		}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public secondForm() {
		
		connection = SqlLiteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show Table Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query = "select Eid,Name,Surname,Age from Employee";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
			
				}
			catch(Exception e)
				{
				e.printStackTrace();
				
				}
			
				refreshTable();
			}
			
		});
		btnNewButton.setBounds(438, 62, 123, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 108, 427, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("EID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 84, 71, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 125, 71, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 159, 89, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 200, 71, 23);
		contentPane.add(lblNewLabel_3);
		
		textUid = new JTextField();
		textUid.setBounds(115, 85, 86, 20);
		contentPane.add(textUid);
		textUid.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(115, 125, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(115, 160, 86, 20);
		contentPane.add(textSurname);
		textSurname.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(115, 201, 86, 20);
		contentPane.add(textAge);
		textAge.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        
				try{
					
					String query = "insert into Employee (EID,Name,Surname,Age) values(?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1,textUid.getText());
					pst.setString(2,textName.getText());
					pst.setString(3,textSurname.getText());
					pst.setString(4,textAge.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved ");
					
					pst.close();
					
				}
			catch(Exception e)
				{
				e.printStackTrace();
				
				}
			
				refreshTable();
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSave.setBounds(10, 259, 89, 23);
		contentPane.add(btnSave);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try{
					
					String query = "update Employee set EID='"+textUid.getText()+"',Name='"+textName.getText()+"',Surname='"+textSurname.getText()+"',Age='"+textAge.getText()+"' where UID='"+textUid.getText()+"' ";
					PreparedStatement pst= connection.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated ");
					
					pst.close();
					
				}
			catch(Exception e1)
				{
				e1.printStackTrace();
				
				}
			
				refreshTable();
				
			}
		});
		btn_Update.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btn_Update.setBounds(10, 298, 89, 23);
		contentPane.add(btn_Update);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try{
					
					String query = "delete from Employee where EID='"+textUid.getText()+"' ";
					PreparedStatement pst= connection.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();
					
				}
			catch(Exception e2)
				{
				e2.printStackTrace();
				
				}
				
				refreshTable();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(10, 344, 89, 23);
		contentPane.add(btnDelete);
		
		comboNames = new JComboBox();
		comboNames.setBounds(10, 11, 184, 33);
		contentPane.add(comboNames);
		
		refreshTable();
		fillComboBox();
	}
}
