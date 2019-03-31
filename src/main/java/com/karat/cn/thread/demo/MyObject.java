package com.karat.cn.thread.demo;
/**
 * 同步与异步
 * @author Administrator
 *
 */
public class MyObject {

	public synchronized void method1() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName());
	}
	//t1线程先持有对象锁，t2线程可以以异步方式调用对象中的非synchronized修饰的方法(异步:对象中另一个方法不加synchronized)
	//t1线程先持有对象锁，t2线程要想调用该对象的另一个synchronized修饰的方法，做不到，需要等ti执行完毕释放对象锁(同步)
	public static void main(String args[]) {
		
		MyObject myObject=new MyObject();
		
		//线程1
		Thread t1=new Thread(new Runnable() {
					
			@Override
			public void run() {
				// TODO Auto-generated method stub
				myObject.method1();
			}
		},"t1");
		//线程2
		Thread t2=new Thread(new Runnable() {
					
			@Override
			public void run() {
				// TODO Auto-generated method stub
				myObject.method2();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
		
	}
}
