import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxWorkGiven {
	
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
				boolean ShapeFileMaps=false;
				boolean ShapeFileMap=false;
				boolean shapeKey=false;
                boolean shapeType=false;
                
				boolean role=false;
				boolean name=false;
				boolean descWeb=false;
				boolean descDesktop=false;
				boolean shapeFile=false;
				
				public void startElement(String uri,String localName, String qName, 
						Attributes attributes) throws SAXException {
					
					if(qName.equalsIgnoreCase("ShapeFileMaps")){
						ShapeFileMaps=true;
					}
					
					if(qName.equalsIgnoreCase("ShapeFileMap")){
						ShapeFileMap=true;
					}
					
						if(qName.equalsIgnoreCase("shapeKey")){
							shapeKey=true;
						}
						
							if(qName.equalsIgnoreCase("shapeType")){
								shapeType=true;
							}
					
					
							if(qName.equalsIgnoreCase("role")){
								role=true;
							}
							
							if(qName.equalsIgnoreCase("name")){
								name=true;
							}
							
								if(qName.equalsIgnoreCase("descWeb")){
									descWeb=true;
								}
								
									if(qName.equalsIgnoreCase("descDesktop")){
										descDesktop=true;
									}
							
							
									if(qName.equalsIgnoreCase("shapeFile")){
										shapeFile=true;
									}
							
				}
				
				public void endElement(String uri,String localName, String qName) throws SAXException{
				
			
					
				}
				
				//print data stored in between '<' n '>' tags
				
				public void characters(char ch[],int start,int length) throws SAXException{
				
					
					if(ShapeFileMaps){
						System.out.println("to:" +new String(ch, start, length));
						ShapeFileMaps=false;
					}
					
					if(shapeKey){
						System.out.println("from:" +new String(ch, start, length));
						shapeKey=false;
					}
					
					if(shapeType){
						System.out.println("heading:" +new String(ch, start, length));
						shapeType=false;
					}
					
					if(role){
						System.out.println("body:" +new String(ch, start, length));
						role=false;
					}
				
					if(name){
						System.out.println("to:" +new String(ch, start, length));
						name=false;
					}
					
					if(descWeb){
						System.out.println("from:" +new String(ch, start, length));
						descWeb=false;
					}
					
					if(descDesktop){
						System.out.println("heading:" +new String(ch, start, length));
						descDesktop=false;
					}
					
					if(shapeFile){
						System.out.println("body:" +new String(ch, start, length));
						shapeFile=false;
					}
					
					
				}
				
				
			};
			
			try {
				saxParser.parse("ShapeFieldMap.xml", handler);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}


}
