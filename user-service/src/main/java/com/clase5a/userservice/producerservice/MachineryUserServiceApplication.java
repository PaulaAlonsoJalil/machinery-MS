package com.clase5a.userservice.producerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MachineryUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MachineryUserServiceApplication.class, args);
    }
}

@RestController
class MaquinariaUsuario {
    @Value("${max-login-attempts}")
    private Integer maxLoginFail;

    @Value("${email-domain-enabled}")
    private String[] domainMailEnabled;

    @RequestMapping(method = RequestMethod.GET, path ="/usuario/info")
    public Map<String, String> message() {
        Map<String, String> response = new HashMap<>();

        response.put("Cantidad maxima de login fallidos", maxLoginFail.toString());

        int i = 1;
        for (String domain:domainMailEnabled) {
            response.put("domainMailEnabled" + i, domain);
            i++;
        }

        return response;
    }

    
}