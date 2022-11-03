package com.dependency.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class DependencyService {
    private final DependencyController dependencyController;

@Autowired
public DependencyService(DependencyController dependencyController) {
        this.dependencyController = dependencyController;
    }
//@GetMapping
//    public String getLang () {
//        return dependencyController.langgetter();
//    }
}
