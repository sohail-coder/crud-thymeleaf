package com.sohail.springboot.thymeleafdemo.dao;

import com.sohail.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//The below-mentioned annotation is for changing the default plural word

//@RepositoryRestResource("members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();
}
