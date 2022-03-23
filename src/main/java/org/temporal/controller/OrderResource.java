package org.temporal.controller;

import org.jboss.logging.Logger;
import org.temporal.BussinessLogic.InvoiceBusiness;
import org.temporal.Model.Department;
import org.temporal.Model.Employee;
import org.temporal.BussinessLogic.DepartmentBusiness;
import org.temporal.BussinessLogic.EmployeeBusiness;
import org.temporal.Model.Invoice;
import org.temporal.Model.PageLoadInvoice;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/home")
@ApplicationScoped
public class OrderResource {

    private static final Logger LOG = Logger.getLogger(OrderResource.class);

    @Inject
    List<Department> departments;

    @Inject
    List<Employee> employees;

    @Inject
    DepartmentBusiness departmentBus;

    @Inject
    EmployeeBusiness employeeBuss;

    @Inject
    InvoiceBusiness invoiceBusiness;

    @GET
    @Path("/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        return employees;
    }

    @GET
    @Path("/getDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments() {
        return departments;
    }

    @GET
    @Path("/getDepartmentById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartmentById(@PathParam("id") int id) {
        return departmentBus.getDepartmentById(id);
    }

    @GET
    @Path("/getEmployeesByDepId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesByDepId(@PathParam("id") int id) {
        return employeeBuss.getEmployeesByDepId(id);
    }

    @GET
    @Path("/getEmployeesByID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeesByID(@PathParam("id") int id) {
        return employeeBuss.getEmployeeById(id);
    }

    @POST
    @Path("invoice/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Invoice createNewInvoice(PageLoadInvoice pageLoadInvoice) {
        LOG.info("pageLoadInvoice-prodID:--- "+pageLoadInvoice.prodID);
        LOG.info("pageLoadInvoice-cusID:--- "+pageLoadInvoice.cusID);
        return null;
    }

    @GET
    @Path("invoice/getLst")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invoice> getLstInvoice() {
        return invoiceBusiness.getInvoiceLst();
    }
}