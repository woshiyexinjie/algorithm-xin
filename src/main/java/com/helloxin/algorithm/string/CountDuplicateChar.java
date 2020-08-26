package com.helloxin.algorithm.string;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateChar {

    private CountDuplicateChar() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateChar1(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> result = new HashMap<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            result.compute(ch,(k,v)->(v== null)?1:++v);
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    public static Map<String, Long> countDuplicateCharactersVCP2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countDuplicateChar1("HELLO WOELD%/"));
        String str = "Hello Wolrd,主人公";
//        System.out.println(str.codePointAt(0));
//        System.out.println((char)str.codePointAt(0));
//        str.chars().forEach(c-> System.out.println(c+" "+(char)c));
//        str.codePoints().forEach(c-> System.out.println(c+" "+(char)c));
        System.out.println("\u5B57");
        String testCode = "ab\uD83D\uDE03cd";
        System.out.println(testCode);
    }
}
