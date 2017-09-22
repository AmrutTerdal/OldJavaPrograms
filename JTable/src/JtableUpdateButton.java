import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JtableUpdateButton {

	private JFrame frame;
	private JTable table;
	String ID;
	ResultSet rs;
	private JScrollPane scrollpane;
	DefaultTableModel dtm;
	Vector column;
	Vector V;
	JTable jt;
	JScrollPane scroll;
	int i = 0;
	private JButton btnNewButton;
	String name;
	String pos;
	String team;
	private JLabel lblNewLabel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtableUpdateButton window = new JtableUpdateButton();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JtableUpdateButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 537, 348);
		frame.getContentPane().add(scrollpane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
		
		));
//		String name = table.getValueAt(table.getSelectedRow(), 1).toString();
//		String pos = table.getValueAt(table.getSelectedRow(), 2).toString();
//		String team = table.getValueAt(table.getSelectedRow(), 3).toString();
//		
//		txtName.setText(name);
//		txtPosition.setText(pos);
//		txtTeam.setText(team);
		
		
		
		
		scrollpane.setViewportView(table);

//        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
//        table.getColumn("Button1").setCellRenderer(buttonRenderer);
//        table.getColumn("Button2").setCellRenderer(buttonRenderer);
        
        
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				PreparedStatement statement=null;
//		        Connection con=null;
//				
//	            try{
//	            	con = DriverManager.getConnection("jdbc:mysql://localhost:3307/compay","root","root");
//						String query = "select * from playerstb";
//						PreparedStatement pst= con.prepareStatement(query);
//						ResultSet rs = pst.executeQuery();
//						table.setModel(DbUtils.resultSetToTableModel(rs));
//				
//						
//						
//					}
//				catch(Exception e1 )
//					{
//					e1.printStackTrace();
//					
//					}
				
					
				
				
			
				PreparedStatement statement;
		        Connection connection=null;
				 try
			        {
			        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/compay","root","root");
			        	String query = "select * from playerstb";
			            statement= connection.prepareStatement(query);
			             statement.execute();
			            Vector V = new Vector();
			            while(rs.next())
			            {
			            	ID = String.valueOf(rs.getLong(1));
			            	V.add(ID);
			            			
			            }
			        	
			        	
			        }
			        catch(Exception e1){
			        	
			        }
				 
				 dtm = new DefaultTableModel();
				 dtm.setColumnIdentifiers(column);
				 jt = new JTable();
				 jt.setModel(dtm);
				  jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				  
				  scroll = new JScrollPane(jt);
		            scroll.setHorizontalScrollBarPolicy(
		                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		            scroll.setVerticalScrollBarPolicy(
		                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		            
		            
		            String ID = "";
		            String Name = "";
		            String Person = "";
		            String Team = "";
		            
		            try {
		                statement = connection.prepareStatement("select * from playerstb");
		                ResultSet rs = statement.executeQuery();
		                
		                String numbers = null;
						for(int i = 0;i<numbers.length();i++){		
		                	if (rs.next()) {
		                		ID = rs.getString("ID");
		                		Name = rs.getString("Name");
		                		Person = rs.getString("Person");
		                		Team = rs.getString("Team");
		                		
		                		 dtm.addRow(new Object[]{ID,Name,Person,Team});
				                    i++;
				                }
		                	 if (i < 1) {
				                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
				                }
				                if (i == 1) {
				                    System.out.println(i + " Record Found");
				                } else {
				                    System.out.println(i + " Records Found");
				                }
				                
						}
						
						statement.close();
		            }catch (Exception e3) 
			        {
			            System.out.println(e3.getMessage());
			        }  
			    	finally {
						
						try {
							
							connection.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			    	}
		            
		    	}
			});
		btnRetrieve.setBounds(69, 383, 89, 23);
		frame.getContentPane().add(btnRetrieve);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				PreparedStatement statement=null;
		        Connection connection=null;
		        
//		        dtm.addColumn("ID");
//		        dtm.addColumn("Name");
//		        dtm.addColumn("Position");
		        
		        Connection connect = null;
		        
		        String ID = "";
	            String Name = "";
	            String Person = "";
	            String Team = "";
		        
				
				String host="jdbc:mysql://localhost:3307/compay";
				String username="root";
				String password="root";
				dtm = new DefaultTableModel();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					connect=DriverManager.getConnection(host,username, password);
					statement=connect.prepareStatement("UPDATE playerstb SET Name=?,Person=?,Team=? WHERE ID=?");
		            
					
					statement.setString(1, dtm.getValueAt(i,1).toString());
					statement.setString(2, dtm.getValueAt(i,2).toString());
					statement.setString(3, dtm.getValueAt(i,3).toString());
					statement.setLong(4, Long.parseLong(String.valueOf(dtm.getValueAt(i,0))));
					
					
					
					
				    
					}catch(SQLException | ClassNotFoundException e){
					e.printStackTrace();
				}
				finally {
					
					try {
						statement.close();
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
		        
		        
		       
		        
		        
				
				
			}
		});
		btnUpdate.setBounds(189, 383, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	});
		btnNewButton.setBounds(308, 383, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("HI Label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hello Amrut");
			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(581, 56, 133, 44);
		frame.getContentPane().add(lblNewLabel);
	}
}

