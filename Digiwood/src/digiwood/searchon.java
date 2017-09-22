package digiwood;
import java.sql.*;
import java.util.Vector;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class searchon {

	public JFrame framesearch;
	private JTextField txtroleid;
	private JTextField txtname;
	private JTextField txtshortname;
	private JTable table;
	String role_id,role_name,role_shortname;
	int status;
	private JComboBox combostatus;
	String query1,combo;
	DefaultTableModel dtm;

 static String comp_role;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchon window = new searchon();
					window.framesearch.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 Connection con=null;
	/**
	 * Create the application.
	 */
	public searchon() {
		initialize();
		con=logdb.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framesearch = new JFrame();
		framesearch.getContentPane().setBackground(SystemColor.textHighlightText);
		framesearch.setBounds(0, 0, 1366, 768);
		framesearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framesearch.getContentPane().setLayout(null);
		

		JLabel lblNewLabel_1 = new JLabel("DIGYWOOD ADS");
		lblNewLabel_1.setBounds(433, 11, 732, 79);
		lblNewLabel_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		framesearch.getContentPane().add(lblNewLabel_1);
		
		JLabel lblsearch = new JLabel("Search On");
		lblsearch.setForeground(SystemColor.textHighlight);
		lblsearch.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblsearch.setBounds(301, 113, 170, 29);
		framesearch.getContentPane().add(lblsearch);
		
		JLabel lblscreenid = new JLabel("ROLE ID");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblscreenid.setForeground(UIManager.getColor("RadioButton.foreground"));
		lblscreenid.setBounds(340, 199, 131, 29);
		framesearch.getContentPane().add(lblscreenid);
		
		txtroleid = new JTextField();
		txtroleid.setBounds(548, 202, 150, 29);
		framesearch.getContentPane().add(txtroleid);
		txtroleid.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblName.setBounds(837, 199, 150, 29);
		framesearch.getContentPane().add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(1055, 202, 150, 29);
		framesearch.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblShortName = new JLabel("Short Name");
		lblShortName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblShortName.setBounds(340, 270, 131, 29);
		framesearch.getContentPane().add(lblShortName);
		
		txtshortname = new JTextField();
		txtshortname.setBounds(548, 273, 150, 29);
		framesearch.getContentPane().add(txtshortname);
		txtshortname.setColumns(10);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblStatus.setBounds(826, 270, 131, 29);
		framesearch.getContentPane().add(lblStatus);
		
	    combostatus = new JComboBox();
		combostatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		combostatus.setBounds(1055, 273, 150, 29);
		framesearch.getContentPane().add(combostatus);
		
		Button btnsearch = new Button("SEARCH");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					 String query = "Select * from role_master where "+" ";
                	 String role,name,shortname;
                	 role = txtroleid.getText();
                	 name=txtname.getText();
                	 shortname=txtshortname.getText();
                	 combo=combostatus.getSelectedItem().toString();
                	//String combo =combo_Customer.getSelectedItem().toString();
                	 
                	 
                	 if(role.length()!=0){
                		 query1= query+"role_id LIKE '%"+role+"%' ";
                	 }
                	 if(name.length()!=0){
                		 query1=query+"role_name LIKE '%"+name+"%' ";
                	 }
                	 if(shortname.length()!=0){
                		 query1=query+"role_shortname LIKE '%"+shortname+"%' ";
                	 }
                	 if((name.length()!=0)&&(shortname.length()!=0)){
                		 query1= query+"role_name LIKE '%"+name+"%' AND role_shortname LIKE '%"+shortname+"%' ";


                	 }
                	 else if (combo.length() != 0) {
 						query1 = query + "status LIKE '%" + combo + "%' ";
 					} 
 					else if (combo.length() != 0) {
 						query1 = query + "status IS NULL ";
 					} 
					PreparedStatement stmt=con.prepareStatement(query1);
					System.out.println(query1);
//					stmt.setString(1, txtroleid.getText());
//					stmt.setString(2,txtname.getText());
//					stmt.setString(3,txtshortname.getText());
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					

									}catch(Exception e1){e1.printStackTrace();
				}
			}
		});
		btnsearch.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnsearch.setBounds(598, 397, 131, 29);
		framesearch.getContentPane().add(btnsearch);
		
		Button btncancel = new Button("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtroleid.setText("");
				txtname.setText("");
				txtshortname.setText("");
			}
		});
		btncancel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btncancel.setBounds(837, 397, 131, 29);
		framesearch.getContentPane().add(btncancel);
		
//		dm = new DefaultTableModel();
//	    dm.setDataVector(new Object[][] { { "button 1", "" },
//	        { "button 2", "" } }, new Object[] { "Button", "" });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{String sql="Select role_id,role_name,role_shortname,status from role_master";
				String str=txtroleid.getText();
				PreparedStatement pst=con.prepareStatement(sql);
				 pst.setString(1, str);
				System.out.println(sql);
				int row=table.getSelectedRow();
				table.getModel().getValueAt(row, 0).toString();
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					txtroleid.setText(rs.getString(role_id));
					txtname.setText(rs.getString(role_name));
					txtshortname.setText(rs.getString(role_shortname));
					combostatus.setSelectedItem(rs.getString(status));
					
					
				}
            }
			
            catch(Exception ex){
            	System.out.println(ex);
            }
			}
		});
		scrollPane.setBounds(252, 498, 1040, 172);
		framesearch.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		Button btnnew = new Button("NEW");
		btnnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					 comp_role = roleb+role1;
					
					System.out.println(comp_role);
				
					
					
					
					
					
					
				}catch(SQLException e1){
					e1.printStackTrace();
					
				}

				framesearch.dispose();
				Role window = new Role();
				window.framerole.setVisible(true);
			}
		});
		btnnew.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		btnnew.setBounds(1043, 397, 131, 29);
		framesearch.getContentPane().add(btnnew);
	}

}
