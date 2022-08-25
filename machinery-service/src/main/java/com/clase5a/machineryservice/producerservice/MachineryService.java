package com.clase5a.machineryservice.producerservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MachineryService {
    public static void main(String[] args) {
        SpringApplication.run(MachineryService.class, args);
    }
}

@RestController
class Maquinaria {
    @Value("${url-vehicle-registry}")
    private String urlDnrpa;

    @Value("${max-machinery-parking-lot}")
    private String catalogoMaquinaMaximo;

    @RequestMapping(method = RequestMethod.GET, path ="/maquinaria/info")
    public Map<String, String> message() {
        Map<String, String> response = new HashMap<>();

        response.put("URL DNRPA", urlDnrpa);
        response.put("Catalogo maximo de maquinas", catalogoMaquinaMaximo);

        return response;
    }
}