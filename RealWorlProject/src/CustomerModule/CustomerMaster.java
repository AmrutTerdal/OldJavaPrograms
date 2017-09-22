package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CustomerMaster {

	JFrame frame;
	private JTextField txtCusto;
	private JTextField txtName;
	static JTextArea txtPlace;
	private JTable table;
	JLabel lblgetuser,lbldate,lblgetscreenid;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMaster window = new CustomerMaster();
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
	 */
	public CustomerMaster() {
		initialize();
		con=dbCon.dbConnector();
		displayTime();
	}

	private void displayTime() {
		{
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

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCustomerId.setBounds(325, 241, 109, 37);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(649, 241, 76, 37);
		frame.getContentPane().add(lblName);
		
		txtCusto = new JTextField();
		txtCusto.setBounds(441, 244, 173, 37);
		frame.getContentPane().add(txtCusto);
		txtCusto.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(735, 241, 173, 37);
		frame.getContentPane().add(txtName);
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblPlace.setBounds(329, 325, 76, 37);
		frame.getContentPane().add(lblPlace);
		
		JButton btnNewButton = new JButton("..");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustMasterPlace window = new CustMasterPlace();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(621, 334, 48, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create New");
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustMasterCreateNew window = new CustMasterCreateNew();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(963, 241, 133, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		txtPlace = new JTextArea();
		txtPlace.setLineWrap(true);
		txtPlace.setBounds(389, 334, 225, 37);
		frame.getContentPane().add(txtPlace);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(678, 338, 48, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboStatus.setBounds(735, 335, 173, 37);
		frame.getContentPane().add(comboStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 486, 829, 208);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String cust,name,place;
					cust = txtCusto.getText();
					name=txtName.getText();
					place=txtPlace.getText();
					String combo = comboStatus.getSelectedItem().toString();

                   // String query = "Select CustID,MainContactPersonName,Place,CustStatus from customer_master";
					//String qry1="Select CustID,MainContactPersonName,Place,CustStatus from customer_master where CustID Like '%"+cust+"%'";
					String qry1="Select CustID,MainContactPersonName,Place,CustStatus from customer_master where";
					



					// 	String qry3=null;
					if(cust!=null)
					{

						String qry2="CustID Like '%"+cust+"%'";
						qry1=qry1+" "+qry2;                      

					}
					if((cust==null)||(name!=null))
					{

						String qry4="and MainContactPersonName Like '%"+name+"%'";
						qry1=qry1+" "+qry4;          	
					}

					if((cust==null)||(name==null)||(place!=null)||(combo!= null))
					{ 

						qry1=qry1+" and Place Like '%"+place+"%'"+"and "+ "CustStatus = '"+combo+"'";

					}

					else if(combo != null){

						qry1=qry1+"and CustStatus='"+combo+"'";
					}













					PreparedStatement pst1= con.prepareStatement(qry1);
					System.out.println(qry1);




					ResultSet rs1 = pst1.executeQuery();


					table.setModel(DbUtils.resultSetToTableModel(rs1));



				}
				catch(Exception e)
				{
					e.printStackTrace();
				}				
			}

				
			
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton_2.setBounds(441, 417, 133, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtCusto.setText("");
				txtName.setText("");
				txtPlace.setText("");
				comboStatus.setSelectedItem("");

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);

				
			}
		});
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnClear.setBounds(752, 417, 133, 35);
		frame.getContentPane().add(btnClear);
//		textArea.setText(CustMasterPlace.txtAreaPlace.getText());
		
		JLabel lblscreenid = new JLabel("SCREEN ID :");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblscreenid.setBounds(43, 130, 116, 34);
		frame.getContentPane().add(lblscreenid);
		
	  lblgetscreenid = new JLabel("");
	  lblgetscreenid.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblgetscreenid.setBounds(169, 130, 150, 34);
		frame.getContentPane().add(lblgetscreenid);

		
		JLabel lblrolescreen = new JLabel("Customer Master");
		lblrolescreen.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblrolescreen.setBounds(460, 130, 156, 34);
		frame.getContentPane().add(lblrolescreen);
		
		JLabel lbluserid = new JLabel("USERID :");
		lbluserid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbluserid.setBounds(698, 130, 95, 34);
		frame.getContentPane().add(lbluserid);
		
		lblgetuser = new JLabel("");
		lblgetuser.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblgetuser.setBounds(773, 130, 162, 34);
		frame.getContentPane().add(lblgetuser);
//		lblgetuser.setText(login.textField.getText());
		
		lbldate = new JLabel("");
		lbldate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbldate.setBounds(1103, 130, 231, 34);
		frame.getContentPane().add(lbldate);
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(48, 195, 871, 265);
//		frame.getContentPane().add(panel_1);

	}
}
