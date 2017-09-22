import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class QuizXml {
	static ArrayList <String> al_question = new ArrayList();
	private JFrame frame;
	String nList;
	 String to;
	 String item;
	 int question;
	 String eElement;
	 private JLabel lblQuestion;
	 private String[] strArray = new String[4];
	 int questions;
	 int count=0;
	 
	
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizXml window = new QuizXml();
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
	public QuizXml() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 795, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGetxml = new JButton("Get Xml Data");
		btnGetxml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Question---------"+al_question.get(count).toString());
				count++;
				

			      try {	
			         File inputFile = new File("quiznew.xml");
			         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			         Document doc = dBuilder.parse(inputFile);
			         doc.getDocumentElement().normalize();
			         System.out.println("items:"  + doc.getDocumentElement().getNodeName());
			          NodeList itemList=doc.getElementsByTagName("item");
			          System.out.println("----------------");
					 for(int m=0;m<itemList.getLength();m++)
					    {
					    	Node p=itemList.item(m);
					    	System.out.println("\n Current Element:"+p.getNodeName());
					    	if(p.getNodeType()==Node.ELEMENT_NODE){
					    	Element element_item=(Element)p;
					    	//System.out.println("question:"+element_item.getAttribute("question"));
					    	String question= element_item.getElementsByTagName("question").item(0).getTextContent();
					    	al_question.add(question);
					    	
//					    String category=itemElement.getAttribute("question");
//					    NodeList riddleList=itemElement.getChildNodes();
//					    questions=riddleList.getLength();
//				        for(int i=0;i<riddleList.getLength();i++){
//					    	Node n= riddleList.item(i);
//					    	if(n.getNodeType()==Node.ELEMENT_NODE){
//					    		Element element_qst=(Element)n;
//					    		 
//						                  String question=element_qst
//						                  .getElementsByTagName("question")
//						                  .item(0)
//						                  .getTextContent();
//						                  al.add(question);
//						                  
//						                  
//						                  String category1=itemElement.getAttribute("answer");
//										    NodeList answerList=itemElement.getChildNodes();
//										    questions=answerList.getLength();
//									        for(int j=0;j<answerList.getLength();j++){
//										    	Node n= answerList.item(j);
//										    	if(n.getNodeType()==Node.ELEMENT_NODE){
//										    		Element element_ans=(Element)n;
//										    		 
//											                  String question=element_qst
//											                  .getElementsByTagName("answer")
//											                  .item(0)
//											                  .getTextContent();
//											                  al.add(question);
											
						                  
						                  
						                  
			               
			              
					    	}              
			               
//			               al.add(eElement
//					                  .getElementsByTagName("question")
//					                  .item(0)
//					                  .getTextContent());
			               

			               
					                  
			               
			               
			               
			               
			               
			               

//				             String answer1 = eElement
//			                  .getElementsByTagName("answer")
//			                  .item(0)
//			                  .getTextContent();
//				             al.add(answer1);
//				             
//				             
//			               
//				             String answer2 = eElement
//					                  .getElementsByTagName("answer")
//					                  .item(0)
//					                  .getTextContent();
//						             al.add(answer2);
//				              
//						             
//						       String answer3 = eElement
//							                  .getElementsByTagName("answer")
//							                  .item(0)
//							                  .getTextContent();
//								             al.add(answer3);
//						                
//								             String answer4 = eElement
//									                  .getElementsByTagName("answer")
//									                  .item(0)
//									                  .getTextContent();
//										             al.add(answer4);
								        
			               

			               
			               
			               
			               
			               
			               
			               
			               
//			               System.out.println("\nquestion : " 
//					                  + eElement
//					                  .getElementsByTagName("question")
//					                  .item(1)
//					                  .getTextContent());
//					               
//					               
//
//						               System.out.println(" " 
//					               + eElement
//					                  .getElementsByTagName("answer")
//					                  .item(4)
//					                  .getTextContent());
//					               
//					               System.out.println(" " 
//							               + eElement
//							                  .getElementsByTagName("answer")
//							                  .item(5)
//							                  .getTextContent());
//						              
//					               System.out.println(" " 
//							               + eElement
//							                  .getElementsByTagName("answer")
//							                  .item(6)
//							                  .getTextContent());
//						              
//					               System.out.println(" " 
//							               + eElement
//							                  .getElementsByTagName("answer")
//							                  .item(7)
//							                  .getTextContent());

					               
					               
					               
					               
					               
//					              
//			               System.out.println("edition : " 
//			               + eElement
//			                  .getElementsByTagName("edition")
//			                  .item(0)
//			                  .getTextContent());
//			               System.out.println("price: " 
//			               + eElement
//			                  .getElementsByTagName("price")
//			                  .item(0)
//			                  .getTextContent());
			               
			               
			               
			               
			               
				        }
			         
			         } catch (Exception e) {
			             e.printStackTrace();
			          }
				
				
				
				
				
			}
				
			
		});
		btnGetxml.setBounds(10, 373, 136, 29);
		frame.getContentPane().add(btnGetxml);
		
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setBounds(27, 39, 730, 62);
		frame.getContentPane().add(lblQuestion);
		
		
		JLabel lblOption1 = new JLabel("");
		lblOption1.setBounds(297, 166, 261, 29);
		frame.getContentPane().add(lblOption1);
		
		JLabel lblOption2 = new JLabel("");
		lblOption2.setBounds(297, 208, 215, 29);
		frame.getContentPane().add(lblOption2);
		
		JLabel lblOption3 = new JLabel("");
		lblOption3.setBounds(297, 248, 261, 29);
		frame.getContentPane().add(lblOption3);
		
		JLabel lblOption4 = new JLabel("");
		lblOption4.setBounds(297, 288, 261, 29);
		frame.getContentPane().add(lblOption4);
		
		JRadioButton rdbtnOption1 = new JRadioButton("");
		rdbtnOption1.setBounds(122, 169, 109, 23);
		frame.getContentPane().add(rdbtnOption1);
		
		JRadioButton rdbtnOption2 = new JRadioButton("");
		rdbtnOption2.setBounds(122, 211, 109, 23);
		frame.getContentPane().add(rdbtnOption2);
		
		JRadioButton rdbtnOption3 = new JRadioButton("");
		rdbtnOption3.setBounds(122, 251, 109, 23);
		frame.getContentPane().add(rdbtnOption3);
		
		JRadioButton rdbtnOption4 = new JRadioButton("");
		rdbtnOption4.setBounds(122, 291, 109, 23);
		frame.getContentPane().add(rdbtnOption4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnOption1);
		bg.add(rdbtnOption2);
		bg.add(rdbtnOption3);
		bg.add(rdbtnOption4);
		
		JButton btnNewButton = new JButton("Get values");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
				//if(count<questions)
				//lblQuestion.setText(al_question.get(count).toString());
				
				//for(count =0;count<9;count++)
				//rdbtnOption1.setText(al.get(count).toString());
				
				
				
				
            
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(156, 373, 126, 29);
		frame.getContentPane().add(btnNewButton);
	}

}