package com.helloxin.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {


    public static void sort2(int[] a, int low, int high){
        int start = low;
        int end = high;
        int key = a[low];


        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key) {
                end--;
            }
            if(a[end]<key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key) {
                start++;
            }
            if(a[start]>key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        //递归
        if(start>low) {
            sort2(a, low, start - 1);
        }
        if(end<high) {
            sort2(a, end + 1, high);
        }
    }

    public static void sort(int[] a, int low, int high) {

        int i,j,t,temp;
        if(low>high) {
            return;
        }
        temp=a[low]; //基准
        i=low;
        j=high;
        while(i!=j) {

            while(a[j]>=temp && i<j)//顺序很重要
            {
                j--;
            }
            while(a[i]<=temp && i<j) {
                i++;
            }
            if(i<j)
            {
                t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }//再把基准数进行交换  
        a[low]=a[i];
        a[i]=temp;
        sort(a,low,i-1);//递归
        sort(a,i+1,high);

    }

    public static void main(String[] args) {

        int[] array = {12,21,15,16,15,1,36,40,3,9,66,9,34,25,77,7,2,56,-15,56,-3,69};
        System.out.print("待排序：");
        for (int aa:array ) {
            System.out.print(aa + " ");
        }
        System.out.println("");
        int start = 0;
        int end = array.length-1;
        sort(array,start,end);
//        sort2(array,start,end);
        System.out.print("排序完：");
        for (int a:array) {
            System.out.print(a + " ");
        }
    }


}
