package org.temporal.Activity;

import org.jboss.logging.Logger;
import org.temporal.Model.Customer;
import org.temporal.Model.Employee;
import org.temporal.Model.Product;
import java.io.IOException;

public class ActivityOrderNewProductImpl implements ActivityOrderNewProduct {

    public ActivityOrderNewProductImpl(){

    }

    private static final Logger LOG = Logger.getLogger(ActivityOrderNewProductImpl.class);

    @Override
    public void placeOrder(Customer customer) {
        LOG.info("***** Customer order new");
    }

    @Override
    public Boolean checkInventoryQuantity(Product product, int quantity) {
        if(product.getQuantity() >= quantity){
            LOG.info("***** Inventory enough to provide");
            return true;
        }

        LOG.info("***** Inventory not enough to provide");
        return false;
    }

    @Override
    public void assignEmpConfirm() throws IOException {
        //Get Employee
        LOG.info("***** Order just assigned to: ");
        this.notifyEmployee();
    }

    @Override
    public void notifyEmployee() throws IOException {
        LOG.info("***** Notify ZNS to employee: " );
    }

    @Override
    public void notifyCustomer(Customer customer) {
        LOG.info("***** Notify  to customer : " + customer.getName());
    }

    @Override
    public void notifyDeliver(Employee employee) {
        LOG.info("***** Notify  to deliver : "+employee.getName());
    }

    @Override
    public void setOrderAccepted() {
        LOG.info("***** Employee has confirmed your order");
    }

    @Override
    public void setOrderPickedUp() {
        LOG.info("***** Order has been picked up");
    }

    @Override
    public void setOrderDelivered() {
        LOG.info("***** Order Delivered");
    }
}
