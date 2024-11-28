package com.example.serviceb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    @GetMapping("/service-b")
    public ResponseEntity<String> serviceB(@RequestParam(name = "fail", required = false) Boolean fail) {
        if (fail != null && fail) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Service B here: Simulated 500 Request Timeout");
        }
        return ResponseEntity.ok("Service B here: Hello from Service B");
    }
}
