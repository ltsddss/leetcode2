package com.lts.aa;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sum=0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set=new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                int temp=set.size();
                set.add(s.charAt(j));
                if(set.size()==temp||j==s.length()-1){
                    sum= Math.max(set.size(), sum);
                    break;
                }
            }
            if(i>s.length()/2&&sum>s.length()/2){
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring(" "));
    }
}
