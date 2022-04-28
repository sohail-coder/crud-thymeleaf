package com.sohail.springboot.thymeleafdemo.controller;

import com.sohail.springboot.thymeleafdemo.entity.Employee;
import com.sohail.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class DemoController {

    private EmployeeService employeeService;

    @Autowired
    public DemoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String form(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "show-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId")int id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "show-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int id,Model model){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
