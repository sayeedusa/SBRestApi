
package com.sdtechny.SBRestApi.Controller;

import com.sdtechny.SBRestApi.ExceptionHandler.EmpNameFieldException;
import com.sdtechny.SBRestApi.Model.Employee;
import com.sdtechny.SBRestApi.Repository.EmpRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
    @Autowired
    EmpRepo repo;
    @GetMapping("/emplist")
   public List<Employee> getallEmployee(){
       List<Employee> emplist=repo.findAll();
       return emplist;
   }
   @GetMapping("/emplist/{id}")
   public Employee getemp(@PathVariable int id){
      // Employee emp=repo.findById(id).get();
       Optional< Employee> emp=repo.findById(id);
     if(emp.isPresent()){
       return emp.get();  
     }else
       throw new RuntimeException(" Employee not Found");  
// this message will show at the end
   }
   
   //To Create Record
   @PostMapping("/emp/add")
   public void createEmp(@RequestBody Employee emp){
       if( emp.getFirstname().isEmpty()){
           throw new EmpNameFieldException("Employee Name is MIssing");
           // untill this code is OK.
           // Further to Extend the The Exception we can add 
           // a Handler End of the Controller
       }
       repo.save(emp);
   }
   //To Update
   @PutMapping("emp/update/{id}")
   public Employee empUpdate(@PathVariable int id){
       Employee emp=repo.findById(id).get();
       emp.setFirstname("Nelam");
       emp.setSalary(500.55);
       repo.save(emp);
       return  emp;
       
       
   }
   
    // To delete a Record
   @DeleteMapping("/emp/delete/{id}")
   public void empDelete(@PathVariable int id){
       Employee emp=repo.findById(id).get();
       repo.delete(emp);
       
   }
   //With out the following code it will system error message and custom message;
   @ExceptionHandler(Exception.class)
   public String RuntimeException(Exception ex){
       return ex.getMessage();
   }
   
   //To make Global Exception Handler we will this Handler in Global
   //Exception Handler Class
  @ExceptionHandler(EmpNameFieldException.class)
   public ResponseEntity<String> EmpNmaeMissingExceptionHandler(EmpNameFieldException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrMsg());
} 
   
}
    

