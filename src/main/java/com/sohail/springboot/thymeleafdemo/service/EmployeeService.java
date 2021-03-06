package com.sohail.springboot.thymeleafdemo.service;



import com.sohail.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
    public void update(Employee employee);

}
