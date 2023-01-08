package com.frostywhale.invoice.service.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frostywhale.invoice.constant.EventConstant;
import com.frostywhale.invoice.entity.Order;
import com.frostywhale.invoice.model.Event;
import com.frostywhale.invoice.service.InvoiceGenerator;

@Component("orderPaid")
public class OrderPaidHandler extends AbstractHandler {


    private InvoiceGenerator invoiceService;

    @Autowired
    public OrderPaidHandler(InvoiceGenerator invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void handle(Event event) {

        if (event != null && event.getType().equals(EventConstant.ORDER_PAID)) {
            try {

                Order order = event.getOrder();
                invoiceService.generateInvoice(order.getId());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
