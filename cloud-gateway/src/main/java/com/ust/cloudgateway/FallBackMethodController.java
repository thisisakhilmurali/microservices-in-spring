package com.ust.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallbackMethod")
    public String userServiceFallbackMethod() {
        return "Please Wait. Department is taking time to load";
    }

    @GetMapping("/departmentServiceFallbackMethod")
    public String departmentServiceFallbackMethod() {
        return "Please Wait. Department is taking time to load";
    }


}
