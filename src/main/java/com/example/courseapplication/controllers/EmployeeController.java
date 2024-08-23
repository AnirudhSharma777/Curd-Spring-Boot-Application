package com.example.courseapplication.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.courseapplication.dto.EmployeeDto;
import com.example.courseapplication.services.EmployeeService;

import java.time.LocalDate;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    private final EmployeeService employeeService;
    


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // @GetMapping
    // public EmployeeDto getEmployee() {
    //     return new EmployeeDto(1L,"Anirudh",LocalDate.of(2004,8,30),true);
    // }

   
    // @GetMapping(path = "/employee")
    // public String getMethodName(@PathParam("sortBy") String sortBy,@PathParam("limit") Integer limit) {
    //     return "Hello "+ sortBy+" "+ limit;
    // }


    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    

    @GetMapping(path="/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }


    @PostMapping
    public EmployeeDto getData(@RequestBody EmployeeDto employeeDto) {
       return employeeService.createNewEmployee(employeeDto);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }
    
}
