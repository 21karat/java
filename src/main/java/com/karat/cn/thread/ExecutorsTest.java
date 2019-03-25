package com.karat.cn.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 参数
 * int corePoolSize,核心池大小
 * int maximumPoolSize,线程池最大线程数
 * long keepAliveTime,表示线程没有任务执行时最多保持多久时间会终止。
 * TimeUnit unit,参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
 * BlockingQueue<Runnable> workQueue一个阻塞队列，用来存储等待执行的任务，
 * 这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：
 * ArrayBlockingQueue;LinkedBlockingQueue;SynchronousQueue;
 * ArrayBlockingQueue和PriorityBlockingQueue使用较少，
 * 一般使用LinkedBlockingQueue和Synchronous。
 * 线程池的排队策略与BlockingQueue有关。
 */
public class ExecutorsTest {
	public static boolean flag = true; // 秒杀物品的标记

	public static void main(String[] args) {
		//创建一个线程
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 0L,
				TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
		
		ThreadTest t1 = new ThreadTest("张三");
		ThreadTest t2 = new ThreadTest("李四");
		ThreadTest t3 = new ThreadTest("王五");
		
		try {
			pool.execute(t1);
		} catch (Exception e) {
			System.out.println(t1.getUserName() + "没有抢到");
		}

		try {
			pool.execute(t3);
		} catch (Exception e) {
			System.out.println(t3.getUserName() + "没有抢到");
		}

		try {
			pool.execute(t2);
		} catch (Exception e) {
			System.out.println(t2.getUserName() + "没有抢到");
		}
		pool.shutdown();
	}

}
