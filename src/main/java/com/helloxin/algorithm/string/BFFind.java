package com.helloxin.algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nandiexin on 2019/4/30.
 * BF朴素查询算法
 */
public class BFFind {

    /**
     * 使用BF算法查询字符串是否包含另一个字符串
     *
     * @param searchStr 被查询的字符串
     * @param subStr    查询是否被包含的字符串
     * @return int 如果包含则返回在 searchStr 字符串中的索引位置，查不到则返回 -1
     */
    public static int find(String searchStr, String subStr) {
        int i = 0;
        int j = 0;
        int Tlen = searchStr.length();
        int Plen = subStr.length();  //子串长度

        while(i<Tlen && j<Plen)
        {
            if(searchStr.charAt(i) == subStr.charAt(j)) {
                i++;
                j++;
            }
            else   //如果当前字符不同，则i和j回退，重新进行匹配
            {

                i = i-j+1;
                j = 0;
            }
        }

        if(j >= Plen) {
            return i - Plen;
        } else {
            return -1;
        }
    }

    public static int find2(String searchStr, String subStr) {

        int tag = -1;
        int j = 0;
        //当然这里假设了searchStr的长度不小于subStr
        for (int i = 0; i < searchStr.length()-subStr.length(); ) {
            if (j == subStr.length()) {
                return tag;
            }
            if (searchStr.charAt(i) == subStr.charAt(j)) {
                j++;
                i++;
            } else {
                tag++;
                i = tag;
                j = 0;
            }
        }
        return tag;
    }

    public static void main(String[] args) {

//        System.out.println(find("ababcabcacbab", "abcac"));

        String searchStr = "ababcabcacbab";
        String subStr = "abcac";
        System.out.println(searchStr.contains(subStr));
        System.out.println(searchStr.indexOf(subStr));

        Pattern p = Pattern.compile(".*"+subStr+".*");
        Matcher m = p.matcher(searchStr);
        boolean isValid = m.matches();
        System.out.println(isValid);

    }


}
