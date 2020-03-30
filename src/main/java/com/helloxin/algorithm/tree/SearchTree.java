package com.helloxin.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yexin on 2019/10/22.
 */
public class SearchTree {


    public static void main(String[] args) {
        //只是不是两个节点
        //和描述的中的表一致，每个数组表示一个case，0和1表示是否覆盖这个维度
        int sample[][] ={{0,1,1},{0,1,0},{1,1,1}};
        //构建一颗树 除了根节点 每个深度表示可以覆盖的该维度的病例
        Inode root = new Inode(-1);
        Queue<Inode> queue = new ArrayDeque<>();
        queue.add(root);
        //遍历每一个维度 有哪些病例满足
        for (int i = 0;i<sample[0].length;i++){
            Inode poll = queue.poll();
            for(int j = 0;j< sample.length;j++){
                if(sample[j][i] == 1){
                    Inode node = new Inode(j);

                }
            }
        }
    }
}
