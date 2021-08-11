package com.fisglobal.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
