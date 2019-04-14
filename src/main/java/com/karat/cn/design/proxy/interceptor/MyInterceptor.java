package com.karat.cn.design.proxy.interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before(Object arg0, Object arg1, Method arg2, Object[] arg3) {
		// TODO Auto-generated method stub
		System.out.println("反射方法前的逻辑");
		return false;//返回false不调用真实对象方法
	}

	@Override
	public void around(Object arg0, Object arg1, Method arg2, Object[] arg3) {
		// TODO Auto-generated method stub
		System.out.println("取代了被代理对象调用的方法");
	}

	@Override
	public void after(Object arg0, Object arg1, Method arg2, Object[] arg3) {
		// TODO Auto-generated method stub
		System.out.println("反射方法后的逻辑");
	}

}
