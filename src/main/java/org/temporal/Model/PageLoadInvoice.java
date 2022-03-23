package org.temporal.Model;

public class PageLoadInvoice {
    public int prodID;
    public int cusID;

    PageLoadInvoice(){
    }

    public PageLoadInvoice(int prodID, int cusID) {
        this.prodID = prodID;
        this.cusID = cusID;
    }
}
