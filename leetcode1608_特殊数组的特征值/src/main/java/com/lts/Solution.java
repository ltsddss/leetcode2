package com.lts;

import java.util.Arrays;

public class Solution {
    //    特殊数组的特征值
    public int specialArray(int[] nums) {
//        首先判断nums中最小的值是否等于nums的长度
//        如果最小值大于nums的长度，则特征值就是nums的长度
//        如果最小值小于nums的长度，遍历nums，结束点是nums.length
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.specialArray(new int[]{0,0}));
    }
}
