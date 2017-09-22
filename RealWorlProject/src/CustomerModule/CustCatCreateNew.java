package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CustCatCreateNew {

	public JFrame frame;
	static JTextField textCustCatId;
	static JTextField textCustDescri;
	static JTextField textSh_Description;
	static JComboBox comboStatus;
	JLabel lblgetscreenid,lblgetuser,lbldate;
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustCatCreateNew window = new CustCatCreateNew();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
		

static Connection con;

	/**
	 * Create the application.
	 * @param obj_SetGetCategory 
	 */
	public CustCatCreateNew() {
		
		con=dbCon.dbConnector();
		initialize();
		displayDateTime();
		generateCustCateId();
		
	}

	private void generateCustCateId() {
		try
		{
			String query1="Select MAX(cust_category_id)FROM cust_category";
			PreparedStatement pst=con.prepareStatement(query1);
			ResultSet rs=pst.executeQuery(query1);
			rs.next();
			
			String hh=rs.getString(1);
			System.out.println(hh);
			String[] part = hh.split("(?<=\\D)(?=\\d)");
			
			int rolea = Integer.valueOf(part[1]);
			String roleb=part[0];
			int role1=rolea+001;
			String comp_role = roleb+role1;
			
			System.out.println(comp_role);
		
			
			
			
			textCustCatId.setText(comp_role);
			
		}catch(SQLException e2){
			e2.printStackTrace();
			
		}
		
	}

	private void displayDateTime() {
		Thread clock=new Thread(){
			public void run(){
				try {
					
					while(true){
						GregorianCalendar	 cal=new GregorianCalendar();
						
						
						int second=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR_OF_DAY);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						LocalDate localDate = LocalDate.now();
						
						lbldate.setText("Time-"+hour+"-"+minute+"-"+second+" Date-"+dtf.format(localDate));
						
						
					sleep(1000);
					}
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			};
			clock.start();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 787, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		
		JLabel label = new JLabel("Customer Category Screen");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		label.setBackground(Color.WHITE);
		label.setBounds(544, 212, 323, 39);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Customer Category Id");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_1.setBounds(431, 286, 194, 39);
		frame.getContentPane().add(label_1);
		
		textCustCatId = new JTextField();
		textCustCatId.setFont(new Font("SansSerif", Font.BOLD, 12));
		textCustCatId.setText((String) null);
		textCustCatId.setColumns(10);
		textCustCatId.setBounds(646, 284, 199, 39);
        frame.getContentPane().add(textCustCatId);
		
		
		
		
		
		JLabel label_2 = new JLabel("Description");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_2.setBounds(436, 354, 102, 32);
		frame.getContentPane().add(label_2);
		
		textCustDescri = new JTextField();
		textCustDescri.setColumns(10);
		textCustDescri.setBounds(646, 349, 199, 39);
		frame.getContentPane().add(textCustDescri);
		
		
		
		JLabel label_3 = new JLabel("Short Description");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_3.setBounds(437, 414, 147, 32);
		frame.getContentPane().add(label_3);
		
		textSh_Description = new JTextField();
		textSh_Description.setColumns(10);
		textSh_Description.setBounds(646, 409, 199, 39);
		frame.getContentPane().add(textSh_Description);
		
		
		JLabel label_4 = new JLabel("Status");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_4.setBounds(441, 477, 53, 30);
		frame.getContentPane().add(label_4);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboStatus.setBounds(645, 471, 199, 39);
		frame.getContentPane().add(comboStatus);
		
		JButton btnSubmit = new JButton("Insert");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String qry1 = "insert into cust_category (cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status) values (?, ?, ?, ?)";

				try {
					
					PreparedStatement pst = con.prepareStatement(qry1);
					
					pst.setString(1, textCustCatId.getText().toString());
					
										
					pst.setString(2, textCustDescri.getText().toString());
					
					pst.setString(3, textSh_Description.getText().toString());
					pst.setString(4, comboStatus.getSelectedItem().toString());

					pst.execute();

					JOptionPane.showMessageDialog(null, "Values Inserted");

				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		});
		btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSubmit.setBounds(524, 548, 95, 39);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textCustCatId.setText("");
				textCustDescri.setText("");
				textSh_Description.setText("");
				comboStatus.setSelectedItem("");
				
			}
		});
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnClear.setBounds(673, 547, 90, 39);
		frame.getContentPane().add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancel.setBounds(806, 548, 95, 39);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblscreenid = new JLabel("SCREEN ID :");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblscreenid.setBounds(43, 130, 116, 34);
		frame.getContentPane().add(lblscreenid);
		
	  lblgetscreenid = new JLabel("Category");
	  lblgetscreenid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblgetscreenid.setBounds(169, 130, 150, 34);
		frame.getContentPane().add(lblgetscreenid);

		
		JLabel lblrolescreen = new JLabel("Modification Screen");
		lblrolescreen.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblrolescreen.setBounds(460, 130, 156, 34);
		frame.getContentPane().add(lblrolescreen);
		
		JLabel lbluserid = new JLabel("USERID :");
		lbluserid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbluserid.setBounds(698, 130, 95, 34);
		frame.getContentPane().add(lbluserid);
		
		lblgetuser = new JLabel("CustomerAdmin");
		lblgetuser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblgetuser.setBounds(773, 130, 162, 34);
		frame.getContentPane().add(lblgetuser);
//		lblgetuser.setText(login.textField.getText());
		
		lbldate = new JLabel("");
		lbldate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbldate.setBounds(1103, 130, 231, 34);
		frame.getContentPane().add(lbldate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(357, 195, 562, 401);
		frame.getContentPane().add(panel_1);

		
		
	}
}
