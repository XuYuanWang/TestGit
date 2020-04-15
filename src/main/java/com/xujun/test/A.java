package com.xujun.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/30/ 21:37
 * @Description :
 */
public class A {
	private static List<Integer> sorted = new LinkedList<>();
	public static void addElement(int n){
		int j=0;
		for (Integer integer : sorted) {
			if (integer>n) {
				break;
			}
			j++;
		}
		sorted.add(j,n);
	}

	public static void main(String[] args) {
		addElement(1);
		addElement(4);
		addElement(2);
		addElement(7);
		addElement(3);
		System.out.println(sorted);
	}
}
