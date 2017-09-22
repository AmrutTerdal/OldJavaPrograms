package CustomerModule;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.sql.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class CustCategoryModule {

	public JFrame CustCategoryframe;
	private static JTextField txt_Category_Id;
	private static JTextField txtDescription;
	private static JTextField txtShrtDesc;
	static JLabel lblClock;
	static JLabel lblDate;
	String query1 = null;
	private static JComboBox comboStatusMain;
	TableModel model;
	int i=0;

	SetGetCategory Obj_SetGetCategory= new SetGetCategory();

	

	static JTextField txt_CustCategoryID,txt_Desc,txt_ShDesc;
	static JComboBox comboStatus;

	JScrollPane scrollPane = new JScrollPane();





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustCategoryModule window = new CustCategoryModule();
					window.CustCategoryframe.setVisible(true);
					




					//	comboData();
					//					clock();
					//tableFilter();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}




		});
	}


	

	/**
	 * Create the application.
	 */
	static Connection con;

	private static JTable table;

	public CustCategoryModule() {
		initialize();
        displayTime();

		con=dbCon.dbConnector();

	}







	private void displayTime() {
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
						
						lblDate.setText("Time-"+hour+"-"+minute+"-"+second+" Date-"+dtf.format(localDate));
						
						
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
		CustCategoryframe = new JFrame();
		CustCategoryframe.getContentPane().setBackground(SystemColor.text);
		CustCategoryframe.setBounds(0, 0, 1356, 768);
		CustCategoryframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CustCategoryframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		CustCategoryframe.getContentPane().setLayout(null);
        JLabel label = new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg"));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        CustCategoryframe.setContentPane(label);


		JLabel lblNewLabel = new JLabel("Customer Category Screen");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel.setBounds(438, 123, 240, 39);
		CustCategoryframe.getContentPane().add(lblNewLabel);

		JLabel lblCustomerId = new JLabel("Customer Category Id");
		lblCustomerId.setForeground(Color.BLACK);
		lblCustomerId.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblCustomerId.setBounds(241, 267, 194, 39);
		CustCategoryframe.getContentPane().add(lblCustomerId);

		JLabel lblShortDesc = new JLabel("Short Description");
		lblShortDesc.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblShortDesc.setForeground(Color.BLACK);
		lblShortDesc.setBounds(675, 270, 147, 32);
		CustCategoryframe.getContentPane().add(lblShortDesc);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setBounds(245, 328, 102, 32);
		CustCategoryframe.getContentPane().add(lblDescription);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setBounds(678, 329, 53, 30);
		CustCategoryframe.getContentPane().add(lblStatus);

		txt_Category_Id = new JTextField();
		txt_Category_Id.setForeground(Color.BLACK);
		txt_Category_Id.setBackground(SystemColor.activeCaption);
		txt_Category_Id.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		txt_Category_Id.setBounds(433, 273, 194, 29);
		CustCategoryframe.getContentPane().add(txt_Category_Id);
		txt_Category_Id.setColumns(10);

		txtDescription = new JTextField();
		txtDescription.setForeground(Color.BLACK);
		txtDescription.setBackground(SystemColor.activeCaption);
		txtDescription.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		txtDescription.setBounds(434, 331, 193, 30);
		CustCategoryframe.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);

		txtShrtDesc = new JTextField();
		txtShrtDesc.setForeground(Color.BLACK);
		txtShrtDesc.setBackground(SystemColor.activeCaption);
		txtShrtDesc.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		txtShrtDesc.setBounds(832, 271, 181, 32);
		CustCategoryframe.getContentPane().add(txtShrtDesc);
		txtShrtDesc.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(SystemColor.inactiveCaption);
		btnSearch.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		btnSearch.setForeground(Color.BLACK);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				try{


					String qry1="Select cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status from cust_category where";
					String cate,desc,sh_desc;
					cate = txt_Category_Id.getText();
					desc=txtDescription.getText();
					sh_desc=txtShrtDesc.getText();
					String combo = comboStatusMain.getSelectedItem().toString();




					// 	String qry3=null;
					if(cate!=null)
					{

						String qry2="cust_category_id Like '%"+cate+"%'";
						qry1=qry1+" "+qry2;                      

					}
					if((cate==null)||(desc!=null))
					{

						String qry4="and cust_cat_desc Like '%"+desc+"%'";
						qry1=qry1+" "+qry4;          	
					}

					if((cate==null)||(desc==null)||(sh_desc!=null)||(combo!= null))
					{ 

						qry1=qry1+" and cust_cat_sh_desc Like '%"+sh_desc+"%'"+"and "+ "cust_status = '"+combo+"'";

					}

					else if(combo != null){

						qry1=qry1+"and Status='"+combo+"'";
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
		btnSearch.setBounds(413, 384, 95, 32);
		CustCategoryframe.getContentPane().add(btnSearch);getClass();











		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {






			}
		});

		scrollPane.setBounds(212, 449, 815, 223);
		CustCategoryframe.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				i = table.getSelectedRow();
				model =(TableModel) table.getModel();

				String CustCategoryID = model.getValueAt(i, 0).toString();
				String desc = model.getValueAt(i, 1).toString();
				String shDesc = model.getValueAt(i, 2).toString();
				String statusCombo = model.getValueAt(i, 3).toString();

				Obj_SetGetCategory.setCustCategoryID(CustCategoryID);
				Obj_SetGetCategory.setDesc(desc);
				Obj_SetGetCategory.setShDesc(shDesc);
				Obj_SetGetCategory.setStatusCombo(statusCombo);
				
				Cust_UpdateDelete window = new Cust_UpdateDelete(Obj_SetGetCategory);
				window.frame.setVisible(true);


				//CustCate_updateDelete updateDelete = new CustCate_updateDelete();
				//updateDelete.setVisible(true);





				//JOptionPane.showMessageDialog(null, "hiiiiiiiii");

				//System.out.println(i);


				//				System.out.println(model);

				//				txt_Category_Id.setText(model.getValueAt(i, 0).toString());
				//				txtDescription.setText(model.getValueAt(i, 1).toString());
				//				txtShrtDesc.setText(model.getValueAt(i, 2).toString());
				//				comboStatusMain.setSelectedItem(model.getValueAt(i, 3).toString()); 








				//System.out.println(CustCategoryID);
				//System.out.println(Desc);

			}
		});

		scrollPane.setViewportView(table);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(SystemColor.inactiveCaption);
		btnReset.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		btnReset.setForeground(Color.BLACK);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txt_Category_Id.setText("");
				txtDescription.setText("");
				txtShrtDesc.setText("");

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);




			}
		});
		btnReset.setBounds(574, 384, 102, 32);
		CustCategoryframe.getContentPane().add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(SystemColor.inactiveCaption);
		btnExit.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		btnExit.setForeground(Color.BLACK);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int result =JOptionPane.showConfirmDialog(null, "Are You Sure Want to clear", null, JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
				if(result==JOptionPane.YES_OPTION){
				CustCategoryframe.dispose();

				}
				else{

				}
			}
		});
		btnExit.setBounds(755, 384, 97, 32);
		CustCategoryframe.getContentPane().add(btnExit);

		lblDate = new JLabel("");
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblDate.setForeground(Color.BLACK);
		lblDate.setBackground(new Color(238, 232, 170));
		lblDate.setBounds(1071, 126, 281, 34);
		CustCategoryframe.getContentPane().add(lblDate);

		comboStatusMain = new JComboBox();
		comboStatusMain.setBackground(SystemColor.activeCaption);
		comboStatusMain.setForeground(Color.BLACK);
		comboStatusMain.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		comboStatusMain.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboStatusMain.setBounds(835, 327, 178, 32);
		CustCategoryframe.getContentPane().add(comboStatusMain);
		

		

		JButton btnNewButton = new JButton("Create New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustCatCreateNew window = new CustCatCreateNew();
				window.frame.setVisible(true);

			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(1061, 270, 119, 30);
		CustCategoryframe.getContentPane().add(btnNewButton);
		
		JLabel lblScreen = new JLabel("Screen ID");
		lblScreen.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblScreen.setBounds(10, 126, 85, 34);
		CustCategoryframe.getContentPane().add(lblScreen);
		
		JLabel lblGetScreen = new JLabel(": Category");
		lblGetScreen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGetScreen.setBounds(99, 126, 147, 34);
		CustCategoryframe.getContentPane().add(lblGetScreen);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUserId.setBounds(764, 128, 69, 34);
		CustCategoryframe.getContentPane().add(lblUserId);
		
		JLabel lblGetUser = new JLabel("CustomerAdmin");
		lblGetUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGetUser.setBounds(835, 126, 147, 34);
		CustCategoryframe.getContentPane().add(lblGetUser);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 128, 1362, 34);
		CustCategoryframe.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 236, 815, 201);
		CustCategoryframe.getContentPane().add(panel_1);

	}
}