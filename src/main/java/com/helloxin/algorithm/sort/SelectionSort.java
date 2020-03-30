package com.helloxin.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    //选择排序  效率n方
    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
             for(int j= i;j<arr.length;j++){
                 if(arr[j] > arr[i]){
                     int temp = arr[j];
                     arr[j] =arr[i];
                     arr[i] = temp;
                 }
             }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
