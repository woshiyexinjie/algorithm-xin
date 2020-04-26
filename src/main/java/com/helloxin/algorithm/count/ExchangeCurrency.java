package com.helloxin.algorithm.count;

import java.sql.SQLOutput;

/**
 * Created by yebanxian on 2020/4/26.
 */
public class ExchangeCurrency {

    public static int exchangeCurrencyMethods() {
        //求兑换 1000 日元纸币时会出现多少种组合?注意，不计硬币兑出的先后顺序
        //如果兑换出了大量的零钱会比较不便，所以只允许机器最多兑换出 15 枚硬币
        int count = 0;
        //500
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16;l++){
                        if(i*500+j*100+k*50+l*10 == 1000 && (i+j+k+l < 16)){
                            System.out.println(i+" "+j+" "+k+" "+l);
                            count ++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(exchangeCurrencyMethods());
    }
}
