package digiwood;
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
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CustCategory {

	public JFrame frame;
	private JTextField txt_Category_Id;
	private JTextField txtDescription;
	private JTextField txtShrtDesc;
	static JLabel lblClock;
	static JLabel lblDate;
	String query1 = null;
	private JComboBox comboBox;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustCategory window = new CustCategory();
					window.frame.setVisible(true);
					dateTime();
				//	comboData();
//					clock();
					//tableFilter();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
		
		

	
	
	//		try
//		{
//			String query="select * from cust_category";
//			PreparedStatement pst= con.prepareStatement(query);
//			ResultSet rs=pst.executeQuery();
//			
//			while(rs.next()){
//				
//				combo_Customer.addItem(rs.getString("cust_category_id"));
//				
//			}
//			
//		}
//			catch(Exception e3)
//			{
//				e3.printStackTrace();
//			}
		
//	}

	



	//protected static void clock() {

//		Thread clock=new Thread(){
//			public void run(){
//				try {
//					//for(;;){
//					while(true){
//					 Object cal = new GregorianCalendar();
//						
//						int day=((Calendar) cal).get(Calendar.DAY_OF_MONTH);
//						int month=((Calendar) cal).getMaximum(Calendar.MONTH);
//						int year=((Calendar) cal).get(Calendar.YEAR);
//						int second=((Calendar) cal).get(Calendar.SECOND);
//						int minute=((Calendar) cal).get(Calendar.MINUTE);
//						int hour=((Calendar) cal).get(Calendar.HOUR);
//						lblClock.setText("Time "+hour+"-"+minute+"-"+second+"  Date"+year+"/"+month+"/"+day);
//						
//					sleep(1000);
//					}
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//}
//			};
//			clock.start();
//		
//	}
	
	




//	 @Override
//     public void insertUpdate(DocumentEvent e1) {
//         String text = jtfFilter.getText();
//
//         if (text.trim().length() == 0) {
//             rowSorter.setRowFilter(null);
//         } else {
//             rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//         }
//     }
//
//     @Override
//     public void removeUpdate(DocumentEvent e2) {
//         String text = jtfFilter.getText();
//
//         if (text.trim().length() == 0) {
//             rowSorter.setRowFilter(null);
//         } else {
//             rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//         }
//     }





//	protected static void comboData() {
//
//		try{
//			String querycombo = "select cust_category_id from cust_category";
//		
//	        PreparedStatement psmt =  con.prepareStatement(querycombo);
//			ResultSet rs1 = psmt.executeQuery();
//			
//			while(rs1.next()){
//			combo_Customer.addItem(rs1.getString(1));}
//			
//	           rs1.close();
//	           psmt.close();
//        
//	           
//			}catch(Exception e1){
//				e1.printStackTrace();						
//	}
//		
//		
//	}


	public static String getCurrentLocalDateTimeStamp() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
	}

	protected static void dateTime() {
		
		getCurrentLocalDateTimeStamp();
		
		
		
//		Date date = new Date(0);
//		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		lblDate.setText(getCurrentLocalDateTimeStamp());
		
		
		
		
	}







	/**
	 * Create the application.
	 */
	static Connection con=null;
	private static JTable table;
	
	public CustCategory() {
		initialize();	
		con=logdb. dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(236,236,234));
		frame.setBounds(0, 0, 1356, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Category Screen");
		lblNewLabel.setForeground(new Color(236,236,234));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 26));
		lblNewLabel.setBounds(523, 80, 323, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer Category Id");
		lblCustomerId.setForeground(new Color(236,236,234));
		lblCustomerId.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCustomerId.setBounds(331, 163, 194, 39);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblShortDesc = new JLabel("Short Description");
		lblShortDesc.setFont(new Font("Calibri", Font.BOLD, 20));
		lblShortDesc.setForeground(new Color(236,236,234));
		lblShortDesc.setBounds(727, 166, 153, 32);
		frame.getContentPane().add(lblShortDesc);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDescription.setForeground(new Color(236,236,234));
		lblDescription.setBounds(416, 224, 102, 32);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblNewLabel_5 = new JLabel("Status");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(236,236,234));
		lblNewLabel_5.setBounds(819, 225, 53, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		txt_Category_Id = new JTextField();
		txt_Category_Id.setBackground(new Color(248, 248, 255));
		txt_Category_Id.setFont(new Font("Gabriola", Font.PLAIN, 17));
		txt_Category_Id.setBounds(523, 169, 194, 29);
		frame.getContentPane().add(txt_Category_Id);
		txt_Category_Id.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBackground(new Color(248, 248, 255));
		txtDescription.setFont(new Font("Gabriola", Font.PLAIN, 17));
		txtDescription.setBounds(524, 227, 193, 30);
		frame.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		txtShrtDesc = new JTextField();
		txtShrtDesc.setBackground(new Color(248, 248, 255));
		txtShrtDesc.setFont(new Font("Gabriola", Font.PLAIN, 17));
		txtShrtDesc.setBounds(882, 167, 181, 32);
		frame.getContentPane().add(txtShrtDesc);
		txtShrtDesc.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\madhu\\workspace\\digiwood\\img\\button-round-arrow-right-icon.png"));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//			   String id;
//				if(id ==!null){
//				String sql1 = "select * from cust_category where cust_category_id like '%a'  ";
//					
//				}

				
                 try{
					
                	 
                	
                	 String qry1="Select * from cust_category where  ";
                	 String cate,desc,sh_desc;
                	 cate = txt_Category_Id.getText();
                	 desc=txtDescription.getText();
                	 sh_desc=txtShrtDesc.getText();
                	String combo = comboBox.getSelectedItem().toString();
                	
                	
                	 
                	// System.out.println(comboStatus.getItemAt(1));
                
              /* 	 
                	if((cate.length()!=0)&&(desc.length()!=0)&&(sh_desc.length()!=0)){
                		 query1= query+"cust_cat_desc LIKE '%"+desc+"%' AND cust_cat_desc LIKE '%"+desc+"%' AND cust_cat_sh_desc LIKE '%"+sh_desc+"%' ";
                		 
                	 }
					
                	 
                    if ((desc.length() != 0) && (sh_desc.length() != 0)) {
						query1 = query + "cust_cat_desc LIKE '%" + desc + "%' AND cust_cat_sh_desc LIKE '%" + sh_desc
								+ "%' ";
					} else if (desc.length() != 0) {
						query1 = query + "cust_cat_desc LIKE '%" + desc + "%' ";
					}

					if ((cate.length() != 0) && (sh_desc.length() != 0)) {
						query1 = query + "cust_cat_desc LIKE '%" + desc + "%' AND cust_cat_sh_desc LIKE '%" + sh_desc
								+ "%' ";
					}

					else if (cate.length() != 0) {
						query1 = query + "cust_category_id LIKE '%" + cate + "%' ";
					} else if (sh_desc.length() != 0) {
						query1 = query + "cust_cat_sh_desc LIKE '%" + sh_desc + "%' ";
					}
					*/
					

				/*	 if(cate.length()!=0){
					 query1=query + "cust_category_id LIKE'%"+cate+"%'";
					 }
					 else if ((cate.length() == 0) || (desc.length() != 0)) {
					 query1 = query + "cust_category_id LIKE '%" + cate + "%'AND cust_cat_desc LIKE '%" + desc+ "%' ";
					 }
                	if((desc.length()==0)||(sh_desc.length()!=0)){
                		query1=query +"cust_cat_desc LIKE '%" + desc + "%' and cust_cat_sh_desc LIKE '%" + sh_desc + "%' ";
                	 }
                 
                	else if((combo.length()!=0)){
             		query1=query +"cust_status LIKE '%" + combo + "%' ";
             	}
             	*/
                	
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
                        
//                        else if(combo!= null){
//                            
//                        	qry1=qry1+"and Status='"+combo+"'";
//                        }
                	

                	
                	
                	
                     //   JTableDataFetchArray
                	
                	
//                	 if(comboBox.getSelectedItem().toString()!=null) {
//                 		query="Select * from cust_category where cust_status='"+comboBox.getSelectedItem().toString()+"'";
//                 	}
                 	
                	 
                	       

                	 
                	 
                	 
                	 
                	 
                	 
                	 
                	 
//               	 if((cate.length()!=0)&&(desc.length()!=0)){
//                		 query1= query1+"cust_category_id LIKE '%"+cate+"%' or cust_cat_desc LIKE '%"+desc+"%' ";
//                	 }
//                	 if((cate.length()!=0)&&(sh_desc.length()!=0)){
//                		 query1= query1+"cust_category_id LIKE '%"+cate+"%' or cust_cat_sh_desc LIKE '%"+sh_desc+"%' ";
//                		 }
                	 
                	 
                	 
                	 
                		 

                	 
					
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
		btnNewButton.setBounds(372, 280, 139, 32);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String category_id = table.getValueAt(table.getSelectedRow(), 1).toString();
				String Short_Description  = table.getValueAt(table.getSelectedRow(), 2).toString();
				String Description = table.getValueAt(table.getSelectedRow(), 3).toString();
				
				
				txt_Category_Id.setText(category_id);
				txtShrtDesc.setText(Short_Description);
				txtDescription.setText(Description);
				
			}
		});
		
		scrollPane.setBounds(372, 341, 679, 242);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		 
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\madhu\\workspace\\digiwood\\img\\button-round-arrow-right-icon.png"));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt_Category_Id.setText("");
				txtDescription.setText("");
				txtShrtDesc.setText("");
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				
				
				
//				 for(int i = 0; i < table.getRowCount(); i++){//For each row
//				        for(int j = 0; j < table.getColumnCount(); j++){//For each column in that row
//				            if(table.getModel().getValueAt(i, j).equals("STRING_TO_SEARCH")){//Search the model
//				                System.out.println(table.getModel().getValueAt(i, j));//Print if found string
//				            }
//				        }//For loop inner
//				    }//For loop outer
			}
		});
		btnNewButton_1.setBounds(536, 280, 139, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\madhu\\workspace\\digiwood\\img\\button-round-arrow-right-icon.png"));
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result =JOptionPane.showConfirmDialog(null, "Are You Sure Want to clear", null, JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
				if(result==JOptionPane.YES_OPTION){
					System.exit(0);
				}
				else{
					
				}
			}
		});
		btnNewButton_4.setBounds(693, 279, 139, 32);
		frame.getContentPane().add(btnNewButton_4);
		
		lblDate = new JLabel("");
		lblDate.setForeground(new Color(236,236,234));
		lblDate.setBackground(new Color(238, 232, 170));
		lblDate.setBounds(902, 113, 177, 32);
		frame.getContentPane().add(lblDate);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Gabriola", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboBox.setBounds(882, 231, 102, 25);
		frame.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85,140,137));
		panel.setBounds(0, 0, 1362, 437);
		frame.getContentPane().add(panel);
		
	}
}