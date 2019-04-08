package com.karat.cn.design.proxy.jdk;
/**
 * jdk动态代理
 * @author 开发
 *
 */
public class TestJdkProxy {

	public static void main(String args[]) {
		JdkProxyExample example=new JdkProxyExample();
		Hello hello=(Hello)example.bind(new HelloImpl());
		hello.say();
		hello.pay();
		Word word=(Word)example.bind(new WordImpl());
		word.eat();
	}
}
