package com.karat.cn.thread.demo;
/**
 * 存在继承关系时,synchronzied修饰的父类子类方法，可以实现线程安全
 * @author 开发
 *
 */
public class SyncDubbo2 {
	
	static class A{
		public int i=10;
		
		public synchronized void add(){
			try {
				i--;
				System.out.println("A:"+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class B extends A{
		
		public synchronized void add(){
			try {
				while(i>0){
					i--;
					System.out.println("B:"+i);
					Thread.sleep(1000);
					super.add();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]){
		//线程1
		Thread t1=new Thread(new Runnable() {					
			@Override
			public void run() {
				// TODO Auto-generated method stub
				B b=new B();
				b.add();
			}
		});		
		t1.start();
	}
}
