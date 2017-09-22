//
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Scanner;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 


public class QuizClassXml extends JFrame {
    public QuizClassXml(){
        initUI();
    }

    private int j;
    private String[] strArray = new String[4]; 
    JTextArea area = new JTextArea(strArray[1]);
    JButton nextButton = new JButton("Next");
    JButton prevButton = new JButton("Previous");
    JButton toggleAnswerButton = new JButton("Previous");
    boolean isToggledNext = false;
    boolean isToggledPrev = false;
    boolean dateLockBool=false;

    public final Date getDateTime(){
        Date date = new Date();
        return date;
    }

    //Loads everything from the selected week in the xml file into an array of strings via xml parsing.
    public final String[] xmlLoader(int s, String[] strArray_m){
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
        return strArray_m;
    }

    //Handles all the data from the next button
    public final void doUpdate(int j, String[] strArray_m, JTextArea area){
        xmlLoader(j, strArray_m); //Load stuff from the xml file
        area.setText(strArray_m[1]); // update the text area
    }

    public final boolean toggleButton(JButton buttonDisable, boolean disableButtonBool){
        buttonDisable.setEnabled(!buttonDisable.isEnabled()); // Swap button state
        if(disableButtonBool){ disableButtonBool = false; } // Swap bool
        else { disableButtonBool = true; }//Swap bool
        return disableButtonBool;//return Bool
    }////End ToggleButton method

    public final void dateLock(JButton nextButton){
            nextButton.setEnabled(!nextButton.isEnabled());
    }//End Datelock Method

    public final void toggleContent(JTextArea area, JButton toggleContent, String[] strArray_m){
        String toggle = toggleContent.getText();
        if(toggle.equalsIgnoreCase("Show Last Week's Answer")){
            toggleContent.setText("This Week's Brain Teaser");
            area.setText(strArray_m[2]);
        }//end if
        else{
            toggleContent.setText("Show Last Week's Answer");
            area.setText(strArray_m[1]);
        }//End else
    }//End ToggleContent method

    public final void initUI() {
        //add panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        //Declare Scanner, input the week you want, load that week from XML file
        Scanner input = new Scanner(System.in);
        j = 1;       
        xmlLoader(j, strArray);
        isToggledPrev = toggleButton(prevButton, isToggledPrev);

        //Create text area with returned XML data as default text area text
        area.setBounds(50, 100, 350, 400);
        panel.add(area); // add text area to panel
        area.setText(strArray[1]);


        JLabel labelAuthor = new JLabel("Quiz Started");
        labelAuthor.setBounds(620, 600, 150, 50);
        panel.add(labelAuthor);

        toggleAnswerButton.setBounds(95, 520, 250, 30);
        toggleAnswerButton.setText("Show Last Week's Answer");
        toggleAnswerButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae){
             toggleContent(area, toggleAnswerButton, strArray);  
           }             
        });
        panel.add(toggleAnswerButton);

        nextButton.setBounds(550, 250, 80, 30);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
            Date date1 = getDateTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try{
                Date date2 = dateFormat.parse(strArray[0]);
                if (date1.compareTo(date2) < 0 ){

                    dateLock(nextButton);
                    dateLockBool=true;
                }
            }   
            catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
                if((j+2)> Integer.parseInt(strArray[3])){
                    isToggledNext = toggleButton(nextButton, isToggledNext);
                }
                if(isToggledPrev){
                   isToggledPrev = toggleButton(prevButton, isToggledPrev);
                }
               j++;
               doUpdate(j, strArray, area);
           } 
        });
        panel.add(nextButton);



        prevButton.setBounds(550, 350, 80, 30);
        prevButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
                if((j-2) == 0 ){
                   isToggledPrev = toggleButton(prevButton, isToggledPrev);
                }
                if(isToggledNext){
                   isToggledNext = toggleButton(nextButton, isToggledNext);
                }
                if(dateLockBool){
                   dateLockBool = false;
                   dateLock(nextButton);
                }
            j--;
            doUpdate(j, strArray, area);
          } 
        });
        panel.add(prevButton);


        //Add quit button
        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(10,610,80,30);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent event){
                System.exit(0);
            }
        });

       panel.add(quitButton); // Add quit button to panel


       //Set overall window options for swing window
       setTitle("Quit Button Test");
       setSize(800,700);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Main, lol
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
            	QuizClassXml ms = new QuizClassXml();
                ms.setVisible(true);
            }
        });
    }
}