import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class finalRegisteration {

	private JFrame frame;
	private JTextField textname;
	private JTextField textuser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalRegisteration window = new finalRegisteration();
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
	public finalRegisteration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registeration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(162, 11, 179, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(74, 102, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textname = new JTextField();
		textname.setBounds(173, 99, 86, 20);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(74, 130, 72, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		textuser = new JTextField();
		textuser.setBounds(173, 130, 86, 20);
		frame.getContentPane().add(textuser);
		textuser.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(74, 161, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 158, 86, 17);
		frame.getContentPane().add(passwordField);
	
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(74, 186, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(122, 241, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addItem("Australia");
		comboBox.addItem("Bangladesh");
		comboBox.addItem("China");
		comboBox.addItem("England");
		comboBox.addItem("India");
		comboBox.addItem("Japan");
		comboBox.addItem("Shrilanka");
		comboBox.setBounds(173, 186, 86, 20);
		frame.getContentPane().add(comboBox);
	}
}
