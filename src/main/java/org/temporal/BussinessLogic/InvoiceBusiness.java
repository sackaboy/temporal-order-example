package org.temporal.BussinessLogic;


import org.temporal.Model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InvoiceBusiness {

    @Inject
    CustomerBusiness customerBus;

    public InvoiceBusiness(){

    }

    List<Invoice> invoiceLst = new ArrayList<>();

    public Invoice createNew(int customerId){
        Customer cus =  customerBus.getCustomerById(customerId);
        String invoiceId = UUID.randomUUID().toString();
        Invoice invoice = new Invoice(invoiceId,cus,"waiting confirm",new Date());
        invoiceLst.add(invoice);
        return invoice;
    }

    public List<Invoice> getInvoiceLst(){
        return this.invoiceLst;
    }
}
