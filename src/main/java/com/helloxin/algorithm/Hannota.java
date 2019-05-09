package com.helloxin.algorithm;

import java.util.Stack;

class Hannota {
    public enum Action{
        No,LToM,MToL,MToR,RToM
    }

    //num是盘子的数量，left，mid，right分别代表左中右三个柱子
    public static int hanoi(int num,String left,String mid,String right){
        //lS,mS,rS代表左中右三个栈（模拟柱子）
        Stack<Integer> lS = new Stack<Integer>();
        Stack<Integer> mS = new Stack<Integer>();
        Stack<Integer> rS = new Stack<Integer>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for(int i=num;i>0;i--){
            lS.push(i);
        }
        Action[] record = { Action.No };
        int step = 0;
        while(rS.size() != num+1){
            step += fStackToStack(record,Action.MToL,Action.LToM,lS,mS,left,mid);
            step += fStackToStack(record,Action.LToM,Action.MToL,mS,lS,mid,left);
            step += fStackToStack(record,Action.MToR,Action.RToM,rS,mS,right,mid);
            step += fStackToStack(record,Action.RToM,Action.MToR,mS,rS,mid,right);
        }
        return step;
    }

    public static int fStackToStack(Action[] record,Action preNoAct,Action nowAct,Stack<Integer> fStack,Stack<Integer> tStack,String from,String to){
        if(record[0] != preNoAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " " + from + "->" + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int i = hanoi(64,"left","mid","right");
        System.out.println("一共走了" + i + "步");
    }
}
