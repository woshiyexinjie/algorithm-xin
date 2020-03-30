package com.helloxin.algorithm.tree;

/**
 * Created by yexin on 2019/10/22.
 */
public class Inode {

    Integer data;
    private Node lchild;
    private Node rchild;
    Inode(Integer data){
        this.data = data;
    }
    public Integer getData() {
        return data;
    }
    public void setData(Integer data) {
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
