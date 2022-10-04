package com.scaspb.db_boot.controller;

import com.scaspb.db_boot.model.Employee;
import com.scaspb.db_boot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @GetMapping(value = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping(value = "/updateInfo")
    public String updateEmployee(@RequestParam("empID") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empID") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
