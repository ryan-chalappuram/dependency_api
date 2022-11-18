package com.dependency.demo;
import com.dependency.demo.XmlToJson;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;

@SpringBootApplication
public class DependencyApplication {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError, TransformerException
	{
//		 XmlToJson xmlToJson = new XmlToJson();
//		 xmlToJson.ToXml();
		SpringApplication.run(DependencyApplication.class, args);}



//	@Bean
//	CommandLineRunner runner(DbService dbservice) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			TypeReference<List<Root>> typeReference = new TypeReference<List<Root>>(){};
//			XmlToJson xmlToJson = new XmlToJson();
//			String jsonString=xmlToJson.ToXml();
//			InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());
//			String dbinput = new String( inputStream.readAllBytes());
//			System.out.println(dbinput);
//			try {
//				List<Root> test = mapper.readValue(dbinput,typeReference);
//				dbservice.save(test);
//				System.out.println("Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save: " + e.getMessage());
//			}
//		};
//	}
}



