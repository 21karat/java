package com.karat.cn.thread.demo;
/**
 * volatile使isRunning变成多线程之间可见变量
 * @author 开发
 *
 */
public class RunThread extends Thread{
	
	//volatile
	private boolean isRunning=true;
	
	private void setRunning(boolean isRunning){
		this.isRunning=isRunning;
	}
	
	public void run(){
		System.out.println("begin=====");
		while(isRunning==true){
			//死循环
		}
		System.out.println("shop=====");
	}
	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException{
		RunThread runThread=new RunThread();
		//启动了runThread第二个线程(从上到下运行的main线程到此产生分支),
		//产生第二线程后copy了主内存中isRunning=true，然后在自己的工作空间跑
		//而变量的变化属于main线程中的变量变化，不加volatile修饰变量，2线程之间变量不可见，导致runThread得不到false
		runThread.start();
		Thread.sleep(3000);
		runThread.setRunning(false);
		System.out.println("已关闭");
		Thread.sleep(1000);
		System.out.println(runThread.isRunning);
	}
}
