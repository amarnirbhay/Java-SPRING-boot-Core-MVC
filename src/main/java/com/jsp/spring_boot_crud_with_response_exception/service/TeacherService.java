package com.jsp.spring_boot_crud_with_response_exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.spring_boot_crud_with_response_exception.dao.TeacherDao;
import com.jsp.spring_boot_crud_with_response_exception.dto.ResponseStructure;
import com.jsp.spring_boot_crud_with_response_exception.dto.Teacher;
import com.jsp.spring_boot_crud_with_response_exception.exception.IdNotFoundException;

@Service
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;
	@Autowired
	ResponseStructure<Teacher> responseStructure2;
	@Autowired
	ResponseStructure<String> responseStructure3;
	
	public ResponseStructure<Teacher> saveTeacher(Teacher teacher) {
		
		
		responseStructure2.setStatusCode(HttpStatus.CREATED.value());
		responseStructure2.setMsg("data Inserted Successfully");
		responseStructure2.setData(teacher);
		
		teacherDao.saveTeacher(teacher);
		
		return responseStructure2;
	}
	@Autowired
	ResponseStructure<List<Teacher>> responseStructure;
	
	public ResponseStructure<List<Teacher>> saveAllTeachers(List<Teacher> teachers){
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMsg("All teachers Data saved Successfully ");
		responseStructure.setData(teachers);
		teacherDao.saveAllTeachers(teachers);
		return responseStructure;
	}
	
	//sort data with attribute(name) in ascending order 
		public List<Teacher> getAllTeacherAscOrder(String name){
			return teacherDao.getAllTeacherAscOrder(name);
		}
		
		
		@Autowired
		ResponseStructure<Teacher> responseStructure1;
		
		//getById Teacher Method
		public ResponseStructure<Teacher> getteacherById(int id)throws IdNotFoundException {
			
			Teacher teacher=teacherDao.getteacherById(id);
			
			if(teacher != null) {
				responseStructure2.setStatusCode(HttpStatus.FOUND.value());
				responseStructure2.setMsg("Data Available");
				responseStructure2.setData(teacher);
			}else {
				throw new IdNotFoundException("given Id is Not present in table");
			}
			return responseStructure2;
		}
		
		//pagination getAlldata
				public Page<Teacher> getAllTeacher(int pageNumber,int pageSize){
					return teacherDao.getAllTeacher(pageNumber, pageSize);
				}
}
