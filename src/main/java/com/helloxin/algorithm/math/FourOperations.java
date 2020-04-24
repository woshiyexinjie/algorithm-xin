package com.helloxin.algorithm.math;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by yebanxian on 2020/4/24.
 */
public class FourOperations {

    /**
     * 求位于 1000~9999，满足上述条件的数
     * 351 → 3×51 = 153
     * 621 → 6×21 = 126
     * 886 → 8×86 = 688
     *
     * @return
     */
    public static int getResult() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        int count =0;
        String op[] = {"+", "-", "*", "/", ""};
        for (int i = 1000; i < 10000; i++) {
            String c = String.valueOf(i);
            for (int j = 0; j < op.length; j++) {
                for (int k = 0; k < op.length; k++) {
                    for (int l = 0; l < op.length; l++) {
                        String val = c.charAt(3) + op[j] + c.charAt(2) + op[k] + c.charAt(1) + op[l] + c.charAt(0);
                        if (val.length() > 4) { /* 一定要插入1个运算符 */
                            Object object = se.eval(val);
                            Integer result = -1;
                            if(object instanceof Double){
                                result = ((Double) object).intValue();
                            }else{
                                result = (Integer) object;
                            }
                            if (i == result.intValue() ) {
                                System.out.println(val + " = " + result);
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println(getResult());
    }

}
