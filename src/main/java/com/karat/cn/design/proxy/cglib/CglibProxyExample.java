package com.karat.cn.design.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{
	//需要代理的原始类
	private Object target;
	/** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */
	public Object getInstance(Object target) {  
        this.target = target; 
        //创建加强器  
        Enhancer enhancer = new Enhancer(); 
        //设置需要加强的类 
        enhancer.setSuperclass(this.target.getClass());  
        //设置回调
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
    }  
	
	// 回调方法  
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("事物开始");
		//这里实现加强 
		Object invoke=arg3.invokeSuper(arg0, arg2);  
        System.out.println("事物结束");  
        return invoke;  
	}

}
