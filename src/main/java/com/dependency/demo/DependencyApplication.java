package com.dependency.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class DependencyApplication {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError, TransformerException
	{
		 XmlToJson xmlToJson = new XmlToJson();
		 xmlToJson.ToXml();
		SpringApplication.run(DependencyApplication.class, args);

	}
}


