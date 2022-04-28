package com.sohail.springboot.thymeleafdemo.service;

import com.sohail.springboot.thymeleafdemo.controller.EmployeetNotFoundException;
import com.sohail.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.sohail.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
         return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Employee employee = null;
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()){
            employee=result.get();
        }
        else{
            throw new EmployeetNotFoundException("No employee with id: "+id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("employee saved"+employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("updated: "+employee);
    }
}
