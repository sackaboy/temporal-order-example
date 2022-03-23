package org.temporal.BussinessLogic;
import org.temporal.Model.InvoiceDetail;
import org.temporal.Model.Product;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class InvoiceDetailBusiness {

    @Inject
    ProductBusiness productBus;

    public InvoiceDetailBusiness(){

    }

    public InvoiceDetail createNew(String invoiceID,int productId, int quantity){
        Product prod =  productBus.getProductById(productId);
        String id = UUID.randomUUID().toString();
        return new InvoiceDetail(invoiceID,invoiceID,prod,quantity);
    }

}
