package com.company.departmentservice.service;

import java.util.*;
import com.company.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.departmentservice.entity.Department;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> getAllDepartments() {
	    return departmentRepository.findAll();
	}
	
	public Department getDepartmentById(Long id) {
	    return departmentRepository.findById(id)
	            .orElseThrow(() ->
	                new ResponseStatusException(
	                    HttpStatus.NOT_FOUND,
	                    "Department not found with id: " + id
	                ));
	}
	
	public Department updateDepartment(Long id, Department updatedDepartment) {
	    Department department = departmentRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND,
	                    "Department not found with id: " + id
	                ));

	    department.setName(updatedDepartment.getName());
	    department.setLocation(updatedDepartment.getLocation());

	    return departmentRepository.save(department);
	}
	
	public void deleteDepartment(Long id) {
	    Department department = departmentRepository.findById(id)
	    		.orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND,
	                    "Department not found with id: " + id
	                ));

	    departmentRepository.delete(department);
	}
}