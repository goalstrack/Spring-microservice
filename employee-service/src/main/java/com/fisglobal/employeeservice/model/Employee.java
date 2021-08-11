package com.fisglobal.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	public String empid;
	
	@NotNull
	@Size(min=2,max=15,message="firstName should have atleast 2 chars")
	public String firstName;
	
	@NotNull
	@Size(min=2,max=15,message="lastName should have atleast 2 chars")
	public String lastName;
	 
	@NotNull
	public float salary;
	
	

}
