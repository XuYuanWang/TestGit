package com.all.test.Demo;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 9:56
 * @Description : 面试题6
 * ）请编写一个函数，能将字符串main-action-holder，转换为mainActionHolder
 */
public class D {
	public static void main(String[] args) {
		String str = "main-action-holder";
		System.out.println(fun(str));
	}

	public static String fun(String str) {
		if (str == null || str.equals(""))
			throw new IllegalArgumentException("illegal param");
		String[] split = str.split("-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if (i == 0) {
				sb.append(split[i]);
			} else {
				//截取字符串
				sb.append(split[i].substring(0,1).toUpperCase()+split[i].substring(1));
			}
		}
		return sb.toString();
	}
}
