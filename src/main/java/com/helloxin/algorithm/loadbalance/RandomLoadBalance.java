package com.helloxin.algorithm.loadbalance;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * Created by nandiexin on 2019/1/8.
 */
public class RandomLoadBalance {


    public static String doSelect(){

        Set<String> keySet = AbstractLoadBalance.map.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        String server = null;

        Random random = new Random();
        int pos = random.nextInt(keyList.size());
        return keyList.get(pos);

    }

    public static void main(String[] args) {


        for (int i= 0;i<50;i++){
            System.out.println(doSelect());
        }

    }

}
