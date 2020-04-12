package com.infotec.employeeDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infotec.model.Employee;
import com.infotec.model.EmployeeRepository;

public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	// to save employe

	public Employee save(Employee employee) {

		return employeeRepository.save(employee);
	}

	// to List employee

	public List<Employee> getEmployee() {

		return employeeRepository.findAll();

	}

	// to get one employee

	public Employee getOne(Long empid) {

		return employeeRepository.getOne(empid);
	}

	// to remove employee

	public void delete(Employee empid) {

		employeeRepository.delete(empid);
	}

}
