package CustomerModule;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

//import com.toedter.calendar.JDateChooser;

public class JTableDataFetchArray extends JFrame {

	JLabel lblCid;
    JPanel pnlAttendenceList;
    JTable tblAttendenceList;
    JScrollPane spAttendenceList;
    DefaultTableModel dtm;
    private JLabel lblDesc1;
    private JLabel lblLessons;
    private JLabel lblDesc;
    private JComboBox StatusComboBox;
 //   JDateChooser dcDate;
    private JButton btnSearchButton;
    
    Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String qry,qry1,qry2,qry3,qry4,qry5;
	private JButton btnClickHereFor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableDataFetchArray frame = new JTableDataFetchArray();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTableDataFetchArray() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1400, 900);
		
		JPanel testPanel = new JPanel();
		testPanel.setForeground(Color.BLACK);
		testPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		testPanel.setBackground(new Color(0, 191, 255));
		testPanel.setBounds(131, 294, 1115, 350);
		getContentPane().add(testPanel);
		testPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField.setBounds(839, 70, 220, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(839, 112, 220, 30);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(839, 153, 220, 30);
		getContentPane().add(textField_2);

		
		String[] status = {"Active", "Inactive"};
		
		
	
		lblCid = new JLabel("CategoryID");
		lblCid.setBounds(390, 69, 172, 30);
		getContentPane().add(lblCid);
		lblCid.setOpaque(true);
		lblCid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCid.setForeground(Color.WHITE);
		lblCid.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCid.setBackground(new Color(0, 0, 205));
		
		lblDesc1 = new JLabel("Description1");
		lblDesc1.setBounds(390, 152, 172, 30);
		getContentPane().add(lblDesc1);
		lblDesc1.setOpaque(true);
		lblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc1.setForeground(Color.WHITE);
		lblDesc1.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblDesc1.setBackground(new Color(0, 0, 205));
		
		lblDesc = new JLabel("Description");
		lblDesc.setBounds(390, 111, 172, 30);
		getContentPane().add(lblDesc);
		lblDesc.setOpaque(true);
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc.setForeground(Color.WHITE);
		lblDesc.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblDesc.setBackground(new Color(0, 0, 205));
		
		lblLessons = new JLabel("Status");
		lblLessons.setBounds(390, 191, 173, 30);
		getContentPane().add(lblLessons);
		lblLessons.setOpaque(true);
		lblLessons.setHorizontalAlignment(SwingConstants.CENTER);
		lblLessons.setForeground(Color.WHITE);
		lblLessons.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblLessons.setBackground(new Color(0, 0, 205));
		
		StatusComboBox = new JComboBox(status);
		StatusComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		StatusComboBox.setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
		StatusComboBox.setBounds(839, 194, 220, 30);
		getContentPane().add(StatusComboBox);
		StatusComboBox.setBackground(new Color(51, 255, 204));
		
		btnSearchButton = new JButton("Search");
		btnSearchButton.setBounds(631, 85, 126, 38);
		getContentPane().add(btnSearchButton);
		btnSearchButton.setBackground(new Color(0, 255, 255));
		btnSearchButton.setForeground(Color.BLACK);
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/customer_module","root","root");

					String query="Select cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status FROM cust_category where "+" ";
					String cid=textField.getText();
				 	String desc=textField_1.getText();
				 	String desc1=textField_2.getText();
				 	
				 	 
				/*    if(cid.length()!=0){
			        	query=query+"category_id LIKE '%"+cid+"%'";
			        }
				 	
				 	if(cid.length()==0){
				 		query=query+"description LIKE '%"+desc+"%'";
				 		
				 	}
				
                    if((cid.length()==0)||(desc.length()==0)){
                    	query=query+" "+"and description1 LIKE '%"+desc1+"%'";
                    }
                    else if(StatusComboBox.getItemAt(0)=="Active"){
				 		query=query+" "+"or status LIKE 'Inactive'";
				 	}
				 	else
				 		query=query+" "+"status LIKE 'Active'";
                    
                    
                 /*   if((cid.length()!=0)&&(desc.length()==0)&&(desc1.length()==0)){
                    	query=query+"category_id Like '%"+cid+"%'";
                    }
                    if((cid.length()==0)&&(desc.length()!=0)&&(desc1.length()==0)){
                    	query=query+"description Like '%"+desc+"%'";
                    }
                    if((cid.length()==0)&&(desc.length()==0)&&(desc1.length()!=0)){
                    	query=query+"description1 Like '%"+desc1+"%'";
                    }
                    if((cid.length()==0)&&(desc.length()!=0)||(desc1.length()!=0)){
                    	query=query+"description Like '%"+desc+"%'"+"and description1 Like '%"+desc1+"%'";
                    }
                         
                    if((StatusComboBox.getSelectedItem()) != null)
                    {
                        
                    	query=query+"and Status='"+StatusComboBox.getSelectedItem().toString()+"'";
                    }*/
                    
				 // String query = "SELECT cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status FROM cust_category where "+"";
				 	
				 	String qry1="Select cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status FROM cust_category where";
				// 	String qry3=null;
                    if(cid!=null)
                    {
    				 	
                    	String qry2="cust_category_id Like '%"+cid+"%'";
				 		qry1=qry1+" "+qry2;                      
                                              
                    }
                    if((cid==null)||(desc!=null))
                    {
                    	
                    	String qry4="and cust_cat_desc Like '%"+desc+"%'";
				 		qry1=qry1+" "+qry4;          	
                    }
                    
                    if((cid==null)||(desc==null)||(desc1!=null)||((StatusComboBox.getSelectedItem()) != null))
                    { 
    				 	
                    	qry1=qry1+" and cust_cat_sh_desc Like '%"+desc1+"%'"+"and "+ "cust_status = '"+StatusComboBox.getSelectedItem().toString()+"'";
                    	
                    }
                    
                    else if((StatusComboBox.getSelectedItem()) != null)
                   
                    {
                        
                    	query=query+"and cust_status='"+StatusComboBox.getSelectedItem().toString()+"'";
                    }
          
			        PreparedStatement pstmt=con.prepareStatement(qry1);
					System.out.println(qry1);
					ResultSet rs=pstmt.executeQuery();
					
					
					Vector<String> columnNames=new Vector<String>();
					columnNames.add("cust_category_id");
					columnNames.add("cust_cat_desc");
					columnNames.add("cust_cat_sh_desc");
					columnNames.add("cust_status");
					
									
					dtm = new DefaultTableModel()
					{
						boolean[] canEdit = new boolean[]{
								false, false, false, false, false, false, false
						};

						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit[columnIndex];
						}
					};
					dtm.setColumnIdentifiers(columnNames);
					
					while(rs.next())
		            {
		            Vector<String> rowData=new Vector<String>();
		            rowData.add(rs.getString("cust_category_id"));
		            rowData.add(rs.getString("cust_cat_desc"));
		            rowData.add(rs.getString("cust_cat_sh_desc"));
		            rowData.add(rs.getString("cust_status"));
		           
		            dtm.addRow(rowData);
		            }
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				tblAttendenceList = new JTable(dtm);
				tblAttendenceList.setRowHeight(30);
				spAttendenceList = new JScrollPane(tblAttendenceList);
				spAttendenceList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				pnlAttendenceList = new JPanel();
				pnlAttendenceList.setBounds(50, 20, 1000, 300);
				testPanel.add(pnlAttendenceList);
				pnlAttendenceList.setBackground(new Color(255, 255, 255));
				pnlAttendenceList.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial Unicode MS", Font.BOLD, 20), new Color(0, 0, 0)));
				pnlAttendenceList.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
				pnlAttendenceList.setLayout(new CardLayout(0, 0));
				pnlAttendenceList.removeAll();
				pnlAttendenceList.validate();
				pnlAttendenceList.add(spAttendenceList);
				
			}
		});
		btnSearchButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		
		JButton btnClrButton = new JButton("Clear");
		btnClrButton.setBackground(Color.CYAN);
		btnClrButton.setForeground(Color.BLACK);
		btnClrButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		btnClrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg11) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");


			}
		});
		btnClrButton.setBounds(632, 159, 125, 38);
		getContentPane().add(btnClrButton);
		
		btnClickHereFor = new JButton("Click here for Add,update and delete the Data");
		btnClickHereFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			//	new Manupulate().setVisible(true);
			}
		});
		btnClickHereFor.setBounds(490, 665, 421, 38);
		getContentPane().add(btnClickHereFor);
		btnClickHereFor.setForeground(Color.BLACK);
		btnClickHereFor.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		btnClickHereFor.setBackground(Color.CYAN);
			
	}
}