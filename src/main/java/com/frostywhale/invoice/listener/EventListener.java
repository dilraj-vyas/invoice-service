package com.frostywhale.invoice.listener;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.frostywhale.invoice.model.Event;
import com.frostywhale.invoice.service.handler.AbstractHandler;

@Component
public class EventListener {

    private Map<String, AbstractHandler> handlerMap;

    @Autowired
    EventListener(Map<String, AbstractHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @JmsListener(destination = "ORDER")
    public void listen(Event event) {
        if (event != null) {
            System.out.println(event);
            AbstractHandler abstractHandler = handlerMap.get(event.getType());
            abstractHandler.handle(event);
        }
    }

}
