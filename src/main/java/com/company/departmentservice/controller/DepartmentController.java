package com.company.departmentservice.controller;

import java.util.*;
import jakarta.validation.Valid;
import com.company.departmentservice.entity.Department;
import com.company.departmentservice.service.DepartmentService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
	    this.departmentService = departmentService;
	}
	
	@PostMapping
	public Department addDepartment(@Valid @RequestBody Department department) {
	    return departmentService.addDepartment(department);
	}
	
	@GetMapping
	public List<Department> getAllDepartments() {
	    return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public Department 
	getDepartmentById(@PathVariable Long id) {
	    return departmentService.getDepartmentById(id);
	}
	
	@PutMapping("/{id}")
	public Department updateDepartment(
	        @PathVariable Long id,
	        @RequestBody Department department) {
	    return departmentService.updateDepartment(id, department);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable Long id) {
	    departmentService.deleteDepartment(id);
	    return "Department deleted successfully";
	}
}