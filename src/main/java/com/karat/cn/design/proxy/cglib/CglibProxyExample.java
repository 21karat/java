package com.karat.cn.design.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{

	
	/**
	 * 生成CGLIB代理对象
	 * @param cls	Class类
	 * @return		Class类的CGLIB代理对象
	 */
	@SuppressWarnings("rawtypes")
	public Object getInstance(Class cls) {  
        //CGLIB  enhancer增强类对象  
        Enhancer enhancer = new Enhancer(); 
        //设置增强类型
        enhancer.setSuperclass(cls);  
        //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        enhancer.setCallback(this);  
        //生成并返回代理对象  
        return enhancer.create();  
    }  
	
	
	@Override
	public Object intercept(Object arg0, Method arg1, 
			Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("事务开始");
		//CGLIB反射调用真实对象的方法
		Object invoke=arg3.invokeSuper(arg0, arg2);  
        System.out.println("事务结束");  
        return invoke;  
	}

}
