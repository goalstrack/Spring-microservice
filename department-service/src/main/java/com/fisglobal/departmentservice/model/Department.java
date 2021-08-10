package com.fisglobal.departmentservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "department")
public class Department {
	
	
	@Id	
	private long departmentId;
	private String departmentName;
	private String location;

}
