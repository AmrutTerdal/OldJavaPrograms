package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SubOrderOutlet {

	private JFrame frame;
	ResultSet rs1,rs2,rs3;
	JComboBox comboBox,comboBox_1,comboBox_2;
	static String query1,area1,subArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubOrderOutlet window = new SubOrderOutlet();
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
	static Connection con=null;
	private JTable table;
	public SubOrderOutlet() {
		initialize();
		//con=Log.dbConnector();

		con=dbCon.dbConnector();
		comboData();
		
	}

	private void comboData() {

		try {
			
						
			


			String cb1 = "SELECT DISTINCT city_name  FROM  sub_order_outlet";
			
			
			

			
			PreparedStatement pst1=con.prepareStatement(cb1);
			
			
			rs1 = pst1.executeQuery(cb1);
			
			

			while (rs1.next()){
			
			
				comboBox.addItem(rs1.getString(1));
				
				area1 = comboBox.getSelectedItem().toString();
				
			}
				
				String cb2 = "Select "+area1+" FROM outlet_city";
				
				PreparedStatement pst2=con.prepareStatement(cb2);
				rs2 = pst2.executeQuery(cb2);
				
				while (rs2.next()){
					
					
						comboBox_1.addItem(rs2.getString(1));
						
						
						
					}
				
				
				System.out.println("city = "+area1);
			

		} catch (SQLException e) {
			
			
			
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1439, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("City\r\n");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(343, 296, 46, 22);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblArea.setBounds(343, 343, 46, 22);
		frame.getContentPane().add(lblArea);

		JLabel lblSubArea = new JLabel("Sub Area");
		lblSubArea.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblSubArea.setBounds(342, 390, 105, 22);
		frame.getContentPane().add(lblSubArea);

		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("SansSerif", Font.BOLD, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(468, 296, 197, 22);
		frame.getContentPane().add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				try{
				
				comboBox_2.setModel(new DefaultComboBoxModel(new String[] {""}));	
				subArea = comboBox_1.getSelectedItem().toString();
				
                String cb3 = "Select "+subArea+" FROM outlet_city";
                
                System.out.println("cobo 3  = "+cb3 );
                
				
				PreparedStatement pst3=con.prepareStatement(cb3);
				rs3 = pst3.executeQuery(cb3);
				
				while (rs3.next()){
					
					
						comboBox_2.addItem(rs3.getString(1));
						
						
						
					}
				
				
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
			}
				
		});
		comboBox_1.setToolTipText("");
		comboBox_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(468, 347, 197, 22);
		frame.getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setFont(new Font("SansSerif", Font.BOLD, 18));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(468, 394, 197, 22);
		frame.getContentPane().add(comboBox_2);
		
		JButton button = new JButton("Fetch");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT device_id,outlet_device_name FROM sub_order_outlet "+"";
					String city,area,subarea;
					city = comboBox.getSelectedItem().toString();
					area=comboBox_1.getSelectedItem().toString();
					subarea=comboBox_2.getSelectedItem().toString();

					if(city.length()!=0){
						query1= query+"where city_name='"+comboBox.getSelectedItem().toString()+"'";
					}
					if(area.length()!=0){
						query1=query+"where area_name LIKE '"+comboBox_1.getSelectedItem().toString()+"' ";
					}
					if(subarea.length()!=0){
						query1=query+"where sub_area_name LIKE '"+comboBox_2.getSelectedItem().toString()+"' ";
					}
					if((area.length()!=0)&&(subarea.length()!=0)){
						query1= query+"where city_name LIKE '"+comboBox.getSelectedItem().toString()+"' AND area_name LIKE '"+comboBox_1.getSelectedItem().toString()+"' AND  sub_area_name  LIKE '"+comboBox_2.getSelectedItem().toString()+"'";
					}

					PreparedStatement pst= con.prepareStatement(query1);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e)
				{
					e.printStackTrace();

				}

			}
		});
		button.setFont(new Font("SansSerif", Font.BOLD, 18));
		button.setBounds(576, 457, 89, 28);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(368, 526, 598, 204);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}