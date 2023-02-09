package com.lts;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 删除数组的其中一个元素，保证nums中是严格递增的
     * @param nums
     * @return
     */
    public boolean canBeIncreasing(int[] nums) {
//        使用栈结构，判断下一个进栈的数值是否比前一个数值大，如果大，则说明递增，小则取消压栈，标志位增一，最后判断标志位是否为1，

        int count=0;
        int maxv=nums[0],minv=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=maxv){
                count++;
                if(count>1) break;
            }else{
                maxv=nums[i];
            }
        }
        if(count<=1) return true;
        count=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=minv){
                count++;
                if(count>1) return false;
            }else{
                minv=nums[i];
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.canBeIncreasing(new int[]{2,3,1,2}));
    }
}
