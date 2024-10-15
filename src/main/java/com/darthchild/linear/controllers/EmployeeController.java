package com.darthchild.linear.controllers;

import com.darthchild.linear.dto.EmployeeDTO;
import com.darthchild.linear.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
Controller gets a GET request, it calls a Service to fulfill it
the Service uses Repository to get the data
*/
@RestController
@RequestMapping(path = "/employees")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // For GET Request
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empId){
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping
    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit){
        return "Employee List by "+sortBy+ " & " +limit;
    }

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // For POST Request
    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    // For PUT Request
    @PutMapping(path = "/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id,employeeDTO);
    }

    // For DELETE Request
    @DeleteMapping(path = "/{id}")
    public Boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
