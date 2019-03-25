package com.karat.cn.clone.shallowcopy.clone;

/**
 * 自带的copy(clone()方法)实现浅拷贝
 * @author 开发
 *
 */
public class Person implements Cloneable{

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
	
	/*@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}*/

	static class Son{
		
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
	
	public static void main(String args[]) throws CloneNotSupportedException{
		Son son=new Son("小明");
		Person person1=new Person("小红",son);
		Person person2=(Person)person1.clone();//自带的copy实现浅拷贝
		
		person2.setName("小强");
		person2.getSon().setSonName("小乔");//修改Son中小明为小乔,因为son拷贝的是引用,所以改变引用值,其它全变
		
		System.out.println(person1);
		System.out.println(person2);
	}
}
