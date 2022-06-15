package net.guhya.algo.string;

import java.util.Arrays;

public class GenerateSuffix {

    public static String[] create(String str) {
        if (str == null || str.length() == 0) return new String[] {};
        String[] result = new String[str.length()+1];
        int i = 0;
        for (; i<str.length(); i++) {
            result[i] = str.substring(i);
        }
        result[i] = "";
        Arrays.sort(result);
        
        return result;
    }

    public static void main(String[] args) {
        String[] suffix1 = create("banana");
        System.out.println(Arrays.toString(suffix1));
        
        String[] suffix2 = create("cattcat");
        System.out.println(Arrays.toString(suffix2));
        
    }

}
