package com.infotec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotec.employeeDAO.EmployeeDAO;
import com.infotec.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDao;

	// to create
	@PostMapping("/employees")
	public Employee createEmployee(Employee employee){
		
		return employeeDao.save(employee);		
	}
	
	// to List employee
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		
		return employeeDao.getEmployee();
		
	}
	
	// to get one empid
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> findOne(@PathVariable(value = "id")  Long empid){
		
		Employee emp = employeeDao.getOne(empid);
		
		if(emp == null){
			
			ResponseEntity.notFound();
		}
		
		
		return ResponseEntity.ok().body(emp);
	}	
		// to update empid
		
		@PostMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,
				@Valid @RequestBody Employee empDetails) {
		
			Employee emp = employeeDao.getOne(empid);
			
			if(emp==null){
				
				ResponseEntity.notFound().build();
			}
			
			emp.setId(empDetails.getId());
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			
			Employee updateDetails = employeeDao.save(emp);
			
			return ResponseEntity.ok().body(updateDetails);
			
		}
		
		//delete empe
		
		@PostMapping("/employees/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable (value = "id") Long eid){
			
			Employee emp = employeeDao.getOne(eid);
			
			if(emp == null){
				
				ResponseEntity.notFound().build();
			}
			
			employeeDao.delete(emp);
			
			return ResponseEntity.ok("deleted");
			
		}
		
		
		
	}
	
