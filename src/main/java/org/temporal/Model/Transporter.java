package org.temporal.Model;

public class Transporter {
    int id;
    String name;
    String nameCode;

    public Transporter(int id, String name, String nameCode) {
        this.id = id;
        this.name = name;
        this.nameCode = nameCode;
    }

    public Transporter(){

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

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }
}
