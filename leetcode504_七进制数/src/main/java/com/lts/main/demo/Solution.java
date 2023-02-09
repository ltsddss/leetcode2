package com.lts.main.demo;

import java.util.Arrays;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        // 将两个字符串分别转换成数组再判断字符数组的每个元素是否一致
        char[] s1_temp=s1.toCharArray();

        char[] s2_temp=s2.toCharArray();

        Arrays.sort(s1_temp);
        Arrays.sort(s2_temp);

        for (int i = 0; i < s1_temp.length; i++) {
            if(s1_temp[i]!=s2_temp[i]){
                return false;
            }
        }
        return true;
    }
}
