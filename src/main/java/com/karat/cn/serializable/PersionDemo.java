package com.karat.cn.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 实现对象序列化
 * @author 开发
 *
 */
public class PersionDemo {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
		Persion p=new Persion("1",20,"男");
		
		//序列化
		ObjectOutputStream outObj = new ObjectOutputStream(  
                new FileOutputStream(new File("E:/aaa.txt")));  
		outObj.writeObject(p);
        System.out.println("对象序列化完成");
        //反序列化
        ObjectInputStream o=new ObjectInputStream(new FileInputStream(new File("E:/aaa.txt")));
        Persion persion=(Persion)o.readObject();
        System.out.println(persion);
        System.out.println("反序列化完成");
        
	}
}
