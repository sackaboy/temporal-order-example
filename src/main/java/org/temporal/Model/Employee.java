package org.temporal.Model;

public class Employee {
    int id;
    String name;
    String phone;
    String title;
    String titleCode;
    String address;
    Department department;

    public Employee() {
    }

    public Employee(int id, String name, String phone,
                    String title, String titleCode, String address,
                    Department department) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.title = title;
        this.titleCode = titleCode;
        this.address = address;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
