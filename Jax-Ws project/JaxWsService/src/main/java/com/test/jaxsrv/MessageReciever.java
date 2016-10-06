package com.test.jaxsrv;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author andrei_yanchuk
 */
@WebService(name = "MessageRecieverService")
public class MessageReciever
{
    @WebMethod
    public String isAvailable(String text)
    {
        return "Service is available";
    }
}
