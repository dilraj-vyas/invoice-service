package com.frostywhale.invoice.service;

import com.frostywhale.invoice.model.Invoice;

public interface InvoiceNotifier {

    public void sendInvoice(Invoice invoice);

}
