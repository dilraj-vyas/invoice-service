package com.frostywhale.invoice.service.handler;

import com.frostywhale.invoice.model.Event;

public abstract class AbstractHandler {

    public abstract void handle(Event event);
}
