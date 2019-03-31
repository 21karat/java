package com.karat.cn.thread.demo;
/**
 * 多线程对象锁
 * @author Administrator
 *
 */
public class MultiThread {

	private static int num=0;
	
	//static
	public synchronized void printNum(String tag) {
		try {
			if(tag.equals("a")) {
				num=100;
				System.out.println("a");
				Thread.sleep(1000);
			}else {
				num=200;
				System.out.println("b");
			}
			System.out.println(tag+":"+num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		MultiThread multiThread1=new MultiThread();		
		MultiThread multiThread2=new MultiThread();
		//线程1
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				multiThread1.printNum("a");
			}
		});
		//线程2
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				multiThread2.printNum("b");
			}
		});
		t1.start();
		t2.start();
		
		//预期结果应该是：a,a:100,b,b:200;但是即使方法加上synchronzied修饰，结果也达不到预期	
		
		//2个线程分别得到的是multiThread1与multiThread2的对象锁，达不到同步的效果
		
		//要想达到效果可以将方法改成静态的,此时属于类(MultiThread)一级别的锁
	}
}
