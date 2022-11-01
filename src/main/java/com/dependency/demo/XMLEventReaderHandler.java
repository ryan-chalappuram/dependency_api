package com.dependency.demo;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLEventReaderHandler {
    public cpe_item processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError
    {
        Cpe_item cpe_item =null;
        Title title =null;
        References references =null;
        Reference reference =null;
        Cpe_23 cpe_23 =null;
        XMLEvent xmlEvent =null;
        XMLEventReaderHandler xmlEventReaderHandler = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xmlFile));
        while(((XMLEventReader) xmlEventReaderHandler).hasNext())
        {
           xmlEvent= ((XMLEventReader) xmlEventReaderHandler).nextEvent();
           switch(xmlEvent.getEventType())
           {
               case XMLStreamConstants.START_DOCUMENT:
                   cpe_item = new Cpe_item();
                   break;
               case XMLStreamConstants.START_ELEMENT:
                   if((((StartElement)xmlEvent).getName()).getLocalPart().equals("cpe-item"))
                   {
                      cpe_item.setName(((StartElement)xmlEvent).getAttributeByName(new QName("name")).toString());

                   }
                   else if((((StartElement)xmlEvent).getName()).getLocalPart().equals("title"))
                   {
                       title = new Title();
                       cpe_item.addTitle(title);
                       title.setName(((StartElement)xmlEvent).getAttributeByName(new QName("en-US","xml","lang")).toString());
                   }

                   else if((((StartElement)xmlEvent).getName()).getLocalPart().equals("cpe-23"))  {
                       cpe_23 = new Cpe_23();
                       cpe_item.addTitle(cpe_23);
                       cpe_23.setName(((StartElement)xmlEvent).getAttributeByName(new QName("name","name","cpe23-item"))).toString());
                   }
                   break;
               case XMLStreamConstants.CHARACTERS:
                   break;
           }
        }

        return null;
    }
}
