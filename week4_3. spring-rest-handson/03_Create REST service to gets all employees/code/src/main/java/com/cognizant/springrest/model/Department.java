package com.cognizant.springrest.model;

public class Department {

    private int id;
    private String name;

    // ✅ Required no-arg constructor
    public Department() {}

    // ✅ Getter and Setter for 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ✅ Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
