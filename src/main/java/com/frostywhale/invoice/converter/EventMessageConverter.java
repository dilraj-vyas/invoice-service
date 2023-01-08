package com.frostywhale.invoice.converter;


import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frostywhale.invoice.model.Event;

public class EventMessageConverter implements MessageConverter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        try {
            String json = objectMapper.writeValueAsString(object);
            TextMessage message = session.createTextMessage();
            message.setText(json);
            return message;
        } catch (JsonProcessingException e) {
            throw new MessageConversionException("Error converting object to JSON", e);
        }
    }

    @Override
    public Event fromMessage(Message message) throws JMSException, MessageConversionException {
        TextMessage textMessage = (TextMessage) message;
        try {
            return objectMapper.readValue(textMessage.getText(), Event.class);
        } catch (IOException e) {
            throw new MessageConversionException("Error converting JSON to object", e);
        }
    }
}