package com.karat.cn.thread.demo;
/**
 * synchronized锁对象
 * @author Administrator
 *
 */
public class MyThread extends Thread{

	private int count=5;
	
	@SuppressWarnings("static-access")
	public synchronized void run() {
		count--;
		System.out.println(this.currentThread().getName()+":"+count);
	}
	
	public static void main(String args[]) {
		
		MyThread thread=new MyThread();
		Thread t1=new Thread(thread,"t1");
		Thread t2=new Thread(thread,"t2");
		Thread t3=new Thread(thread,"t3");
		Thread t4=new Thread(thread,"t4");
		Thread t5=new Thread(thread,"t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		//按照线程启动，结果应该为：54321，但是run方法不加synchronized达不到预期结果
	}
}
