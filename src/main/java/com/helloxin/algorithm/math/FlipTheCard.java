package com.helloxin.algorithm.math;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by yebanxian on 2020/4/24.
 */
public class FlipTheCard {

    public static void printUnFlipCard() {
        //注意什么条件 边界是什么
        byte cards[] = new byte[100];
        int j = 1;
        int step = 2;
        while (j < cards.length) {
            int c = j;
            while (c < cards.length) {
                cards[c] = (byte) (cards[c] == 1 ? 0 : 1);
                c += step;
            }
            j = step;
            step++;
        }
        for (int i = 0; i < 100; i++) {
            if (cards[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        printUnFlipCard();
    }
}
