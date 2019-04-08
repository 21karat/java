package com.karat.cn.design.singleton;
/**
 * 作为对象的创建模式,单例模式确保某一个类只有一个实例,而且自行实例化并向整个系统提供这个实例。这个类称为单例类
 * 
 * 单例模式的特点:
 * 单例类只能有一个实例。
 * 单例类必须自己创建自己的唯一实例。
 * 单例类必须给所有其他对象提供这一实例。
 * @author 开发
 *
 *
 * 饿汉式单例类
 */
public class EagerSingleton {

	private static EagerSingleton singleton=new EagerSingleton();
	
	
	/**
	 * 私有默认构造函数
	 */
	private EagerSingleton(){
		
	}
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static EagerSingleton getInstance(){
		return singleton;
	}
	
}
/**
 * 步骤：
 * 类被加载时，静态变量初始化，调用默认构造器，那么单例类的唯一实例就被创建出来了
 * 饿汉式是典型的空间换时间
 */