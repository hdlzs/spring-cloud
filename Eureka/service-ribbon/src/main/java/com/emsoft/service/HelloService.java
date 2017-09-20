package com.emsoft.service;

import com.emsoft.ribbon.RibbonApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        System.out.println("in ser");
        return restTemplate.getForObject("http://compute-service/hi?name="+name,String.class);
    }

}
