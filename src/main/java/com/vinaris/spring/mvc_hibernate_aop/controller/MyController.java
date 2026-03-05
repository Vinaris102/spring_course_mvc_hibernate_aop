package com.vinaris.spring.mvc_hibernate_aop.controller;

import com.vinaris.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.vinaris.spring.mvc_hibernate_aop.entity.Employee;
import com.vinaris.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        System.out.println("========== КОНТРОЛЛЕР ВЫЗВАН ==========");
        List<Employee> allEmployees =  employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "Server Run";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";

    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
