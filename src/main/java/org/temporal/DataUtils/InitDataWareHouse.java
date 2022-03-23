package org.temporal.DataUtils;

import org.temporal.Model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InitDataWareHouse {

    public InitDataWareHouse(){

    }

    @Inject
    List<Department> depLst;

    @Produces
    @ApplicationScoped
    public List<Customer> getLstCustomer(){
        List<Customer> cusLst = new ArrayList<>();
        cusLst.add(new Customer(1,"Anh Khiem","505 Au Co, Quan Tan Binh,TpHCM","09123466662"));
        cusLst.add(new Customer(2,"Anh Hung","200 Nguyen Huu Canh, Quan 7, TpHCM","09358883292"));
        cusLst.add(new Customer(3,"Chi Hang","2964 Huynh Tan Phat, Quan 7, TpHCM","0934343883"));
        return cusLst;
    }

    @Produces
    @ApplicationScoped
    public List<Department> getLstDepartment(){
        List<Department> depLst = new ArrayList<>();
        depLst.add(new Department(1,"Hoàng Phúc Nguyễn Trãi","137 Nguyễn Trãi"));
        depLst.add(new Department(2,"Hoàng Phúc Nguyễn Huệ","56 Nguyễn Huệ"));
        depLst.add(new Department(3,"Hoàng Phúc Quận 5","Quận 5"));
        return depLst;
    }

    @Produces
    @ApplicationScoped
    public List<Employee> getLstEmployee(){
        List<Employee> empLst = new ArrayList<>();
        empLst.add(new Employee(1,"Chu Văn Hạnh","000000454545","Shipper", "SHIP", "Âu Cơ, Phường 9, Quận Tân Bình,Tp.HCM", depLst.get(0)));
        empLst.add(new Employee(2,"Mã Văn Tèo","0936035888","Shipper", "SHIP", "Âu Cơ, Phường 9, Quận Tân Bình,Tp.HCM", depLst.get(0)));
        empLst.add(new Employee(3,"Mã Siêu","0936035999","Seller", "SELL", "Nguyễn Văn Trỗi, Phường 10, Quận Tân Bình,Tp.HCM", depLst.get(0)));
        empLst.add(new Employee(4,"Tư Mã Ý","0936035001","Seller", "SELL", "Nguyễn Văn Trỗi, Phường 10, Quận Tân Bình,Tp.HCM", depLst.get(0)));
        empLst.add(new Employee(5,"Tào Tháo","0936035006", "Customer Service", "CS", "Quận Tân Phú,Tp.HCM", depLst.get(0)));
        empLst.add(new Employee(6,"Lưu Bị","0936035002", "Inventory Management", "IM", "Quận Tân Phú,Tp.HCM", depLst.get(1)));
        empLst.add(new Employee(7,"Gia Cát Lượng","0936036003","Inventory Management", "IM", "Tp.HCM", depLst.get(1)));
        empLst.add(new Employee(8,"Quan Vũ","0936035004","Seller", "SELL", "Tp.HCM", depLst.get(1)));
        empLst.add(new Employee(9,"Trương Phi","0936035005","Seller", "SELL", "Tp.HCM", depLst.get(1)));
        empLst.add(new Employee(10,"Quách Gia","0936036007","Inventory Management", "IM", "Tp.HCM", depLst.get(2)));
        empLst.add(new Employee(11,"Từ Hoảng","0936035008","Seller", "SELL", "Tp.HCM", depLst.get(2)));
        empLst.add(new Employee(12,"Hạ Hầu Đôn","0936035009","Seller", "SELL", "Tp.HCM", depLst.get(2)));
        empLst.add(new Employee(13,"Duy Nguyễn","00240454545","Shipper", "SHIP", "Âu Cơ, Phường 9, Quận Tân Bình,Tp.HCM", depLst.get(0)));
        return empLst;
    }

    @Produces
    @ApplicationScoped
    public List<Product> getLstProduct(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Kappa Sock",120000.00,49,"",true,new Provider(1,"Kappa")));
        productList.add(new Product(2,"Dr Martens 1461",2700000.00,12,"",true,new Provider(1,"Dr Martens")));
        return productList;
    }

    @Produces
    @ApplicationScoped
    public List<Status> getLstStatus(){
        List<Status> statusList = new ArrayList<>();
        statusList.add(new Status(1,"Waiting Confirm"));
        statusList.add(new Status(2,"Delivering"));
        statusList.add(new Status(3,"Success Delivered"));
        statusList.add(new Status(4,"Received"));
        return statusList;
    }
}