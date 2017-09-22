package com.edureka.Selenium.Driver.Besics;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliAutomatDesktop {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		
		Screen screen = new Screen();
		
		Pattern pattern = new Pattern("‪C:\\Users\\amrut\\Desktop\\ringtones\\ring.PNG");
		
		screen.doubleClick(pattern);

	}

}
