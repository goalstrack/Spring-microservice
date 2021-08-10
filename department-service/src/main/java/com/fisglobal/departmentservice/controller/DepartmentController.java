package com.fisglobal.departmentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/derpartment")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartment()
	{
		List<Department> department= departmentRepository.findAll();
		if(department.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(department);
		}
		else {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records Found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") long id)
	{
		Optional<Department> optional= departmentRepository.findById(id);
		
		if(optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records Found");
		}
	}
	
	//@PostMapping
	//public ResponseEntity<?> 

}
