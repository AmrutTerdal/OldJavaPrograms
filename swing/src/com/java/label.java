
package com.java;

import javax.swing.*;

public class label {

	public static void main(String[] args) {
		JFrame f=new JFrame();
		JLabel l1=new JLabel("username");
		l1.setBounds(80,120,100,40);
		JLabel l2=new JLabel("password");
		l2.setBounds(80,120,100,40);
		f.add(l1);
		f.add(l2);
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

}
