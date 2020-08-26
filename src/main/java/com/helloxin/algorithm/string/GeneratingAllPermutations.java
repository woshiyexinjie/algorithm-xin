package com.helloxin.algorithm.string;

public class GeneratingAllPermutations {

    public static void getAllPermutations(String str) {
        getAllPermutationsPrint("", str);
    }

    private static void getAllPermutationsPrint(String prefix, String str) {
        if (str == null || str.length() == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < str.length(); i++) {
            getAllPermutationsPrint(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }

    public static void main(String[] args) {
        String str = "ABCD";
        getAllPermutations(str);

//        System.out.println(str.substring(0,0));
    }
}
