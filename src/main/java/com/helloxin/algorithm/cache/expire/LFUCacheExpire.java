package com.helloxin.algorithm.cache.expire;


import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.logging.Logger;

/**
 * Created by nandiexin on 2019/5/8.
 */
public class LFUCacheExpire<T> {

    Logger logger = Logger.getLogger("LFUCacheExpire");

    final static Integer MAX_CACHE_NUM = 500000;
    //最不经常使用淘汰算法
    //LFU（Least Frequently Used）算法根据数据的历史访问频率来淘汰数据，其核心思想是“如果数据过去被访问多次，那么将来被访问的频率也更高

    //使用优先队列来处理缓存的顺序 主要是方便实现淘汰
    final static PriorityQueue<MyCache> priorityQueue = new PriorityQueue();

    final static Object object = new Object();

    public  boolean addCache(T needCache){
        //同步方法块
        synchronized (object) {

            if(priorityQueue.size() >= MAX_CACHE_NUM){
                throw new RuntimeException("已经达到缓存上线");
            }
            //缓存对象
            MyCache myCache = new MyCache(needCache);
            if (containsCache(needCache)) {
                return false;
            }
            return priorityQueue.add(myCache);
        }
    }


    private boolean containsCache(T needCache) {
        Iterator<MyCache> iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            MyCache myCache = iterator.next();
            //这里T如果没有实现equels方法 那么可能就比较地址啦
            if(myCache.getCacheObj().equals(needCache)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查询缓存 如果数据比较多 可能会比较慢 这种方式
     * @param yourCache
     * @return
     */
    public MyCache getCache(T yourCache){

        synchronized (object) {
            Iterator<MyCache> iterator = priorityQueue.iterator();
            while (iterator.hasNext()) {
                MyCache myCache = iterator.next();
                if (myCache.getCacheObj().equals(yourCache)) {
                    myCache.setUseCount(myCache.getUseCount() + 1);
                    iterator.remove();
                    //因为priorityQueue 只会进行一次排序 所以这个就暂时先删除原来的再加入吧
                    myCache.setUpdateTime(LocalDateTime.now());
                    priorityQueue.add(myCache);
                    return myCache;
                }
            }
        }
        return null;
    }

    /**
     * 返回缓存的数量
     * @return
     */
    public Integer getCacheSize(){

       return priorityQueue.size();
    }

    /**
     * 按照传入的数量 淘汰缓存
     * @param num x
     * @return
     */
    public Integer lfuEliminationCacheByNum(Integer num){

         if(null == num){
             num =10;
         }
         int cacheSize = priorityQueue.size();
         Integer eliminationNum = num;
         if(cacheSize <= num){
             priorityQueue.clear();
             return (eliminationNum = cacheSize);
         }
         return lfuEliminationCache(eliminationNum);
    }

    /**
     * 按照百分比 比如10 就是百分之10 默认值
     * @param percentage
     * @return
     */
    public Integer lfuEliminationCacheByPercentage(Integer percentage){

        if(null == percentage){
            percentage =10;
        }
        int cacheSize = priorityQueue.size();
        Integer eliminationNum = cacheSize*percentage/100;
        return lfuEliminationCache(eliminationNum);
    }

    private Integer lfuEliminationCache(Integer eliminationNum) {

        for(int i= 0;i<eliminationNum;i++){
            MyCache myCache = priorityQueue.poll();
            logger.info("remove cache="+myCache.getCacheObj()+",useCount="+myCache.getUseCount());
        }
        return eliminationNum;
    }


    /**
     * 使用队列的 poll 函数将数据库里面的数据输出并且清空
     */
    public void ergodicCache(){
        while (!priorityQueue.isEmpty()){
            MyCache myCache = priorityQueue.poll();
            logger.info("ergodicCache cache="+myCache.getCacheObj()+",useCount="+myCache.getUseCount());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int initCount = 500;
        LFUCacheExpire<String> lfuCacheExpire = new LFUCacheExpire<>();
        lfuCacheExpire.addCache("COOL");;
        lfuCacheExpire.addCache("Hello");
        lfuCacheExpire.addCache("xin");
        lfuCacheExpire.addCache("world");
        lfuCacheExpire.addCache("world");
        lfuCacheExpire.getCache("COOL");
        System.out.println(lfuCacheExpire.addCache("world"));
        System.out.println(lfuCacheExpire.lfuEliminationCacheByNum(3));

//        System.out.println(lfuCacheExpire.getCacheSize());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1300L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lfuCacheExpire.addCache("Hello");
//                lfuCacheExpire.addCache("world");
//            }
//        });
//        lfuCacheExpire.getCache("world3");
//        System.out.println(lfuCacheExpire.getCache("world3").getUseCount());



//        Thread.sleep(10000L) ;


    }

}
