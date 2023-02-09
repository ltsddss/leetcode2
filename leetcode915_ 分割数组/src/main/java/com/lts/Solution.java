package com.lts;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int partitionDisjoint1(int[] nums) {
//        找到左侧数组的最大值与右侧数组的最小值相比较
        int max=nums[0];

//        创建小顶堆
        Queue<Integer> queue=new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            queue.remove(nums[i]);
            if(max<=nums[i]){
                max=nums[i];
            }
            if(max<=queue.peek()){
                return nums.length-queue.size();
            }
        }
        return 0;
    }
    public int partitionDisjoint(int[] nums) {
//        找到左侧数组的最大值与右侧数组的最小值相比较
        int max=nums[0];
        int leftmax=nums[0];
        int index=0;

        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
            if(nums[i]<leftmax){
                leftmax=max;
                index=i;
            }
        }

        return index+1;
    }
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}
