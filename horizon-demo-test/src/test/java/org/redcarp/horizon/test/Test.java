package org.redcarp.horizon.test;

/**
 * @author redcarp
 * @date 2024/7/24
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(200000);
				System.out.println("hello,i'm thread");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		thread.start();
		thread.join(10000);
		System.out.println("hello world");
	}
}
