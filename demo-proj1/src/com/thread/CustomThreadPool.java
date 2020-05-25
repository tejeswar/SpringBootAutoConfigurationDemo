package com.thread;

import java.util.LinkedList;

public class CustomThreadPool {
	
	private WorkerThread[] threads;
	private LinkedList<Runnable> taskQueue;

	public CustomThreadPool(int threadNumber) {
		taskQueue = new LinkedList<Runnable>();
		threads = new WorkerThread[threadNumber];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}
	}
	
	public void enqueue(Runnable r) {
		synchronized (taskQueue) {
			taskQueue.addLast(r);
			taskQueue.notify();
		}
	}
	 class WorkerThread extends Thread {
		public void run() {
			Runnable r;
			while (true) {
				synchronized (taskQueue) {
					while (taskQueue.isEmpty()) {
						try {
							taskQueue.wait();
						} catch (InterruptedException e) {
							// ignore
						}
					}
					r = (Runnable) taskQueue.removeFirst();					
				}
				try {
					r.run();
				} catch (Exception e) {
					// ignore
				}
			}
		}
	}
	 public static void main(String[] args) {
		 CustomThreadPool stp = new CustomThreadPool(2);
			stp.enqueue(new TestTask1());
			stp.enqueue(new TestTask2());
		}

		private static class TestTask1 implements Runnable {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("A");
				}
			}
		}

		private static class TestTask2 implements Runnable {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("B");
				}
			}
		}
}


