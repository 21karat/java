package com.karat.cn.design.proxy.staticpro;

/**
 * 代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
 * @author 开发
 *
 */
public class StaticProxyExample implements Hello{

	private Hello hello=new HelloImpl();//生成被代理对象的引用,代理拿引用去操作被代理对象
	
	
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		hello.say();
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		hello.pay();
	}
	

}
