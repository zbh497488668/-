package com.test;

public class TenThread {
    
    private static class ThreadSample extends Thread{
	
	int max=Integer.MIN_VALUE;
	int[] array;
	public  ThreadSample (int[] a) {
	    this.array=a;
	}
	public int getMax() {
	    return this.max;
	}
	@Override
	public void run() {
	   for (int i = 0; i < array.length; i++) {
	    max=Math.max(max, array[i]);
	}
	}
	
    }
    public static void main(String[] args) {
	ThreadSample[] nSample=new ThreadSample[10];
	int[][] nArrary=new int[10][10];
	nArrary[0]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[1]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[2]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[3]=new int[]{1,2,3,4,5,6,7,8,9,110};
	
	nArrary[4]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[5]=new int[]{1,2,3,4,5,6,557,8,9,10};
	nArrary[6]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[7]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[8]=new int[]{1,2,3,4,5,6,7,8,9,10};
	nArrary[9]=new int[]{1,2,3,4,5,6,7,8,9,11};
	int max=Integer.MIN_VALUE;
	for (int i = 0; i < 10; i++) {
	    //创建10个进程
	    nSample[i]=new ThreadSample(nArrary[i]);  
	    nSample[i].start();
	}
	try {
	    for (int i = 0; i < 10; i++) {
		 nSample[i].join();
		 max=Math.max(max, nSample[i].getMax());
	    }
	} catch (InterruptedException e) {
	    // TODO: handle exception
	}
	System.out.print("最大值："+max);
    }

}
