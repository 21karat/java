package com.karat.cn.thread.demo;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 使用volatile不具备原子性，只是具备多线程之间可见性
 * 
 * AtomicInteger具备原子性
 * @author 开发
 *
 */
public class Volatile extends Thread{

	//private static volatile int num;	
	private static AtomicInteger num=new AtomicInteger(0);
	
	private static void add(){
		for(int i=0;i<1000;i++){
			//num++;
			num.incrementAndGet();//类似num++
		}
		System.out.println(num);
	}
	
	public void run(){
		add();
	}
	
	public static void main(String args[]){
		Volatile[] s=new Volatile[10];
		for(int i=0;i<10;i++){
			s[i]=new Volatile();
		}
		for(int i=0;i<10;i++){
			s[i].start();
		}
	}
}
