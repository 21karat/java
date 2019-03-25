package com.karat.cn.serializable;

import java.io.Serializable;
/**
 * 序列化对象
 * @author 开发
 *
 */
public class Persion implements Serializable{
	
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -6872638263540706801L;

	private String id;
	
	private static String name="小明";
	
	private int age;
	
	private transient String sex;
	
	public Persion() {
		super();
	}

	public Persion(String id, int age, String sex) {
		super();
		this.id = id;
		this.age = age;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "Persion [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
