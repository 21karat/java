package com.karat.cn.thread.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/**
 * 改版三
 * 使用CountDownLatch替代synchronized锁以达到实时性
 * @author 开发
 *
 */
public class ListAdd3 {
	@SuppressWarnings("rawtypes")
	private volatile static List list=new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public void add(){
		list.add("123");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String args[]){
		ListAdd3 listAdd3=new ListAdd3();
		//括号的数字表示通知几次？2的话表示达到2次再通知
		final CountDownLatch countDownLatch=new CountDownLatch(1);
		
		//线程1
		Thread t1=new Thread(new Runnable() {
							
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i=0;i<10;i++){
						listAdd3.add();
						System.out.println("当前线程："+Thread.currentThread().getName());	
						Thread.sleep(500);
						if(listAdd3.size()==5){
							System.out.println("已发出通知："+Thread.currentThread().getName()+"listAdd1.size()==5开始");
							
							countDownLatch.countDown();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1");
		//线程2
		Thread t2=new Thread(new Runnable() {						
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(listAdd3.size()!=5){
					try {
						countDownLatch.await();//等待阻塞
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("当前线程"+Thread.currentThread().getName()+"listAdd1.size()==5停止");
					throw new RuntimeException();
				}
			}
		},"t2");
				
		t2.start();
		t1.start();
	}
}
