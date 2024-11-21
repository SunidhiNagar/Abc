package com.spring.Student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.Student.dto.RequestDTO;
import com.spring.Student.dto.ResponseDTO;
import com.spring.Student.service.EmployeeService;

@RestController
@RequestMapping("/bfhl")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getOperationCode() {
        return "{ \"operation_code\": 1 }";
    }

    @PostMapping
    public ResponseDTO processRequest(@RequestBody RequestDTO request) {
        return employeeService.processRequest(request);
    }
}



