package com.almaaz.updateservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almaaz.updateservice.feign.UpdateFeign;
import com.almaaz.updateservice.model.Employee;
import com.almaaz.updateservice.repository.UpdateRepository;

@RestController
@RequestMapping("/update")
public class UpdateController {

	@Autowired
	UpdateRepository updaterepository;
	
	@Autowired
	UpdateFeign updatefeign;
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployeeName(@RequestBody Employee employee) {
		if(updaterepository.existsById(employee.getId())) {
			employee.setName(employee.getName());
			employee.setSalary(employee.getSalary());
			employee.setNumber(employee.getNumber());
			updaterepository.save(employee);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		else {
			System.out.println("insert emp called");
			ResponseEntity<String> str = updatefeign.insertEmployee(employee);
			return str;
		}
	}
}
