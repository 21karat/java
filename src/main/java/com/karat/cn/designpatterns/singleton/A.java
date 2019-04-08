package com.karat.cn.designpatterns.singleton;
/**
 * 静态内部类单列
 * @author 开发
 *
 */
public class A {

	private static class B{
		private static B b=new B();
	}
	
	public static B getInstance(){
		return B.b;
	}
}
/**
 *单列有相同的 hashCode
 */
