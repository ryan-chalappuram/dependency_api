package com.dependency.demo;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class staxhandler {
    public StringBuffer processXMLFile(File xMLFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError
    {
        XMLEvent xmlEvent = null;
        Characters characters = null;
        StringBuffer rawXML = new StringBuffer();
        XMLEventReader xmlEventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xMLFile));
        while(xmlEventReader.hasNext())
        {
            xmlEvent = xmlEventReader.nextEvent();
//            StartElement xmlEvent1 = xmlEventReader.nextEvent().asStartElement();
            switch (xmlEvent.getEventType()){
//                case  XMLStreamConstants.ATTRIBUTE:
//                    rawXML.append(xmlEvent.asStartElement().getAttributes());

                    //break;
                case XMLStreamConstants.START_ELEMENT:
                    rawXML.append("<"+(((StartElement)xmlEvent).getName()).getLocalPart()+">");
                    Iterator<Attribute> attributeIterator = xmlEvent.asStartElement().getAttributes();
                    while(attributeIterator.hasNext())
                    {
                        Attribute attribute = attributeIterator.next();
                        if(attribute.getName().toString().equals("href")){
                            rawXML.append(attribute.getValue());
                        }
                    }

//                    rawXML.append((xmlEvent).asStartElement().getAttributeByName());

                    break;
                case XMLStreamConstants.CHARACTERS:
                    characters = (Characters) xmlEvent;
                    if(!(characters.isWhiteSpace() || characters.isIgnorableWhiteSpace())) rawXML.append(characters.getData());
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    rawXML.append("</"+((EndElement)xmlEvent).getName().getLocalPart()+">");
                    break;
            }

        }
        return rawXML;
    }
}
