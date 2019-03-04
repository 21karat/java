package com.karat.cn.io;

import java.io.File;

public class FileTest {

	public static void main(String args[]){
		File file1=new File("E:/");//指定问价目录
		String[] str1=file1.list();//获取指定目录下的所有文件或者问价夹得名称数组
		for(String s:str1){
			System.out.println(s);
		}
		System.out.println("=========文件夹的File数组===========");
		File[] fs1=file1.listFiles();//获取指定目录下的所有文件或者文件夹的File数组
		for(File f:fs1){
			System.out.println(f);
		}
		System.out.println("==========.jpg==========");
		File file2=new File("C:\\Users\\devel\\Pictures\\Saved Pictures");
		String[] str2=file2.list();
		for(String s: str2){
			if(s.endsWith(".jpg") || s.endsWith(".png")){//如果后缀是这种格式的就输出
				System.out.println(s);
			}
		}
		System.out.println("==========获取子一级目录==========");
		File file3=new File("E:\\JavaEE");
		File[] fs2=file3.listFiles();
		for(File f:fs2){
			if(f.isDirectory()){//判断如果是一个目录
				String[] str3=f.list();
				for(String str:str3){
					System.out.println(str);
				}
			}
		}
	}
	
	
}
