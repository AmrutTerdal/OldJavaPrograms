package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class CustomerSubCategory {

	public JFrame frame;
	private JTextField txtSubCat;
	private JTable table;
	private JComboBox comboCategory;
	TableModel model;
	int i=0;
	cateGetSet obj_cateGetSet = new cateGetSet();
	static String category,name,sub_category,sub_cat_status;
	JLabel lblgetscreenid,lblgetuser,lbldate;
	
	//CustSubCatGetSet Obj_CustSubCatGetSet= new CustSubCatGetSet();

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSubCategory window = new CustomerSubCategory();
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
	public CustomerSubCategory() {
		initialize();
		con=dbCon.dbConnector();
		loadComboData();
		loadTimeDate();
	}

	private void loadTimeDate() {
		
		
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

	private void loadComboData() {
		try
		{
			String query1="Select category FROM cust_sub_cat";
			PreparedStatement pst=con.prepareStatement(query1);
			ResultSet rs=pst.executeQuery(query1);
			while(rs.next())
			{
			
			//String id=rs.getString(1);
			System.out.println(rs.getString(1));
			
			comboCategory.addItem(rs.getString(1));
			
			}


		}
		catch (Exception e){


		}

	}

		
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCategory.setBounds(524, 269, 78, 28);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblSubCategory = new JLabel("Sub Category");
		lblSubCategory.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSubCategory.setBounds(524, 323, 102, 28);
		frame.getContentPane().add(lblSubCategory);
		
		comboCategory = new JComboBox();
		comboCategory.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboCategory.setBounds(658, 269, 142, 28);
		frame.getContentPane().add(comboCategory);
		//comboCategory.setModel(aModel);
		
		txtSubCat = new JTextField();
		txtSubCat.setBounds(658, 325, 145, 28);
		frame.getContentPane().add(txtSubCat);
		txtSubCat.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 430, 636, 152);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				i = table.getSelectedRow();
				model =(TableModel) table.getModel();

				 category = model.getValueAt(i, 0).toString();
				 sub_category = model.getValueAt(i, 1).toString();
				 name = model.getValueAt(i, 2).toString();
				 sub_cat_status = model.getValueAt(i, 3).toString();
				
		        obj_cateGetSet.setCategory(category);
		        obj_cateGetSet.setSub_category(sub_category);
		        obj_cateGetSet.setName(name);
		        obj_cateGetSet.setSub_cat_status(sub_cat_status);
				
				
		        CustSubCateUpdateDelete window = new CustSubCateUpdateDelete();
				window.frame.setVisible(true);

				
			     
               
				
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
try{
					
					String cate,subcate;
					cate = comboCategory.getSelectedItem().toString();
					subcate = txtSubCat.getText().toString();
					
					
					
					
                   // String query = "Select CustID,MainContactPersonName,Place,CustStatus from customer_master";
					//String qry1="Select CustID,MainContactPersonName,Place,CustStatus from customer_master where CustID Like '%"+cust+"%'";
					String qry1="Select * from cust_sub_cat where";
					



					// 	String qry3=null;
					if(cate!=null)
					{

						String qry2="category Like '%"+cate+"%'";
						qry1=qry1+" "+qry2;                      

					}
					if((cate==null)||(subcate!=null))
					{

						String qry4="and sub_category Like '%"+subcate+"%'";
						qry1=qry1+" "+qry4;          	
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
		btnSearch.setBounds(557, 381, 87, 36);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				comboCategory.setSelectedItem("");
				txtSubCat.setText("");
						
			}
		});
		btnNewButton.setBounds(670, 381, 93, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(774, 381, 100, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New ");
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CustSubCatCreateNew window = new CustSubCatCreateNew();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(883, 269, 62, 28);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblscreenid = new JLabel("SCREEN ID :");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblscreenid.setBounds(43, 130, 116, 34);
		frame.getContentPane().add(lblscreenid);
		
	  lblgetscreenid = new JLabel("Sub Category");
	  lblgetscreenid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblgetscreenid.setBounds(169, 130, 150, 34);
		frame.getContentPane().add(lblgetscreenid);

		
		JLabel lblrolescreen = new JLabel("Customer Sub Category");
		lblrolescreen.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblrolescreen.setBounds(460, 130, 184, 34);
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
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(48, 195, 871, 265);
//		frame.getContentPane().add(panel_1);

	}
}
