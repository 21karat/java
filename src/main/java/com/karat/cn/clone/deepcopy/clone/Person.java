package com.karat.cn.clone.deepcopy.clone;
/**
 * 通过clone方法实现深度copy
 * 
 * 
 * 相对于浅copy,深copy对引用类型的修改,并不会影响到对应的copy对象的值。
 * 
 * 每层对象都浅copy一遍就是深copy
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

	protected Object clone() throws CloneNotSupportedException{
		Person person=(Person) super.clone();//第一层copy
		person.setSon((Son)person.getSon().clone());//第二层copy
		return person;//返回的没有引用了
	}
	
	
	static class Son implements Cloneable{
		
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
		
		
		protected Object clone() throws CloneNotSupportedException{
			return super.clone();//copy
		}
	}
	
	public static void main(String args[]) throws CloneNotSupportedException{
		Son son=new Son("小明");
		Person person1=new Person("小红",son);
		Person person2=(Person)person1.clone();
		
		person2.setName("小刚");
		person2.getSon().setSonName("小强");//修改引用对象值
		
		System.out.println(person1);
		System.out.println(person2);
	}
}
