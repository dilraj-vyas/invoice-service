package com.frostywhale.invoice.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frostywhale.invoice.entity.Order;
import com.frostywhale.invoice.exception.OrderNotFoundException;
import com.frostywhale.invoice.model.Invoice;
import com.frostywhale.invoice.service.InvoiceGenerator;
import com.frostywhale.invoice.service.InvoiceNotifier;
import com.frostywhale.invoice.service.InvoiceRenderer;
import com.frostywhale.invoice.service.InvoiceStorage;
import com.frostywhale.invoice.service.OrderService;
import com.frostywhale.invoice.util.DiscountCalculator;
import com.frostywhale.invoice.util.TaxCalculator;

@Service
public class InvoiceGeneratorImpl implements InvoiceGenerator {

    private OrderService orderService;
    private InvoiceRenderer invoiceRenderer;
    private InvoiceStorage invoiceStorage;
    private InvoiceNotifier invoiceNotifier;

    @Autowired
    public InvoiceGeneratorImpl(
        OrderService orderService,
        InvoiceRenderer invoiceRenderer,
        InvoiceStorage invoiceStorage,
        InvoiceNotifier invoiceNotifier) {
        this.orderService = orderService;
        this.invoiceRenderer = invoiceRenderer;
        this.invoiceStorage = invoiceStorage;
        this.invoiceNotifier = invoiceNotifier;
    }

    @Override
    public void generateInvoice(int orderId) throws IOException, OrderNotFoundException {

        Order order = orderService.getById(orderId);

        if (order != null) {
            Invoice invoice = new Invoice();
            invoice.setCustomer(order.getCustomer());
            invoice.setItems(order.getItems());
            invoice.setSubtotal(order.getSubtotal());
            invoice.setDiscount(DiscountCalculator.calculateDiscount(order));
            invoice.setTax(TaxCalculator.calculateTax(order));
            invoice.setTotal(invoice.getSubtotal() - invoice.getDiscount() + invoice.getTax());
            byte[] invoicePdf = invoiceRenderer.renderInvoice(invoice);
        } else {
            throw new OrderNotFoundException("Order Not Exist with Order id :" + orderId);
        }
    }
}
