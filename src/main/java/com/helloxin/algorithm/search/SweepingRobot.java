package com.helloxin.algorithm.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 扫地机器人不重复走法
 */
public class SweepingRobot {
    //机器人只会前后左右移动，假定初始位置为{0，0} 移动只能从objects中的一种
    private static int[][] objects = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int count = 0;
    private static final int N = 12;

    public static void main(String[] args) {
        List<int[]> steps = new ArrayList<>(N);
        //设置初始位置
        steps.add(new int[]{0, 0});
        count = moveNext(1, steps);
        System.out.println(count);
    }

    /**
     * 移动
     *
     * @param nextStep
     * @param steps
     * @return
     */
    private static int moveNext(int nextStep, List<int[]> steps) {
        //走完 N 步，返回 1，增加一次走法
        if (steps.size() == N + 1) {
            return 1;
        }
        int cnt = 0;
        int i;
        for (int j = 0; j < objects.length; j++) {
            i = nextStep;
            //深度优先 走完一次 清空 nextStep 的后几位
            for (int k = steps.size(); k > nextStep; k--) {
                steps.remove(k - 1);
            }
            //下一步移动的坐标
            int[] next = {steps.get(i - 1)[0] + objects[j][0], steps.get(i - 1)[1] + objects[j][1]};
            //如果未移动到以前坐标 则继续走下去
            if (!contains(steps, next)) {
                steps.add(next);
                cnt += moveNext(++i, steps);
            }
        }
        return cnt;
    }

    /**
     * 判断是否包含
     *
     * @param steps
     * @param next
     * @return
     */
    private static boolean contains(List<int[]> steps, int[] next) {
        boolean result = false;
        if (steps == null) {
            return result;
        }
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i)[0] == next[0] && steps.get(i)[1] == next[1]) {
                return true;
            }
        }
        return result;
    }
}


class Node {
    private int v;// 值
    private int x;// 横坐标

    public Node(int v, int x) {
        this.v = v;
        this.x = x;
    }

    public Node(int v) {
        this.v = v;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}

class SortByX implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Node) o1).getX() - ((Node) o2).getX();
    }
}

