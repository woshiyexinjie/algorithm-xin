package com.helloxin.algorithm.search;

/**
 * Created by yebanxian on 2020/4/24.
 */
public class CutWood {

    /**
     * 这里用的递归 思维是深度搜索算法
     * @param m 人数
     * @param n 需要木头根数
     * @param current  几根木头
     * @return
     */
    public static int getQuicklyCutNum(int m, int n, int current) {
        if (current > n) {
            return 0;
        } else if (current < m) {
            return 1 + getQuicklyCutNum(m, n, current * 2);
        } else {
            return 1 + getQuicklyCutNum(m, n, current + m);
        }
    }

    /**
     * 这里是逆向思维 从1出发拼到符合的 n
     * @param m
     * @param n
     * @param current
     * @return
     */
    public static int cutbar(int m, int n, int current) {
        int count =0;
        while (n>current){
            current+=current < m?current:m;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getQuicklyCutNum(3,20,1));
        System.out.println(getQuicklyCutNum(5,100,1));

        System.out.println(cutbar(3,20,1));
        System.out.println(cutbar(5,100,1));

    }
}
