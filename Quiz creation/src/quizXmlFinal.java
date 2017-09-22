import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class quizXmlFinal {

	private JFrame frame;
	private String[] strArray = new String[4];
	
	JLabel lblQuestion;
	int s;
	String[] strArray_m;
	

	
	
	
	
	
	
        	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizXmlFinal window = new quizXmlFinal();
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
	public quizXmlFinal() {
		initialize();
		
		
		
		
		
		
		
		
	}
	
	
	
	 
	
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 791, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setBounds(23, 39, 727, 42);
		frame.getContentPane().add(lblQuestion);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
		        try {
		            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		            Document doc = docBuilder.parse (new File("test.xml"));


		            
		            
		            // normalize text representation
		            doc.getDocumentElement ().normalize ();
		            NodeList listOfWeek = doc.getElementsByTagName("week");
		            


		                Node firstWeekNode = listOfWeek.item(s-1);
		                int totalWeeks = listOfWeek.getLength();
		                strArray_m[3] = Integer.toString(totalWeeks);


		                if(firstWeekNode.getNodeType() == Node.ELEMENT_NODE){
		                    Element firstWeekElement = (Element)firstWeekNode;
		                    //-------
		                    

		                    
		                    
		                    NodeList dateList = firstWeekElement.getElementsByTagName("date");
		                    Element dateElement = (Element)dateList.item(0);

		                    NodeList textDateList = dateElement.getChildNodes();
		                    strArray_m[0]= (((Node)textDateList.item(0)).getNodeValue().trim()).toString();

		                    //-------
		                   
		                    NodeList riddleList = firstWeekElement.getElementsByTagName("riddle");
		                 
		                    
		                    Element riddleElement = (Element)riddleList.item(0);

		                    NodeList textRiddleList = riddleElement.getChildNodes();
		                    strArray_m[1]= (((Node)textRiddleList.item(0)).getNodeValue().trim()).toString();
		                    lblQuestion.setText("Amrut");

		                    //----
		                    
		                    NodeList lWSList = firstWeekElement.getElementsByTagName("lastWeekSolution");
		                    

		                    
		                    Element ageElement = (Element)lWSList.item(0);

		                    NodeList textLWSList = ageElement.getChildNodes();
		                    strArray_m[2]= (((Node)textLWSList.item(0)).getNodeValue().trim()).toString();

		                    //------
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
		btnSubmit.setBounds(53, 149, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
