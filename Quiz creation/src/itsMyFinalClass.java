import java.awt.EventQueue;


import javax.swing.JFrame;
import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.text.AbstractDocument.ElementEdit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class itsMyFinalClass {

	private JFrame frame;
	static int noofquestions,count = 0;
	static ArrayList<String>lst_id = new ArrayList<String>(); 
	static ArrayList<String>lst_question = new ArrayList<String>();
	static ArrayList<String> lst_choice1 = new ArrayList<String>();
	static ArrayList<String> lst_choice2 = new ArrayList<String>();
	static ArrayList<String> lst_choice3 = new ArrayList<String>();
	static ArrayList<String> lst_choice4 = new ArrayList<String>();
	static JLabel lblQuestion;
	static JLabel lbl_id;
	static JRadioButton rdb_Choice1;
	static JRadioButton rdb_Choice2;
	static JRadioButton rdb_Choice3;
	static JRadioButton rdb_Choice4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itsMyFinalClass window = new itsMyFinalClass();
					window.frame.setVisible(true);
					readXml();
					//upNext();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	static void readXml() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("madhuQuiz.xml");
			doc.getDocumentElement().normalize();
			System.out.println("data:" + doc.getDocumentElement().getNodeName());
			NodeList questionList = doc.getElementsByTagName("item");
			System.out.println("*******");
			noofquestions = questionList.getLength();
			for (int i = 0; i < questionList.getLength(); i++) {
				Node q = questionList.item(i);
				if (q.getNodeType() == Node.ELEMENT_NODE) {
					Element element_question = (Element) q;
					String id = element_question.getAttribute("id");
					lst_id.add(id);

					System.out.println("Questio id" + element_question.getAttribute(id));
					String question = element_question.getElementsByTagName("question").item(0).getTextContent();
					lst_question.add(question);

					Element element_choice1 = (Element) q;
					String choice1 = element_choice1.getElementsByTagName("answer").item(0).getTextContent();
					lst_choice1.add(choice1);

					Element element_choice2 = (Element) q;
					String choice2 = element_choice2.getElementsByTagName("answer").item(1).getTextContent();
					lst_choice2.add(choice2);

					Element element_choice3 = (Element) q;
					String choice3 = element_choice3.getElementsByTagName("answer").item(2).getTextContent();
					lst_choice3.add(choice3);

					Element element_choice4 = (Element) q;
					String choice4 = element_choice4.getElementsByTagName("answer").item(3).getTextContent();
					lst_choice4.add(choice4);

					Element element_answer = (Element) q;

				}

			}

		} catch (ParserConfigurationException e) {

			e.printStackTrace();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	static void upNext() {
		
		if(count<0)
		{
			count = 0;
		}
		else if(count>noofquestions)
		{
			count = noofquestions-1;
		}
		
		if(count<noofquestions){
			lbl_id.setText(lst_id.get(count).toString());
			lblQuestion.setText(lst_question.get(count).toString());
			rdb_Choice1.setText(lst_choice1.get(count).toString());
			rdb_Choice2.setText(lst_choice2.get(count).toString());
			rdb_Choice3.setText(lst_choice3.get(count).toString());
			rdb_Choice4.setText(lst_choice4.get(count).toString());
			count++;
			
		}
		else{
			count=noofquestions;
		}

	}
	
	Connection con;
	
	/**
	 * Create the application.
	 */
	public itsMyFinalClass() {
		initialize();
		con = con=dbCon.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 793, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setBounds(38, 79, 691, 40);
		frame.getContentPane().add(lblQuestion);
		
		JLabel lbl_Id = new JLabel("");
		lbl_Id.setBounds(22, 22, 46, 30);
		frame.getContentPane().add(lbl_Id);
		
		JRadioButton rdb_Choice1 = new JRadioButton("");
		rdb_Choice1.setBounds(93, 143, 405, 30);
		frame.getContentPane().add(rdb_Choice1);
		
		JRadioButton rdb_Choice2 = new JRadioButton("");
		rdb_Choice2.setBounds(93, 188, 405, 30);
		frame.getContentPane().add(rdb_Choice2);
		
		JRadioButton rdbChoice3 = new JRadioButton("");
		rdbChoice3.setBounds(93, 233, 405, 30);
		frame.getContentPane().add(rdbChoice3);
		
		JRadioButton rdb_Choice4 = new JRadioButton("");
		rdb_Choice4.setBounds(93, 270, 405, 30);
		frame.getContentPane().add(rdb_Choice4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(38, 320, 109, 30);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(157, 320, 99, 30);
		frame.getContentPane().add(btnInsert);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(count<0)
				{
					count = 0;
				}
				else if(count>noofquestions)
				{
					count = noofquestions-1;
				}
				
				if(count<noofquestions){
					lbl_id.setText(lst_id.get(count).toString());
					lblQuestion.setText(lst_question.get(count).toString());
					rdb_Choice1.setText(lst_choice1.get(count).toString());
					rdb_Choice2.setText(lst_choice2.get(count).toString());
					rdb_Choice3.setText(lst_choice3.get(count).toString());
					rdb_Choice4.setText(lst_choice4.get(count).toString());
					count++;
					
				}
				else{
					count=noofquestions;
				}

				
			}
		});
		btnNext.setBounds(266, 320, 109, 30);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(385, 321, 99, 28);
		frame.getContentPane().add(btnBack);
		
		JButton btnUpade = new JButton("Update");
		btnUpade.setBounds(494, 321, 109, 28);
		frame.getContentPane().add(btnUpade);
	}
}
