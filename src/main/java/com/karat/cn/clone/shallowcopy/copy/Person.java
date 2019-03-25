package com.karat.cn.clone.shallowcopy.copy;
/**
 * 自定义构造函数实现浅拷贝
 * @author 开发
 *
 */
public class Person {

	private String name;
	
	private Son son;
	
	
	public Person() {
		super();
	}
	
	//自定义构造函数实现拷贝
	public Person(Person person){
		this.name=person.name;//值传递
		this.son=person.son;//引用传递
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
	
	public static void main(String args[]){
		Son son=new Son("小明");
		Person person1=new Person("小红",son);
		//通过自定义构造函数实现copy
		Person person2=new Person(person1);//"小红"属于值传递,son属于引用传递,修改son值都会变,修改"小红",person1中改变而person2中不变
		person1.setName("小花");//修改值传递(值)
		person1.getSon().setSonName("小强");//修改引用传递(值)
		System.out.println("person1"+person1);
		System.out.println("person2"+person2);
	}
}
