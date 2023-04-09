package com.jsp.spring_boot_crud_with_response_exception.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Teacher {
		@Id
		@Column(name = "teacherid")
		private int teacherId;
		@Column(name = "teachername")
		private String teacherName;
		@Column(name = "teacheremail")
		private String teacherEmail;
		@Column(name = "teacherphone")
		private Long teacherPhone;
		public int getTeacherId() {
			return teacherId;
		}
		public void setTeacherId(int teacherId) {
			this.teacherId = teacherId;
		}
		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}
		public String getTeacherEmail() {
			return teacherEmail;
		}
		public void setTeacherEmail(String teacherEmail) {
			this.teacherEmail = teacherEmail;
		}
		public Long getTeacherPhone() {
			return teacherPhone;
		}
		public void setTeacherPhone(Long teacherPhone) {
			this.teacherPhone = teacherPhone;
		}
}
