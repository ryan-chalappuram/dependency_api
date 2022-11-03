package com.dependency.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@SpringBootApplication
public class DependencyApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DependencyApplication.class, args);

	}
}


