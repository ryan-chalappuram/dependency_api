package com.dependency.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final CpeRepository cpeRepository;

    @Autowired
    public TestService(CpeRepository cpeRepository) {
        this.cpeRepository = cpeRepository;
    }

    public Iterable<Root> list() {
        return cpeRepository.findAll();
    }

    public Root save(Root cpe_item){
        return cpeRepository.save(cpe_item);
    }
    public Iterable<Root> save(List<Root> cpe_items) {
        return cpeRepository.saveAll(cpe_items);

    }
}
