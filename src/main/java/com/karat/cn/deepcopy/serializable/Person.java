package com.karat.cn.deepcopy.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 将对象序列化然后反序列化实现深copy
 * @author 开发
 */
@SuppressWarnings("serial")
public class Person implements Serializable{

	private String name;
	
	private Son son;
	

	public Person() {
		super();
	}

	public Person(String name, Son son) {
		super();
		this.name = name;
		this.son = son;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Son getSon() {
		return son;
	}

	public void setSon(Son son) {
		this.son = son;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", son=" + son + "]";
	}

	
	static class Son implements Serializable{
		
		private String sonName;

		public Son() {
			super();
		}

		public Son(String sonName) {
			super();
			this.sonName = sonName;
		}

		public String getSonName() {
			return sonName;
		}

		public void setSonName(String sonName) {
			this.sonName = sonName;
		}

		@Override
		public String toString() {
			return "Son [sonName=" + sonName + "]";
		}	
	}
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Son son=new Son("KKK");
		Person person1=new Person("AA",son);
		//通过序列化实现深copy
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		ObjectOutputStream outputStream=new ObjectOutputStream(byteArrayOutputStream);
		outputStream.writeObject(person1);//序列化
		outputStream.flush();
		
		ObjectInputStream inputStream=new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
		Person person2=(Person)inputStream.readObject();//反序列化
		
		person1.setName("小明");
		person1.getSon().setSonName("小强");
		
		System.out.println(person1);
		System.out.println(person2);
	}
}
