package CustomerModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustMastPlace {

	private JFrame frame;
	JComboBox comboStates;
	static String com;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustMastPlace window = new CustMastPlace();
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
	public CustMastPlace() {
		initialize();
		ComboData();
	}

	private void ComboData() {
		
		String com = comboStates.getSelectedItem().toString();
		String state = com;
		System.out.println("Combo"+state);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboStates = new JComboBox();
		comboStates.setModel(new DefaultComboBoxModel(new String[] {"Andhra ", "Goa ", "Banglore"}));
		comboStates.setBounds(103, 57, 109, 26);
		frame.getContentPane().add(comboStates);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 com = comboStates.getSelectedItem().toString();
				 
				
				System.out.println("Combo"+com);
			}
		});
		btnSubmit.setBounds(111, 131, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
