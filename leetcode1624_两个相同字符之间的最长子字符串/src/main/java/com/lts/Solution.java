package com.lts;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
//
        int max=-1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j)){
                    int temp=j-i-1;
                    if(max<temp){
                        max=temp;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.maxLengthBetweenEqualCharacters("asdfghjkl"));
    }
}
