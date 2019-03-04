package com.karat.cn.io;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String args[]) throws IOException{
		
		File file=new File("aa.txt");//文件默认就创建在你创建的项目下面，刷新即可看到
		System.out.println(file.exists());//判断文件是否存在
		file.createNewFile();//创建文件，不是文件夹
		System.out.println(file.exists());//再次判断是否存在
		System.out.println(file.getName());//获取文件的名字
		System.out.println(file.getAbsolutePath());//获取文件的绝对路径
		System.out.println(file.getPath());//获取文件的相对路径
		System.out.println(file.getParent());//获取文件的父路径
		System.out.println(file.canRead());//文件是否可读
		System.out.println(file.canWrite());//文件是否可写
		System.out.println(file.length());//文件的长度
		System.out.println(file.lastModified());//文件最后一次修改时间
		System.out.println(file.isDirectory());//判断文件是否是一个目录
		System.out.println(file.isHidden());//文件是否隐藏
		System.out.println(file.isFile());//判断文件是否存在
	}
}
