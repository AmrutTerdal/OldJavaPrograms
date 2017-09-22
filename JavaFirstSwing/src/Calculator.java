import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnMultiply;
	private JButton btnDivide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 21, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 21, 121, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1,num2,ans;
				
				try {
					
					num1=Integer.parseInt(textField.getText());
					num2=Integer.parseInt(textField_1.getText());
					ans=num1+num2;
					textField_2.setText(Integer.toString(ans));
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Please Enter The valid number");
				}
			}
		});
		btnNewButton.setBounds(50, 117, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Minus");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1,num2,ans;
              try {
					
					num1=Integer.parseInt(textField.getText());
					num2=Integer.parseInt(textField_1.getText());
					ans=num1-num2;
					textField_2.setText(Integer.toString(ans));
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Please Enter The valid number");
				}
			}
		});
		btnNewButton_1.setBounds(239, 117, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 181, 121, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("The Answer Will Show Here");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(22, 181, 173, 26);
		frame.getContentPane().add(lblNewLabel);
		
		btnMultiply = new JButton("Multiply");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,ans;
				
				try{
					num1=Integer.parseInt(textField.getText());
					num2=Integer.parseInt(textField_1.getText());
					ans=num1*num2;
					textField_2.setText(Integer.toString(ans));
					
				}catch(Exception a){
				
					JOptionPane.showMessageDialog(null, "Please Enter the valid number");
				}
			}
		});
		btnMultiply.setBounds(50, 151, 89, 23);
		frame.getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("Divide");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,ans;
				
				try{
					num1=Integer.parseInt(textField.getText());
					num2=Integer.parseInt(textField_1.getText());
					ans=num1/num2;
					
					textField_2.setText(Integer.toString(ans));
					
				
					
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(null, "Please Enter valid input");
				}
				
			}
		});
		btnDivide.setBounds(239, 151, 89, 23);
		frame.getContentPane().add(btnDivide);
	}
}
