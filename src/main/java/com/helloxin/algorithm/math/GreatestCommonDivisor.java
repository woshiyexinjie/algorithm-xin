package com.helloxin.algorithm.math;

/**
 * Created by nandiexin on 2019/6/19.
 * 想计算最大公约数
 */
public class GreatestCommonDivisor {

    //简单一点 遍历一一遍小的那个
    //这里用了一个for循环 所以计算的时间复杂度为O(n)
    public static int dealGCD(int one, int two) {

        int min = Math.min(one, two);
        int max = Math.max(one, two);
        for (int i = min; i > 1; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        //如果上面的计算找不到公约数 那么返回 1
        return 1;
    }

    //辗转相除法 这个时间的复杂度还是O(n),但是相对于遍历小的那个 还是优化啦
    public static int dealGCDV2(int one, int two) {

        int temp = 0;
        while (two != 0) {
            temp = one % two;
            one = two;
            two = temp;
        }
        return one;
    }

    //更相减损法 如果理解了上面的除法 那么减法也是类似的
    public static int dealGCDV3(int one, int two) {

        while (one != two) {
            if (one > two) {
                one -= two;
            } else {
                two -= one;
            }
        }
        return one;
    }


    public static void main(String[] args) {

        System.out.println(dealGCDV2(377, 319));


    }
}
