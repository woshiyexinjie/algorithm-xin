package com.helloxin.algorithm.string;

public class UTFTest {
    public static void main(String[] args) {
//        String str = "编";
//        StringBuffer sb = new StringBuffer();
//        char [] source_char = str.toCharArray();
//        String unicode = null;
//        for (int i=0;i<source_char.length;i++) {
//            unicode = Integer.toHexString(source_char[i]);
//            if (unicode.length() <= 2) {
//                unicode = "00" + unicode;
//            }
//            sb.append("\\u" + unicode);
//        }
//        System.out.println(sb);
//
//        String testCode = "ab\uD83D\uDE03cd";
//        int cpCount = testCode.codePointCount(0, testCode.length());
//        for(int index = 0; index < cpCount; ++index) {
//            //这里的i是字符的位置
//            int i = testCode.offsetByCodePoints(0, index);
//            int codepoint = testCode.codePointAt(i);
//            System.out.println(codepoint);
//        }

//        char[] chars = Character.toChars(128149); System.out.println(chars);

        String str = String.valueOf(Character.toChars(128149));
        System.out.println(str);


    }
}
