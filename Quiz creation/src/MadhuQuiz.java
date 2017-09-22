

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import java.awt.SystemColor;
import java.awt.Font;

public class MadhuQuiz {
	static ArrayList<String> lst_id=new ArrayList();
	static ArrayList<String> lst_question=new ArrayList();
	static ArrayList<String> lst_choice1=new ArrayList();
	static ArrayList<String> lst_choice2=new ArrayList();
	static ArrayList<String> lst_choice3=new ArrayList();
	static ArrayList<String> lst_choice4=new ArrayList();
	static ArrayList<String> lst_answer=new ArrayList();
	int count_ans=0;
	JLabel title;
	static JLabel ques;
	JLabel answer;
	static JLabel id;
	JButton next,previous,submit;
	static JRadioButton choice1,choice2,choice3,choice4;
	ButtonGroup bg;
	static int count=0;
	static String query1;
    static int noofquestions;
	JFrame frame;
	String NoQuestionAttemp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MadhuQuiz window = new MadhuQuiz();
					window.frame.setVisible(true);
					readXml();
//					upNext();
					
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
			Document doc= builder.parse("madhuQuiz.xml");
			doc.getDocumentElement().normalize();
	System.out.println("data:"+doc.getDocumentElement().getNodeName());
			NodeList questionlist=doc.getElementsByTagName("item");
			System.out.println("-----------");
			noofquestions=questionlist.getLength();
			for(int i=0;i<questionlist.getLength();i++)
			{
				Node q=questionlist.item(i);
				if(q.getNodeType()==Node.ELEMENT_NODE){
					//Element element_id=(Element)q;
					//System.out.println("Question Id : "+ element_id.getAttribute("id"));
				//	String question=element_id.getElementsByTagName("question").item(0).getTextContent();
				//	lst_id.add(question);
					Element element_question=(Element)q;
					String id=element_question.getAttribute("id");
					lst_id.add(id);
					
				System.out.println("Question id : "+ element_question.getAttribute("id"));
					String question = element_question.getElementsByTagName("question").item(0).getTextContent();
					lst_question.add(question);
					Element element_choice1=(Element)q;
					//System.out.println("Choices : " 
			          //    + element_choice1.getAttribute("choices"));
					String choice1 = element_choice1.getElementsByTagName("answer").item(0).getTextContent();
					lst_choice1.add(choice1);
					Element element_choice2=(Element)q;
//					System.out.println("Choices : " 
//			                + element_choice2.getAttribute("choices"));
					String choice2 = element_choice2.getElementsByTagName("answer").item(1).getTextContent();
					lst_choice2.add(choice2);
//					System.out.println("Choices : " 
//			              + element_choice2.getAttribute("choices"));
					Element element_choice3=(Element)q;
					String choice3 = element_choice3.getElementsByTagName("answer").item(2).getTextContent();
					lst_choice3.add(choice3);
					Element element_choice4=(Element)q;
//					System.out.println("Choices : " 
//			               + element_choice4.getAttribute("choices"));
					String choice4 = element_choice4.getElementsByTagName("answer").item(3).getTextContent();
					lst_choice4.add(choice4);
					Element element_answer=(Element)q;
//					System.out.println("Choices : " 
//			               + element_choice4.getAttribute("choices"));
//					String answer = element_answer.getElementsByTagName("answer1").item(0).getTextContent();
//					lst_answer.add(answer);
					
//					try{
//						String query="INSERT INTO test_quiz(question_id,correct_answer)VALUES(?,?)";	
//						PreparedStatement statement = con.prepareStatement(query);
//					statement.setString(1, id);
////					 if(choice1.isSelected()){
////	                	
////	                	 query1 =choice1.;
////	                	
////	                }
////	                else if(choice2.isSelected()){
////	                	 query1 =choice2.getText().toString();
////	                }
////	                else if(choice3.isSelected()){
////	                	query1 = choice3.getText().toString();
////	                }
////	                else if(choice4.isSelected()){
////	                	 query1 = choice4.getText().toString();
////	                }
////	                statement.setString(2,query1);
//					statement.execute();
//					statement.close();
//						
//					}
//					catch(Exception e1){
//						//System.out.println(e1);
////							JOptionPane.showMessageDialog(null, "Failed to Submit");
//				}
//						finally{
//							//System.out.println("Table inserted");
//						}
//		
					
					
					
					
					
					/*String qtext=question.getAttribute("qtext");
					NodeList qtextlist=question.getChildNodes();
					for(int j=0;j<qtextlist.getLength();j++){
						Node n= qtextlist.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE){
							Element name=(Element)n;

							System.out.println("Question"+qtext+":"+name.getTagName()+ "="+name.getTextContent());;*/
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
//	static void upNext(){
//		if(count<0)
//		{
//			count=0;
//		}
//		else if(count>noofquestions){
//			count=noofquestions-1;
//		}
//		
//		if(count<noofquestions){
//		id.setText(lst_id.get(count).toString());
//		ques.setText(lst_question.get(count).toString());
//		choice1.setText(lst_choice1.get(count).toString());
//		choice2.setText(lst_choice2.get(count).toString());
//		choice3.setText(lst_choice3.get(count).toString());
//		choice4.setText(lst_choice4.get(count).toString());
////		answer.setText(lst_answer.get(count).toString());
//		count++;
//		}
//		else {
//		count=noofquestions;
//		}
//	}
	
	
 Connection con;
	/**
	 * Create the application.
	 */
	public MadhuQuiz() {
		initialize();
		
		
		con=dbCon.dbConnector();
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame();
		frame.setBounds(100, 100, 929, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);

		title=new JLabel("");
		title.setBackground(Color.WHITE);
		title.setBounds(50, 50, 400, 50);
		frame.getContentPane().add(title);
		//button
		next = new JButton("Next");
		next.setFont(new Font("Tahoma", Font.BOLD, 13));
		next.setBounds(244, 400, 100, 40);
		frame.getContentPane().add(next);

		previous = new JButton("Previous");
		previous.setFont(new Font("Tahoma", Font.BOLD, 13));
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
			  id.setText(lst_id.get(count).toString());
				ques.setText(lst_question.get(count).toString());
				choice1.setText(lst_choice1.get(count).toString());
				choice2.setText(lst_choice2.get(count).toString());
				choice3.setText(lst_choice3.get(count).toString());
			     choice4.setText(lst_choice4.get(count).toString());
//			     answer.setText(lst_answer.get(count).toString());
				count--;
				}
				else {
					
					}
				//System.out.println("Id ----------"+lst_id.get(count).toString());
		//		System.out.println("Question ----------"+lst_question.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice1.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice2.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice3.get(count).toString());
//				System.out.println("Choices ----------"+lst_choice4.get(count).toString());
//				
//				count--;
//				

				try{
				String query="UPDATE  quiz set question='"+ques.getText()+"',stud_answer='"+query1+"' where id='"+id.getText()+"'";	
				PreparedStatement statement = con.prepareStatement(query);
//				statement.setString(1, id.getText());
//				statement.setString(2, ques.getText());
				 if(choice1.isSelected()){
               	
               	 query1 =choice1.getText().toString();
               	
                }
              else if(choice2.isSelected()){
               	 query1 =choice2.getText().toString();
                }
                else if(choice3.isSelected()){
               	query1 = choice3.getText().toString();
                }
                else if(choice4.isSelected()){
              	 query1 = choice4.getText().toString();
               }
//              statement.setString(3,query1);
//              statement.setString(4,query1);
				 
				 
              
			statement.execute();			statement.close();
					
			}
			catch(Exception e1){				//System.out.println(e1);
						e1.printStackTrace();
		}
				
			}
		});
		previous.setBounds(75, 400, 100, 40);
		frame.getContentPane().add(previous);

		submit=new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.BOLD, 13));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(frame,"Test Submitted");		
			}
		});
		submit.setBounds(400, 400, 100, 40);
		frame.getContentPane().add(submit);
		//radiobutton
		choice1=new JRadioButton();
		choice1.setBounds(92, 175, 335, 19);
		frame.getContentPane().add(choice1);
		choice2=new JRadioButton();
		choice2.setBounds(92, 225, 335, 19);
		frame.getContentPane().add(choice2);
		choice3=new JRadioButton(); 
		choice3.setBounds(92, 275, 335, 19);
		frame.getContentPane().add(choice3);
		choice4=new JRadioButton(); 
		choice4.setBounds(92, 325, 335, 19);
		frame.getContentPane().add(choice4);
		//label
		ques=new JLabel();
		ques.setBounds(92, 125, 505, 14);
		frame.getContentPane().add(ques);
      	id = new JLabel("");
      	id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setBounds(21, 26, 59, 28);
		frame.getContentPane().add(id);

		answer=new JLabel();
		answer.setBounds(98, 375, 481, 14);
		frame.getContentPane().add(answer);

		//buttongroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(choice1);
		bg.add(choice2);
		bg.add(choice3);
		bg.add(choice4);
		
		JButton btnNewButton = new JButton("RESULT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
			try{
				JOptionPane.showMessageDialog(null, "answers correct--"  +count_ans);
				
				JOptionPane.showMessageDialog(null, "Total number of Questions attempted--   " +NoQuestionAttemp);
				
				

				 
			}catch(Exception e5){ e5.printStackTrace();}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(541, 400, 129, 40);
		frame.getContentPane().add(btnNewButton);
		



		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
//				upNext();
				
				if(count<0)
				{
					count=0;
				}
				else if(count>noofquestions){
					count=noofquestions-1;
				}
				
				if(count<noofquestions){
				id.setText(lst_id.get(count).toString());
				ques.setText(lst_question.get(count).toString());
				choice1.setText(lst_choice1.get(count).toString());
				choice2.setText(lst_choice2.get(count).toString());
				choice3.setText(lst_choice3.get(count).toString());
				choice4.setText(lst_choice4.get(count).toString());
//				answer.setText(lst_answer.get(count).toString());
				count++;
				}
				else {
				count=noofquestions;
				}
				

				
				try{
					
					if(choice1.isSelected()){
		               	
		               	 query1 =choice1.getText().toString();
		               	
		                }
		              else if(choice2.isSelected()){
		               	 query1 =choice2.getText().toString();
		                }
		                else if(choice3.isSelected()){
		               	query1 = choice3.getText().toString();
		                }
		                else if(choice4.isSelected()){
		              	 query1 = choice4.getText().toString();
		               }
					
					
					
				String query="INSERT INTO quiz(id,question,stud_answer)VALUES(?,?,?)";	
					PreparedStatement statement = con.prepareStatement(query);
//				String query="SELECT q1.correct_ans, q2.stud_ans FROM quiz q1 , quiz q2 WHERE q1.id = '"+id.getText()+"'";
//					String query="select * from quiz where correct_answer=?";
//					PreparedStatement statement = con.prepareStatement(query);                                       
//                                                               	
				statement.setString(1, id.getText());
				
				statement.setString(2, ques.getText());
				 
//              statement.setString(1,query1);
              statement.setString(3,query1);
//              ResultSet rs=statement.executeQuery();
//				int count=0;
//				while(rs.next()){
//					count=count+1;
//				}
//				if(count==1)
//				{
//					JOptionPane.showMessageDialog(null, "answer correct");
//				
//					count_ans++;
//				}
//				else{
//					JOptionPane.showMessageDialog(null, "answer wrong");
//				}
              
			statement.execute();			
//				statement.close();
					
			}
			catch(Exception e1){				//System.out.println(e1);
						e1.printStackTrace();
		}

				NoQuestionAttemp = id.getText().toString();	
				
			}	
		});

		}
	}

