package com.btt.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Andrei_Yanchuk on 1/3/2017.
 */
@Component
public class MessageComponent {

    @Value("${message.hello}")
    String messageFromApProp;

    @Autowired
    ProperyComponent properyComponent;

    public String helloMessage()
    {
        return messageFromApProp+"<br>"+properyComponent.getHelloMessage();
    }
}
