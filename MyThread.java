package com.test;

import java.util.Timer;
import java.util.TimerTask;

public class MyThread extends Thread{
    
    //数值范围
    public  static final int MAX_PRIMES=1000000;
    //sleep 秒数
   public  static final int TEN_SECONDS=10000;
    
    public volatile boolean finished=false; 
  
  @Override
    public void run() {
    //  super.run();
   //开始计算素数
	int[] premes=new int[MAX_PRIMES];
	
	int count=0;
	for (int i = 2; count < MAX_PRIMES; i++) {
	    	if(finished){
	    	    
	       break;
	    	}
	    	//判断素数
	    	boolean preme=true;
	    	for (int y= 0; y < count; y++) {
		    if(i%(premes[y])==0){
			preme=false;
			break;
		    }
		}
	    
		if(preme){
		    premes[count++]=i;
		   System.out.println("素数"+i);
		
		} 
	}
    }
  
public static void main(String[] args) {
    Timer timer=new Timer();
    final MyThread tthread=new MyThread();
	tthread.start();
	/*try {
	    Thread.sleep(TEN_SECONDS);
	} catch (InterruptedException e) {
	  
	}
	finally{
	    tthread.finished=true;
	}*/
	//定时  还是没有办法成功，原因待查..放在算完一个素数40行之后。。就可以用
	timer.schedule(new TimerTask() {
	    
	    @Override
	    public void run() {
		  tthread.finished=true;
		
	    }
	}, TEN_SECONDS);
	
	
}
}
