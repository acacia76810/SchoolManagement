package com.school.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String classStd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassStd() {
		return classStd;
	}
	public void setClassStd(String classStd) {
		this.classStd = classStd;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classStd=" + classStd + "]";
	}
	
}
