package com.creditsaisonindia.SNSPublisher.controllers;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.creditsaisonindia.SNSPublisher.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SNSController {

    @Autowired
    private AmazonSNSClient snsClient;

    String TOPIC_ARN = "arn:aws:sns:us-east-1:971709774307:Lending-Topic-Tushar";

    @PostMapping("/events")
    public String publishMessage(@RequestBody Event event){
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, event.toString(),
                "This is test message from spring microservice");
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        MessageAttributeValue eventType = new MessageAttributeValue();
        eventType.setDataType("String");
        eventType.setStringValue(event.getEventType());
        messageAttributes.put("eventType", eventType);
        publishRequest.setMessageAttributes(messageAttributes);
        snsClient.publish(publishRequest);
        return "Message published successfully";
    }

    @GetMapping("/test")
    public String test(){
        return "Application is working";
    }

}
