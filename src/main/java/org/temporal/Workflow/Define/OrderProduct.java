package org.temporal.Workflow.Define;

import io.temporal.workflow.*;
import org.temporal.Model.Invoice;

@WorkflowInterface
public interface OrderProduct {

    public static final String QUEUE_NAME = "Customer_Order";

    @WorkflowMethod
    Invoice orderNewProduct(Invoice invoice);

    @QueryMethod
    String getStatus();

    @SignalMethod
    void signalOrderAccepted();

    @SignalMethod
    void signalOrderPickedUp();

    @SignalMethod
    void signalDelivered();
}