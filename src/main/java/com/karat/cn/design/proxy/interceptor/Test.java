package com.karat.cn.design.proxy.interceptor;

import com.karat.cn.design.proxy.jdk.Hello;
import com.karat.cn.design.proxy.jdk.HelloImpl;

public class Test {

	public static void main(String args[]) {
		Hello proxy=(Hello)InterceptorJDKProxy.bind(new HelloImpl(),
				"com.karat.cn.design.proxy.interceptor.MyInterceptor");
		proxy.say();
		proxy.pay();
	}
}
