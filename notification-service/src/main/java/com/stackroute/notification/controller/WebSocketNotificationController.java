package com.stackroute.notification.controller;

import com.stackroute.notification.domain.WebSocketNotificationReceiving;
import com.stackroute.notification.domain.WebSocketNotificationSending;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
//STOMP messages routed to @Controller classes

public class WebSocketNotificationController {

public String data [];
    @MessageMapping("/search")
    @SendTo("/topic/result")
    @CrossOrigin
    public WebSocketNotificationSending webSocketNotificationSending(WebSocketNotificationReceiving webSocketNotificationReceiving) throws Exception{
        Thread.sleep(1000);
        //JSONArray sampleObject = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("searchResult", "It is data showing the results for the");
        obj.put("status", 1);

        return  new WebSocketNotificationSending("Server response for " + HtmlUtils.htmlEscape(webSocketNotificationReceiving.getName()) + " is: "+obj);
    }

}
