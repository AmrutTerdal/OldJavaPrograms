import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;


public class ReadXmlSax{

	public static void main(String[] args) {
	
//obtain n config a SAX based parser
	SAXParserFactory factory=SAXParserFactory.newInstance();
		
	//obtain object for SAX parser
	SAXParser saxParser = null;
	try {
		saxParser = factory.newSAXParser();
	} catch (ParserConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SAXException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	DefaultHandler handler=new DefaultHandler(){
		boolean bto=false;
		boolean bfrom=false;
		boolean bheading=false;
		boolean bbody=false;
		public void startElement(String uri,String localName, String qName, 
				Attributes attributes) throws SAXException {
			
			if(qName.equalsIgnoreCase("to")){
			bto=true;
			}
			
			if(qName.equalsIgnoreCase("from")){
				bfrom=true;
			}
			
				if(qName.equalsIgnoreCase("heading")){
					bheading=true;
				}
				
					if(qName.equalsIgnoreCase("body")){
						bbody=true;
					}
			
					
					
		}
		
		public void endElement(String uri,String localName, String qName) throws SAXException{
		
	
			
		}
		
		//print data stored in between '<' n '>' tags
		
		public void characters(char ch[],int start,int length) throws SAXException{
		
			
			if(bto){
				System.out.println("to:" +new String(ch, start, length));
				bto=false;
			}
			
			if(bfrom){
				System.out.println("from:" +new String(ch, start, length));
				bfrom=false;
			}
			
			if(bheading){
				System.out.println("heading:" +new String(ch, start, length));
				bheading=false;
			}
			
			if(bbody){
				System.out.println("body:" +new String(ch, start, length));
				bbody=false;
			}
		}
		
		
	};
	
	try {
		saxParser.parse("emails.xml", handler);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}




