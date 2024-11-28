package com.example.serivcea;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/service-a")
    public String callServiceB(@RequestParam(name = "fail", required = false) Boolean fail) {
        String serviceBUrl = "http://envoy:9901/service-b";

        if (fail != null) {
            serviceBUrl += "?fail=" + fail;
        }

        try {
            String response = restTemplate.getForObject(serviceBUrl, String.class);
            return "Response from Service B: " + response;
        } catch (Exception e) {
            return "Service B is unavailable or circuit breaker is open." + e.getMessage();
        }
    }

}