package com.helloxin.algorithm.binary;

/**
 * Created by yebanxian on 2020/4/23.
 */
public class PalindromeDecimalSystem {

    /**
     * 求用十进制、二进制、八进制表示都是回文数的所有数字中，大于十进制数 10 的最小值
     * @return
     */
    public static int getlargeThanTen() {
        for (int i = 11; i < Integer.MAX_VALUE; i += 2) {
             if(String.valueOf(i).equals(new StringBuffer(i+"").reverse().toString())
             && Integer.toOctalString(i).equals(new StringBuffer(Integer.toOctalString(i)).reverse().toString())
             && Integer.toBinaryString(i).equals(new StringBuffer(Integer.toBinaryString(i)).reverse().toString())){
                 return i;
             }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getlargeThanTen());
    }
}
