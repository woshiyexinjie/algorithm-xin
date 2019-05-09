package com.helloxin.algorithm.cache.expire;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Created by nandiexin on 2019/5/8.
 * 用作一个缓存对象
 */
public class MyCache<T> implements Comparable<MyCache<T>> {

    T cacheObj;

    int useCount;

    LocalDateTime createTime;

    LocalDateTime updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyCache<?> myCache = (MyCache<?>) o;
        return  Objects.equals(cacheObj, myCache.cacheObj) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(cacheObj);
    }

    @Override
    public int compareTo(MyCache<T> o) {

        if(this.getUseCount() > o.getUseCount()){
            return 1;
        }
        if(this.getUseCount() < o.getUseCount()){
            return -1;
        }
        return 0;
    }

    public MyCache() {
    }

    public MyCache(T cacheObj) {

        this.cacheObj = cacheObj;
        this.useCount = 1;   //第一次添加的时候 默认为1，代表使用了一次
        this.createTime = LocalDateTime.now();   //创建时间和最近更新时间设置为当前时间
        this.updateTime = createTime;
    }

    public T getCacheObj() {
        return cacheObj;
    }

    public void setCacheObj(T cacheObj) {
        this.cacheObj = cacheObj;
    }

    public int getUseCount() {
        return useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }



}
