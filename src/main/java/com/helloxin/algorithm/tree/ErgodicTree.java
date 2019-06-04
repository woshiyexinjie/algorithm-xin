package com.helloxin.algorithm.tree;

/**
 * Created by nandiexin on 2019/6/3.
 */
public class ErgodicTree {

    //将树的信息输出 中序遍历
    public static void printMidTreeNode(Node root) {
        if (null != root) {
            printMidTreeNode(root.getLchild());
            System.out.print(root.getData() + " ");
            printMidTreeNode(root.getRchild());
        }

    }

    //前序遍历
    public static void printPreTreeNode(Node root) {
        if (null != root) {
            System.out.print(root.getData() + " ");
            printMidTreeNode(root.getLchild());
            printMidTreeNode(root.getRchild());
        }

    }
}
