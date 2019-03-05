package com.karat.cn.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read {

	public static void main(String args[]) throws IOException{
		//文档
		File file=new File("C:\\Users\\devel\\Desktop\\记事本.txt");
		//定义输出
		StringBuilder builder=new StringBuilder();
		//定义字符输入流
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		
		String s=null;
		
		while((s=bufferedReader.readLine())!=null){
			builder.append(System.lineSeparator()+s);
		}
		//关闭流
		bufferedReader.close();
		
		System.out.println(builder.toString());
	}
}
