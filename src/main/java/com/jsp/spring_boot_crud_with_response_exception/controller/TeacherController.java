package com.jsp.spring_boot_crud_with_response_exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_boot_crud_with_response_exception.dto.ResponseStructure;
import com.jsp.spring_boot_crud_with_response_exception.dto.Teacher;
import com.jsp.spring_boot_crud_with_response_exception.exception.IdNotFoundException;
import com.jsp.spring_boot_crud_with_response_exception.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/saveTeacherDetails")
	public ResponseStructure<Teacher> saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@PostMapping("/saveAllTeachers")
	public ResponseStructure<List<Teacher>> saveAllTeachers(@RequestBody List<Teacher> teachers) {
		return teacherService.saveAllTeachers(teachers);
	}

	//sort data with attribute(name) in ascending order
	@GetMapping("/getAllTeacherAsc/{name}")
	public List<Teacher> getAllTeacherAscOrder(@PathVariable String name) {
		return teacherService.getAllTeacherAscOrder(name);
	}

	//getById Teacher Method
	@GetMapping("/getTeacherById/{Id}")
	public ResponseStructure<Teacher> getteacherById(@PathVariable int id) throws IdNotFoundException {

		return teacherService.getteacherById(id);
	}

	//pagination getAlldata
	@GetMapping("/getAllDataPagination/{pageNumber}/{pageSize}")
	public Page<Teacher> getAllTeacher(@PathVariable int pageNumber, @PathVariable int pageSize) {
		return teacherService.getAllTeacher(pageNumber, pageSize);
	}
}
