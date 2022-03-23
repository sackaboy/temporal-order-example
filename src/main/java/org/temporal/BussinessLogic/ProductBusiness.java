package org.temporal.BussinessLogic;


import org.temporal.Model.Department;
import org.temporal.Model.Employee;
import org.temporal.Model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductBusiness {

    @Inject
    List<Product> productList;

    public ProductBusiness(){

    }

    public Product getProductById(int prodId){
        var prod = productList
                .stream()
                .filter(item -> item.getId() == prodId)
                .collect(Collectors.toList());
        return prod.size() > 0 ? prod.get(0) : null;
    }
}
