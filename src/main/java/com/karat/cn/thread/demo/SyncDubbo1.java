package com.karat.cn.thread.demo;
/**
 * synchronized锁重入
 * @author Administrator
 *
 */
public class SyncDubbo1 {

	public synchronized void method1() {
		System.out.println("1");
		method2();
	}
	public synchronized void method2() {
		System.out.println("2");
		method3();
	}
	public synchronized void method3() {
		System.out.println("3");
	}
	
	public static void main(String args[]) {
		SyncDubbo1 dubbo=new SyncDubbo1();
		//线程1
		Thread t1=new Thread(new Runnable() {
							
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dubbo.method1();
			}
		});		
		t1.start();
	}
}
