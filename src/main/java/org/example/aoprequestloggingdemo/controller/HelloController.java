package org.example.aoprequestloggingdemo.controller;

import org.example.aoprequestloggingdemo.annotation.Logged;
import org.example.aoprequestloggingdemo.dto.request.HelloExampleRequest;
import org.example.aoprequestloggingdemo.dto.response.HelloExampleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Logged
    @PostMapping
    public HelloExampleResponse sayHello(@RequestBody HelloExampleRequest request) {
        return new HelloExampleResponse(request.getHelloMessage() + " from " + request.getRequestSubject());
    }
}
