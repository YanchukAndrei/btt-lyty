package com.btt.guest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
/*@Configuration
@EnableAutoConfiguration
@ComponentScan
This 3 = @SpringBootApplication
*/
@SpringBootApplication
@EnableConfigurationProperties(ProperyComponent.class)
public class TestSpringBootWebConfiguration {

    @Resource
    MessageComponent messager;

    @RequestMapping("/")
    String home() {
        return messager.helloMessage();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestSpringBootWebConfiguration.class, args);
    }

}



// PLAY WITH DEV TOOL!!!!! REMOTE Execution!
// https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html