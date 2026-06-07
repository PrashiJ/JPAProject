package com.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class fullTimeEmployee extends Employee {

    protected fullTimeEmployee(){}

    public fullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }

    private BigDecimal salary;

}
