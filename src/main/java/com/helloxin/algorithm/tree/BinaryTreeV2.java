package com.helloxin.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by nandiexin on 2019/1/23.
 */
public class BinaryTreeV2 {

    public  Node root;



    public Node getRoot() {
        return root;
    }

    public boolean addNode(Node node){
        if(null == node){
           return false;
        }
        if(root == null){
            root = node;
            return true;
        }
        Node inNode = findInNeed(root);
        if(inNode.getLchild() == null){
            inNode.setLchild(node);
            return true;
        }
        if(inNode.getRchild() == null){
            inNode.setRchild(node);
            return true;
        }
        return false;
    }

    private Node findInNeed(Node rt) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(rt);
        while(queue.size()!= 0){
            Node no = queue.poll();
            if(no.getRchild() == null || no.getLchild() == null){
                return no;
            }else{
                queue.add(no.getLchild() );
                queue.add(no.getRchild() );
            }
        }
        return null;

    }


    public static void main(String[] args) {


        BinaryTreeV2 treeV2 = new BinaryTreeV2();
        treeV2.addNode(new Node("HH"));
        treeV2.addNode(new Node("A"));
        treeV2.addNode(new Node("B"));
        treeV2.addNode(new Node("C"));
        treeV2.addNode(new Node("D"));
        ErgodicTree.printMidTreeNode(treeV2.getRoot());
    }

}