package com.karat.cn.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler{
	//真实对象
	private Object target=null;
	
	/**
	 * 建立代理对象与真实对象之间的代理关系
	 * @param target 真实对象
	 * @return 代理对象
	 */
	public Object bind(Object target) {
		this.target=target;
		//生成代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	/**
	 * 代理方法逻辑
	 * arg0：代理对象(bind返回的对象)
	 * arg1：当前调度方法
	 * arg2：调度方法的参数
	 */
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("进入代理");
		System.out.println("在调度真实对象之前操作");
		Object object=arg1.invoke(target, arg2);
		System.out.println("在调度真实对象之后操作");
		return object;
	}

}
