package com.jsp.spring_boot_crud_with_response_exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring_boot_crud_with_response_exception.dto.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
