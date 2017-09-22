package com.java;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeExample {
	
	JFrame f;
	
	TreeExample(){
		
		f = new JFrame();
		
		DefaultMutableTreeNode style = new DefaultMutableTreeNode("style");
		DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
		DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");
		
		style.add(color);
		style.add(font);
		
		DefaultMutableTreeNode red = new DefaultMutableTreeNode("red");
		DefaultMutableTreeNode black = new DefaultMutableTreeNode("blue");
		DefaultMutableTreeNode blue = new DefaultMutableTreeNode("blue");
		DefaultMutableTreeNode green = new DefaultMutableTreeNode("Green");
		
		color.add(red);color.add(black);color.add(blue);color.add(green);
		
		JTree jt = new JTree(style);
		f.add(jt);
		f.setSize(200, 200);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new TreeExample();
	}
	

}
