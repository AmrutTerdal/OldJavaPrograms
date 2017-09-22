import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javafx.scene.control.TableColumn;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class JpanelDataLoad {

	private JFrame frame;
	static JTable table;
	static DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JpanelDataLoad window = new JpanelDataLoad();
					window.frame.setVisible(true);
					AddCol();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void AddCol() {
		
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

		
		
		
		
	}
static Connection con;
	
	/**
	 * Create the application.
	 */
	public JpanelDataLoad() {
		initialize();
		con=dbCon.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 795, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 109, 559, 274);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadData = new JButton("Load data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="Select cust_category_id,cust_cat_desc,cust_cat_sh_desc,cust_status FROM cust_category";
				try{
					 PreparedStatement pstmt=con.prepareStatement(query);
						System.out.println(query);
						ResultSet rs = pstmt.executeQuery();
						
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

					
				}catch(Exception e){
					
					 
					e.printStackTrace();
					
									
					

				}
				
				
								
				
			}
		});
		btnLoadData.setBounds(272, 57, 118, 32);
		frame.getContentPane().add(btnLoadData);
	}
}
