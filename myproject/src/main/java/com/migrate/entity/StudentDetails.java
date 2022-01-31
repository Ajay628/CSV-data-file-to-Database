package com.migrate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {
	private String Name;
	@Id
	@Column(name="Roll")
	
	private int Roll;
	@Column(name="Course")
	private String Course;
	@Column(name="Mark1")
	private int Mark1;
	@Column(name="Mark2")
	private int Mark2;
	@Column(name="Mark3")
	private int Mark3;
	@Column(name="TotalMark")
	private int TotalMark;
	@Column(name="Average")
	private float Average;
	


	
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public int getMark1() {
		return Mark1;
	}
	public void setMark1(int mark1) {
		Mark1 = mark1;
	}
	public int getMark2() {
		return Mark2;
	}
	public void setMark2(int mark2) {
		Mark2 = mark2;
	}
	public int getMark3() {
		return Mark3;
	}
	public void setMark3(int mark3) {
		Mark3 = mark3;
	}
	
	
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Roll=" + Roll + ", Course=" + Course + ", Mark1=" + Mark1 + ", Mark2="
				+ Mark2 + ", Mark3=" + Mark3 + "]";
	}
}

