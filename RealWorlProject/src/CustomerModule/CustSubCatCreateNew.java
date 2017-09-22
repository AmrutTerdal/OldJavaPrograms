package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CustSubCatCreateNew {

	public JFrame frame;
	private JTextField txtSubCate;
	private JTextField txtName;
	private JTextField txtCate;
	static JLabel lblgetuser;
	static JLabel lbldate;
	static JLabel lblgetscreenid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustSubCatCreateNew window = new CustSubCatCreateNew();
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
	static Connection con;
	
	
	public CustSubCatCreateNew() {
		initialize();
		con=dbCon.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 861, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		
		
		JLabel label = new JLabel("Category");
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setBounds(384, 285, 118, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Sub Category");
		label_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_1.setBounds(384, 335, 124, 32);
		frame.getContentPane().add(label_1);
		
		txtSubCate = new JTextField();
		txtSubCate.setText((String) null);
		txtSubCate.setColumns(10);
		txtSubCate.setBounds(578, 334, 143, 28);
		frame.getContentPane().add(txtSubCate);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_2.setBounds(385, 385, 124, 32);
		frame.getContentPane().add(label_2);
		
		txtName = new JTextField();
		txtName.setText((String) null);
		txtName.setColumns(10);
		txtName.setBounds(578, 384, 143, 28);
		frame.getContentPane().add(txtName);
		
		JLabel label_3 = new JLabel("Status");
		label_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_3.setBounds(387, 435, 98, 28);
		frame.getContentPane().add(label_3);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboStatus.setBounds(578, 433, 143, 28);
		frame.getContentPane().add(comboStatus);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String qry1 = "insert into cust_sub_cat (category,sub_category,name,sub_cat_status) values (?, ?, ?, ?)";

				try {
					
				
					
					PreparedStatement pst = con.prepareStatement(qry1);
					
					pst.setString(1, txtCate.getText().toString());
					
					pst.setString(2, txtSubCate.getText().toString());
					
					pst.setString(3, txtName.getText().toString());
					
					
					pst.setString(4, comboStatus.getSelectedItem().toString());

					pst.execute();

					JOptionPane.showMessageDialog(null, "Values Inserted");

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		btnInsert.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnInsert.setBounds(388, 510, 86, 32);
		frame.getContentPane().add(btnInsert);
		
		txtCate = new JTextField();
		txtCate.setBounds(578, 291, 143, 28);
		frame.getContentPane().add(txtCate);
		txtCate.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReset.setBounds(514, 510, 86, 32);
		frame.getContentPane().add(btnReset);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(646, 510, 89, 32);
		frame.getContentPane().add(btnNewButton);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(332, 231, 474, 345);
		frame.getContentPane().add(panel_1);
	}
}
