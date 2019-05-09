package com.helloxin.algorithm.loadbalance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2019/1/8.
 */
public class AbstractLoadBalance {

    final static Map<String,Integer> map = new HashMap<>();

    static{
         map.put("192.168.1.1",1);
         map.put("192.168.1.2",2);
         map.put("192.168.1.3",4);
         map.put("192.168.1.4",1);
         map.put("192.168.1.5",2);
         map.put("192.168.1.6",1);
    }
}
