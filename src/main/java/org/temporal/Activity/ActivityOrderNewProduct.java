package org.temporal.Activity;

import io.temporal.activity.ActivityInterface;
import org.temporal.Model.Customer;
import org.temporal.Model.Employee;
import org.temporal.Model.Product;

import java.io.IOException;

@ActivityInterface
public interface ActivityOrderNewProduct {
    void placeOrder(Customer customer);
    Boolean checkInventoryQuantity(Product product, int quantity);
    void assignEmpConfirm() throws IOException;
    void notifyEmployee() throws IOException;
    void notifyCustomer(Customer customer);
    void notifyDeliver(Employee employee);
    void setOrderAccepted();
    void setOrderPickedUp();
    void setOrderDelivered();
}
