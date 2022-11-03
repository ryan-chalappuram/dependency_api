package com.dependency.demo;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.dependency.demo.xmlclass.*;
import static java.lang.System.*;
@Service
public class DependencyController {
public xmlclass unmarshall() throws JAXBException, IOException{
    JAXBContext context = JAXBContext.newInstance(xmlclass.class);
    return (xmlclass) context.createUnmarshaller()
            .unmarshal(new FileReader("src/main/resources/test.xml")) ;
}

}

//    public void foo() {
//        try {
//            File file = new File("src/main/resources/test.xml");
//            JAXBContext jaxbContext = null;
//            try {
//                jaxbContext = JAXBContext.newInstance(xmlclass.class);
//            } catch (JAXBException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            Unmarshaller unmarshaller = null;
//            try {
//                unmarshaller = jaxbContext.createUnmarshaller();
//            } catch (JAXBException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            try {
//                xmlclass Title = (xmlclass) unmarshaller.unmarshal(file);
//            } catch (JAXBException ex) {
//                throw new RuntimeException(ex);
//            }
//            System.out.println(xmlclass.getLang());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//        public String langgetter() {
//
//        String lang = xmlclass.getLang("en-US");
//           return lang;
//
//        }
//}

