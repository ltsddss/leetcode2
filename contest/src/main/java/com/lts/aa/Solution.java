package com.lts.aa;

import java.util.Arrays;

public class Solution {
    public int[] leftRigthDifference(int[] nums) {

        int[] left=new int[nums.length];
        left[0]=0;
        int leftsum=0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            leftsum+=nums[i];
            if(i<nums.length-1){
                left[i+1]=leftsum;
            }
            sum+=nums[i];
        }
        int[] result=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i]=Math.abs(left[i]-(sum-nums[i]));
            sum-=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(Arrays.toString(solution.leftRigthDifference(new int[]{10, 4, 8, 3})));
    }
}
