package com.frostywhale.invoice.service;

import java.io.IOException;

public interface InvoiceGenerator {

    public void generateInvoice(int orderId) throws IOException;


}
