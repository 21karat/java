package com.karat.cn.designpatterns.singleton;
/**
 * 懒汉式单例类
 * @author 开发
 *
 */
public class LazySingleton {

	private static LazySingleton singleton;
	
	/**
	 * 私有默认构造函数
	 */
	private LazySingleton(){}
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static synchronized LazySingleton getInstance(){
		if(singleton==null){
			singleton=new LazySingleton();
		}
		return singleton;
	}
}
/**
 *上面的懒汉式单例类实现了对静态工厂方法同步化，以处理多线程环境
 *
 *
 *懒汉式是时间换空间(线程安全)
 */
