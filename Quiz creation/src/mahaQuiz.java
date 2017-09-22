 

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.scene.control.Alert;

public class mahaQuiz{
	static ArrayList<String> lst_question=new ArrayList();
	static ArrayList<String> lst_choice1=new ArrayList();
	static ArrayList<String> lst_choice2=new ArrayList();
	static ArrayList<String> lst_choice3=new ArrayList();
	static ArrayList<String> lst_choice4=new ArrayList();
	JLabel title,ques,choice1,choice2,choice3,choice4,answer;
	JButton next,previous,submit;
	JRadioButton r1,r2,r3,r4;
	int count=0;
    static int noofquestions;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mahaQuiz window = new mahaQuiz();
					window.frame.setVisible(true);
					readXml();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void readXml() {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc= builder.parse("mahaquiz.xml");
			doc.getDocumentElement().normalize();
	System.out.println("data:"+doc.getDocumentElement().getNodeName());
			NodeList questionlist=doc.getElementsByTagName("question");
			System.out.println("-----------");
			noofquestions=questionlist.getLength();
			for(int i=0;i<questionlist.getLength();i++)
			{
				Node q=questionlist.item(i);
				if(q.getNodeType()==Node.ELEMENT_NODE){
					Element element_question=(Element)q;
				System.out.println("Question id : " 
		                + element_question.getAttribute("id"));
					String question = element_question.getElementsByTagName("qtext").item(0).getTextContent();
					lst_question.add(question);
					Element element_choice1=(Element)q;
					//System.out.println("Choices : " 
			          //    + element_choice1.getAttribute("choices"));
					String choice1 = element_choice1.getElementsByTagName("choice").item(0).getTextContent();
					lst_choice1.add(choice1);
					Element element_choice2=(Element)q;
//					System.out.println("Choices : " 
//			                + element_choice2.getAttribute("choices"));
					String choice2 = element_choice2.getElementsByTagName("choice").item(1).getTextContent();
					lst_choice2.add(choice2);
//					System.out.println("Choices : " 
//			              + element_choice2.getAttribute("choices"));
					Element element_choice3=(Element)q;
					String choice3 = element_choice3.getElementsByTagName("choice").item(2).getTextContent();
					lst_choice3.add(choice3);
					Element element_choice4=(Element)q;
//					System.out.println("Choices : " 
//			               + element_choice4.getAttribute("choices"));
					String choice4 = element_choice4.getElementsByTagName("choice").item(3).getTextContent();
					lst_choice4.add(choice4);
					
					//String qtext=question.getAttribute("qtext");
					//NodeList qtextlist=question.getChildNodes();
					//for(int j=0;j<qtextlist.getLength();j++){
						//Node n= qtextlist.item(j);
						//if(n.getNodeType()==Node.ELEMENT_NODE){
							//Element name=(Element)n;

							//System.out.println("Question"+qtext+":"+name.getTagName()+ "="+name.getTextContent());;
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

	/**
	 * Create the application.
	 */
	public mahaQuiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame();
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.GRAY);
		frame.setVisible(true);

		title=new JLabel("QUIZ");
		title.setBounds(50, 50, 400, 50);
		frame.getContentPane().add(title);
		//button
		next = new JButton("Next");
		next.setBounds(100, 400, 100, 40);
		frame.getContentPane().add(next);

		previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(count<0)
				{
					count=0;
				}
				else if(count>=noofquestions){
					count=noofquestions-1;
				}
				
				if(count<noofquestions){
				ques.setText(lst_question.get(count).toString());
				choice1.setText(lst_choice1.get(count).toString());
				choice2.setText(lst_choice2.get(count).toString());
				choice3.setText(lst_choice3.get(count).toString());
			     choice4.setText(lst_choice4.get(count).toString());
				count--;
				}
				else {
					
					}
		//		System.out.println("Question ----------"+lst_question.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice1.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice2.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice3.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice4.get(count).toString());
//				
//				count--;
//				
			}
		});
		previous.setBounds(250, 400, 100, 40);
		frame.getContentPane().add(previous);

		submit=new JButton("Submit");
		submit.setBounds(400, 400, 100, 40);
		frame.getContentPane().add(submit);
		//radiobutton
		r1=new JRadioButton();
		r1.setBounds(92, 175, 29, 19);
		frame.getContentPane().add(r1);
		r2=new JRadioButton();
		r2.setBounds(92, 225, 29, 19);
		frame.getContentPane().add(r2);
		r3=new JRadioButton(); 
		r3.setBounds(92, 275, 29, 19);
		frame.getContentPane().add(r3);
		r4=new JRadioButton(); 
		r4.setBounds(92, 325, 29, 19);
		frame.getContentPane().add(r4);
		//label
		ques=new JLabel();
		ques.setBounds(92, 125, 505, 14);
		frame.getContentPane().add(ques);
		
		choice1=new JLabel();
		choice1.setBounds(144, 175, 535, 14);
		frame.getContentPane().add(choice1);
		choice2=new JLabel();
		choice2.setBounds(144, 225, 535, 14);
		frame.getContentPane().add(choice2);
		choice3=new JLabel();
		choice3.setBounds(144, 275, 535, 14);
		frame.getContentPane().add(choice3);
		choice4=new JLabel();
		choice4.setBounds(144, 325, 535, 14);
		frame.getContentPane().add(choice4);
		answer=new JLabel();
		answer.setBounds(144, 187, 85, 14);
		frame.getContentPane().add(answer);

		//buttongroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);


		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(count<0)
				{
					count=0;
				}
				else if(count>noofquestions){
					count=noofquestions-1;
				}
				
				if(count<noofquestions){
				ques.setText(lst_question.get(count).toString());
				choice1.setText(lst_choice1.get(count).toString());
				choice2.setText(lst_choice2.get(count).toString());
				choice3.setText(lst_choice3.get(count).toString());
				choice4.setText(lst_choice4.get(count).toString());
				count++;
				}
				else {
				count=noofquestions;
				}
			
//				System.out.println("Question ----------"+lst_question.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice1.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice2.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice3.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice4.get(count).toString());
//				
//				count++;
			}
		});


	}

}
