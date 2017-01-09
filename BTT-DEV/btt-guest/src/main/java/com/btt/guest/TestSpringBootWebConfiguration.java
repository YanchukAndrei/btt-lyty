package com.btt.guest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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