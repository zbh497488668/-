package com.test;

public class Synchronize {
   static volatile int x=0;
    public static class thread1 extends Thread{
	
	@Override
	public  void run() {
	    for (int i = 0; i < 10; i++) {
		 x=1;
	    }
	   
	    // TODO Auto-generated method stub
	 //  System.out.print("x:"+x);
	}
    }
    public static class thread2 extends Thread{
	
   	@Override
   	public  void run() {
   	    // TODO Auto-generated method stub
   	// synchronized (this) {
   	  for (int i = 0; i < 10; i++) {
		 x=2;
	    }  
   	// }
   	   
   	
   	 //  System.out.print("x:"+x);
   	}
       }
    //在不使用synchronized 程序锁的情况 为了看到效果 只能把 循环次数改大了，加了锁就可以不用改了
    public static void main(String[] args) throws InterruptedException {
	
	new thread1().start();
	new thread2().start();
	new thread2().join();new thread1().join();//在不使用锁的情况下。想要按顺序执行就 等待2个线程都执行完（既join）方法，再输出
	 System.out.print("x:"+x);
    }
}
