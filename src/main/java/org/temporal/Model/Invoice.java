package org.temporal.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    String id;
    List<InvoiceDetail> invoiceDetailList;
    Customer customer;
    String status;
    Date create;

    public Invoice(){

    }

    public void addInvoiceDetail(InvoiceDetail invoiceDetail){
        this.invoiceDetailList.add(invoiceDetail);
    }

    public Invoice(String id, Customer customer, String status, Date create) {
        this.id = id;
        this.customer = customer;
        this.status = status;
        this.create = create;
        this.invoiceDetailList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
