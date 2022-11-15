package com.dependency.demo;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

public class driver {
    public static final String FILE_NAME= "test.xml";
    public static void main(String[] args)throws FileNotFoundException, XMLStreamException, FactoryConfigurationError,TransformerException {
       //System.out.println((new staxhandler()).processXMLFile(new File(FILE_NAME)).toString());
        System.out.println(transformXML(4,(new staxhandler()).processXMLFile(new File(FILE_NAME)).toString()));
    }
    public static String transformXML(int indentation ,String rawXML) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number",indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXML)),streamResult);
        return streamResult.getWriter().toString();
    }
}
