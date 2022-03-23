package org.temporal.BussinessLogic;


import org.temporal.Model.Customer;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerBusiness {

    @Inject
    List<Customer> customerList;

    public CustomerBusiness(){

    }

    public Customer getCustomerById(int cusId){
        var cus = customerList
                .stream()
                .filter(item -> item.getId() == cusId)
                .collect(Collectors.toList());
        return cus.size() > 0 ? cus.get(0) : null;
    }
}
