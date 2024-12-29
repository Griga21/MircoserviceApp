package com;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @GetMapping(value = "/{firstName}")
    public String helloGet(
            @PathVariable("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }
}
@Data
class HelloRequest{
    private String firstName;
    private String lastName;
}
