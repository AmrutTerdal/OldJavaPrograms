import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlWorkGiven {
	
	public static void main (String args[])
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
		    try {
				Document doc = builder.parse("ShapeFieldMap.xml");
				NodeList fromList = doc.getElementsByTagName("ShapeFileMaps");
			    for(int i = 0;i<fromList.getLength();i++){
			      Node p = fromList.item(i);
			      if(p.getNodeType()==Node.ELEMENT_NODE){
			    	  Element email = (Element)p;
			    	   
			    	  String to = email.getAttribute("shapeKey");
			    	  NodeList nameList =  email.getChildNodes();
			    	  for(int j = 0;j<nameList.getLength();j++){
			    		  Node n = nameList.item(j);
			    		  if(n.getNodeType()==Node.ELEMENT_NODE){
			    			  Element name = (Element) n;
			    			  System.out.println("ShapeFieldMap"+to+":"+name.getTagName()+"="+name.getTextContent());
			    			  
			    		  }
			    		  
			    		  
			    		  
			    	  }
			    		  
			      }
			    }
		    } catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
