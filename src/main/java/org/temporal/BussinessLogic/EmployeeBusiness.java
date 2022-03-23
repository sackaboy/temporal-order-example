package org.temporal.BussinessLogic;

import org.temporal.Model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeBusiness {

    @Inject
    List<Employee> employeeList;

    public EmployeeBusiness(){

    }

    public List<Employee> getEmployeesByDepId(int depId){
        var emp = employeeList
                .stream()
                .filter(item -> item.getDepartment()
                .getId() == depId)
                .collect(Collectors.toList());
        return emp.size() > 0 ? emp : null;
    }

    public Employee getEmployeeById(int empId){
        var emp = employeeList
                .stream()
                .filter(item -> item.getId() == empId)
                .collect(Collectors.toList());
        return emp.size() > 0 ? emp.get(0) : null;
    }

    public Employee getEmployeeByCode(String empCode){
        Random randomizer = new Random();
        var emp = employeeList
                .stream()
                .filter(item -> item.getTitleCode().equals(empCode))
                .collect(Collectors.toList());
        return emp.size() > 0 ? emp.get(randomizer.nextInt(emp.size())) : null;
    }
}
