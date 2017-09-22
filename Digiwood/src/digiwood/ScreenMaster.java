package digiwood;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ScreenMaster {

	private JFrame framescreen;
	private JTextField txtRole;
	private JTextField txtName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenMaster window = new ScreenMaster();
					window.framescreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenMaster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framescreen = new JFrame();
		framescreen.getContentPane().setBackground(SystemColor.textHighlightText);
		framescreen.setBounds(100, 100, 1350, 720);
		framescreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framescreen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DIGYWOOD ADS");
		lblNewLabel_1.setBounds(433, 11, 732, 79);
		lblNewLabel_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		framescreen.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblscreenid = new JLabel("ROLE ID");
		lblscreenid.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblscreenid.setForeground(UIManager.getColor("RadioButton.foreground"));
		lblscreenid.setBounds(354, 233, 131, 29);
		framescreen.getContentPane().add(lblscreenid);
		
		txtRole = new JTextField();
		txtRole.setBounds(610, 236, 150, 29);
		framescreen.getContentPane().add(txtRole);
		txtRole.setColumns(10);
		
		JLabel lblscreenname = new JLabel("ROLE NAME");
		lblscreenname.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblscreenname.setBounds(354, 296, 223, 29);
		framescreen.getContentPane().add(lblscreenname);
		
		txtName = new JTextField();
		txtName.setBounds(610, 299, 150, 29);
		framescreen.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblscreenShortName = new JLabel("SCREEN SHORTNAME");
		 lblscreenShortName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblscreenShortName.setBounds(354, 360, 223, 29);
		framescreen.getContentPane().add(lblscreenShortName);
		
		textField = new JTextField();
		textField.setBounds(610, 363, 150, 29);
		framescreen.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblStatus.setBounds(354, 432, 223, 29);
		framescreen.getContentPane().add(lblStatus);
		
		JComboBox combostatus = new JComboBox();
		combostatus.setBounds(610, 435, 150, 29);
		framescreen.getContentPane().add(combostatus);
		
	}

}
