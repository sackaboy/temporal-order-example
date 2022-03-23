package org.temporal.Model;

import java.util.Date;
import java.util.List;

public class InvoiceDetail {
    String id;
    String invoiceID;
    Product product;
    int quantity;

    public InvoiceDetail(){

    }

    public InvoiceDetail(String id, String invoiceID, Product product, int quantity) {
        this.id = id;
        this.invoiceID = invoiceID;
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productList) {
        this.product = productList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
