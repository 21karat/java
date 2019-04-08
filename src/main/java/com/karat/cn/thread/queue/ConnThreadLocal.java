package com.karat.cn.thread.queue;
/**
 * 不同线程有不同ConnThreadLocal对象
 * @author 开发
 *
 */
public class ConnThreadLocal {

	public static ThreadLocal<String> th=new ThreadLocal<>();
	
	public void setTh(String value){
		th.set(value);
	}
	@SuppressWarnings("static-access")
	public void getTh(){
		System.out.println(Thread.currentThread().getName()+":"+this.th.get());
	}
	
	public static void main(String args[]){
		final ConnThreadLocal ct=new ConnThreadLocal();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ct.setTh("123");
				ct.getTh();
			}
		},"t1");
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					ct.getTh();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		},"t2");
		t1.start();
		t2.start();
		
	}
}
