package com.karat.cn.design.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author Administrator
 *
 */
public class InterceptorJDKProxy implements InvocationHandler{

	private Object target;//真实对象
	private String interfaceptorClass=null;//拦截器全限定名
	
	
	public InterceptorJDKProxy(Object target, String interfaceptorClass) {
		this.target = target;
		this.interfaceptorClass = interfaceptorClass;
	}
	/**
	 * 绑定委托对象并返回一个(代理占位)
	 * @param object	真实对象
	 * @param interfaceptorClass	
	 * @return	代理对象占位
	 */
	public static Object bind(Object object,String interfaceptorClass) {
		//取代代理对象
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(),
				new InterceptorJDKProxy(object, interfaceptorClass));
	}
	/**
	 * @param proxy	代理对象
	 * @param method 方法,被调用的方法
	 * @param args	方法参数
	 * @return	
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if(interfaceptorClass==null) {
			//没有设置拦截器则直接反射原有方法
			return method.invoke(target, args);
		}
		Object result=null;
		//通过反射生成拦截器
		Interceptor interceptor=(Interceptor)Class.forName(interfaceptorClass).newInstance();
		//调用前置方法
		if(interceptor.before(proxy, target, method, args)) {
			//反射原有对象方法
			result=method.invoke(target, args);
		}else {
			//返回false执行around方法
			interceptor.around(proxy, target, method, args);
		}
		//调用后置方法
		interceptor.after(proxy, target, method, args);
		return result;
	}

}
