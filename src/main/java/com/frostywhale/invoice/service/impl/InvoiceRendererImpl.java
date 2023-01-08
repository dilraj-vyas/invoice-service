package com.frostywhale.invoice.service.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.frostywhale.invoice.entity.OrderItem;
import com.frostywhale.invoice.model.Invoice;
import com.frostywhale.invoice.service.InvoiceRenderer;

@Component
public class InvoiceRendererImpl implements InvoiceRenderer {

    public byte[] renderInvoice(Invoice invoice) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);

            try (PDPageContentStream content = new PDPageContentStream(doc, page)) {
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 16);
                content.newLineAtOffset(100, 680);
                content.showText("INVOICE");
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 12);
                content.newLineAtOffset(100, 645);

                content.showText("Invoice #: " + new Random().nextInt(10000)+1);
                content.newLine();
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 12);
                content.newLineAtOffset(100, 620);
                content.showText("Customer :"+invoice.getCustomer().getName());
                content.newLine();
                content.endText();

                content.moveTo(100, 600);
                content.lineTo(500, 600);
                content.stroke();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.newLineAtOffset(100, 550);
                content.showText("Product");
                content.newLineAtOffset(300, 0);
                content.showText("Price");
                content.newLine();
                content.endText();

                float y = 500;
                for (OrderItem item : invoice.getItems()) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 12);
                    content.newLineAtOffset(100, y);
                    content.showText(item.getProduct().getName());
                    content.newLineAtOffset(300, 0);
                    content.showText(String.format("$%.2f", item.getProduct().getPrice()));
                    content.newLine();
                    content.endText();
                    y -= 20;
                }

                content.moveTo(100, y);
                content.lineTo(500, y);
                content.stroke();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.newLineAtOffset(100, y - 50);
                content.showText("Subtotal: " + String.format("$%.2f", invoice.getSubtotal()));
                content.newLine();
                content.endText();
                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 12);
                content.newLineAtOffset(100, y - 70);

                content.showText("Discount: " + String.format("$%.2f", invoice.getDiscount()));
                content.newLine();
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 12);
                content.newLineAtOffset(100, y - 85);

                content.showText("Tax: " + String.format("$%.2f", invoice.getTax()));
                content.newLine();
                content.endText();
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 12);
                content.newLineAtOffset(100, y - 100);

                content.showText("Total: " + String.format("$%.2f", invoice.getTotal()));
                content.endText();
            }

            File file = new File("D:\\pdf\\output.pdf");
            doc.save(file);
//            doc.save(out);


            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
