package org.temporal.controller;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.jboss.logging.Logger;
import org.temporal.BussinessLogic.*;
import org.temporal.Model.*;
import org.temporal.Workflow.Define.OrderProduct;
import org.temporal.WorkflowObservable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.UUID;

@Path("/workflow")
@ApplicationScoped
public class WorkflowResource {

    @Inject
    WorkflowObservable workflowObservable;

    @Inject
    InvoiceBusiness invoiceBusiness;

    @Inject
    InvoiceDetailBusiness invoiceDetailBusiness;

    private static final Logger LOG = Logger.getLogger(WorkflowResource.class);

    @POST
    @Path("/placeOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Invoice placeNewOrder(PageLoadInvoice pageLoadInvoice) {
        int productOrderQuantity = 2;
        Invoice invoice = invoiceBusiness.createNew(pageLoadInvoice.cusID);
        InvoiceDetail invoiceDetail = invoiceDetailBusiness.createNew(invoice.getId(),pageLoadInvoice.prodID, productOrderQuantity);

        invoice.addInvoiceDetail(invoiceDetail);

        OrderProduct workflow =
                workflowObservable.getClient().newWorkflowStub(
                        OrderProduct.class, WorkflowOptions.newBuilder()
                                .setWorkflowId("Customer_Order_" + Math.abs(new Random().nextInt()))
                                .setTaskQueue(OrderProduct.QUEUE_NAME).build());
        WorkflowClient.start(workflow::orderNewProduct,invoice);
        return invoice;
    }

    @GET
    @Path("/confirmed/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String confirmedOrder(@PathParam("orderId") int orderId) {
        OrderProduct orderProductWF = workflowObservable.getClient().newWorkflowStub(OrderProduct.class,"Customer_Order_"+orderId);
        orderProductWF.signalOrderAccepted();
        return "Accepted";
    }

    @GET
    @Path("/pickedUp/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String pickedUpOrder(@PathParam("orderId") int orderId) {
        OrderProduct orderProductWF = workflowObservable.getClient().newWorkflowStub(OrderProduct.class,"Customer_Order_"+orderId);
        orderProductWF.signalOrderPickedUp();
        return "Delivering";
    }

    @GET
    @Path("/delivered/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deliveredOrder(@PathParam("orderId") int orderId) {
        OrderProduct orderProductWF = workflowObservable.getClient().newWorkflowStub(OrderProduct.class,"Customer_Order_"+orderId);
        orderProductWF.signalDelivered();
        return "Delivered";
    }
}