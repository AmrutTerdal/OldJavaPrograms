package com.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class maxtextField {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maxtextField window = new maxtextField();
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
	public maxtextField() {
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
		
		textField = new JTextField(" This my First Text BOx");
		textField.setBounds(22, 22, 199, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("This is my Second TextBox");
		textField_1.setBounds(22, 53, 199, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrThisTheText = new JTextArea();
		txtrThisTheText.setText("This the text area \r\n");
		txtrThisTheText.setText("This is Second text area ");
		txtrThisTheText.setBounds(22, 84, 199, 136);
		frame.getContentPane().add(txtrThisTheText);
		
		lblNewLabel = new JLabel("Count Words"+words.length);
		lblNewLabel.setBounds(245, 75, 80, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Count Character"+text.length);
		lblNewLabel_1.setBounds(245, 130, 80, 28);
		frame.getContentPane().add(lblNewLabel_1);
	
		
	}
}
