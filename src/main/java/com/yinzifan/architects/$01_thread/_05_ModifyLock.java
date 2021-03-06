package com.yinzifan.architects.$01_thread;

public class _05_ModifyLock {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public synchronized void changeAttributte(String name, int age) {
		try {
			System.out.println("当前线程: " + Thread.currentThread().getName() + "开始");
			this.setName(name);
			this.setAge(age);
			System.out.println("当前线程: " + Thread.currentThread().getName() + "修改内容为: " + this.name + "," + this.age);
			Thread.sleep(2000);
			System.out.println("当前线程: " + Thread.currentThread().getName() + "结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final _05_ModifyLock modifyLock = new _05_ModifyLock();
		Thread t1 = new Thread(() -> modifyLock.changeAttributte("张三", 23), "t1");
		Thread t2 = new Thread(() -> modifyLock.changeAttributte("李四", 24), "t2");

		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();

	}

}
