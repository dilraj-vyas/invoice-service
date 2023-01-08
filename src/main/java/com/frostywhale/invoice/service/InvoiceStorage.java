package com.frostywhale.invoice.service;

import java.util.List;

import com.frostywhale.invoice.model.Invoice;

public interface InvoiceStorage {

    public Invoice save(Invoice invoice);

    public Invoice getById(String id);


    public List<Invoice> getAll();
}
