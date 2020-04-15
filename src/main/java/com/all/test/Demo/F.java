package com.all.test.Demo;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 10:08
 * @Description : 面试题7
 * 简单实现在线购买电影票，请重点考虑多人同时购买一个座位的情况，可以
 * 使用伪代码
 */
public class F {

	private static int total_count = 100;//总票数
	private static int remain_count = 100;//剩余票数
	private static int sold_count = 0;//已售票数
	volatile int s = 6;
	public synchronized static void buyMovieTickets(int count) {
		if (count < 0 || count > remain_count)
			throw new IllegalArgumentException("illegal param remain count is" + remain_count);
		remain_count = remain_count - count;
		sold_count = sold_count + count;
		String str = "电影票总量：" + total_count + " 已卖出：" + sold_count + " 剩余：" + remain_count;
		System.out.println(str);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				buyMovieTickets(20);
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				buyMovieTickets(30);
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				buyMovieTickets(80);
			}
		};

		t1.start();
		t2.start();
		t3.start();
	}
}
