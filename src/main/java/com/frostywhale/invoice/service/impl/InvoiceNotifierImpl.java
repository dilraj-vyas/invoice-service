package com.frostywhale.invoice.service.impl;

import org.springframework.stereotype.Component;

import com.frostywhale.invoice.model.Invoice;
import com.frostywhale.invoice.service.InvoiceNotifier;

@Component
public class InvoiceNotifierImpl  implements InvoiceNotifier {
    @Override
    public void sendInvoice(Invoice invoice) {

    }
}
