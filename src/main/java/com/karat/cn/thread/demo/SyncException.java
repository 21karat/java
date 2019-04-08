package com.karat.cn.thread.demo;

/**
 * synchronzied修饰的方法，抛出异常，
 * 处理：
 * 1.记录异常日志，继续执行后续任务(当前抛出异常的任务与其它执行任务不相干)
 * 2.抛出运行时异常，不执行后续任务
 * @author 开发
 *
 */
public class SyncException {

	public int i=0;
	
	public synchronized void add(){
		while(true){
			try {
				i++;
				Thread.sleep(200);
				System.out.println(i);
				if(i==10){
					Integer.parseInt("a");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("log info i="+i);
				//continue;
				break;
			}
		}
	}
	
	public static void main(String args[]){
		SyncException s=new SyncException();
		//线程1
		Thread t1=new Thread(new Runnable() {					
			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.add();
			}
		});		
		t1.start();
	}
	
}

