package com.lts;

public class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)){
            int start=s.indexOf(part);

            s=s.substring(0,start)+s.substring(start+part.length());
        }
        return s;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.removeOccurrences("axxxxyyyyb", "xy"));
    }
}
