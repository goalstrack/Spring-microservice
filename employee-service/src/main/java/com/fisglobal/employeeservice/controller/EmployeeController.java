package com.fisglobal.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.employeeservice.EmployeeServiceApplication;
import com.fisglobal.employeeservice.exception.RecordNotFound;
import com.fisglobal.employeeservice.model.Employee;
import com.fisglobal.employeeservice.repository.EmployeeRepository;



@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRespository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees()
	{
		List<Employee> empl= empRespository.findAll();
		if(empl.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(empl);
		}
		else {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records Found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws RecordNotFound
	{
		Employee employee= empRespository.getById(id).orElseThrow(()-> new RecordNotFound("Organization not found::"+id));
		return ResponseEntity.ok().body(employee);
	/* (	if(optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No records Found");
		}*/
	}
	
	@PostMapping("/createOrganization")
	public ResponseEntity<?> createOrganization(@Valid @RequestBody  Employee organization)
	{
		if(empRespository.existsById(organization.getEmpid()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("records already exists");
		}
		Employee o1= empRespository.save(organization);
		
		System.out.println(o1);
		if(o1!=null)
		return ResponseEntity.status(201).body(organization);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records Found");
	}

	

}
