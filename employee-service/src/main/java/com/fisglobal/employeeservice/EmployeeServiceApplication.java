package com.fisglobal.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.employeeservice.model.Employee;
import com.fisglobal.employeeservice.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(EmployeeServiceApplication.class, args);
		EmployeeRepository empr=context.getBean(EmployeeRepository.class);
		/*Employee emp=new Employee("e01", "Bhakti", "shastri", 25000);
		Employee emp1=new Employee("e02", "ved", "shastri", 20030);
		Employee emp2=new Employee("e03", "sangeeta", "shastri", 22000);
		Employee emp3=new Employee("e04", "shradha", "shastri", 29000);
		empr.save(emp);
		empr.save(emp1);
		empr.save(emp2);
		empr.save(emp3);
		context.close(); */
	
	}

}
