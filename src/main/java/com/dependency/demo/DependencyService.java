//package com.dependency.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.xml.bind.JAXBException;
//import java.io.IOException;
//
//@RestController
//
//public class DependencyService {
//    private final DependencyController dependencyController;
//
//@Autowired
//public DependencyService(DependencyController dependencyController) {
//        this.dependencyController = dependencyController;
//    }
//    @RequestMapping("/")
//    public xmlclass getlang() throws JAXBException, IOException {
//    return dependencyController.unmarshall();
//    }
//@GetMapping
//    public String getLang () {
//        return dependencyController.langgetter();
//    }
//}
