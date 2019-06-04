package com.helloxin.algorithm.sort;

public class BubbleSort {

    public static void bubbleSort(int []arr) {
        for(int i =0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];

                    arr[j]=arr[j+1];

                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int score[] = {10,9,8,7,6,5,4,3,2,1,0};
        System.out.print("初始值：");
        for(int a = 0; a < score.length; a++){
            System.out.print(score[a]+" ");
        }
        System.out.println("");
        int compareNum = 0;
        int insideLoopNum =0;
        for (int i = 0; i < score.length -1; i++) {

            boolean flag = true;
            //其实只想通过这个测试 if 还是执行 else
            if (score.length >= 1) {
                for (int j = 0; j < score.length - i - 1; j++) {
                    insideLoopNum++;
                    if (score[j] > score[j + 1]) {
                        int temp  = score[j];
                        score[j] = score[j + 1];
                        score[j + 1] = temp;
                        flag = false;
                        compareNum++;
                    }
                    if(score.length - i - 3 - j >= 0 ) {
                        if (score[score.length - i - 3 - j] > score[score.length - i - 2 - j]) {
                            int temp2 = score[score.length - i - 3 - j];
                            score[score.length - i - 3 - j] = score[score.length - i - 2 - j];
                            score[score.length - i - 2 - j] = temp2;
                            compareNum++;
                        }
                    }
                }
                if (flag == true) {
                    break;
                }
                System.out.print("第" + (i + 1) + "次排序结果：");
                for (int a = 0; a < score.length; a++) {
                    System.out.print(score[a] + " ");
                }
                System.out.println("");
            } else {
                for (int j = 0; j < score.length - i - 1; j++) {
                    insideLoopNum++;
                    if (score[j] > score[j + 1]) {
                        int temp = score[j];
                        score[j] = score[j + 1];
                        score[j + 1] = temp;
                        flag = false;
                        compareNum++;
                    }
                }
                if (flag == true) {
                    break;
                }
                System.out.print("第" + (i + 1) + "次排序结果：");
                for (int a = 0; a < score.length; a++) {
                    System.out.print(score[a] + " ");
                }
                System.out.println("");
            }
        }
        System.out.print("最终排序的结果：");
        for(int a = 0; a < score.length; a++){
            System.out.print(score[a]+" ");
        }
        System.out.println("");
        System.out.println("比较次数替换次数："+compareNum);
        System.out.println("内循环次数："+insideLoopNum);

    }
}
