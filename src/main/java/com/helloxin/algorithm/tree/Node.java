package com.helloxin.algorithm.tree;

/**
 * Created by nandiexin on 2019/6/3.
 */
public class Node{

    String data;
    private Node lchild;
    private Node rchild;
    public Node(String data){
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Node getLchild() {
        return lchild;
    }
    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }
    public Node getRchild() {
        return rchild;
    }
    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }
}
