package com.karat.cn.thread.message;

import java.util.ArrayList;
import java.util.List;
/**
 * wait和notify改造版线程通讯
 * 不好的地方是notify不释放锁，所以造成不实时
 * @author 开发
 *
 */
public class ListAdd2 {
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
		ListAdd2 listAdd2=new ListAdd2();
		//1.实列化一个对象lock(将对象当成一把锁)
		//当使用wait和notify的时候，一定要配合synchronized关键字去使用
		final Object lock=new Object();
		
		//线程1
		Thread t1=new Thread(new Runnable() {
							
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					synchronized(lock){
						for(int i=0;i<10;i++){
							listAdd2.add();
							System.out.println("当前线程："+Thread.currentThread().getName());	
							Thread.sleep(500);
							if(listAdd2.size()==5){
								System.out.println("已发出通知："+Thread.currentThread().getName()+"listAdd1.size()==5开始");
								lock.notify();//唤醒睡眠线程，但是不释放锁，等该线程执行完再执行被唤醒的线程
							}
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
				synchronized(lock){
					if(listAdd2.size()!=5){
						try {
							lock.wait();//等待阻塞
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("当前线程"+Thread.currentThread().getName()+"listAdd1.size()==5停止");
						throw new RuntimeException();
					}
				}
			}
		},"t2");
				
		t2.start();
		t1.start();
	}
}
