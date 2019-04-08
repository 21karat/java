package com.karat.cn.thread.message;

import java.util.ArrayList;
import java.util.List;
/**
 * 原版线程通讯
 * @author 开发
 *
 */
public class ListAdd1 {

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
		ListAdd1 listAdd1=new ListAdd1();
		//线程1
		Thread t1=new Thread(new Runnable() {
							
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i=0;i<10;i++){
						listAdd1.add();
						System.out.println("当前线程："+Thread.currentThread().getName()+"开始");	
						Thread.sleep(500);
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
				while(true){
					if(listAdd1.size()==5){
						System.out.println("当前线程收到通知："+Thread.currentThread().getName()+"listAdd1.size()==5停止");
						throw new RuntimeException();
					}
				}
			}
		},"t2");
				
		t1.start();
		t2.start();
	}
}
