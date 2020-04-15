package com.all.test.Demo;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 10:07
 * @Description : 面试题5
 * 找出这样的数字：一个数字等于它的各分解项相加。示例数字 28可分解为
 * 1、2、4、7、14，1+2+4+7+14=28。同样，数字 6分解为:1、2、3，1+2+3=6。
 * 用代码找出1-500 以内的所有符合这样条件的数字。
 */
public class E {
	public static void main(String[] args) {
		for (int i = 1; i < 500; i++) {
			int sum = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0)
					sum += j;
			}
			if (i == sum)
				System.out.println(i);
		}
	}
}
