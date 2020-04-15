package com.all.test.Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 8:53
 * @Description : 面试题1
 * 写一个验证掷骰子概率的程序，同时投掷2 颗6面骰子 n次，计算其和得到
 * 各数字的概率
 */
public class A {
	public static void main(String[] args) {
		fun(100);
	}

	public static void fun(int n) {
		Random random = new Random();
		//用一个map去存放运行记录
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num1 = random.nextInt(6)+1;
			int num2 = random.nextInt(6)+1;
			int sum = num1 + num2;
			map.put(sum,map.get(sum) == null ? 1 : map.get(sum)+1);
		}

		//遍历计算概率
		Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
		for (Map.Entry<Integer,Integer> entry:entries) {
			Integer key = entry.getKey();
			double sum = entry.getValue();
			double probability = sum / n;
			System.out.println("和为："+key+" 出现的概率为："+probability);
		}
	}
}

