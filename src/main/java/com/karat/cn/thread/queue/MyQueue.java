package com.karat.cn.thread.queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现LinkedBlockingQueue下面的put和take
 * 利用wait/notify实现阻塞队列(模拟Queue)
 * @author 开发
 *
 */
public class MyQueue {

	//1.集合，用来承装元素
	private final LinkedList<Object> list=new LinkedList<>();
	//2.计数器(用来统计加入元素的数量)
	private AtomicInteger count=new AtomicInteger(0);
	//3.指定上下限
	private final int minSize=0;
	private final int maxSize;
	
	//4.构造器初始化指定上线大小
	public MyQueue(int len) {
		this.maxSize=len;
	}
	
	//初始化对象用于加锁
	private final Object lock=new Object();
	
	//存
	public void put(Object object){
		synchronized (lock) {
			//表示当前容器已满
			while(this.maxSize==count.get()){
				try {
					lock.wait();//等
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//1.队列添加元素
			list.add(object);
			System.out.println("新加入的元素为："+object);
			//2.计数器递增
			count.incrementAndGet();
			//3.唤醒休眠线程(当容器为空时有其它线程问容器要数据)
			lock.notify();
		}
	}
	//取
	public Object take(){
		Object object=null;
		synchronized (lock) {
			//当前容器是空的
			while(count.get()==this.minSize){
				try {
					lock.wait();//阻塞休眠
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//1.不为空移除第一个元素
			object=list.removeFirst();
			//2.计数器递减
			count.decrementAndGet();
			//3.唤醒线程(当容器满了，有其它向内部添加元素的线程在等待)
			lock.notify();
		}
		return object;
	}
	//返回容器的大小
	public int getSize(){
		return this.count.get();
	}
	//测试(当休眠5秒后移除2个元素后才能加入新元素)
	public static void main(String args[]) throws InterruptedException{
		MyQueue mq=new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");

		System.out.println("当前容器的长度："+mq.getSize());
		
		//线程1
		Thread t1=new Thread(new Runnable() {						
			@Override
			public void run() {
				mq.take();
				mq.take();	
			}
		},"t1");
						
		t1.start();
		
		Thread.sleep(5000);
		//线程2
		Thread t2=new Thread(new Runnable() {						
			@Override
			public void run() {
				mq.put("f");
				mq.put("g");	
			}
		},"t1");
								
		t2.start();
		System.out.println("当前容器的长度："+mq.getSize());
	}
}
