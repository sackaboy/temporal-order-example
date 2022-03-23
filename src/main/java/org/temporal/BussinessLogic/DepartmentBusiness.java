package org.temporal.BussinessLogic;


import org.temporal.Model.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DepartmentBusiness {

    @Inject
    List<Department> departmentLst;

    public DepartmentBusiness(){

    }

    public Department getDepartmentById(int id){
        var dep = departmentLst.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
        return dep.size() > 0 ? dep.get(0) : null;
    }
}
