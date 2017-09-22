import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.sql.ConnectionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class quizMyXmlFinal {

	private JFrame frame;
	String var1;
	ButtonGroup bg;
	static int questions;
	static JRadioButton rdbtnNewRadioButton_2;
	static JRadioButton rdbtnNewRadioButton;
	static JRadioButton rdbtnNewRadioButton_3;
	static JRadioButton rdbtnNewRadioButton_1;
	static JLabel lblQuestion;
	static ArrayList<String> lstquestion = new ArrayList<String>();
	static ArrayList<String> lbl2Array = new ArrayList<String>();
	static ArrayList<String> lbl3Array = new ArrayList<String>();
	static ArrayList<String> lbl4Array = new ArrayList<String>();
	static ArrayList<String> lbl5Array = new ArrayList<String>();
	static ArrayList<String> lbl6Array = new ArrayList<String>();
	static int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizMyXmlFinal window = new quizMyXmlFinal();
					window.frame.setVisible(true);
					loadXml();
					upNext();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			

				
				
			

			
			
			
			}	
			
		});
	}
	
	static void loadXml(){
		
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc= builder.parse("madhuQuiz.xml");
			 NodeList personlist=doc.getElementsByTagName("items");
			 for(int m=0;m<personlist.getLength();m++)
			    {
			    	Node p=personlist.item(m);
			    	if(p.getNodeType()==Node.ELEMENT_NODE){
			    	Element book=(Element)p;
			    	
			    	
			    String category=book.getAttribute("question");
			    NodeList riddleList=book.getChildNodes();
			    questions=riddleList.getLength();
		        for(int i=0;i<riddleList.getLength();i++){
			    	Node n= riddleList.item(i);
			    	if(n.getNodeType()==Node.ELEMENT_NODE){
			    		Element element_qst=(Element)n;
			    		 
				                  String question=element_qst
				                  .getElementsByTagName("question")
				                  .item(0)
				                  .getTextContent();
			              lstquestion.add(question);
			              
			              
			              
			              
			              
			              
			///              
			   String items=book.getAttribute("answer");
						    NodeList item=book.getChildNodes();
						    for(int j=0;j<item.getLength();j++){
						    	Node k= item.item(j);
						    	if(k.getNodeType()==Node.ELEMENT_NODE){
						    		Element element_ans=(Element)k;
						    		
						    		
						    		String option1=element_ans
							                  .getElementsByTagName("answer")
							                  .item(0)
							                  .getTextContent();
						              lbl2Array.add(option1);
						              String option2=element_ans
							                  .getElementsByTagName("answer")
							                  .item(1)
							                  .getTextContent();
						              lbl3Array.add(option2);
						              String option3=element_ans
							                  .getElementsByTagName("answer")
							                  .item(2)
							                  .getTextContent();
						              lbl4Array.add(option3);
						              String option4=element_ans
							                  .getElementsByTagName("answer")
							                  .item(3)
							                  .getTextContent();
						              lbl5Array.add(option4);

			    		

		
			    	}
}
			    	}
			    }}}
			} catch (ParserConfigurationException e) {
				
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	
	
	
	
	Connection con=null;
	
	static void upNext(){
		
		if(count<0)
		{
			count = 0;
		}
		else if(count>questions){
			count = questions-1;
		
			
		}
		
		if(count<questions){
			lblQuestion.setText(lstquestion.get(count).toString());
			rdbtnNewRadioButton.setText(lbl2Array.get(count).toString());
			
			rdbtnNewRadioButton_1.setText(lbl3Array.get(count).toString());
			rdbtnNewRadioButton_2.setText(lbl4Array.get(count).toString());
			rdbtnNewRadioButton_3.setText(lbl5Array.get(count).toString());
			count++;
		
	}
		else{
			count = questions;
		}}

	/**
	 * Create the application.
	 */
	public quizMyXmlFinal() {
		initialize();
		con=dbCon.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setBounds(26, 11, 725, 53);
		frame.getContentPane().add(lblQuestion);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(90, 103, 165, 30);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(90, 163, 165, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(90, 223, 165, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(90, 280, 165, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(count<0)
				{
					count = 0;
				}
				else if(count>questions){
					count = questions-1;
				
					
				}
				
				if(count<questions){
					lblQuestion.setText(lstquestion.get(count).toString());
					rdbtnNewRadioButton.setText(lbl2Array.get(count).toString());
					
					rdbtnNewRadioButton_1.setText(lbl3Array.get(count).toString());
					rdbtnNewRadioButton_2.setText(lbl4Array.get(count).toString());
					rdbtnNewRadioButton_3.setText(lbl5Array.get(count).toString());
					count++;
				
			}
				else{
					count = questions;
				}
			
				try{
					String query="INSERT INTO quizxml(questions,answers) VALUES (?,?)";
	           
					
				PreparedStatement pstmt = con.prepareStatement(query);
				
				
				
	            pstmt.setString(1,lblQuestion.getText());
	            if(rdbtnNewRadioButton.isSelected()){
	            	var1 = rdbtnNewRadioButton.getText().toString();
	            }
	            
	            if(rdbtnNewRadioButton_1.isSelected()){
	            	var1 = rdbtnNewRadioButton_1.getText().toString();
	            }
	            
	            if(rdbtnNewRadioButton.isSelected()){
	            	var1 = rdbtnNewRadioButton_2.getText().toString();
	            	
	            }
	            
	            if(rdbtnNewRadioButton.isSelected()){
	            	var1 = rdbtnNewRadioButton_3.getText().toString();
	            }
	            pstmt.setString(2,var1);
	            pstmt.execute();
	            pstmt.close();
	            
	            
//	            pstmt.setString(2,rdbtnNewRadioButton.getText());
//	            pstmt.setString(2,rdbtnNewRadioButton_1.getText());
//	            pstmt.setString(2,rdbtnNewRadioButton_2.getText());
//	            pstmt.setString(2,rdbtnNewRadioButton_3.getText());
				}
				catch(Exception e1)
				{
					e1.printStackTrace();				}
				
			
			
			
			}
			
			
			
			
		});
		
		btnNext.setBounds(198, 355, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(count<0){
					count = 0;
					
				}
				else if(count>questions){
					count = questions-1;
				}
				
				if(count<questions){
					lblQuestion.setText(lstquestion.get(count).toString());
					rdbtnNewRadioButton.setText(lbl2Array.get(count).toString());
					
					rdbtnNewRadioButton_1.setText(lbl3Array.get(count).toString());
					rdbtnNewRadioButton_2.setText(lbl4Array.get(count).toString());
					rdbtnNewRadioButton_3.setText(lbl5Array.get(count).toString());
					count--;
				
			}
				else{
					count = questions;
				}
				
				
				
			}
		});
		btnPrevious.setBounds(60, 355, 89, 23);
		frame.getContentPane().add(btnPrevious);
	}
}
