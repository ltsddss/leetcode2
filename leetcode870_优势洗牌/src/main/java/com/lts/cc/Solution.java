package com.lts.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] temp=new int[words.length];
        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            temp[i]=isTrue(words[i])?1:0;
        }
        for (int[] query : queries) {
            int sum=0;
            for (int i = query[0]; i <= query[1]; i++) {
                sum+=temp[i];
            }
            list.add(sum);
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }

    public Boolean isTrue(String str){
        return (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u')
                && (str.charAt(str.length() - 1) == 'a' || str.charAt(str.length() - 1) == 'e' || str.charAt(str.length() - 1) == 'i' || str.charAt(str.length() - 1) == 'o' || str.charAt(str.length() - 1) == 'u');
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(Arrays.toString(s.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})));
    }
}
