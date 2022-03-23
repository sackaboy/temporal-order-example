package org.temporal.BussinessLogic;


import org.temporal.Model.Product;
import org.temporal.Model.Status;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StatusBusiness {

    @Inject
    List<Status> statusList;

    public StatusBusiness(){

    }

    public Status getStatusById(int statusId){
        var status = statusList
                .stream()
                .filter(item -> item.getId() == statusId)
                .collect(Collectors.toList());
        return status.size() > 0 ? status.get(0) : null;
    }
}
