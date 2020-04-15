package com.all.test.Demo;

import java.util.*;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 9:38
 * @Description : 面试题2
 * 编写程序解决以下问题：长度为N 的数组，随机放入值为1-50 中间的任意
 * 整数，请编写程序找出其中的偶数数字，并按照该数字在数组中出现次数从多到少排序
 * 输出。
 */
public class B {
	public static void main(String[] args) {
		int[] ints = generateArray(100);
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < ints.length; i++) {
			int num = ints[i];
			map.put(num, map.get(num) == null? 1 : map.get(num) + 1);
		}

		//按照value升序输出
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>(){
			//重写compare方法
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		System.out.println(list);

	}
	//生成数组
	public static int[] generateArray(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("illegal param");
		int[] array = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt(50)+1;
		}
		return array;
	}
}
