package com.helloxin.algorithm.tree;

/**
 * Created by nandiexin on 2019/1/23.
 */
class Node{

    String data;
    private Node lchild;
    private Node rchild;
    Node(String data){
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



public class BinaryTree {

    private static Node root;
    private static String[] treeNodes;
    static int index;

    public BinaryTree(String tree) {
        root = new Node("");
        treeNodes = tree.split(",");
        index = 0;
        createTree(root);
    }

    /**
     * 先序创建 然后就是直溜溜的都是
     */
    public static Node createTree(Node node) {

        if(index >= treeNodes.length){
            return null;
        }
        String data = treeNodes[index];
        System.out.println("index " + index + " data " + data);
        index++;

        node.setData(data);
        node.setLchild(createTree(new Node("")));
        node.setRchild(createTree(new Node("")));
        root = node;
        return node;

    }

    public Node getRoot() {
        return root;
    }

    //将树的信息输出 中序遍历
    public static void printMidTreeNode(Node root){
        if(null != root){
            printMidTreeNode(root.getLchild());
            System.out.print(root.getData()+" ");
            printMidTreeNode(root.getRchild());
        }

    }

    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node right = invertTree(root.getRchild());
        Node left = invertTree(root.getLchild());
        root.setRchild(left);
        root.setLchild(right);
        return root;
    }



    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree("A,B,C,D");
        Node node = tree.getRoot();
        System.out.println(node.getData());
        printMidTreeNode(node);
        invertTree(node);
        System.out.println();
        printMidTreeNode(node);

    }

}