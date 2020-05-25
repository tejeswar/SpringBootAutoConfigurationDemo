package com.thread;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
//https://howtodoinjava.com/java/multi-threading/java-thread-pool-executor-example/
public class CustomThreadPoolDemo {

	 //Thread pool size
    private final int poolSize;
     
    //Internally pool is an array
    private final WorkerThread[] workers;
     
    // FIFO ordering
    private final LinkedBlockingQueue<Runnable> queue;
    
    public static void main(String[] args) 
    {
        CustomThreadPoolDemo customThreadPool = new CustomThreadPoolDemo(3);
         
        for (int i = 1; i <= 9; i++) 
        {
            Task task = new Task("Task-" + i);
            System.out.println("Created : " + task.getName());
 
            customThreadPool.execute(task);
        }
    }
    
    static class Task implements Runnable {
        private String name;
     
        public Task(String name) {
            this.name = name;
        }
     
        public String getName() {
            return name;
        }
     
        public void run() {
            System.out.println(Thread.currentThread().getName()+ " executing : " + name);
        }
    }
    
    
    
 
    public CustomThreadPoolDemo(int poolSize) 
    {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[poolSize];
 
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }
 
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            //queue.notify();
            queue.notifyAll();
        }
    }
    private class WorkerThread extends Thread {
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                }
 
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
 
    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < poolSize; i++) {
            workers[i] = null;
        }
    }
}
