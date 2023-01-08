package com.frostywhale.invoice.error.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class ScheduledMessageErrorHandler implements ErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledMessageErrorHandler.class);

    @Override
    public void handleError(Throwable t) {

        LOG.error("Error Message : {}", t.getMessage());
    }
}
