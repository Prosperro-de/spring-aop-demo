package org.example.aoprequestloggingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopRequestLoggingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopRequestLoggingDemoApplication.class, args);
    }

}
