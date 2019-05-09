package com.helloxin.algorithm.loadbalance;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by nandiexin on 2019/1/8.
 */
public class RoundRobinLoadBalance extends AbstractLoadBalance{

    private static Integer pos = 0;


    public static String doSelect(){

        Set<String> keySet = AbstractLoadBalance.map.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        String server = null;

        synchronized (pos) {
            if (pos >= keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }

        return server;

    }

    public static void main(String[] args) {


        for (int i= 0;i<50;i++){
            System.out.println(doSelect());
        }

    }


}
