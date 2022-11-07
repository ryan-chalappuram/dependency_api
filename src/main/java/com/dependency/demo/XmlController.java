package com.dependency.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class XmlController  {
    @GetMapping
    CpeList cpeList() throws XMLStreamException, IOException {

        InputStream xmlResource = XmlController.class.getClassLoader().getResourceAsStream("test.xml");
        XMLInputFactory xmlInputFactory =XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlResource);
        XmlMapper mapper= new XmlMapper();
        CpeList cpeList= mapper.readValue(xmlStreamReader,CpeList.class);
//        CpeItem emp1= cpeList.getCpeItems()[0];
//        System.out.println(" "+emp1.getTitle());
//        System.out.println(" "+emp1.getName());


//        for(CpeItem cpeItem : cpeList.getCpeItems())   {
//            cpeItem.getName();
//            cpeItem.getTitle();
//        }
        return cpeList;
    }

}
