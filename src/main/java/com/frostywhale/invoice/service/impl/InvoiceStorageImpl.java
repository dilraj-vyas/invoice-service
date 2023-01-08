package com.frostywhale.invoice.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.frostywhale.invoice.model.Invoice;
import com.frostywhale.invoice.service.InvoiceStorage;

@Component
public class InvoiceStorageImpl implements InvoiceStorage {
    @Override
    public Invoice save(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getById(String id) {
        return null;
    }

    @Override
    public List<Invoice> getAll() {
        return null;
    }
}
