package com.thread.semaphore;
//Multiple threads,multiple resources and multiple semaphores
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//https://howtodoinjava.com/java/multi-threading/control-concurrent-access-to-multiple-copies-of-a-resource-using-semaphore/
public class SemaphoreExample {

	public static void main(String[] args) 
    {
        PrinterQueue printerQueue = new PrinterQueue();
        int noOfWorkerThreads = 10;
        Thread thread[] = new Thread[noOfWorkerThreads];
        for (int i = 0; i < noOfWorkerThreads; i++) 
        {
            thread[i] = new Thread(new PrintingJob(printerQueue), "Thread-" + i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < noOfWorkerThreads; i++) 
        {
            thread[i].start();
        }
        //System.out.println("Total time taken:"+(System.currentTimeMillis()-start));
    }
	
	static class PrintingJob implements Runnable {
	    private PrinterQueue printerQueue;
	 
	    public PrintingJob(PrinterQueue printerQueue) {
	        this.printerQueue = printerQueue;
	    }
	 
	    @Override
	    public void run() {
	        System.out.printf("%s: Going to print a document\n", Thread
	                .currentThread().getName());
	        printerQueue.printJob(new Object());
	    }
	}
	
	static class PrinterQueue 
	{
	    //This Semaphore will keep track of no. of printers used at any point of time.
	    private final Semaphore semaphore;
	     
	    //While checking/acquiring a free printer out of three available printers, we will use this lock.
	    private final Lock printerLock;
	     
	    //This array represents the pool of free printers.
	    private boolean freePrinters[];
	 
	    public PrinterQueue() 
	    {
	        //semaphore = new Semaphore(1);
	        //semaphore = new Semaphore(2);
	       semaphore = new Semaphore(3);
	        //freePrinters = new boolean[4];
	        freePrinters = new boolean[3];
	        Arrays.fill(freePrinters, true);
	        printerLock = new ReentrantLock();
	    }
	 
	    public void printJob(Object document) 
	    {
	    	int assignedPrinter = -5;
	    	 assignedPrinter = getPrinter();
	    	 if(assignedPrinter != -1) {
	    		 return;
	    	 }
	        try
	        {
	        	
	        	
	            //Decrease the semaphore counter to mark a printer busy
	            semaphore.acquire();
	             
	            //Get the free printer
	            // assignedPrinter = getPrinter();
	             
	            //Print the job
	            //Long duration = (long) (Math.random() * 10000);
	            Long duration = (long)9000;
	            System.out.println(Thread.currentThread().getName()
	                    + ": Printer-" + assignedPrinter
	                    + " : Printing a Job during " + (duration / 1000)
	                    + " seconds :: Time - " + new Date());
	            Thread.sleep(duration);
	             
	            //Printing is done; Free the printer to be used by other threads.
	            
	            releasePrinter(assignedPrinter);
	        	 
	        } 
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        } 
	        finally {
	            System.out.printf("%s: The document has been printed by Printer-" + assignedPrinter+"\n", Thread
	                    .currentThread().getName());
	             
	            //Increase the semaphore counter back
	            semaphore.release();
	        }
	       // }
	    }
	 
	    //Acquire a free printer for printing a job
	    private int getPrinter() 
	    {
	       // int foundPrinter = 0;
	        int foundPrinter = -1;
	        try {
	            //Get a lock here so that only one thread can go beyond this at a time
	            printerLock.lock();
	             
	            //Check which printer is free
	            for (int i = 0; i < freePrinters.length; i++) 
	            {
	                //If free printer found then mark it busy
	                if (freePrinters[i]) 
	                {
	                    foundPrinter = i;
	                    freePrinters[i] = false;
	                    break;
	                }
	            }
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        } finally
	        {
	            //Allow other threads to check for free priniter
	            printerLock.unlock();
	        }
	        return foundPrinter;
	    }
	     
	    //Release the printer
	    private void releasePrinter(int i) {
	        printerLock.lock();
	        //Mark the printer free
	        freePrinters[i] = true;
	        printerLock.unlock();
	    }
	}
}
