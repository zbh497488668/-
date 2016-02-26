package com.test;

/**
 * @author Administrator
 *
 */
public class TwoThread {
    
    
    public static class thread1 extends Thread{
	@Override
	public void run() {
	  System.out.println("1");
	  System.out.println("2");
	}
    }
    public static class thread2 extends Thread{
  	@Override
  	public void run() {
  	  System.out.println("A");
  	  System.out.println("B");
  	}
      }
    public static void main(String[] args) {
	new thread1().start();
	new thread2().start();
    }

}
