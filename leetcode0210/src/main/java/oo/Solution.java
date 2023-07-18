package oo;


//给你一个下标从 1开始、长度为 n 的整数数组 nums 。
//对 nums 中的元素 nums[i]而言，如果 n 能够被 i 整除，即 n%i==0 ，则认为 num[i]是一个 特殊元素 。
//返回 nums 中所有 特殊元素 的 平方和 。
public class Solution {
    public int sumOfSquares(int[] nums) {
        int length=nums.length;
        int result=0;
        for (int i = 1; i <length+1 ; i++) {
            if(length%i==0){
//                特殊值
                result+=Math.pow(nums[i-1],2);
            }
        }
        return result;
    }
}
