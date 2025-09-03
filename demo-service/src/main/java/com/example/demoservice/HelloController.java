package com.example.demoservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author binod-nakhan
 * @created 2025-09-03
 */

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final RestTemplate restTemplate;

    @Value("${message.hello}")
    private String helloMessage;

    @GetMapping("/hello")
    public String hello() {
        return helloMessage;
    }

    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://demo-service/hello", String.class);
    }
}
