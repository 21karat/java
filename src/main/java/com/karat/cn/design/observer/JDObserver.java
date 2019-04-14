package com.karat.cn.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author Administrator
 *
 */
public class JDObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String  newProduct=(String)arg;
		System.out.println("发送新产品"+newProduct+"到京东");
	}	
}
