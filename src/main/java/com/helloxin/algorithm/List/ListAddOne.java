package com.helloxin.algorithm.List;


/**
 * Created by yebanxian on 2020/7/2.
 */
public class ListAddOne {
    public static Integer addOne(Node head) {
        if (head.getNext() == null) {
            Integer val = head.getData() + 1;
            head.setData(val);
            if (head.getData() == 10) {
                head.setData(0);
                return 1;
            }
        } else {
            Integer mval = addOne(head.next) + head.getData();
            head.setData(mval);
            if (head.getData() == 10) {
                head.setData(0);
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setData(9);
        Node node2 = new Node();
        node2.setData(9);
        node1.setNext(node2);
        Node node3 = new Node();
        node3.setData(9);
        node2.setNext(node3);

        addOne(node1);
        if (node1.getData() == 0) {
            node1.setData(0);
            Node node = new Node();
            node.setData(1);
            node.setNext(node1);
        }
    }
}
