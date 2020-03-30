package com.helloxin.algorithm.search;

public class BinarySearch {

    //二分查找是比较快速的方法 只是建立在数据是有序的情况下
    //在实际业务中，如果数据量比较大的话，增量数据需要先预处理，但是对于数量瞬间来的，预处理压力会很大

    //还要数据结构支持二分查找的效率 如链表，但又不能随机访问 这样就没有二分查找的效果了，需要换成其他的数据结构

    private static Integer binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};

        System.out.println(binarySearch(myList, 3)); // 1
        System.out.println(binarySearch(myList, -1)); // null
    }

}
