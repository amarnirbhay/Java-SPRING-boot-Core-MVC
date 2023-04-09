package com.jsp.spring_boot_crud_with_response_exception.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jsp.spring_boot_crud_with_response_exception.dto.ResponseStructure;
import com.jsp.spring_boot_crud_with_response_exception.dto.Teacher;
import com.jsp.spring_boot_crud_with_response_exception.exception.IdNotFoundException;
import com.jsp.spring_boot_crud_with_response_exception.repository.TeacherRepository;

@Repository
public class TeacherDao {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public List<Teacher> saveAllTeachers(List<Teacher> teachers) {
		return teacherRepository.saveAll(teachers);
	}
	
	//sort data with attribute(name) in ascending order 
	public List<Teacher> getAllTeacherAscOrder(String teacherName){
		return teacherRepository.findAll(Sort.by(Sort.Direction.ASC , teacherName));
	}
	
	//getById Teacher Method
	public Teacher getteacherById(int id) {
		
		Optional<Teacher> optional=teacherRepository.findById(id);
		
		if(optional.isPresent()) {
			 return optional.get();
		}
		else {
			return null;
		}
		
		
	}
	
	//pagination getAlldata
		public Page<Teacher> getAllTeacher(int pageNumber,int pageSize){
			
			return teacherRepository.findAll(PageRequest.of(pageNumber, pageSize));
		}
	
	
	
}
