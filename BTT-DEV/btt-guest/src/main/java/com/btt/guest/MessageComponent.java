package com.btt.guest;

import org.springframework.stereotype.Component;

/**
 * Created by Andrei_Yanchuk on 1/3/2017.
 */
@Component
public class MessageComponent {

    public String helloMessage()
    {
        return "Hello Spring Application!!!";
    }
}
