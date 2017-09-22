package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import javafx.embed.swing.JFXPanel;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Cust_UpdateDelete {

	public JFrame frame;
	static JTextField txt_CustCategoryID;
	static JTextField txt_Desc;
	static JTextField txt_ShDesc;
	static JComboBox comboStatus;
	
	
	static SetGetCategory obj_SetGetCategory;
	static JLabel lbldate;
	JLabel lblgetscreenid;
	JLabel lblgetuser;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cust_UpdateDelete window = new Cust_UpdateDelete(obj_SetGetCategory);
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}

	
	
	

static Connection con;
private JTable table;

	/**
	 * Create the application.
	 * @param obj_SetGetCategory 
	 */
	public Cust_UpdateDelete(SetGetCategory obj_SetGetCategory) {
		this.obj_SetGetCategory=obj_SetGetCategory;
		con=dbCon.dbConnector();
		initialize();
		displaytime();
	}

	private void displaytime() {
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
		
		JLabel label = new JLabel("Customer Category Screen");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		label.setBackground(Color.WHITE);
		label.setBounds(422, 212, 323, 39);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Customer Category Id");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_1.setBounds(419, 286, 194, 39);
		frame.getContentPane().add(label_1);
		
		txt_CustCategoryID = new JTextField();
		txt_CustCategoryID.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_CustCategoryID.setEnabled(false);
		txt_CustCategoryID.setEditable(false);
		txt_CustCategoryID.setText((String) null);
		txt_CustCategoryID.setColumns(10);
		txt_CustCategoryID.setBounds(634, 284, 199, 39);
		frame.getContentPane().add(txt_CustCategoryID);
		txt_CustCategoryID.setText(obj_SetGetCategory.getCustCategoryID());
		
		
		
		
		JLabel label_2 = new JLabel("Description");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_2.setBounds(424, 354, 102, 32);
		frame.getContentPane().add(label_2);
		
		txt_Desc = new JTextField();
		txt_Desc.setColumns(10);
		txt_Desc.setBounds(634, 349, 199, 39);
		frame.getContentPane().add(txt_Desc);
		txt_Desc.setText(obj_SetGetCategory.getDesc());
		
		
		JLabel label_3 = new JLabel("Short Description");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_3.setBounds(429, 414, 147, 32);
		frame.getContentPane().add(label_3);
		
		txt_ShDesc = new JTextField();
		txt_ShDesc.setColumns(10);
		txt_ShDesc.setBounds(634, 409, 199, 39);
		frame.getContentPane().add(txt_ShDesc);
		txt_ShDesc.setText(obj_SetGetCategory.getShDesc());
		
		JLabel label_4 = new JLabel("Status");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_4.setBounds(433, 475, 53, 30);
		frame.getContentPane().add(label_4);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboStatus.setBounds(633, 471, 199, 39);
		frame.getContentPane().add(comboStatus);
		comboStatus.setSelectedItem(obj_SetGetCategory.getStatusCombo());
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					//"update Employee set EID='"+textUid.getText()+"',Name='"+textName.getText()+"',Surname='"+textSurname.getText()+"',Age='"+textAge.getText()+"' where UID='"+textUid.getText()+"' ";
					
					String query = "update cust_category set cust_cat_desc='"+txt_Desc.getText()+"',cust_cat_sh_desc='"+txt_ShDesc.getText()+"',cust_status='"+comboStatus.getSelectedItem().toString()+"' where cust_category_id ='"+txt_CustCategoryID.getText()+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Update Successfull");
					
					String qry1="Select cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status from cust_category where cust_category_id ='"+txt_CustCategoryID.getText()+"'";
					
					
					PreparedStatement pst1= con.prepareStatement(qry1);
					System.out.println(qry1);




					ResultSet rs1 = pst1.executeQuery();


					table.setModel(DbUtils.resultSetToTableModel(rs1));

					
					
					
					
				}catch(Exception e){
					e.printStackTrace();
					
				}
				
			}
		});
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdate.setBounds(576, 541, 74, 32);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancel.setBounds(744, 541, 82, 32);
		frame.getContentPane().add(btnCancel);
		
		JButton btnNewButton = new JButton("Delete");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					int result = JOptionPane.showConfirmDialog(null, "Aru Sure?", null, JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					if(result==JOptionPane.YES_OPTION){
						
						String query1 = "delete from cust_category where cust_category_id ='"+txt_CustCategoryID.getText()+"'";
						PreparedStatement pst = con.prepareStatement(query1);
						pst.execute();
						JOptionPane.showConfirmDialog(null, "Data Deleted Successfully");

					}
					
										
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(660, 541, 74, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblscreenid = new JLabel("SCREEN ID :");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblscreenid.setBounds(43, 130, 116, 34);
		frame.getContentPane().add(lblscreenid);
		
	  lblgetscreenid = new JLabel("Category");
	  lblgetscreenid.setFont(new Font("SansSerif", Font.BOLD, 18));
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
		
		lblgetuser = new JLabel("Customer Admin");
		lblgetuser.setFont(new Font("SansSerif", Font.BOLD, 18));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 641, 784, 39);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
	}
}
