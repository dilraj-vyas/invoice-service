package com.frostywhale.invoice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.frostywhale.invoice.constant.TopicConstant;
import com.frostywhale.invoice.model.Event;

@Component
public class EventProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMsg(Event event) {

        jmsTemplate.convertAndSend(TopicConstant.ORDER_TOPIC, event);
    }


}
