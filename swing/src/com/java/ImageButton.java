package com.java;

import java.awt.image.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.image.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageButton {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageButton window = new ImageButton();
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
	public ImageButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		java.awt.Image img= new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img) );
		
		lblNewLabel.setBounds(196, 89, 246, 167);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		java.awt.Image img1= new ImageIcon(this.getClass().getResource("/Ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1) );
		
		
		btnNewButton.addActionListener(new ActionListener()
		
		
		{
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); 
				second sec = new second();
				sec.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(270, 280, 136, 57);
		frame.getContentPane().add(btnNewButton);
	}

}
