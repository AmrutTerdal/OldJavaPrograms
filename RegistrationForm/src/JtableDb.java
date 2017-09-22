import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JtableDb {

	private JFrame framenext;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtableDb window = new JtableDb();
					window.framenext.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	
	Connection con = null;
	
	public JtableDb() {
		initialize();
		con = dataBaseConnector.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framenext = new JFrame();
		framenext.getContentPane().setBackground(new Color(127, 255, 212));
		framenext.setBounds(100, 100, 777, 450);
		framenext.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framenext.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 90, 662, 310);
		framenext.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		JButton btnNewButton = new JButton("Show Table Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(161, 26, 338, 49);
		framenext.getContentPane().add(btnNewButton);
	}
}
