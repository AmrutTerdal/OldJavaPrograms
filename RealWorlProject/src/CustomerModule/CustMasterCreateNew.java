package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CustMasterCreateNew {

	public JFrame frame;
	private JTextField txtCustomerId;
	private JTextField txtCustName;
	private JTextField txtCustCate;
	private JTextField txtCustSubCat;
	private JTextField txtPlace;
	private JTextField txtDistrict;
	private JTextField txtRemarks;
	private JTextField txtEmail;
	private JTextField txtPhone1;
	private JTextField txtPhone2;
	private JTextField txtContctPerson;
	private JComboBox combStatus;
	JComboBox comboState;
	JComboBox comboCustomerType;
	JTextArea txtAreaAddr1,txtAreaAddr2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustMasterCreateNew window = new CustMasterCreateNew();
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
	public CustMasterCreateNew() {
		initialize();
		con=dbCon.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 1378, 785);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCustomerId.setBounds(265, 207, 103, 34);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCustomerName.setBounds(265, 252, 111, 34);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblCustomerType = new JLabel("Customer Type");
		lblCustomerType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCustomerType.setBounds(265, 297, 111, 34);
		frame.getContentPane().add(lblCustomerType);
		
		JLabel lblCustomerCategory = new JLabel("Customer Category");
		lblCustomerCategory.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCustomerCategory.setBounds(265, 342, 135, 34);
		frame.getContentPane().add(lblCustomerCategory);
		
		JLabel lblCustomerSubCategory = new JLabel("Customer Sub Category");
		lblCustomerSubCategory.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCustomerSubCategory.setBounds(265, 387, 170, 34);
		frame.getContentPane().add(lblCustomerSubCategory);
		
		JLabel lblAddress = new JLabel("Address 1");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(265, 454, 83, 34);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblAddress2 = new JLabel("Address 2");
		lblAddress2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress2.setBounds(265, 540, 83, 34);
		frame.getContentPane().add(lblAddress2);
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPlace.setBounds(265, 613, 51, 34);
		frame.getContentPane().add(lblPlace);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDistrict.setBounds(739, 205, 65, 34);
		frame.getContentPane().add(lblDistrict);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblState.setBounds(739, 256, 78, 34);
		frame.getContentPane().add(lblState);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRemarks.setBounds(739, 301, 95, 34);
		frame.getContentPane().add(lblRemarks);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmailId.setBounds(739, 346, 111, 34);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblPhone = new JLabel("Phone 1");
		lblPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhone.setBounds(739, 396, 95, 34);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblPhone_1 = new JLabel("Phone 2");
		lblPhone_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhone_1.setBounds(740, 441, 78, 34);
		frame.getContentPane().add(lblPhone_1);
		
		JLabel lblMainContactPerson = new JLabel("Main Contact Person Name");
		lblMainContactPerson.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMainContactPerson.setBounds(739, 486, 193, 34);
		frame.getContentPane().add(lblMainContactPerson);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblStatus.setBounds(739, 540, 159, 34);
		frame.getContentPane().add(lblStatus);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(439, 209, 173, 34);
		frame.getContentPane().add(txtCustomerId);
		
		txtCustName = new JTextField();
		txtCustName.setColumns(10);
		txtCustName.setBounds(439, 254, 173, 34);
		frame.getContentPane().add(txtCustName);
		
		txtCustCate = new JTextField();
		txtCustCate.setColumns(10);
		txtCustCate.setBounds(440, 344, 170, 34);
		frame.getContentPane().add(txtCustCate);
		
		txtCustSubCat = new JTextField();
		txtCustSubCat.setColumns(10);
		txtCustSubCat.setBounds(439, 384, 172, 34);
		frame.getContentPane().add(txtCustSubCat);
		
		txtPlace = new JTextField();
		txtPlace.setColumns(10);
		txtPlace.setBounds(439, 615, 173, 34);
		frame.getContentPane().add(txtPlace);
		
		txtDistrict = new JTextField();
		txtDistrict.setColumns(10);
		txtDistrict.setBounds(941, 209, 170, 34);
		frame.getContentPane().add(txtDistrict);
		
		txtRemarks = new JTextField();
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(941, 303, 170, 34);
		frame.getContentPane().add(txtRemarks);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(941, 348, 170, 34);
		frame.getContentPane().add(txtEmail);
		
		txtPhone1 = new JTextField();
		txtPhone1.setColumns(10);
		txtPhone1.setBounds(941, 393, 170, 34);
		frame.getContentPane().add(txtPhone1);
		
		txtPhone2 = new JTextField();
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(941, 438, 170, 34);
		frame.getContentPane().add(txtPhone2);
		
		txtContctPerson = new JTextField();
		txtContctPerson.setColumns(10);
		txtContctPerson.setBounds(942, 488, 170, 34);
		frame.getContentPane().add(txtContctPerson);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String qry1 = "insert into customer_master (CustID,CustomerName,CustType,CustCate,CustSubCate,Address1,Address2,Place,District,State,Remarks,EmailID,Phone1,Phone2,MainContactPersonName,CustStatus,CreatedDateTime) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,now())";

				//CustID,CustomerName,CustType,CustCate,CustSubCate,Address1,Address2,Place,District,State,Remarks,EmailID,Phone1,Phone2,
				//MainContactPersonName,CustStatus,CreatedDateTime
				
				
				try {
					
					PreparedStatement pst = con.prepareStatement(qry1);
					
				
				pst.setString(1, txtCustomerId.getText().toString());
				pst.setString(2, txtCustName.getText().toString());
				pst.setString(3, comboCustomerType.getSelectedItem().toString());
				pst.setString(4, txtCustCate.getText().toString());
				
				pst.setString(5, txtCustSubCat.getText().toString());
				
				pst.setString(6, txtAreaAddr1.getText().toString());
				pst.setString(7, txtAreaAddr2.getText().toString());
				pst.setString(8, txtPlace.getText().toString());
				pst.setString(9, txtDistrict.getText().toString());
				pst.setString(10, comboState.getSelectedItem().toString());
				
				
				pst.setString(11, txtRemarks.getText().toString());
				pst.setString(12, txtEmail.getText().toString());
				pst.setString(13, txtPhone1.getText().toString());
				pst.setString(14, txtPhone2.getText().toString());
				pst.setString(15, txtContctPerson.getText().toString());
				pst.setString(16, combStatus.getSelectedItem().toString());
				
				
				
					
//					pst.setString(3, textSh_Description.getText().toString());
//					

					pst.execute();

					JOptionPane.showMessageDialog(null, "Values Inserted");

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			
		
				
			}
		});
		btnSubmit.setBounds(766, 660, 95, 34);
		frame.getContentPane().add(btnSubmit);
		
	    combStatus = new JComboBox();
	    combStatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		combStatus.setBounds(943, 542, 168, 34);
		frame.getContentPane().add(combStatus);
		
		txtAreaAddr2 = new JTextArea();
		txtAreaAddr2.setLineWrap(true);
		txtAreaAddr2.setBounds(439, 521, 173, 67);
		frame.getContentPane().add(txtAreaAddr2);
		
		txtAreaAddr1 = new JTextArea();
		txtAreaAddr1.setLineWrap(true);
		txtAreaAddr1.setBounds(439, 443, 173, 67);
		frame.getContentPane().add(txtAreaAddr1);
		
		comboCustomerType = new JComboBox();
		comboCustomerType.setModel(new DefaultComboBoxModel(new String[] {"", "OUTLET", "ADS"}));
		comboCustomerType.setBounds(439, 299, 170, 34);
		frame.getContentPane().add(comboCustomerType);
		
		comboState = new JComboBox();
		comboState.setModel(new DefaultComboBoxModel(new String[] {"", "AndhraPradesh\t", "Arunachal Pradesh\t", "Assam\t", "Bihar\t", "Chahattisgarh\t", "Goa\t", "Gujarat\t", "Haryana\t", "Himachal Pradesh\t", "Jammu and Kashmir ", "Jharkhand\t", "Karnataka\t", "Kerala\t", "Madhya Pradesh\t", "Maharashtra\t", "Manipur\t", "Meghalaya\t", "Mizoram\t\t", "Nagaland\t", "Odisha (Orissa)\t", "Punjab\t", "Rajasthan\t", "Sikkim\t", "Tamil Nadu\t", "Telangana\t", "Tripura\t", "Uttar Pradesh\t", "Uttarakhand\t", "West Bengal"}));
		comboState.setBounds(941, 254, 170, 34);
		frame.getContentPane().add(comboState);
	}
}
