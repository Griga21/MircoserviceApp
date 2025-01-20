package com.study;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    public String helloRemoteServiceCall(String firstName, String lastName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseExchange=
                restTemplate.exchange(
                        "http://logical-service-id/name" +  "{firstName}/{lastName}",
                        HttpMethod.GET, null, String.class, firstName, lastName);
        return responseExchange.getBody();
    }

    @GetMapping(value = "/{firstName}/{lastName}")
    public String helloGet(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {
        return
                helloRemoteServiceCall(firstName, lastName);
    }
    
}

