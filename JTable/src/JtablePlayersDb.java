import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class JtablePlayersDb {

	private JFrame frame;
	private JTable table;
	private JTextField txtName;
	private JTextField txtPosition;
	private JTextField txtTeam;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtablePlayersDb window = new JtablePlayersDb();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Create the application.
	 */
	public JtablePlayersDb() {
		initialize();
	}
	
	 private void retrieve()
	    {
	     DefaultTableModel dm = new DbUpdater().getData();
	        table.setModel(dm);   
	    }
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String name = table.getValueAt(table.getSelectedRow(), 1).toString();
				String pos = table.getValueAt(table.getSelectedRow(), 2).toString();
				String team = table.getValueAt(table.getSelectedRow(), 3).toString();
				
				txtName.setText(name);
				txtPosition.setText(pos);
				txtTeam.setText(team);
			}
		});
		table.setBounds(352, 47, 412, 364);
		frame.getContentPane().add(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 147, 73, 29);
		frame.getContentPane().add(lblName);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(21, 187, 73, 29);
		frame.getContentPane().add(lblPosition);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setBounds(21, 235, 73, 29);
		frame.getContentPane().add(lblTeam);
		
		txtName = new JTextField();
		txtName.setBounds(80, 147, 137, 29);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPosition = new JTextField();
		txtPosition.setBounds(80, 187, 137, 29);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		txtTeam = new JTextField();
		txtTeam.setBounds(80, 227, 137, 32);
		frame.getContentPane().add(txtTeam);
		txtTeam.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
			}
		});
		btnInsert.setBounds(21, 300, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index = table.getSelectedRow();
				String id = table.getValueAt(index, 0).toString();
				
				if(new DbUpdater().update(id,txtName.getText(),txtPosition.getText(),txtTeam.getText()))
				{   
					
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					retrieve();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Updated");
				}
				
				
				
				if (new DbUpdater().add(txtName.getText(), txtPosition.getText(), txtTeam.getText())) {
		            JOptionPane.showMessageDialog(null, "Successfully Inserted");
		            //CLEAR TXT
		            txtName.setText("");
		            txtPosition.setText("");
		            txtTeam.setText("");
		            
		           // retrieve();
		        } else {
		            JOptionPane.showMessageDialog(null, "Not Saved");
		        }
				
				
			}
		});
		btnUpdate.setBounds(21, 334, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] options = {"Yes","No"};
				int ans = JOptionPane.showOptionDialog(null,"Sure to Delete","Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if(ans==0)
				{
				
				int index = table.getSelectedRow();
				String id = table.getValueAt(index, 0).toString();
				
			}
				String id = null;
				if(new DbUpdater().delete(id))
				{
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					
					//clear text
					    txtName.setText("");
			            txtPosition.setText("");
			            txtTeam.setText("");
			          
				}
				else
				{
					JOptionPane.showMessageDialog(null, "not deleted");
				}
				
				
			}
				
		});
		btnDelete.setBounds(145, 334, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				retrieve();
				
			}
		});
		btnRetrieve.setBounds(145, 300, 89, 23);
		frame.getContentPane().add(btnRetrieve);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
				
			}
		});
		btnClear.setBounds(86, 379, 89, 23);
		frame.getContentPane().add(btnClear);
	}
}
