package com.karat.cn.design.proxy.cglib;
/**
 * cglib动态代理
 * @author 开发
 *
 */
public class TestCglib {
	
	public static void main(String args[]){  
		CglibProxyExample s=new CglibProxyExample();  	
		HelloService s1=(HelloService)s.getInstance(new HelloService());  
        s1.say(); 
    }    
}
