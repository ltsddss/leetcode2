package com.lts.date25;

import java.util.Arrays;
import java.util.List;

public class Solution {
    //2824. 统计和小于目标的下标对数目
    public int countPairs(List<Integer> nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    result++;
                }
            }
        }
        return result;
    }

    //    2825. 循环增长使字符串子序列等于另一个字符串
    public boolean canMakeSubsequence(String str1, String str2) {
        int result = 0;
        for (int i = 0; i < str1.length() && result < str2.length(); i++) {
            if (str2.charAt(result) - str1.charAt(i) <= 1 && str2.charAt(result) - str1.charAt(i) >= 0 || str1.charAt(i) == 'z' && str2.charAt(result) == 'a') {
                result++;
            }
        }
        return result == str2.length();
    }

    //    2826. 将三个组排序
    public int minimumOperations(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return nums.size() - result;
    }

    //    2827. 范围中美丽整数的数目
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int result=0;
        for (int i = low; i <= high; i++) {
                if(isSame(i)&&i%k==0){
                    result++;
                }
        }
        return result;
    }

//    奇数位和偶数位是否相同
    public boolean isSame(int num){
        int jishu=0;
        int ou=0;
        while (num!=0){
            if(num%10%2==0){
//                偶数位
                ou++;
            }else {
                jishu++;
            }
            num=num/10;
        }
        return jishu==ou;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfBeautifulIntegers(10, 20, 3));
    }
}
