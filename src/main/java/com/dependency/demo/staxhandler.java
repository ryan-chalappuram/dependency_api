package com.dependency.demo;

import javax.xml.stream.*;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
            switch (xmlEvent.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    rawXML.append("<"+(((StartElement)xmlEvent).getName()).getLocalPart()+">");
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
