package com.lts;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int result=words.length;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if(!allowed.contains(""+words[i].charAt(j))){
                    result--;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.countConsistentStrings("abc", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}
