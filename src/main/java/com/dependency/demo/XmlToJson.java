package com.dependency.demo;

import org.json.JSONObject;
import org.json.XML;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlToJson {
    public static final String FILE_NAME= "test.xml";
    public String read;


    public void ToXml() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError,TransformerException{
        transformXML(4,(new staxhandler()).processXMLFile(new File(FILE_NAME)).toString());
        JSONObject json = XML.toJSONObject(read);
        String jsonString = json.toString(4);
        System.out.println(jsonString);
    }
    public  String transformXML(int indentation ,String rawXML) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number",indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXML)),streamResult);
        read =streamResult.getWriter().toString();
        return read;
        //String read =streamResult.getWriter().toString();
    }

}
