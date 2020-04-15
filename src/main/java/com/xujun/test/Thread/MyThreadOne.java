package com.xujun.test.Thread;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 16:53
 * @Description :
 */
public class MyThreadOne extends Thread {
	@Override
	public void run() {
		Thread.currentThread().setName("Thread继承类线程");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}

class Test{
	public static void main(String[] args) {
		MyThreadOne thread = new MyThreadOne();
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}