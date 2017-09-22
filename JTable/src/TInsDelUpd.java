import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class TInsDelUpd {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TInsDelUpd window = new TInsDelUpd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DefaultTableModel dm;
	/**
	 * Create the application.
	 */
	public TInsDelUpd() {
		initialize();
		
		CreateColumns();
	}
	
	private void CreateColumns()
	{
		dm = (DefaultTableModel) table.getModel();
		dm.addColumn("Name");
		dm.addColumn("Position");
		dm.addColumn("Team");
		
	}
	
	private void Populate(String name,String pos, String team)
	{
		dm = (DefaultTableModel) table.getModel();
		String[] rowData={name,pos,team};
		dm.addRow(rowData);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				textField_1.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textField_2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			
			}
		});
		table.setBounds(10, 11, 380, 393);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(433, 43, 94, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Position");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(433, 99, 94, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Team");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(433, 150, 94, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(523, 48, 101, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(522, 104, 102, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(523, 155, 101, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Populate(textField.getText(),textField_1.getText(),textField_2.getText());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(433, 230, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dm.removeRow(table.getSelectedRow());
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(566, 230, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = JOptionPane.showInputDialog("Enter The Name");
				String position = JOptionPane.showInputDialog("Enter The Designation");
				String team = JOptionPane.showInputDialog("Enter The Team");
				
				Object rowData[] = new Object[4];
				rowData[0] = id;
				rowData[1] = position;
				rowData[2] = team;
				
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				model.addRow(rowData);
			
			}
		});
		btnNewButton_2.setBounds(433, 281, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
