package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CustSubCateUpdateDelete {

	public JFrame frame;
	static JTextField txtSubcat;
	static JTextField txtName;
	static cateGetSet obj_cateGetSet;
	static JComboBox comboStatus;
	static JComboBox comboCategory;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblName;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
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
					CustSubCateUpdateDelete window = new CustSubCateUpdateDelete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param obj_cateGetSet 
	 * 
	 * 
	 */
	static Connection con;
	private JButton btnNewButton_2;
	public CustSubCateUpdateDelete() {
		initialize();
		con=dbCon.dbConnector();
		//this.obj_cateGetSet=obj_cateGetSet;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\amrut\\Desktop\\Ipmessenger\\HeaderImage.jpg")));
		
		
		txtSubcat = new JTextField();
		txtSubcat.setBounds(584, 343, 143, 28);
		frame.getContentPane().add(txtSubcat);
		txtSubcat.setColumns(10);
		txtSubcat.setText(CustomerSubCategory.sub_category);
		
		
		
		comboCategory = new JComboBox();
		comboCategory.setBounds(584, 294, 143, 28);
		frame.getContentPane().add(comboCategory);
		//comboCategory.setModel(CustomerSubCategory.category);
		comboCategory.setModel(new DefaultComboBoxModel(new String[] {CustomerSubCategory.category}));
		
		txtName = new JTextField();
		txtName.setBounds(584, 393, 143, 28);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(CustomerSubCategory.name);
		
		
		
		comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1"}));
		comboStatus.setBounds(584, 442, 143, 28);
		frame.getContentPane().add(comboStatus);
		comboStatus.setSelectedItem(CustomerSubCategory.sub_cat_status);
		
		lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(390, 301, 118, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Sub Category");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(390, 346, 124, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(391, 391, 124, 32);
		frame.getContentPane().add(lblName);
		
		lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_2.setBounds(393, 442, 98, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					//"update Employee set EID='"+textUid.getText()+"',Name='"+textName.getText()+"',Surname='"+textSurname.getText()+"',Age='"+textAge.getText()+"' where UID='"+textUid.getText()+"' ";
					
					String query = "update set sub_category='"+txtSubcat.getText()+"',name='"+txtName.getText()+"',='"+comboStatus.getSelectedItem().toString()+"' where category ='"+comboCategory.getSelectedItem().toString()+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Update Successfull");
					
					
					
					
					



					


					

					
					
					
					
				}catch(Exception e){
					e.printStackTrace();
					
				}

			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(390, 530, 86, 32);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					int result = JOptionPane.showConfirmDialog(null, "Aru Sure?", null, JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					if(result==JOptionPane.YES_OPTION){
						
						String query1 = "delete from sub_category where category ='"+comboCategory.getSelectedItem().toString()+"'";
						PreparedStatement pst = con.prepareStatement(query1);
						pst.execute();
						JOptionPane.showConfirmDialog(null, "Data Deleted Successfully");

					}
					
										
				}catch(Exception e1){
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_1.setBounds(505, 530, 86, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton_2.setBounds(617, 531, 110, 30);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(332, 231, 474, 345);
		frame.getContentPane().add(panel_1);

		
		
	}

}
