package com.paalkanakku.project.serviceImpl;

import com.lowagie.text.DocumentException;
import com.paalkanakku.project.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class PdfService {

    @Autowired
    private TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void createPdf(InvoiceNumTable invoiceNumTable) {
        Map<String, Object> invoiceData = createObjects(invoiceNumTable);
        Context context = new Context();
        context.setVariables(invoiceData);
        String htmlContent = templateEngine.process("thymeleafTemplate", context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\User\\Public\\" + invoiceNumTable.getHotelDetails().getCustomerName() + "-" + invoiceNumTable.getInvoiceNumber() + ".pdf");
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        private Map<String, Object> createObjects(InvoiceNumTable invoiceNumTable) {

        Map<String, Object> data = new HashMap<>();

        SrDetails srDetails = new SrDetails("SR FOODS", "225 j/10 sofia complex bye pass road , madurai-625016", "GSTN11232M12", "8489127214");
            data.put("srDetails", srDetails);
            data.put("hotelDetails", invoiceNumTable.getHotelDetails());
            data.put("productDetails", invoiceNumTable.getProductDetailList());
            data.put("date", invoiceNumTable.getDate());
            data.put("invoiceNumber", invoiceNumTable.getInvoiceNumber());
        return data;
    }


}
