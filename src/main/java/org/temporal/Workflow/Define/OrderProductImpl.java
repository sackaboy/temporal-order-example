package org.temporal.Workflow.Define;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import org.jboss.logging.Logger;
import org.temporal.Activity.ActivityOrderNewProduct;
import org.temporal.Model.Invoice;
import java.time.Duration;

public class OrderProductImpl implements OrderProduct {

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
        .setInitialInterval(Duration.ofSeconds(1))
        .setMaximumInterval(Duration.ofSeconds(5))
        .setBackoffCoefficient(2)
        .setMaximumAttempts(10)
        .build();
    private final ActivityOptions defaultActivityOptions = ActivityOptions.newBuilder()
            // Timeout options specify when to automatically timeout Activities if the process is taking too long.
            .setStartToCloseTimeout(Duration.ofSeconds(60))
            // Optionally provide customized RetryOptions.
            // Temporal retries failures by default, this is simply an example.
            .setRetryOptions(retryoptions)
            .build();


    private final ActivityOrderNewProduct activityOrderNewProduct = Workflow.newActivityStub(ActivityOrderNewProduct.class,defaultActivityOptions);

    public boolean isOrderConfirmed = false;
    public boolean isOrderPickedUp = false;
    public boolean isOrderDelivered = false;
    private String status = "";

    private static final Logger LOG = Logger.getLogger(OrderProductImpl.class);

    @Override
    public Invoice orderNewProduct(Invoice invoice) {
        try{
            activityOrderNewProduct.placeOrder(invoice.getCustomer());
            status = "waiting confirm";
            if(activityOrderNewProduct.checkInventoryQuantity(
                    invoice.getInvoiceDetailList().get(0).getProduct(),
                    invoice.getInvoiceDetailList().get(0).getQuantity())
            ){
                LOG.info("***** Waiting for Hoang Phuc International to confirm your order");
                activityOrderNewProduct.assignEmpConfirm();

                LOG.info("isOrderConfirmed: "+isOrderConfirmed);
                Workflow.await(() -> isOrderConfirmed);
                LOG.info("isOrderConfirmed: "+isOrderConfirmed);
                invoice.setStatus("confirmed");
                status = invoice.getStatus();
                LOG.info("***** Please wait till we assign a delivery executive");

                Workflow.await(() -> isOrderPickedUp);
                invoice.setStatus( "picked up");
                status = invoice.getStatus();
                LOG.info("isOrderPickedUp: "+isOrderPickedUp);

                Workflow.await(() -> isOrderDelivered);
                invoice.setStatus( "delivered");
                status = invoice.getStatus();
            }else{
                LOG.info("***** Placed Order Not Successfully !");
                invoice.setStatus( "cancelled");
                status = invoice.getStatus();
                activityOrderNewProduct.notifyCustomer(invoice.getCustomer());
            }

            return invoice;
        }catch (Exception e){
            invoice.setStatus( "cancelled cause error");
            status = invoice.getStatus();
        }
        return invoice;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void signalOrderAccepted() {
        activityOrderNewProduct.setOrderAccepted();
        this.isOrderConfirmed = true;
    }

    @Override
    public void signalOrderPickedUp() {
        activityOrderNewProduct.setOrderPickedUp();
        this.isOrderPickedUp = true;
    }

    @Override
    public void signalDelivered() {
        activityOrderNewProduct.setOrderDelivered();
        this.isOrderDelivered = true;
    }
}
