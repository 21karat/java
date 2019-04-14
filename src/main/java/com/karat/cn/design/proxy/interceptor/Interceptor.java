package com.karat.cn.design.proxy.interceptor;

import java.lang.reflect.Method;


/**
 * 定义拦截器接口
 * @author Administrator
 *
 */
public interface Interceptor {
	/**
	 * 
	 * @param arg0	代理对象
	 * @param arg1	真实对象
	 * @param arg2	method方法
	 * @param arg3	参数
	 * @return
	 */
	//返回boolean 在真实对象前调用。返回true反射真实对象的方法，返回false调用around方法
	public boolean before(Object arg0,Object arg1,
			Method arg2,Object[] arg3);
	//在before返回false时被调用的方法
	public void around(Object arg0,Object arg1,
			Method arg2,Object[] arg3);
	//最后执行的方法
	public void after(Object arg0,Object arg1,
			Method arg2,Object[] arg3);
}
