package com.auspiciouslife.readinglist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloworld() {
        return "Hello World!";
    }
}
