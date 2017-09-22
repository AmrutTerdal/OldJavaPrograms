import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class QuizFinalDevelopmentWindowBuilder {

	private JFrame frame;
	private String[] strArray = new String[4]; 
	private JLabel lblQuestion;
	private JRadioButton rdbtnOptionA;
	private JRadioButton rdbtnOptionB;
	private JRadioButton rdbtnOptionC;
	private JRadioButton rdbtnOptionD;
	int s;
	String[] strArray_m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizFinalDevelopmentWindowBuilder window = new QuizFinalDevelopmentWindowBuilder();
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
	public QuizFinalDevelopmentWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 804, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setBounds(31, 22, 734, 52);
		frame.getContentPane().add(lblQuestion);
		
		JRadioButton rdbtnOptionA = new JRadioButton("");
		rdbtnOptionA.setBounds(64, 113, 109, 23);
		frame.getContentPane().add(rdbtnOptionA);
		
		JRadioButton rdbtnOptionB = new JRadioButton("");
		rdbtnOptionB.setBounds(64, 148, 109, 23);
		frame.getContentPane().add(rdbtnOptionB);
		
		JRadioButton rdbtnOptionC = new JRadioButton("");
		rdbtnOptionC.setBounds(64, 185, 109, 23);
		frame.getContentPane().add(rdbtnOptionC);
		
		JRadioButton rdbtnOptionD = new JRadioButton("");
		rdbtnOptionD.setBounds(64, 218, 109, 23);
		frame.getContentPane().add(rdbtnOptionD);
		
		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
			            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			            Document doc = docBuilder.parse (new File("quiznew.xml"));


			            
			            
			            // normalize text representation
			            doc.getDocumentElement ().normalize ();
			            NodeList listOfitem = doc.getElementsByTagName("item");
			            


			                Node ListOfitemNode = listOfitem.item(s-1);
		                int totalListOfitem = listOfitem.getLength();
//		                   strArray_m[2] = Integer.toString(totalListOfitem);
			                
			                
			                


			                if(ListOfitemNode.getNodeType() == Node.ELEMENT_NODE){
			                    Element listOfitemElement = (Element)ListOfitemNode;
			                    //-------
			                    

			                    
			                    
			                    NodeList questionList = listOfitemElement.getElementsByTagName("question");
			                    Element questionElement = (Element)questionList.item(0);

			                    NodeList textquestionList = questionElement.getChildNodes();
			                    strArray_m[0]= (((Node)textquestionList.item(0)).getNodeValue().trim()).toString();
			                    
			                    System.out.println(textquestionList);
			                    
			                    
			                    //-------
			                   
			                    NodeList optionList = listOfitemElement.getElementsByTagName("answer");
			                 
			                    
			                    Element optionElement = (Element)optionList.item(0);

			                    NodeList textoptionList = optionElement.getChildNodes();
			                    strArray_m[1]= (((Node)textoptionList.item(0)).getNodeValue().trim()).toString();
			                    
			                    System.out.println(strArray_m[1]);

			                    //----
			                    
			              }//end of if clause

			        }
			            catch (SAXParseException err) {
			        System.out.println ("** Parsing error" + ", line " 
			             + err.getLineNumber () + ", uri " + err.getSystemId ());
			        System.out.println(" " + err.getMessage ());

			        }catch (SAXException e) {
			        Exception x = e.getException ();
			        ((x == null) ? e : x).printStackTrace ();

			        }catch (Throwable t) {
			        t.printStackTrace ();
			        }
			}
		});
		btnNewButton.setBounds(35, 273, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
