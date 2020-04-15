package com.all.test.Demo;

import java.io.File;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 9:41
 * @Description : 面试题3
 */
public class C {
	//这边在外面定义一个记录文件数的变量
	private static int sum = 0;

	public static void main(String[] args) {
		File file = new File("D:\\logs");
		fun(file);
		System.out.println(sum);
	}

	public static void fun(File file) {
		File[] files = file.listFiles();
		for (File file1:files) {
			if (file1.isDirectory()) {
				fun(file1);
			} else {
				System.out.println(file1.getName());
				sum++;
			}
		}
		System.out.println("sum = " + sum);
	}
}
