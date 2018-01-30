package com.jason.firework.algorithmlibrary.basedemo;

import android.util.LruCache;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/29$ 14:09$
 * <p/>
 */
public class LruCacheDemo {
    private LruCache<String,String> lruCache = null;

    LruCacheDemo(){
        lruCache = new LruCache<>(100);
    }

    public void testLruCache(){
        lruCache.put("one",new String("one"));
        lruCache.put("two",new String("two"));
        lruCache.put("three",new String("three"));
        lruCache.put("four",new String("four"));

        System.out.println(lruCache.get("one"));
        System.out.println(lruCache.get("four"));
    }

}
