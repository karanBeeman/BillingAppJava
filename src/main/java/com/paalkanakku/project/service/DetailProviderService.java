package com.paalkanakku.project.service;

import com.paalkanakku.project.model.*;

import java.text.ParseException;
import java.util.List;

public interface DetailProviderService {

    InvoiceNumTable saveInvoiceDetails(InvoiceNumTable invoiceNumTable) throws Exception;

    InvoiceNumTable updateInvoiceDetails(InvoiceNumTable invoiceNumTable);
}
