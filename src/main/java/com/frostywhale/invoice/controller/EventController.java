package com.frostywhale.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frostywhale.invoice.producer.EventProducer;
import com.frostywhale.invoice.model.Event;

@RestController
@RequestMapping("/frosty-whale/order")
public class EventController {

    @Autowired
    EventProducer eventProducer;

    @PostMapping("/push")
    public ResponseEntity<String> push(@RequestBody Event event) {
        eventProducer.sendMsg(event);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
