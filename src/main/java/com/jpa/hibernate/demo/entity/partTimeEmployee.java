package com.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class partTimeEmployee extends Employee {

    protected partTimeEmployee(){}

    public partTimeEmployee(String name, BigDecimal hourlyWage){
        super(name);
        this.hourlyWage = hourlyWage;
    }

    private BigDecimal hourlyWage;

}
