package com.all.test.Demo;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 10:16
 * @Description : 学生类
 */
public class Student {
	private String student;//学生姓名
	private int gender;//学生性别，0表示女，1表示男
	private double stature;//学生身高，单位cm

	public Student(String student, int gender, double stature) {
		this.student = student;
		this.gender = gender;
		this.stature = stature;
	}

	public Student() {
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public double getStature() {
		return stature;
	}

	public void setStature(double stature) {
		this.stature = stature;
	}

}
