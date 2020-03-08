package com.example.demo.configuration;

public class SharedUtil {
	
	private Integer tableFor;
	public Integer getTableFor() {
		return tableFor;
	}

	public synchronized void setTableFor(Integer tableFor) {
		this.tableFor = tableFor;
	}
	
//	private ThreadLocal<Integer> tableFor = new ThreadLocal<Integer>();
//    
//	
//	
//	public Integer getTableFor() {
//		return tableFor.get();
//	}
//	public void setTableFor(Integer tableFor) {
//		this.tableFor.set(tableFor) ;
//	}



	public synchronized void printMultiplicationTable() {
		for(int i = 1; i < 11 ; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+tableFor+" X "+i+ " = "+(tableFor*i));
			//System.out.println(Thread.currentThread().getName()+" : "+tableFor.get()+" X "+i+ " = "+(tableFor.get()*i));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
