package com.karat.cn.thread;
//下单
public class ThreadTest extends Thread{
	private String userName;

	public ThreadTest(String userName) {
		super();
		this.userName = userName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
			if (ExecutorsTest.flag) {
				System.out.println(this.userName + "秒杀成功");
				ExecutorsTest.flag = false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
