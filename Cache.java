package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 简答的线程安全的 高速缓存
 * @author Administrator
 *
 */
public class Cache {
    
    private final Map cache=new HashMap();
    //在load
    public Object load(String name){
	//自己实现如何读取
	return "";
    }
    
    //清除
    public void clear(String name){
	synchronized (cache) {
	    cache.clear();
	}
	
    }
    //get
    public Object getCache(String name){
	
	synchronized (cache) {
	    Object o=cache.get(name);
	    if(null==o){//大概缓存丢失的话。。从load方法里读取出来，再放入缓存
		o=load(name);
		cache.put(name, o);
	    }
	    return o;
	}
	
    }
    

}
