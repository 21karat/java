package com.karat.cn.design.observer;

public class Test {

	public static void main(String args[]) {
		ProductList list=ProductList.getInstance();
		TBObserver tbObserver=new TBObserver();
		JDObserver jdObserver=new JDObserver();
		list.addObserver(jdObserver);
		list.addObserver(tbObserver);
		list.addProudct("上架新产品");
	}
}
