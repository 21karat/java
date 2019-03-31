package com.karat.cn.thread.demo;
/**
 * 脏读
 * @author Administrator
 *
 */
public class DirtyRead {

	private String username="999";
	private String password="123";
	
	public synchronized void setValue(String username,String password) {
		this.username=username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password=password;
		System.out.println(this.username+":"+this.password);
	}
	//synchronized
	public  void getValue() {
		System.out.println(this.username+":"+this.password);
	}
	
	public static void main(String args[]) throws InterruptedException {
		
		DirtyRead dirtyRead=new DirtyRead();		
		//线程1
		Thread t1=new Thread(new Runnable() {
					
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dirtyRead.setValue("a","b");
			}
		});		
		t1.start();
		Thread.sleep(1000);
		dirtyRead.getValue();
	}
	
}
