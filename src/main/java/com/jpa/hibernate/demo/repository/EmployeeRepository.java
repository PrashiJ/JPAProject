package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee){
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees(){
        return  em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
