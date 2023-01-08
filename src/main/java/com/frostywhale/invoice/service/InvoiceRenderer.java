package com.frostywhale.invoice.service;

import java.io.IOException;

import com.frostywhale.invoice.model.Invoice;

public interface InvoiceRenderer {

    public byte[] renderInvoice(Invoice invoice) throws IOException;
}
