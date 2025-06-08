package com.universidad.luisCruz.service;

import com.universidad.luisCruz.model.AgifyInit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    public Integer suma(Integer a, Integer b) {
        return a + b;
    }
    public AgifyInit ageAndCount(String nombre) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.agify.io?name=" + nombre;
        return restTemplate.getForObject(url, AgifyInit.class);
    }
}
