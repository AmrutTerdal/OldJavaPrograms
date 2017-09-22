package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CustMasterPlace {

	static JFrame frame;
	static JComboBox comboDistri;
	static JComboBox comboState;
	static JTextArea txtAddress,txtAreaPlace;
	static String comp;
	static ArrayList AutoLoad = new ArrayList();
	static ArrayList lst_id=new ArrayList();
	static String name;
	static DefaultListModel<String> listModelId = new DefaultListModel();
	static JComboBox comboPlace;
	static ResultSet   rs1;
	static String state;
	static String half;
	




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustMasterPlace window = new CustMasterPlace();
					window.frame.setVisible(true);
					//comboNEwSet();
					DatabaseLoad();

					//listPlaceSet();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}




		});
	}

	

	private static void DatabaseLoad() {
		try
		{
			String query1="Select Place FROM customer_master";
			PreparedStatement pst=con.prepareStatement(query1);
			ResultSet rs=pst.executeQuery(query1);
			rs.next();

			String id=rs.getString(1);


		}
		catch (Exception e){


		}

	}



	/**
	 * Create the application.
	 */

	static Connection con;
	private static JList list;

	public CustMasterPlace() {

		initialize();

		con=dbCon.dbConnector();
		//comboNEwSet();

	}

//	private static void comboNEwSet() {
//		
//		
//		
//		
//
//		try{
//			//String Dstate= comboState.getSelectedItem().toString();
//			//			
//			String state = comboState.getSelectedItem().toString();
//
//			System.out.println("D state is" +state);
//			//String querycombo = "Select state FROM states";
//			String querycombo = "Select '"+state+"' FROM states";
//			//String querycombo = "Select AndhraPradesh FROM states";
//			//+ " where cust_category_id Like '%"+Dstate+"%'";
//
//
//
//
//
//			PreparedStatement st =  con.prepareStatement(querycombo);
//			rs1 = st.executeQuery();
//			while(rs1.next()){
//				System.out.println("Query"+rs1);
//				
//				comboDistri.addItem(rs1.getString(1));  
//				
//				//comboDistri.setModel(new DefaultComboBoxModel(new String[] {Dstate})); 
//
//			}
//			rs1.close();
//			st.close();
//
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//
//
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("SansSerif", Font.BOLD, 14));
		//frame.setBounds(100, 100, 136, 169);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblState.setBounds(10, 11, 52, 28);
		frame.getContentPane().add(lblState);

		JLabel lblNewLabel = new JLabel("District");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(11, 48, 61, 28);
		frame.getContentPane().add(lblNewLabel);

		comboState = new JComboBox();
		comboState.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
							//String Dstate= comboState.getSelectedItem().toString();
					comboDistri.setModel(new DefaultComboBoxModel(new String[] {""}));		
				
					
					state = comboState.getSelectedItem().toString();

					System.out.println("D state is" +state);
					
					String querycombo = "Select "+state+" FROM states";
					//String querycombo = "Select AndhraPradesh FROM states";
					//+ " where cust_category_id Like '%"+Dstate+"%'";





					PreparedStatement st =  con.prepareStatement(querycombo);
					rs1 = st.executeQuery();
					while(rs1.next()){
						System.out.println("Query = "+querycombo);
						System.out.println("Query"+rs1);
						
						comboDistri.addItem(rs1.getString(1));  
						
						//comboDistri.setModel(new DefaultComboBoxModel(new String[] {Dstate})); 

					}
					rs1.close();
					st.close();


				}catch(Exception e){
					e.printStackTrace();
				
				
			}
			}
		});
		comboState.setModel(new DefaultComboBoxModel(new String[] {"", "AndhraPradesh", "Goa", "Karnataka"}));
		comboState.setEditable(true);
		comboState.setBounds(72, 11, 137, 28);
		
		frame.getContentPane().add(comboState);
		AutoCompletion.enable(comboState);

		comboDistri = new JComboBox();
		comboDistri.setModel(new DefaultComboBoxModel(new String[] {"", "<dynamic>"}));
		comboDistri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {



			}
		});
		comboDistri.setEditable(true);
		comboDistri.setModel(new DefaultComboBoxModel(new String[] {""}));
		//comboDistri.setModel(new DefaultComboBoxModel(new String[] {"","Anantapur", "Chittoor", "East Godavari", "Guntur", "Cuddapah", "Krishna", "Kurnool", "Prakasam", "Nellore", "Srikakulam", "Vishakhapatnam", "Vizianagaram", "West Godavari"}));
		comboDistri.setBounds(71, 50, 138, 28);
		comboDistri.setEditable(true);
		frame.getContentPane().add(comboDistri);
		AutoCompletion.enable(comboDistri);





		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String distri = comboDistri.getSelectedItem().toString();
				state = comboState.getSelectedItem().toString();
				String place = txtAreaPlace.getText().toString();

				String space = ", ";

				String half = distri+space+state;
				
				comp = distri+space+state+space+place;

				System.out.println("complete = "+comp);
				txtAddress.setText(comp);

			}
		});
		btnNewButton.setBounds(81, 146, 89, 28);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboDistri.setSelectedItem("");
				comboState.setSelectedItem("");
				txtAreaPlace.setText("");
				txtAddress.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_1.setBounds(191, 146, 89, 28);
		frame.getContentPane().add(btnNewButton_1);

		txtAddress = new JTextArea();
		txtAddress.setLineWrap(true);
		txtAddress.setEditable(false);
		txtAddress.setBounds(82, 184, 198, 76);
		frame.getContentPane().add(txtAddress);

		JLabel lblNewLabel_1 = new JLabel("Place");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(13, 85, 52, 28);
		frame.getContentPane().add(lblNewLabel_1);

		txtAreaPlace = new JTextArea();
		txtAreaPlace.setLineWrap(true);
		txtAreaPlace.setBounds(72, 82, 198, 53);
		frame.getContentPane().add(txtAreaPlace);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(10, 202, 68, 28);
		frame.getContentPane().add(lblAddress);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				CustomerMaster window = new CustomerMaster();
				window.frame.setVisible(true);
				CustomerMaster.txtPlace.setText(half);

			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.setBounds(290, 228, 75, 28);
		frame.getContentPane().add(btnNewButton_2);

		

	}
}

