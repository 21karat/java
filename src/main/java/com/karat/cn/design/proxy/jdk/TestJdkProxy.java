package com.karat.cn.design.proxy.jdk;

public class TestJdkProxy {

	public static void main(String args[]) {
		JdkProxyExample example=new JdkProxyExample();
		Hello hello=(Hello)example.bind(new HelloImpl());
		hello.say();
	}
}
